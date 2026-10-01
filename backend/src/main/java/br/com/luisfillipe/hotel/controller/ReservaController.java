package br.com.luisfillipe.hotel.controller;
import br.com.luisfillipe.hotel.model.*; import br.com.luisfillipe.hotel.repository.*; import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.time.LocalDate; import java.util.List;
@RestController @RequestMapping("/api/reservas") public class ReservaController{
 private final ReservaRepository rr; private final HospedeRepository hr; private final QuartoRepository qr;
 public ReservaController(ReservaRepository rr,HospedeRepository hr,QuartoRepository qr){this.rr=rr;this.hr=hr;this.qr=qr;}
 @GetMapping public List<Reserva> listar(){return rr.findAll();}
 @GetMapping("/periodo") public List<Reserva> periodo(@RequestParam LocalDate inicio,@RequestParam LocalDate fim){return rr.findByCheckInBetween(inicio,fim);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Reserva criar(@Valid @RequestBody Reserva r){
  if(!r.getCheckOut().isAfter(r.getCheckIn())) throw new IllegalArgumentException("checkOut deve ser posterior ao checkIn");
  Hospede h=hr.findById(r.getHospede().getId()).orElseThrow(); Quarto q=qr.findById(r.getQuarto().getId()).orElseThrow();
  if(!q.isDisponivel()) throw new IllegalStateException("Quarto indisponivel");
  r.setHospede(h); r.setQuarto(q); r.setStatus(StatusReserva.RESERVADA); q.setDisponivel(false); qr.save(q); return rr.save(r);
 }
 @PatchMapping("/{id}/check-in") public Reserva checkIn(@PathVariable Long id){
  Reserva r=rr.findById(id).orElseThrow();
  if(r.getStatus()!=StatusReserva.RESERVADA) throw new IllegalStateException("Reserva não está disponível para check-in");
  r.setStatus(StatusReserva.CHECK_IN); return rr.save(r);
 }
 @PatchMapping("/{id}/check-out") public Reserva checkOut(@PathVariable Long id){
  Reserva r=rr.findById(id).orElseThrow();
  if(r.getStatus()!=StatusReserva.CHECK_IN) throw new IllegalStateException("Reserva não está em check-in");
  r.setStatus(StatusReserva.CHECK_OUT); r.getQuarto().setDisponivel(true); qr.save(r.getQuarto()); return rr.save(r);
 }
 @PatchMapping("/{id}/cancelar") public Reserva cancelar(@PathVariable Long id){
  Reserva r=rr.findById(id).orElseThrow();
  if(r.getStatus()==StatusReserva.CHECK_OUT||r.getStatus()==StatusReserva.CANCELADA) throw new IllegalStateException("Reserva não pode ser cancelada");
  r.setStatus(StatusReserva.CANCELADA); r.getQuarto().setDisponivel(true); qr.save(r.getQuarto()); return rr.save(r);
 }
}
