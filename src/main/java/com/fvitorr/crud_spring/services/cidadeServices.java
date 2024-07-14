package com.fvitorr.crud_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvitorr.crud_spring.models.cidade;
import com.fvitorr.crud_spring.repositories.cidadeRepository;

import jakarta.transaction.Transactional;

@Service
public class cidadeServices {
  @Autowired
  private cidadeRepository c_Repository;

  @Transactional
  public cidade create(cidade obj){
    this.c_Repository.save(obj);
    return obj;
  }

  @Transactional
  public List<cidade> findAll(){
    return this.c_Repository.findAll();
  }

  @Transactional
  public cidade update(cidade obj){
    Optional<cidade> upCidade = this.c_Repository.findById(obj.getId());
    if (upCidade.isPresent()) {
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

  @Transactional
  public void delete(Long id){
    try{
      this.c_Repository.deleteById(id);
    }catch(Exception e){
      throw new RuntimeException("Erro ao excluir");
    }
  }

  public cidade findById(Long id){
    Optional<cidade> cidade = this.c_Repository.findById(id);
    return cidade.orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
  }
}