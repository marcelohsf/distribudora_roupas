package com.distribuidora.resources;


import com.distribuidora.domains.Fornecedor;
import com.distribuidora.domains.dtos.FornecedorDTO;
import com.distribuidora.services.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {


    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping // exemplo http://localhost:8080/fornecedor
    public ResponseEntity<List<FornecedorDTO>> findAll(){
        return ResponseEntity.ok().body(fornecedorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Integer id){
        Fornecedor obj = this.fornecedorService.findById(id);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable String cnpj){
        Fornecedor obj = this.fornecedorService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }


    @PostMapping
    public ResponseEntity<FornecedorDTO> create(@Valid @RequestBody FornecedorDTO dto){
        Fornecedor fornecedor = fornecedorService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(fornecedor.getIdFornecedor()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> update(@PathVariable Integer id, @Valid @RequestBody FornecedorDTO objDto){
        Fornecedor Obj = fornecedorService.update(id, objDto);
        return ResponseEntity.ok().body(new FornecedorDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> delete(@PathVariable Integer id){
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
