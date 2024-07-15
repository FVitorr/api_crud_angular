package com.fvitorr.crud_spring.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = cidade.TABLE_NAME)
public class cidade {
  public static final String TABLE_NAME = "cidade";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id",unique = true)
  private long id;

  @Column(name = "cidade",length = 255, nullable = false)
  private String cidade;

  @Column(name = "estado",length = 255, nullable = false)
  private String estado;

  @Column(name = "populacao", nullable = false)
  private long populacao;

}
