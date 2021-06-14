package ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.Carrossel;

@Repository
public interface CarrosselRepository extends JpaRepository<Carrossel, Long> {

}
