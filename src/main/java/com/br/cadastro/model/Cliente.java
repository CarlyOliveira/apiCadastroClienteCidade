package com.br.cadastro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "{msg.validacao.campo.cliente.nome}")
	private String nome;

	@NotBlank(message = "{msg.validacao.campo.cliente.sobrenome}")
	private String sobreNome;

	@NotNull(message = "{msg.validacao.campo.cliente.genero}")
	@Enumerated
	private Genero genero;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "{msg.validacao.campo.cliente.dataDeNascimento}")
	@PastOrPresent(message = "{msg.validacao.campo.cliente.dataDeNascimento.futuraOuPresente}")
	private Date dataDeNascimento;

	@NotNull(message = "{msg.validacao.campo.cliente.idade}")
	private Integer idade;

	@NotNull(message = "{msg.validacao.campo.cliente.cidade}")
	@OneToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

}
