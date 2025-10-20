package com.jobtrack.api.service;

import com.jobtrack.api.dto.AtualizarCandidaturaRequestDTO;
import com.jobtrack.api.dto.CriarCandidaturaRequestDTO;
import com.jobtrack.api.exceptions.RecursoNaoEncontradoException;
import com.jobtrack.api.model.Candidatura;
import com.jobtrack.api.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    public List<Candidatura> listarTodos(){
        return candidaturaRepository.findAll();
    }

    public Candidatura buscarPorId(Long id){
        return candidaturaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Candidatura com o ID " + id + " não encontrada"));
    }

    public Candidatura criarCandidatura(CriarCandidaturaRequestDTO dto){
        Candidatura novaCandidatura = new Candidatura();

        novaCandidatura.setTituloVaga(dto.getTituloVaga());
        novaCandidatura.setEmpresa(dto.getEmpresa());
        novaCandidatura.setDataCandidatura(dto.getDataCandidatura());
        novaCandidatura.setStatus(dto.getStatusCandidatura());

        return candidaturaRepository.save(novaCandidatura);
    }

    public Candidatura atualizarCandidatura(Long id, AtualizarCandidaturaRequestDTO dto){
        Candidatura candidaturaAtualizada = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Candidatura com o ID " + id + " não encontrada"));

        candidaturaAtualizada.setStatus(dto.getStatusCandidatura());
        candidaturaAtualizada.setUrlVaga(dto.getUrlVaga());
        candidaturaAtualizada.setProximaAcaoData(dto.getProximaAcaoData());

        return candidaturaRepository.save(candidaturaAtualizada);
    }

    public void deletarCandidatura(Long id){
        candidaturaRepository.deleteById(id);
    }

}
