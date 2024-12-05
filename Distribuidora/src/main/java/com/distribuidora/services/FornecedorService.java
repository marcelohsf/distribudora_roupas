package com.distribuidora.services;

import com.distribuidora.domains.Fornecedor;
import com.distribuidora.domains.dtos.FornecedorDTO;
import com.distribuidora.repositories.FornecedorRepository;
import com.distribuidora.services.exceptions.DataIntegrityViolationException;
import com.distribuidora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {


    @Autowired
    private FornecedorRepository fornecedorRepo;

    //Retorna uma lista de EstabelecimentoDTO
    public List<FornecedorDTO> findAll(){
        return fornecedorRepo.findAll().stream()
                .map(obj -> new FornecedorDTO(obj))
                .collect(Collectors.toList());
    }

    public Fornecedor findById(Integer id){
        Optional<Fornecedor> obj = fornecedorRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor Não Encontrado! ID: "+ id));
    }

    public Fornecedor findByCnpj(String cnpj){
        Optional<Fornecedor> obj = fornecedorRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor Não Encontrado! CNPJ: "+ cnpj));
    }

    public Fornecedor create (FornecedorDTO dto){
        dto.setIdFornecedor(null);
        validaFornecedor(dto);
        Fornecedor obj = new Fornecedor(dto);
        return fornecedorRepo.save(obj);
    }

    private void validaFornecedor(FornecedorDTO dto){
        Optional<Fornecedor> obj = fornecedorRepo.findByCnpj(dto.getCnpj());
        if (obj.isPresent() && obj.get().getIdFornecedor() != dto.getIdFornecedor()){
            throw new DataIntegrityViolationException("CNPJ já Cadastrado!");
        }
    }

    public Fornecedor update(Integer id, FornecedorDTO objDto){
        objDto.setIdFornecedor(id);
        Fornecedor oldObj = findById(id);
        validaFornecedor(objDto);
        oldObj = new Fornecedor(objDto);
        return fornecedorRepo.save(oldObj);
    }

    public void delete(Integer id){
        Fornecedor obj = findById(id);
        if (obj.getRoupas().size()>0){
            throw new DataIntegrityViolationException("Fornecedor não pode ser Deletado pois possui roupas vinculados!");
        }
        fornecedorRepo.deleteById(id);
    }
}
