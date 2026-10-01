package br.com.luisfillipe.hotel.repository;
import br.com.luisfillipe.hotel.model.Reserva; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.List;
public interface ReservaRepository extends JpaRepository<Reserva,Long>{List<Reserva> findByCheckInBetween(LocalDate inicio,LocalDate fim);}
