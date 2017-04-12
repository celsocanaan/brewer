/**
 * Classe WebConfig 
 * Classe para Configuração do Spring 
 */
package com.algaworks.brewer.config;

import java.math.BigDecimal;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.algaworks.brewer.controle.ControladorCliente;
import com.algaworks.brewer.controle.conversor.ConversorCidade;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@ComponentScan(basePackageClasses = { ControladorCliente.class }) // Encontre
// @ComponentScan(basePackages = { "com.algaworks.brewer.controle" }) // Encontre os
// controles que estão neste pacote
@EnableWebMvc // Habilita o projeto para web MVC
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Bean // Bean deixa disponivel dentro no contexto Spring
	public ViewResolver viewResolver() { // Para encontrar a view a ser exibida
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}

	/**
	 * Classe que processa os arquivos HTML
	 * 
	 * @return
	 */
	@Bean
	public TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());

		engine.addDialect(new LayoutDialect());
//		engine.addDialect(new BrewerDialect());
//		engine.addDialect(new DataAttributeDialect());

		return engine;
	}

	/**
	 * Resolve os templates do Spring
	 * 
	 * @return
	 */
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("classpath:/templates/"); // Local onde estão as
														// views (html)
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}

	/**
	 * Método addResourceHandlers Este método procura os recursos estáticos no
	 * local abaixo. Recursos que não tem controller
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	/**
	 * Classe para registrar os conversores O Spring procura
	 * mvcConversionService() para conversão.
	 * 
	 * @return
	 */
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		conversionService.addConverter(new ConversorCidade());
		
		NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter("###,###,###,##0.00");
		conversionService.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);

		NumberStyleFormatter integerFormatter = new NumberStyleFormatter("##,###,##0");
		conversionService.addFormatterForFieldType(Integer.class, integerFormatter);
		return conversionService;
	}
	
	/**
	 * Força a utilizar o idioma pt_BR. Alterar na internacionalização
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
