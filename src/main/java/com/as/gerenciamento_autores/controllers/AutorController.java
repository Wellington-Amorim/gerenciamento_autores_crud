package com.as.gerenciamento_autores.controllers;

import com.as.gerenciamento_autores.modals.AutorModal;
import com.as.gerenciamento_autores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorModal> criar(@RequestBody AutorModal autorModal) {
        AutorModal autor = autorService.criar(autorModal);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(autor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(autorModal);
    }

    @GetMapping
    public ResponseEntity<List<AutorModal>> listar()  {
        List<AutorModal> autores = autorService.listar();
        return ResponseEntity.ok().body(autores);
    }

    @GetMapping("/{id}")
    public Optional<AutorModal> buscarId(@PathVariable Long id) {
        return autorService.buscarId(id);
    }

    @PutMapping("/{id}")
    public AutorModal atualizar(@PathVariable Long id, @RequestBody AutorModal autorModal) {
        return autorService.atualizar(id, autorModal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
