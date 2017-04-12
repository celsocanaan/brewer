package com.algaworks.brewer.controle.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.algaworks.brewer.modelo.Cidade;


/**
 * Classe para converter campo digitado para o objeto e vice-versa Deve-se
 * registrar na WebConfig.FormattingConversionService
 * 
 * @author celso
 *
 */
public class ConversorCidade implements Converter<String, Cidade> {

	@Override
	public Cidade convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Cidade cidade = new Cidade();
			cidade.setId(Long.valueOf(id));
			return cidade;
		}
		return null;
	}

}
