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

import com.br.cadastro.dominio.Cliente;
import com.br.cadastro.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cliente")
@Api(value="API REST CLIENTES")
@CrossOrigin(origins="*")
public class ClienteApi {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "clientes", method = RequestMethod.GET)
	@ApiOperation(value="Retorna os clientes cadastrados")
	public Iterable<Cliente> getClientes() {
		return clienteService.getClientes();
	}

	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna o cliente cadastrado por id")
	public Cliente getClienteId(@PathVariable("id") Long id) {
		return clienteService.getClienteId(id);
	}

	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna o cliente cadastrado por nome")
	public Iterable<Cliente> getClienteNome(@PathVariable("nome") String nome) {
		return clienteService.getClienteNome(nome);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Deleta o cliente cadastrado por id")
	public Cliente deleteCliente(@Valid @PathVariable Long id) throws Exception {
		return clienteService.delete(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ApiOperation(value="Altera o nome e o sobrenomecliente do cliente cadastrado")
	public Cliente putNomeCliente(@Valid @RequestBody Cliente cliente, @PathVariable Long id) throws Exception {
		return clienteService.setClienteNome(cliente, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Cadastra o cliente")
	public ResponseEntity<?> saveCliente(@Valid @RequestBody Cliente cliente) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

}
