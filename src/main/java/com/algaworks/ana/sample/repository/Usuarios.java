package com.algaworks.ana.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.ana.sample.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{
	@Query("SELECT u FROM Usuario u WHERE username = ?1")
	public Usuario findByUsername(String username);
}
