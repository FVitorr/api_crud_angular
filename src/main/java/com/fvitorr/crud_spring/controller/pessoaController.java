package com.fvitorr.crud_spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fvitorr.crud_spring.models.cidade;
import com.fvitorr.crud_spring.models.pessoa;
import com.fvitorr.crud_spring.services.pessoaServices;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/pessoa")
@Validated
public class pessoaController {
  @Autowired
  private pessoaServices pessoaS;

  @GetMapping
  public ResponseEntity<List<pessoa>> getAllCidades() {
      List<pessoa> pessoas = pessoaS.findAll();
      return new ResponseEntity<>(pessoas, HttpStatus.OK);
  }

  @PostMapping
  @Validated
  public ResponseEntity<Void> create( @RequestBody pessoa obj){
    this.pessoaS.create(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  @Validated
  public ResponseEntity<Void> updade(@RequestBody pessoa obj, @PathVariable Long id) {
      obj.setId(id);
      this.pessoaS.update(obj);
      return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  @Validated
  public ResponseEntity<Void> delete(@Validated @PathVariable Long id){
    this.pessoaS.delete(id);
    return ResponseEntity.noContent().build();
  }
}
