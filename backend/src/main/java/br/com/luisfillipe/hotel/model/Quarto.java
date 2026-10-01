package br.com.luisfillipe.hotel.model;
import jakarta.persistence.*; import jakarta.validation.constraints.NotBlank;
@Entity public class Quarto {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String numero; @ManyToOne(optional=false) private CategoriaQuarto categoria; private boolean disponivel=true;
 public Long getId(){return id;} public String getNumero(){return numero;} public void setNumero(String v){numero=v;}
 public CategoriaQuarto getCategoria(){return categoria;} public void setCategoria(CategoriaQuarto v){categoria=v;}
 public boolean isDisponivel(){return disponivel;} public void setDisponivel(boolean v){disponivel=v;}
}
