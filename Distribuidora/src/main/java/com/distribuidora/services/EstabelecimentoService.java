package com.distribuidora.services;

import com.distribuidora.domains.Estabelecimento;
import com.distribuidora.domains.dtos.EstabelecimentoDTO;
import com.distribuidora.repositories.EstabelecimentoRepository;
import com.distribuidora.services.exceptions.DataIntegrityViolationException;
import com.distribuidora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepo;

    //Retorna uma lista de EstabelecimentoDTO
    public List<EstabelecimentoDTO> findAll(){
        return estabelecimentoRepo.findAll().stream()
                .map(obj -> new EstabelecimentoDTO(obj))
                .collect(Collectors.toList());
    }

    public Estabelecimento findById(Integer id){
        Optional<Estabelecimento> obj = estabelecimentoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Estabelecimento Não Encontrado! ID: "+ id));
    }

    public Estabelecimento findByNome(String nome){
        Optional<Estabelecimento> obj = estabelecimentoRepo.findByNome(nome);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Estabelecimento Não Encontrado! NOME: "+ nome));
    }

    public Estabelecimento create (EstabelecimentoDTO dto){
        dto.setIdEstabelecimento(null);
        validaEstabelecimento(dto);
        Estabelecimento obj = new Estabelecimento(dto);
        return estabelecimentoRepo.save(obj);
    }

    private void validaEstabelecimento(EstabelecimentoDTO dto){
        Optional<Estabelecimento> obj = estabelecimentoRepo.findByNome(dto.getNome());
        if (obj.isPresent() && obj.get().getIdEstabelecimento() != dto.getIdEstabelecimento()){
            throw new DataIntegrityViolationException("NOME já Cadastrado!");
        }
    }

    public Estabelecimento update(Integer id, EstabelecimentoDTO objDto){
        objDto.setIdEstabelecimento(id);
        Estabelecimento oldObj = findById(id);
        validaEstabelecimento(objDto);
        oldObj = new Estabelecimento(objDto);
        return estabelecimentoRepo.save(oldObj);
    }

    public void delete(Integer id){
        Estabelecimento obj = findById(id);
        if (obj.getRoupas().size()>0){
            throw new DataIntegrityViolationException("Estabelecimento não pode ser Deletado pois possui roupas vinculados!");
        }
        estabelecimentoRepo.deleteById(id);
    }


}
