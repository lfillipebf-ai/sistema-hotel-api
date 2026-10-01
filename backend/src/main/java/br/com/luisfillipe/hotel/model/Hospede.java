package br.com.luisfillipe.hotel.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity public class Hospede {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String nome; @NotBlank private String documento; @Email private String email; private String telefone;
 public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String v){nome=v;}
 public String getDocumento(){return documento;} public void setDocumento(String v){documento=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getTelefone(){return telefone;} public void setTelefone(String v){telefone=v;}
}
