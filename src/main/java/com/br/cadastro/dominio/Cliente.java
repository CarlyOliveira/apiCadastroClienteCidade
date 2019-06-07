package com.br.cadastro.dominio;

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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@ApiModel(value="Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("Codigo do cliente")
	private long id;

	@NotBlank(message = "{msg.validacao.campo.cliente.nome}")
	@ApiModelProperty("Nome do cliente")
	private String nome;

	@NotBlank(message = "{msg.validacao.campo.cliente.sobrenome}")
	@ApiModelProperty("Sobrenome do cliente")
	private String sobreNome;

	@NotNull(message = "{msg.validacao.campo.cliente.genero}")
	@Enumerated
	@ApiModelProperty("Genero do cliente. Recebe:  M - Masculino e F - Feminino")
	private Genero genero;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "{msg.validacao.campo.cliente.dataDeNascimento}")
	@PastOrPresent(message = "{msg.validacao.campo.cliente.dataDeNascimento.futuraOuPresente}")
	@ApiModelProperty(value="Data de nascimento do cliente. Deve ser igual ou inferior a data atual. - pattern: dd/MM/yyyy ")
	private Date dataDeNascimento;

	@NotNull(message = "{msg.validacao.campo.cliente.idade}")
	@ApiModelProperty("Idade do cliente")
	private Integer idade;

	@NotNull(message = "{msg.validacao.campo.cliente.cidade}")
	@OneToOne
	@JoinColumn(name = "id_cidade")
	@ApiModelProperty("Cidade do cliente. Deve ser uma cidade ja cadastrada, para isso, Use a Cidade Api.")
	private Cidade cidade;

}
