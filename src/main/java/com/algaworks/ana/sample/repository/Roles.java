package com.algaworks.ana.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.ana.sample.model.Role;

public interface Roles extends JpaRepository<Role, Long>{

}
