package com.distribuidora.resources;


import com.distribuidora.domains.Estabelecimento;
import com.distribuidora.domains.dtos.EstabelecimentoDTO;
import com.distribuidora.services.EstabelecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoResource {


    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @GetMapping // exemplo http://localhost:8080/estabelecimento
    public ResponseEntity<List<EstabelecimentoDTO>> findAll(){
        return ResponseEntity.ok().body(estabelecimentoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> findById(@PathVariable Integer id){
        Estabelecimento obj = this.estabelecimentoService.findById(id);
        return ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<EstabelecimentoDTO> findByNome(@PathVariable String nome){
        Estabelecimento obj = this.estabelecimentoService.findByNome(nome);
        return ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
    }


    @PostMapping
    public ResponseEntity<EstabelecimentoDTO> create(@Valid @RequestBody EstabelecimentoDTO dto){
        Estabelecimento estabelecimento = estabelecimentoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(estabelecimento.getIdEstabelecimento()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> update(@PathVariable Integer id, @Valid @RequestBody EstabelecimentoDTO objDto){
        Estabelecimento Obj = estabelecimentoService.update(id, objDto);
        return ResponseEntity.ok().body(new EstabelecimentoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> delete(@PathVariable Integer id){
        estabelecimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
