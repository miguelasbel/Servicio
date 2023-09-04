package com.example.Crud.Controller;

import com.example.Crud.Entity.Sociedad;
import com.example.Crud.Service.SociedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sociedades")
public class SociedadController {
    private final SociedadService sociedadService;

    @Autowired
    public SociedadController(SociedadService sociedadService) {
        this.sociedadService = sociedadService;
    }

    @GetMapping("/ObtenerTodos")
    public List<Sociedad> obtenerTodasLasSociedades() {
        return sociedadService.obtenerTodasLasSociedades();
    }

    @GetMapping("/obtenerId/{id}")
    public Optional<Sociedad> obtenerSociedadPorId(@PathVariable Long id) {
        return sociedadService.obtenerSociedadPorId(id);
    }

    @PostMapping("/guardar")
    public Sociedad guardarSociedad(@RequestBody Sociedad sociedad) {
        return sociedadService.guardarSociedad(sociedad);
    }

    @PutMapping("/actualizar/{id}")
    public Sociedad actualizarSociedad(@PathVariable Long id, @RequestBody Sociedad sociedad) {

        return sociedadService.guardarSociedad(sociedad);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSociedad(@PathVariable Long id) {
        sociedadService.eliminarSociedad(id);
    }
}
