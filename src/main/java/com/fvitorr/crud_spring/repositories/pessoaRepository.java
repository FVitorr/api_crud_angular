package com.fvitorr.crud_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fvitorr.crud_spring.models.pessoa;

@Repository
public interface pessoaRepository extends JpaRepository<pessoa,Long>{
      // Contar o número de pessoas associadas a uma cidade
    @Query(value= "SELECT COUNT(id) FROM pessoa WHERE pessoa.id_cidade = :cidadeId",nativeQuery = true)
    long countByIdCidade(@Param("cidadeId") Long cidadeId);
}