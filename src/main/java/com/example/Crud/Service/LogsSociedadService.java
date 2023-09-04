package com.example.Crud.Service;

import com.example.Crud.Entity.LogsSociedad;
import com.example.Crud.Repository.LogsSociedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LogsSociedadService {
    private final LogsSociedadRepository logsSociedadRepository;

    @Autowired
    public LogsSociedadService(LogsSociedadRepository logsSociedadRepository) {
        this.logsSociedadRepository = logsSociedadRepository;
    }

    public List<LogsSociedad> obtenerTodosLosLogsDeSociedad() {
        return logsSociedadRepository.findAll();
    }

    public Optional<LogsSociedad> obtenerLogsDeSociedadPorId(Long id) {
        return logsSociedadRepository.findById(id);
    }

    public LogsSociedad guardarLogsDeSociedad(LogsSociedad logsSociedad) {
        return logsSociedadRepository.save(logsSociedad);
    }

    public void eliminarLogsDeSociedad(Long id) {
        logsSociedadRepository.deleteById(id);
    }
}
