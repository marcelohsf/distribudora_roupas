package com.distribuidora.services;

import com.distribuidora.domains.Estabelecimento;
import com.distribuidora.domains.Fornecedor;
import com.distribuidora.domains.Roupa;
import com.distribuidora.domains.enums.Avaliacao;
import com.distribuidora.domains.enums.Status;
import com.distribuidora.repositories.EstabelecimentoRepository;
import com.distribuidora.repositories.FornecedorRepository;
import com.distribuidora.repositories.RoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DBService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepo;

    @Autowired
    private FornecedorRepository fornecedorRepo;

    @Autowired
    private RoupaRepository roupaRepo;

    public void initDB(){
        Estabelecimento estabelecimento1 = new Estabelecimento(null,"Albatroz","Rua1","Cidade1");
        Estabelecimento estabelecimento2 = new Estabelecimento(null,"Estabelecimento2","Rua2","Cidade2");
        Estabelecimento estabelecimento3 = new Estabelecimento(null,"Estabelecimento3","Rua3","Cidade3");

        Fornecedor fornecedor1 = new Fornecedor(null,"Fornecedo1","FF1","Rua F1","FONE1");
        Fornecedor fornecedor2 = new Fornecedor(null,"Fornecedo2","FF2","Rua F2","FONE2");
        Fornecedor fornecedor3 = new Fornecedor(null,"Fornecedo3","FF3","Rua F3","FONE3");

        Roupa roupa1 = new Roupa(null,"Camiseta Oakley","G","Branca", new BigDecimal("50"), new BigDecimal("500"),"Camiseta",estabelecimento1,fornecedor1, Status.DISPONIVEL, Avaliacao.CINCOESTRELAS);
        Roupa roupa2 = new Roupa(null,"Camiseta Nike","M","Verde", new BigDecimal("50"), new BigDecimal("500"),"Camiseta",estabelecimento2,fornecedor2, Status.DISPONIVEL, Avaliacao.TRESESTRELAS);
        Roupa roupa3 = new Roupa(null,"Camiseta Adidas","P","Amarelo", new BigDecimal("50"), new BigDecimal("500"),"Camiseta",estabelecimento3,fornecedor3, Status.DISPONIVEL, Avaliacao.DUASESTRELAS);

        estabelecimentoRepo.save(estabelecimento1);
        estabelecimentoRepo.save(estabelecimento2);
        estabelecimentoRepo.save(estabelecimento3);

        fornecedorRepo.save(fornecedor1);
        fornecedorRepo.save(fornecedor2);
        fornecedorRepo.save(fornecedor3);

        roupaRepo.save(roupa1);
        roupaRepo.save(roupa2);
        roupaRepo.save(roupa3);
    }
}
