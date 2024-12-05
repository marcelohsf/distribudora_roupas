package com.distribuidora.services;

import com.distribuidora.domains.Estabelecimento;
import com.distribuidora.domains.Fornecedor;
import com.distribuidora.domains.Roupa;
import com.distribuidora.domains.dtos.RoupaDTO;
import com.distribuidora.repositories.EstabelecimentoRepository;
import com.distribuidora.repositories.FornecedorRepository;
import com.distribuidora.repositories.RoupaRepository;
import com.distribuidora.services.exceptions.DataIntegrityViolationException;
import com.distribuidora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoupaService {

    @Autowired
    private RoupaRepository roupaRepo;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepo;

    @Autowired
    private FornecedorRepository fornecedorRepo;

    //Retorna uma lista de EstabelecimentoDTO
    public List<RoupaDTO> findAll(){
        return roupaRepo.findAll().stream()
                .map(obj -> new RoupaDTO(obj))
                .collect(Collectors.toList());
    }

    public Roupa findById(Long id){
        Optional<Roupa> obj = roupaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Roupa Não Encontrada! ID: "+ id));
    }

    public Roupa findByDescricao(String descricao){
        Optional<Roupa> obj = roupaRepo.findByDescricao(descricao);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Roupa Não Encontrada! DESCRIÇÃO: "+ descricao));
    }

    public Roupa create (RoupaDTO dto){
        dto.setIdRoupa(null);
        validaRoupa(dto);
        Roupa obj = new Roupa(dto);
        return roupaRepo.save(obj);
    }

    private void validaRoupa(RoupaDTO dto){
        Optional<Roupa> obj = roupaRepo.findByDescricao(dto.getDescricao());
        if (obj.isPresent() && obj.get().getIdRoupa() != dto.getIdRoupa()){
            throw new DataIntegrityViolationException("DESCRIÇÃO já Cadastrada!");
        }
        // Valida se o estabelecimento existe
        if (!estabelecimentoRepo.existsById(dto.getEstabelecimento())) {
            throw new ObjectNotFoundException(
                    "Estabelecimento não encontrado! ID: " + dto.getEstabelecimento()
            );
        }

        // Valida se o fornecedor existe
        if (!fornecedorRepo.existsById(dto.getFornecedor())) {
            throw new ObjectNotFoundException(
                    "Fornecedor não encontrado! ID: " + dto.getFornecedor()
            );
        }

    }

    public Roupa update(Long id, RoupaDTO objDto){
        objDto.setIdRoupa(id);
        Roupa oldObj = findById(id);
        validaRoupa(objDto);
        oldObj = new Roupa(objDto);
        return roupaRepo.save(oldObj);
    }

    public void delete(Long id){
        Roupa obj = findById(id);
        roupaRepo.deleteById(id);
    }

}
