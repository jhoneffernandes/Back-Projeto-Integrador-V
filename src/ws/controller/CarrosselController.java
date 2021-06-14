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

import ws.model.Carrossel;
import ws.repository.CarrosselRepository;

@RestController
public class CarrosselController {

	@Autowired
	private CarrosselRepository carrosselRepository;
	
	@RequestMapping(value = "/carrossel", method = RequestMethod.GET, 
			produces = "application/json")
	public List<Carrossel> get() {
		return carrosselRepository.findAll();
	}
	
	@RequestMapping(value = "/carrossel/{id}", method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Carrossel> getPorId(@PathVariable(value = "id") long id) {
		Optional<Carrossel> carrossel = carrosselRepository.findById(id);
		if (carrossel.isPresent()) {
			return new ResponseEntity<Carrossel>(carrossel.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/carrossel", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public Carrossel post(@Valid @RequestBody Carrossel carrossel) {
		return carrosselRepository.save(carrossel);
	}
	
	@RequestMapping(value = "/carrossel/{id}", method = RequestMethod.PUT,
			consumes = "application/json", produces = "application/json")
	public ResponseEntity<Carrossel> put(@PathVariable(value = "id") long id,
			@Valid @RequestBody Carrossel novoCarrossel) {
		Optional<Carrossel> antigoCarrossel = carrosselRepository.findById(id);
		if (antigoCarrossel.isPresent()) {
			Carrossel carrossel = antigoCarrossel.get();
			carrossel.setTitulo(novoCarrossel.getTitulo());
			carrossel.setTexto(novoCarrossel.getTexto());
			carrossel.setImg(novoCarrossel.getImg());
			carrossel.setPosition(novoCarrossel.getPosition());
			carrosselRepository.save(carrossel);
			return new ResponseEntity<Carrossel>(carrossel, HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/carrossel/{id}", method = RequestMethod.DELETE,
			produces = "application/json")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
		Optional<Carrossel> carrossel = carrosselRepository.findById(id);
		if (carrossel.isPresent()) {
			carrosselRepository.delete(carrossel.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
