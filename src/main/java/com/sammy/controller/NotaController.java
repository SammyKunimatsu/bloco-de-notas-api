package com.sammy.controller;

import com.sammy.model.Nota;
import com.sammy.repositorio.NotaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@Tag(name = "API de Bloco de Notas", description = "Operações para criar, ler, atualizar e deletar notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @PostMapping
    @Operation(summary = "Criar uma nova nota", description = "Cria uma nova nota com título e conteúdo.")
    public ResponseEntity<Nota> criarNota(@RequestBody Nota nota) {
        Nota novaNota = notaRepository.save(nota);
        return new ResponseEntity<>(novaNota, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todas as notas", description = "Retorna uma lista com todas as notas salvas.")
    public List<Nota> listarTodasAsNotas() {
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar nota por ID", description = "Retorna uma nota específica pelo seu ID.")
    public ResponseEntity<Nota> buscarNotaPorId(@PathVariable Long id) {
        return notaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma nota", description = "Atualiza o título ou o conteúdo de uma nota existente.")
    public ResponseEntity<Nota> atualizarNota(@PathVariable Long id, @RequestBody Nota detalhesNota) {
        return notaRepository.findById(id)
                .map(notaExistente -> {
                    notaExistente.setTitulo(detalhesNota.getTitulo());
                    notaExistente.setConteudo(detalhesNota.getConteudo());
                    Nota notaAtualizada = notaRepository.save(notaExistente);
                    return ResponseEntity.ok(notaAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma nota", description = "Remove uma nota do banco de dados pelo seu ID.")
    public ResponseEntity<Void> deletarNota(@PathVariable Long id) {
        return notaRepository.findById(id)
                .map(nota -> {
                    notaRepository.delete(nota);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
