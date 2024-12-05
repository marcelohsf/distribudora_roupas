package com.distribuidora.domains;

import com.distribuidora.domains.dtos.EstabelecimentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estabelecimento")
    private Integer idEstabelecimento;

    @NotNull @NotBlank
    @Column(unique = true)
    private String nome;

    @NotNull @NotBlank
    private String endereco;

    @NotNull @NotBlank
    private String cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "estabelecimento")
    private List<Roupa> roupas = new ArrayList<>();

    public Estabelecimento() {
    }

    public Estabelecimento(Integer idEstabelecimento, String nome, String endereco, String cidade) {
        this.idEstabelecimento = idEstabelecimento;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public Estabelecimento(EstabelecimentoDTO dto) {
        this.idEstabelecimento = dto.getIdEstabelecimento();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.cidade = dto.getCidade();
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull @NotBlank String endereco) {
        this.endereco = endereco;
    }

    public @NotNull @NotBlank String getCidade() {
        return cidade;
    }

    public void setCidade(@NotNull @NotBlank String cidade) {
        this.cidade = cidade;
    }

    public List<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(List<Roupa> roupas) {
        this.roupas = roupas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
        return Objects.equals(idEstabelecimento, that.idEstabelecimento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idEstabelecimento);
    }
}
