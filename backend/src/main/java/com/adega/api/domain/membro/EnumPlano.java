package com.adega.api.domain.membro;

public enum EnumPlano {
    BASICO("BASICO"),
    PREMIUM("PREMIUM");
    private String plano;

    EnumPlano(String plano) {
        this.plano = plano;
    }
}
