package com.distribuidora.domains;


import com.distribuidora.domains.dtos.RoupaDTO;
import com.distribuidora.domains.enums.Avaliacao;
import com.distribuidora.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "roupa")
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_roupa")
    private Long idRoupa;

    @NotNull @NotBlank
    @Column(unique = true)
    private String descricao;

    @NotNull @NotBlank
    private String tamanho;

    @NotNull @NotBlank
    private String cor;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal preco;

    @NotNull
    @Digits(integer = 10, fraction = 3)
    private BigDecimal quantidadeEstoque;

    @NotNull @NotBlank
    private String categoria;

    @ManyToOne
    @JoinColumn(name="idestabelecimento")
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name="idfornecedor")
    private Fornecedor  fornecedor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "avaliacao")
    private Avaliacao avaliacao;


    public Roupa() {
    }

    public Roupa(Long idRoupa, String descricao, String tamanho, String cor, BigDecimal preco, BigDecimal quantidadeEstoque, String categoria, Estabelecimento estabelecimento, Fornecedor fornecedor, Status status, Avaliacao avaliacao) {
        this.idRoupa = idRoupa;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.estabelecimento = estabelecimento;
        this.fornecedor = fornecedor;
        this.status = status;
        this.avaliacao = avaliacao;
    }

    public Roupa(RoupaDTO dto) {
        this.idRoupa = dto.getIdRoupa();
        this.descricao = dto.getDescricao();
        this.tamanho = dto.getTamanho();
        this.cor = dto.getCor();
        this.preco = dto.getPreco();
        this.quantidadeEstoque = dto.getQuantidadeEstoque();
        this.categoria = dto.getCategoria();
        this.estabelecimento = new Estabelecimento();
        this.estabelecimento.setIdEstabelecimento(dto.getEstabelecimento());
        this.fornecedor = new Fornecedor();
        this.fornecedor.setIdFornecedor(dto.getFornecedor());
        this.status = Status.toEnum(dto.getStatus());
        this.avaliacao = Avaliacao.toEnum(dto.getAvaliacao());
    }

    public Long getIdRoupa() {
        return idRoupa;
    }

    public void setIdRoupa(Long idRoupa) {
        this.idRoupa = idRoupa;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }

    public @NotNull @NotBlank String getTamanho() {
        return tamanho;
    }

    public void setTamanho(@NotNull @NotBlank String tamanho) {
        this.tamanho = tamanho;
    }

    public @NotNull @NotBlank String getCor() {
        return cor;
    }

    public void setCor(@NotNull @NotBlank String cor) {
        this.cor = cor;
    }

    public @NotNull @Digits(integer = 10, fraction = 2) BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(@NotNull @Digits(integer = 10, fraction = 2) BigDecimal preco) {
        this.preco = preco;
    }

    public @NotNull @Digits(integer = 10, fraction = 3) BigDecimal getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(@NotNull @Digits(integer = 10, fraction = 3) BigDecimal quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public @NotNull @NotBlank String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull @NotBlank String categoria) {
        this.categoria = categoria;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roupa roupa = (Roupa) o;
        return Objects.equals(idRoupa, roupa.idRoupa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idRoupa);
    }
}
