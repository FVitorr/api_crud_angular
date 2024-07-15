package com.fvitorr.crud_spring.services;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvitorr.crud_spring.models.cidade;
import com.fvitorr.crud_spring.models.pessoa;
import com.fvitorr.crud_spring.repositories.pessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class pessoaServices {
  @Autowired
  private pessoaRepository p_Repository;

  @Transactional
  public pessoa create(pessoa obj){
    this.p_Repository.save(obj);
    return obj;
  }

  @Transactional
  public List<pessoa> findAll(){
    return this.p_Repository.findAll();
  }

  @Transactional
  public pessoa update(pessoa obj){
    Optional<pessoa> upPessoa = this.p_Repository.findById(obj.getId());
    if (upPessoa.isPresent()) {
      cidade existingCidade = upCidade.get();
      
      // Atualizar os campos desejados
      existingCidade.setCidade(obj.getCidade());
      existingCidade.setEstado(obj.getEstado());
      existingCidade.setPopulacao(obj.getPopulacao());
      
      // Salvar o objeto atualizado de volta ao banco de dados
      return c_Repository.save(existingCidade);
    } else {
        // Opcional: lançar uma exceção ou retornar um resultado indicando que a cidade não foi encontrada
        throw new RuntimeException("Cidade com ID " + obj.getId() + " não encontrada.");
    }
  }


}
