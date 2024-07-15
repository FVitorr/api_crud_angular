package com.fvitorr.crud_spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = pessoa.TABLE_NAME)
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

  @Column(name = "cpf",length = 255, nullable = false)
  private String cpf;

  @Column(name = "hobbie", nullable = false)
  private String hobbie;

  @ManyToOne
  @JoinColumn(name = "id_cidade", nullable = false)
  private cidade cidade;
}
