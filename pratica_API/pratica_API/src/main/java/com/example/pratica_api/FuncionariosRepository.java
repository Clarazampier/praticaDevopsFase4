package com.example.pratica_api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
    List<Funcionarios> findByData(Date data);
}