package com.adega.api.domain.user;

public enum Role {
    GERENTE("GERENTE"),
    FUNCIONARIO("FUNCIONARIO"),
    MEMBRO("MEMBRO");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
