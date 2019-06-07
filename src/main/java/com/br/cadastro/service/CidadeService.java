package com.br.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cadastro.dominio.Cidade;
import com.br.cadastro.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public List<Cidade> getCidades() {
		return cidadeRepository.findAll();
	}

	public Cidade getCidadeId(Long id) {
		return cidadeRepository.findById(id).get();
	}

	public Iterable<Cidade> getCidadeNome(String nome) {
		return cidadeRepository.findByNome(nome);
	}

	public Iterable<Cidade> getCidadeEstado(String estado) {
		return cidadeRepository.findByEstado(estado);
	}

	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

}
