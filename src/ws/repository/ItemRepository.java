package ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
