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

import ws.model.Mensagem;
import ws.repository.MensagemRepository;

@RestController
public class MensagemController {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@RequestMapping(value = "/mensagem", method = RequestMethod.GET, 
			produces = "application/json")
	public List<Mensagem> get() {
		return mensagemRepository.findAll();
	}
	
	@RequestMapping(value = "/mensagem/{id}", method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Mensagem> getPorId(@PathVariable(value = "id") long id) {
		Optional<Mensagem> mensagem = mensagemRepository.findById(id);
		if (mensagem.isPresent()) {
			return new ResponseEntity<Mensagem>(mensagem.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/mensagem", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public Mensagem post(@Valid @RequestBody Mensagem mensagem) {
		return mensagemRepository.save(mensagem);
	}
	
	@RequestMapping(value = "/mensagem/{id}", method = RequestMethod.PUT,
			consumes = "application/json", produces = "application/json")
	public ResponseEntity<Mensagem> put(@PathVariable(value = "id") long id,
			@Valid @RequestBody Mensagem novoMensagem) {
		Optional<Mensagem> antigoMensagem = mensagemRepository.findById(id);
		if (antigoMensagem.isPresent()) {
			Mensagem mensagem = antigoMensagem.get();
			mensagem.setNome(novoMensagem.getNome());
			mensagem.setCidade(novoMensagem.getCidade());
			mensagem.setMensagem(novoMensagem.getMensagem());
			mensagemRepository.save(mensagem);
			return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/mensagem/{id}", method = RequestMethod.DELETE,
			produces = "application/json")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
		Optional<Mensagem> mensagem = mensagemRepository.findById(id);
		if (mensagem.isPresent()) {
			mensagemRepository.delete(mensagem.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
