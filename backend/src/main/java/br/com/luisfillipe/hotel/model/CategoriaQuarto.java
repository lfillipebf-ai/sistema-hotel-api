package br.com.luisfillipe.hotel.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity public class CategoriaQuarto {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String nome; @NotNull private Integer capacidade; @NotNull private Double diaria;
 public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String v){nome=v;}
 public Integer getCapacidade(){return capacidade;} public void setCapacidade(Integer v){capacidade=v;}
 public Double getDiaria(){return diaria;} public void setDiaria(Double v){diaria=v;}
}
