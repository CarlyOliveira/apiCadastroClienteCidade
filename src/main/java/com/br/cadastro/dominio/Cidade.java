package com.br.cadastro.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@ApiModel(value="Cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("Codigo da cidade")
	private long id;

	@NotBlank(message = "{msg.validacao.campo.cidade.nome}")
	@ApiModelProperty("Nome da cidade")
	private String nome;

	@NotBlank(message = "{msg.validacao.campo.cidade.estado}")
	@ApiModelProperty("Estado que a cidade faz parte.")
	private String estado;

}
