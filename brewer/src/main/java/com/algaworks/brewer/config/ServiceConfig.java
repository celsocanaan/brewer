package com.algaworks.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.algaworks.brewer.servico.ServicoCadaCliente;

/*
 * Informe o pacote onde estão os serviços.
 * Basta colocar no ComponentScaf uma classe para identificar qual é o pacote dos serviços.
 */
@Configuration
@ComponentScan(basePackageClasses = ServicoCadaCliente.class )
public class ServiceConfig {

}
