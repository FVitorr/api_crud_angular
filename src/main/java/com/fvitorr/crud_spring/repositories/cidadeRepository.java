package com.fvitorr.crud_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fvitorr.crud_spring.models.cidade;

@Repository
public interface cidadeRepository extends JpaRepository<cidade, Long>{
} 
