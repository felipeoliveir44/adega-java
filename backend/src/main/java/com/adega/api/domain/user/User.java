package com.adega.api.domain.user;

import com.adega.api.domain.funcionario.Funcionario;
import com.adega.api.domain.funcionario.dto.DadosCadastrarFuncionario;
import com.adega.api.domain.membro.Membro;
import com.adega.api.domain.membro.dto.DadosCadastroMembro;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbuser")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;


    public User(DadosCadastrarFuncionario dados, String senha) {
        this.login = dados.email();
        this.senha = senha;
        this.role = dados.role();
    }

    public User(DadosCadastroMembro dados, String senha) {
        this.login = dados.email();
        this.senha = senha;
        this.role = dados.role();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Role.GERENTE) return List.of(new SimpleGrantedAuthority("ROLE_GERENTE"), new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
        else if (this.role == Role.FUNCIONARIO) {
            return List.of(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
        }
        else return List.of(new SimpleGrantedAuthority("ROLE_MEMBRO"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
