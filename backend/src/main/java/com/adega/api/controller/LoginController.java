package com.adega.api.controller;

import com.adega.api.domain.user.dto.AutenticarUser;
import com.adega.api.domain.user.User;
import com.adega.api.domain.user.dto.LoginResponseDTO;
import com.adega.api.infra.security.TokenService;
import com.adega.api.repository.FuncionarioRepository;
import com.adega.api.repository.MembroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private MembroRepository membroRepository;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticarUser data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.manager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User)auth.getPrincipal());
        var userRoles = ((User) auth.getPrincipal()).getAuthorities();
        // Filtra as authorities para verificar se o usuário tem ROLE_ADMIN ou ROLE_USER
        boolean hasGerenteROle = userRoles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_GERENTE"));
        boolean hasFuncionarioRole = userRoles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_FUNCIONARIO"));
        boolean hasMembroRole = userRoles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_MEMBRO"));

        // Define a role a ser retornada com base nas roles do usuário
        String role = null;
        if (hasGerenteROle) {
            role = "ROLE_GERENTE";
        } else if (hasFuncionarioRole) {
            role = "ROLE_FUNCIONARIO";
        }
        else {
            role = "ROLE_MEMBRO";
        }
        return ResponseEntity.ok(new LoginResponseDTO(token, role));
    }
}
