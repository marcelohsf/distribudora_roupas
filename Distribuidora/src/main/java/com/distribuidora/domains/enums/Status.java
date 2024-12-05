package com.distribuidora.domains.enums;

public enum Status {
    NAODISPONIVEL(0,"NÃO DISPONÍVEL"), DISPONIVEL(1,"DISPONÍVEL");

    private Integer id;
    private String status;

    Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return status;
    }

    public void setSituacao(String situacao) {
        this.status = situacao;
    }


    public static Status toEnum(Integer id) {
        if (id == null) return null;
        for (Status x : Status.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido!");
    }
}
