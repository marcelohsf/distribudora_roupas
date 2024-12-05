package com.distribuidora.domains.dtos;

import com.distribuidora.domains.Fornecedor;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FornecedorDTO {
    private Integer idFornecedor;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo cnpj não pode ser nulo!")
    @NotBlank(message = "O campo cnpj não pode ser vazio!")
    private String cnpj;

    @NotNull(message = "O campo endereco não pode ser nulo!")
    @NotBlank(message = "O campo endereco não pode ser vazio!")
    private String endereco;

    @NotNull(message = "O campo telefone não pode ser nulo!")
    @NotBlank(message = "O campo telefone não pode ser vazio!")
    private String telefone;

    public FornecedorDTO() {
    }

    public FornecedorDTO(Fornecedor fornecedor) {
        this.idFornecedor = fornecedor.getIdFornecedor();
        this.nome = fornecedor.getNome();
        this.cnpj = fornecedor.getCnpj();
        this.endereco = fornecedor.getEndereco();
        this.telefone = fornecedor.getTelefone();
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo endereco não pode ser nulo!") @NotBlank(message = "O campo endereco não pode ser vazio!") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereco não pode ser nulo!") @NotBlank(message = "O campo endereco não pode ser vazio!") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo telefone não pode ser nulo!") @NotBlank(message = "O campo telefone não pode ser vazio!") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull(message = "O campo telefone não pode ser nulo!") @NotBlank(message = "O campo telefone não pode ser vazio!") String telefone) {
        this.telefone = telefone;
    }
}
