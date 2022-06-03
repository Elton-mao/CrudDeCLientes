package com.example.estudo.twClientes.repository;

import com.example.estudo.twClientes.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
}
