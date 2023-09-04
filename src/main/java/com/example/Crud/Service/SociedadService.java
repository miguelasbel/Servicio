package com.example.Crud.Service;

import com.example.Crud.Entity.Sociedad;
import com.example.Crud.Repository.SociedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SociedadService {
    private final SociedadRepository sociedadRepository;

    @Autowired
    public SociedadService(SociedadRepository sociedadRepository) {
        this.sociedadRepository = sociedadRepository;
    }

    public List<Sociedad> obtenerTodasLasSociedades() {
        return sociedadRepository.findAll();
    }

    public Optional<Sociedad> obtenerSociedadPorId(Long id) {
        return sociedadRepository.findById(id);
    }

    public Sociedad guardarSociedad(Sociedad sociedad) {
        return sociedadRepository.save(sociedad);
    }

    public void eliminarSociedad(Long id) {
        sociedadRepository.deleteById(id);
    }

}
