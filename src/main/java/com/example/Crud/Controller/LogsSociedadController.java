package com.example.Crud.Controller;

import com.example.Crud.Entity.LogsSociedad;
import com.example.Crud.Service.LogsSociedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logs-sociedad")
public class LogsSociedadController {
    private final LogsSociedadService logsSociedadService;

    @Autowired
    public LogsSociedadController(LogsSociedadService logsSociedadService) {
        this.logsSociedadService = logsSociedadService;
    }

    @GetMapping("/obtenerTodos")
    public List<LogsSociedad> obtenerTodosLosLogsDeSociedad() {
        return logsSociedadService.obtenerTodosLosLogsDeSociedad();
    }

    @GetMapping("/obtenerId/{id}")
    public Optional<LogsSociedad> obtenerLogsDeSociedadPorId(@PathVariable Long id) {
        return logsSociedadService.obtenerLogsDeSociedadPorId(id);
    }

    @PostMapping("/guardarLogs")
    public LogsSociedad guardarLogsDeSociedad(@RequestBody LogsSociedad logsSociedad) {
        return logsSociedadService.guardarLogsDeSociedad(logsSociedad);
    }

    @DeleteMapping("/eliminarLogs/{id}")
    public void eliminarLogsDeSociedad(@PathVariable Long id) {
        logsSociedadService.eliminarLogsDeSociedad(id);
    }
}

