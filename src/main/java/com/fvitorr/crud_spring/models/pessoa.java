package com.fvitorr.crud_spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class pessoa {
  public static final String TABLE_NAME = "pessoa";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id",unique = true)
  private long id;

  @Column(name = "nome",length = 255, nullable = false)
  private String nome;

  @Column(name = "time",length = 255, nullable = false)
  private String time;

  @Column(name = "hobbie", nullable = false)
  private String hobbie;

  @ManyToOne
  @Column(name = "id_cidade", nullable = false)
  private String id_cidade;
}
