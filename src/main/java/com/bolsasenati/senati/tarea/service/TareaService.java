package com.bolsasenati.senati.tarea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsasenati.senati.tarea.model.BloqueSeminario;
import com.bolsasenati.senati.tarea.model.Tarea;
import com.bolsasenati.senati.tarea.repository.BloqueSeminarioRepository;
import com.bolsasenati.senati.tarea.repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private BloqueSeminarioRepository bloqueRepository;

    @Autowired
    private TareaRepository tareaRepository;

    public List<BloqueSeminario> listarBloques() {
        return bloqueRepository.findAll();
    }

    public List<Tarea> listarTareasPorBloque(String bloqueId) {
        return tareaRepository.findByBloqueId(bloqueId);
    }

    public Tarea calificarTarea(Long tareaId, Double nota, String retroalimentacion) {
        Optional<Tarea> mTarea = tareaRepository.findById(tareaId);
        if (mTarea.isPresent()) {
            Tarea tarea = mTarea.get();
            tarea.setNota(nota);
            tarea.setRetroalimentacion(retroalimentacion);
            tarea.setEstado("Calificado");
            return tareaRepository.save(tarea);
        }
        throw new RuntimeException("La tarea con ID " + tareaId + " no existe.");
    }
}