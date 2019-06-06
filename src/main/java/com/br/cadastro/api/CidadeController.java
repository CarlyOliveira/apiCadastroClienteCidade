package com.br.cadastro.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.cadastro.model.Cidade;
import com.br.cadastro.service.CidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cidade")
@Api(value="API REST CIDADES")
@CrossOrigin(origins="*")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna as cidades cadastradas por nome")
	public Iterable<Cidade> getNome(@PathVariable("nome") String nome) {
		return cidadeService.getCidadeNome(nome);
	}

	@RequestMapping(value = "estado/{estado}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna a cidade cadastrada por id")
	public Iterable<Cidade> getEstado(@PathVariable("estado") String estado) {
		return cidadeService.getCidadeEstado(estado);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Cadastra a cidade")
	public ResponseEntity<?> save(@Valid @RequestBody Cidade cidade) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.save(cidade));
	}

}
