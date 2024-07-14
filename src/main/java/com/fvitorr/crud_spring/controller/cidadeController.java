package com.fvitorr.crud_spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fvitorr.crud_spring.models.cidade;
import com.fvitorr.crud_spring.services.cidadeServices;

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
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/cidade")
@Validated
public class cidadeController {
  @Autowired
  private cidadeServices cidadeS;

  @GetMapping
  public ResponseEntity<List<cidade>> getAllCidades() {
      List<cidade> cidades = cidadeS.findAll();
      return new ResponseEntity<>(cidades, HttpStatus.OK);
  }
  

  @GetMapping("/{id}")
  public ResponseEntity<cidade> findById(@PathVariable long id) {
    cidade obj = this.cidadeS.findById(id);
    return ResponseEntity.ok(obj);
  }

  @PostMapping
  @Validated
  public ResponseEntity<Void> create( @RequestBody cidade obj){
    this.cidadeS.create(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  @Validated
  public ResponseEntity<Void> updade(@RequestBody cidade obj, @PathVariable Long id) {
      obj.setId(id);
      this.cidadeS.update(obj);
      return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  @Validated
  public ResponseEntity<Void> delete(@Validated @PathVariable Long id){
    this.cidadeS.delete(id);
    return ResponseEntity.noContent().build();
  }
}