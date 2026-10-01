package br.com.luisfillipe.hotel.controller;
import br.com.luisfillipe.hotel.model.Hospede; import br.com.luisfillipe.hotel.repository.HospedeRepository; import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/hospedes") public class HospedeController{
 private final HospedeRepository r; public HospedeController(HospedeRepository r){this.r=r;}
 @GetMapping public List<Hospede> listar(){return r.findAll();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Hospede criar(@Valid @RequestBody Hospede h){return r.save(h);}
}
