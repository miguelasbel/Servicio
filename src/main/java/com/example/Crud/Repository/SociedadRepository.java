package com.example.Crud.Repository;

import com.example.Crud.Entity.Sociedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SociedadRepository extends JpaRepository<Sociedad, Long> {

}
