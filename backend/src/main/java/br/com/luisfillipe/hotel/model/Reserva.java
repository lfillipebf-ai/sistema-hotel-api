package br.com.luisfillipe.hotel.model;
import jakarta.persistence.*; import jakarta.validation.constraints.NotNull; import java.time.LocalDate;
@Entity public class Reserva {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Hospede hospede;
 @ManyToOne(optional=false) private Quarto quarto;
 @NotNull private LocalDate checkIn; @NotNull private LocalDate checkOut;
 @Enumerated(EnumType.STRING) private StatusReserva status=StatusReserva.RESERVADA;
 public Long getId(){return id;} public Hospede getHospede(){return hospede;} public void setHospede(Hospede v){hospede=v;}
 public Quarto getQuarto(){return quarto;} public void setQuarto(Quarto v){quarto=v;}
 public LocalDate getCheckIn(){return checkIn;} public void setCheckIn(LocalDate v){checkIn=v;}
 public LocalDate getCheckOut(){return checkOut;} public void setCheckOut(LocalDate v){checkOut=v;}
 public StatusReserva getStatus(){return status;} public void setStatus(StatusReserva v){status=v;}
}
