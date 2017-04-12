/**
 * Classe Appinitializer
 * Responsável pela configuração de mapeamento para Spring localizar os controles 
 */

package com.algaworks.brewer.config.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.algaworks.brewer.config.JPAConfig;
import com.algaworks.brewer.config.ServiceConfig;
import com.algaworks.brewer.config.WebConfig;

public class Appinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Método getRootConfigClasses()
	 * Configurações que não fazem parte da Web. São os serviços que estão disponiveis para
	 * os métodos abaixo
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { JPAConfig.class, ServiceConfig.class };
	}

	/**
	 * Configurações que fazem parte da Web.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		 // Classe para configurar o Spring Web para achar os controles do Situr
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// Padrão da URL que deve ser encaminhado para receber a requisição Web.
		return new String[] { "/" }; 
	}

	/**
	 * Filtros para compatibilização de acentuação
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}
}
