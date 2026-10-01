package br.com.luisfillipe.hotel.controller;
import br.com.luisfillipe.hotel.model.Quarto; import br.com.luisfillipe.hotel.repository.QuartoRepository; import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/quartos") public class QuartoController{
 private final QuartoRepository r; public QuartoController(QuartoRepository r){this.r=r;}
 @GetMapping public List<Quarto> listar(){return r.findAll();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Quarto criar(@Valid @RequestBody Quarto q){return r.save(q);}
}
