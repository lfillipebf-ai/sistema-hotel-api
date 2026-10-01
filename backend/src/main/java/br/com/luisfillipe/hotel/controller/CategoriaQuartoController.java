package br.com.luisfillipe.hotel.controller;
import br.com.luisfillipe.hotel.model.CategoriaQuarto; import br.com.luisfillipe.hotel.repository.CategoriaQuartoRepository; import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/categorias") public class CategoriaQuartoController{
 private final CategoriaQuartoRepository r; public CategoriaQuartoController(CategoriaQuartoRepository r){this.r=r;}
 @GetMapping public List<CategoriaQuarto> listar(){return r.findAll();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public CategoriaQuarto criar(@Valid @RequestBody CategoriaQuarto c){return r.save(c);}
}
