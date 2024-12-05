package com.distribuidora.domains;

import com.distribuidora.domains.dtos.FornecedorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fornecedor")
    private Integer idFornecedor;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cnpj;

    @NotNull @NotBlank
    private String endereco;

    @NotNull @NotBlank
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    private List<Roupa> roupas = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor, String nome, String cnpj, String endereco, String telefone) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Fornecedor(FornecedorDTO dto) {
        this.idFornecedor = dto.getIdFornecedor();
        this.nome = dto.getNome();
        this.cnpj = dto.getCnpj();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull @NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull @NotBlank String endereco) {
        this.endereco = endereco;
    }

    public @NotNull @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @NotBlank String telefone) {
        this.telefone = telefone;
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
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(idFornecedor, that.idFornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idFornecedor);
    }
}
