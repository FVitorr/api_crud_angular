package com.fvitorr.crud_spring.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
      pessoa ex_Pessoa = upPessoa.get();
      
      // Atualizar os campos desejados
      ex_Pessoa.setNome(obj.getNome());
      ex_Pessoa.setTime(obj.getTime());
      ex_Pessoa.setCpf(obj.getCpf());
      ex_Pessoa.setHobbie(obj.getHobbie());
      ex_Pessoa.setCidade(obj.getCidade());
      
      // Salvar o objeto atualizado de volta ao banco de dados
      return p_Repository.save(ex_Pessoa);
    } else {
        // Opcional: lançar uma exceção ou retornar um resultado indicando que a cidade não foi encontrada
        throw new RuntimeException("Cidade com ID " + obj.getId() + " não encontrada.");
    }
  }

  @Transactional
  public void delete(Long id){
    try{
      this.p_Repository.deleteById(id);
    }catch(Exception e){
      throw new RuntimeException("Erro ao excluir");
    }
  }

  // Verificar se há pessoas associadas a uma cidade
  public boolean hasPessoasAssociated(Long cidadeId) {
    long count = p_Repository.countByIdCidade(cidadeId);
    return count > 0;
  }
}
