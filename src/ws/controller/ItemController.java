package ws.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ws.model.Item;
import ws.repository.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@RequestMapping(value = "/item", method = RequestMethod.GET, 
			produces = "application/json")
	public List<Item> get() {
		return itemRepository.findAll();
	}
	
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Item> getPorId(@PathVariable(value = "id") long id) {
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent()) {
			return new ResponseEntity<Item>(item.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/item", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public Item post(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@RequestMapping(value = "/item/{id}", method = RequestMethod.PUT,
			consumes = "application/json", produces = "application/json")
	public ResponseEntity<Item> put(@PathVariable(value = "id") long id,
			@Valid @RequestBody Item novoItem) {
		Optional<Item> antigoItem = itemRepository.findById(id);
		if (antigoItem.isPresent()) {
			Item item = antigoItem.get();
			item.setNome(novoItem.getNome());
			item.setQuantidade(novoItem.getQuantidade());
			item.setValor(novoItem.getValor());
			itemRepository.save(item);
			return new ResponseEntity<Item>(item, HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE,
			produces = "application/json")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent()) {
			itemRepository.delete(item.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
