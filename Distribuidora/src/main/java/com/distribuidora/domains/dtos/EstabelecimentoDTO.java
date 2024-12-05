package com.distribuidora.domains.dtos;

import com.distribuidora.domains.Estabelecimento;
import com.distribuidora.repositories.EstabelecimentoRepository;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstabelecimentoDTO {

    private Integer idEstabelecimento;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo endereco não pode ser nulo!")
    @NotBlank(message = "O campo endereco não pode ser vazio!")
    private String endereco;

    @NotNull(message = "O campo cidade não pode ser nulo!")
    @NotBlank(message = "O campo cidade não pode ser vazio!")
    private String cidade;

    public EstabelecimentoDTO() {
    }

    public EstabelecimentoDTO(Estabelecimento estabelecimento) {
        this.idEstabelecimento = estabelecimento.getIdEstabelecimento();
        this.nome = estabelecimento.getNome();
        this.endereco = estabelecimento.getEndereco();
        this.cidade = estabelecimento.getCidade();
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo endereco não pode ser nulo!") @NotBlank(message = "O campo endereco não pode ser vazio!") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereco não pode ser nulo!") @NotBlank(message = "O campo endereco não pode ser vazio!") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo cidade não pode ser nulo!") @NotBlank(message = "O campo cidade não pode ser vazio!") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotNull(message = "O campo cidade não pode ser nulo!") @NotBlank(message = "O campo cidade não pode ser vazio!") String cidade) {
        this.cidade = cidade;
    }
}
