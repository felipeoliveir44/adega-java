package com.adega.api.domain.funcionario;

public enum Role {

    GERENTE("gerente"),
    CAIXA("caixa"),
    ATENDENTE("atendente");

    private String role;

    Role(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
