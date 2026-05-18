package com.bolsasenati.senati.tarea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsasenati.senati.tarea.model.BloqueSeminario;
import com.bolsasenati.senati.tarea.model.Tarea;
import com.bolsasenati.senati.tarea.service.TareaService;

@RestController
@RequestMapping("/api")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/bloques")
    public List<BloqueSeminario> getBloques() {
        return tareaService.listarBloques();
    }

    @GetMapping("/bloques/{bloqueId}/tareas")
    public List<Tarea> getTareasPorBloque(@PathVariable String bloqueId) {
        return tareaService.listarTareasPorBloque(bloqueId);
    }

    @PutMapping("/tareas/{id}/calificar")
    public Tarea calificar(@PathVariable Long id, @RequestBody Tarea datosCalificacion) {
        return tareaService.calificarTarea(
            id, 
            datosCalificacion.getNota(), 
            datosCalificacion.getRetroalimentacion()
        );
    }
}