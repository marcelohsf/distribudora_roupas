package com.distribuidora.domains.dtos;

import com.distribuidora.domains.Roupa;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class RoupaDTO {

    private Long idRoupa;

    @NotNull(message = "O campo descricao não pode ser nulo!")
    @NotBlank(message = "O campo descricao não pode ser vazio!")
    private String descricao;

    @NotNull(message = "O campo tamanho não pode ser nulo!")
    @NotBlank(message = "O campo tamanho não pode ser vazio!")
    private String tamanho;

    @NotNull(message = "O campo cor não pode ser nulo!")
    @NotBlank(message = "O campo cor não pode ser vazio!")
    private String cor;

    @NotNull(message = "O campo preco não pode ser nulo!")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal preco;

    @NotNull(message = "O campo quantidadeEstoque não pode ser nulo!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal quantidadeEstoque;

    @NotNull(message = "O campo categoria não pode ser nulo!")
    @NotBlank(message = "O campo categoria não pode ser vazio!")
    private String categoria;


    @NotNull(message = "O campo estabelecimento é requerido!")
    private int estabelecimento;
    private String nomeEstabelecimento;


    @NotNull(message = "O campo fornecedor é requerido!")
    private int fornecedor;
    private String nomeFornecedor;

    private int avaliacao;

    private int status;

    public RoupaDTO() {
    }

    public RoupaDTO(Roupa roupa) {
        this.idRoupa = roupa.getIdRoupa();
        this.descricao = roupa.getDescricao();
        this.tamanho = roupa.getTamanho();
        this.cor = roupa.getCor();
        this.preco = roupa.getPreco();
        this.quantidadeEstoque = roupa.getQuantidadeEstoque();
        this.categoria = roupa.getCategoria();
        this.estabelecimento = roupa.getEstabelecimento().getIdEstabelecimento();
        this.nomeEstabelecimento = roupa.getEstabelecimento().getNome();
        this.fornecedor = roupa.getFornecedor().getIdFornecedor();
        this.nomeFornecedor = roupa.getFornecedor().getNome();
        this.avaliacao = roupa.getAvaliacao().getId();
        this.status = roupa.getStatus().getId();
    }

    public Long getIdRoupa() {
        return idRoupa;
    }

    public void setIdRoupa(Long idRoupa) {
        this.idRoupa = idRoupa;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo!") @NotBlank(message = "O campo descricao não pode ser vazio!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo!") @NotBlank(message = "O campo descricao não pode ser vazio!") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo tamanho não pode ser nulo!") @NotBlank(message = "O campo tamanho não pode ser vazio!") String getTamanho() {
        return tamanho;
    }

    public void setTamanho(@NotNull(message = "O campo tamanho não pode ser nulo!") @NotBlank(message = "O campo tamanho não pode ser vazio!") String tamanho) {
        this.tamanho = tamanho;
    }

    public @NotNull(message = "O campo cor não pode ser nulo!") @NotBlank(message = "O campo cor não pode ser vazio!") String getCor() {
        return cor;
    }

    public void setCor(@NotNull(message = "O campo cor não pode ser nulo!") @NotBlank(message = "O campo cor não pode ser vazio!") String cor) {
        this.cor = cor;
    }

    public @NotNull(message = "O campo preco não pode ser nulo!") @Digits(integer = 10, fraction = 2) BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(@NotNull(message = "O campo preco não pode ser nulo!") @Digits(integer = 10, fraction = 2) BigDecimal preco) {
        this.preco = preco;
    }

    public @NotNull(message = "O campo quantidadeEstoque não pode ser nulo!") @Digits(integer = 10, fraction = 3) BigDecimal getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(@NotNull(message = "O campo quantidadeEstoque não pode ser nulo!") @Digits(integer = 10, fraction = 3) BigDecimal quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public @NotNull(message = "O campo categoria não pode ser nulo!") @NotBlank(message = "O campo categoria não pode ser vazio!") String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull(message = "O campo categoria não pode ser nulo!") @NotBlank(message = "O campo categoria não pode ser vazio!") String categoria) {
        this.categoria = categoria;
    }

    @NotNull(message = "O campo estabelecimento é requerido!")
    public int getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(@NotNull(message = "O campo estabelecimento é requerido!") int estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    @NotNull(message = "O campo fornecedor é requerido!")
    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(@NotNull(message = "O campo fornecedor é requerido!") int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
