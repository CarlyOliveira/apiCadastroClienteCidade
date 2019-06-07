package com.br.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cadastro.dominio.Cliente;
import com.br.cadastro.exception.CadastroException;
import com.br.cadastro.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Iterable<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteId(Long id) {
		return clienteRepository.findById(id).get();
	}

	public Iterable<Cliente> getClienteNome(String nome) {
		return clienteRepository.findByNome(nome);
	}

	public Cliente delete(Long id) throws Exception {
		clienteRepository.findById(id).orElseThrow(() -> new CadastroException("Cliente nao foi encontrado"));
		Cliente cliente = clienteRepository.findById(id).get();
		clienteRepository.delete(cliente);
		return cliente;

	}

	public Cliente save(Cliente cliente) throws Exception {
		if (clienteRepository.findById(cliente.getId()).isPresent()) {
			throw new CadastroException("Cliente ja esta cadastrado");
		}
		return clienteRepository.save(cliente);

	}

	public Cliente setClienteNome(Cliente cliente, Long id) throws Exception {
		clienteRepository.findById(id).orElseThrow(() -> new CadastroException("Cliente nao foi encontrado"));
		clienteRepository.findById(id).ifPresent(c -> {
			c.setNome(cliente.getNome());
			c.setSobreNome(cliente.getSobreNome());

			clienteRepository.save(c);
		});

		return clienteRepository.findById(id).get();

	}
}
