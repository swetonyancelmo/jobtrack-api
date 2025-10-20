package com.jobtrack.api.controller;

import com.jobtrack.api.dto.AtualizarCandidaturaRequestDTO;
import com.jobtrack.api.dto.CandidaturaResponseDTO;
import com.jobtrack.api.dto.CriarCandidaturaRequestDTO;
import com.jobtrack.api.model.Candidatura;
import com.jobtrack.api.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;

@RestController
@RequestMapping("/api/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @GetMapping
    public ResponseEntity<List<CandidaturaResponseDTO>> listarTodasCandidaturas(){
        List<CandidaturaResponseDTO> candidaturas = candidaturaService.listarTodos()
                .stream()
                .map(CandidaturaResponseDTO::new)
                .toList();

        return ResponseEntity.ok(candidaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidaturaResponseDTO> buscarCandidaturaPorId(@PathVariable Long id) {
        Candidatura candidaturaEncontrada = candidaturaService.buscarPorId(id);
        return ResponseEntity.ok(new CandidaturaResponseDTO(candidaturaEncontrada));
    }

    @PostMapping
    public ResponseEntity<CandidaturaResponseDTO> criarCandidatura(@RequestBody CriarCandidaturaRequestDTO dto){
        Candidatura candidatura = candidaturaService.criarCandidatura(dto);
        return new ResponseEntity<>(new CandidaturaResponseDTO(candidatura), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidaturaResponseDTO> atualizarCandidatura(@PathVariable Long id,
            @RequestBody AtualizarCandidaturaRequestDTO dto){
        Candidatura candidaturaAtualizada = candidaturaService.atualizarCandidatura(id, dto);
        return ResponseEntity.ok(new CandidaturaResponseDTO(candidaturaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CandidaturaResponseDTO> deletarCandidatura(@PathVariable Long id){
        candidaturaService.deletarCandidatura(id);
        return ResponseEntity.noContent().build();
    }
}
