package com.distribuidora.resources;


import com.distribuidora.domains.Roupa;
import com.distribuidora.domains.dtos.RoupaDTO;
import com.distribuidora.services.RoupaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/roupa")
public class RoupaResource {

    @Autowired
    private RoupaService roupaService;

    @GetMapping // exemplo http://localhost:8080/roupa
    public ResponseEntity<List<RoupaDTO>> findAll(){
        return ResponseEntity.ok().body(roupaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoupaDTO> findById(@PathVariable Long id){
        Roupa obj = this.roupaService.findById(id);
        return ResponseEntity.ok().body(new RoupaDTO(obj));
    }

    @GetMapping(value = "/descricao/{descricao}")
    public ResponseEntity<RoupaDTO> findById(@PathVariable String descricao){
        Roupa obj = this.roupaService.findByDescricao(descricao);
        return ResponseEntity.ok().body(new RoupaDTO(obj));
    }


    @PostMapping
    public ResponseEntity<RoupaDTO> create(@Valid @RequestBody RoupaDTO dto){
        Roupa roupa = roupaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(roupa.getIdRoupa()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoupaDTO> update(@PathVariable Long id, @Valid @RequestBody RoupaDTO objDto){
        Roupa Obj = roupaService.update(id, objDto);
        return ResponseEntity.ok().body(new RoupaDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RoupaDTO> delete(@PathVariable Long id){
        roupaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
