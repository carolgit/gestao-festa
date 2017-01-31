package com.algaworks.ana.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.ana.sample.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {

}
