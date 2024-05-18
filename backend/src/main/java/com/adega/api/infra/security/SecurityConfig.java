package com.adega.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/produto/cadastrar").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/produto/listar").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/produto/atualizar/{id}").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/produto/listar").hasAnyRole("GERENTE", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST, "/funcionario/cadastrar").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/funcionario/listar").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/funcionario/atualizar").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/funcionario/desativar/{id}").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/funcionario/ativar/{id}").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/fornecedor/cadastra").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/fornecedor/atualizar/{id}").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/fornecedor/list").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/fornecedor/list").hasRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST, "/cliente/cadastro").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/cliente/atualizar/{id}").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/cliente/lista").hasAnyRole("GERENTE", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/categoria/lista").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/categoria/cadastra").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/pdv").hasAnyRole("GERENTE", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST, "/gestao").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/gestao").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/gestao/ano").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/membro/cadastrar").hasAnyRole("GERENTE", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/membro/listar/membros").hasAnyRole("GERENTE", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/membro/listar/produtos").hasAnyRole("GERENTE", "FUNCIONARIO", "MEMBRO")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
