package com.distribuidora.domains.enums;

public enum Avaliacao {
    CINCOESTRELAS(0,"5 ESTRELAS"),QUATROESTRELAS(1,"4 ESTRELAS"),TRESESTRELAS(2,"3 ESTRELAS"),DUASESTRELAS(3,"2 ESTRELAS"),UMAESTRELA(3,"1 ESTRELA"),;

    private Integer id;
    private String situacao;

    Avaliacao() {
    }

    Avaliacao(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }


    public static Avaliacao toEnum(Integer id) {
        if (id == null) return null;
        for (Avaliacao x : Avaliacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Avaliação inválida");
    }
}
