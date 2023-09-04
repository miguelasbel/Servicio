package com.example.Crud.Repository;

import com.example.Crud.Entity.LogsSociedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsSociedadRepository extends JpaRepository<LogsSociedad, Long> {

}
