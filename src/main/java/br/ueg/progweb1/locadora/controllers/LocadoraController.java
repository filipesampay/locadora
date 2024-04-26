package br.ueg.progweb1.locadora.controllers;

import br.ueg.progweb1.locadora.exceptions.CustomException;
import br.ueg.progweb1.locadora.mapper.LocadoraMapper;
import br.ueg.progweb1.locadora.model.Locadora;
import br.ueg.progweb1.locadora.model.dtos.LocacaoDTO;
import br.ueg.progweb1.locadora.service.LocadoraService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "${api.version}/locadora/carro")
public class LocadoraController {

    @Autowired
    private LocadoraService service;

    @Autowired
    private LocadoraMapper mapper;

    @PostMapping
    @Operation(description = "Endpoint para criar novo carro.")
    public ResponseEntity<Object> create(@RequestBody LocacaoDTO dto) {
        Locadora car = null;
        try {
            Locadora carModel = mapper.toModel(dto);
            car = service.create(carModel);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Erro: " + e.getMessage());
        }
        return ResponseEntity.ok(car);
    }

    @GetMapping
    @Operation(description = "Endpoint para listar todos os carros.")
    public ResponseEntity<List<Locadora>> list() {
        List<Locadora> list = new ArrayList<>();
        try {
            list = service.list();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.of(Optional.ofNullable(list));
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Endpoint para listar todos os dados de um carro através do ID.")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        Locadora car = Locadora.builder().id(0L).build();
        try {
            car = service.get(id);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(car);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Endpoint para atualizar os dados de um carro através do ID.")
    public ResponseEntity<Object> update(@RequestBody LocacaoDTO dto,
                                         @PathVariable("id") Long id) {
        Locadora car = null;
        try {
            Locadora data = mapper.toModel(dto);
            data.setId(id);
            car = service.update(data);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Erro: " + e.getMessage());
        }
        return ResponseEntity.ok(car);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "Endpoint para apagar um carro através do ID.")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Locadora car = Locadora.builder().id(0L).build();
        try {
            car = service.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(car);
    }

}