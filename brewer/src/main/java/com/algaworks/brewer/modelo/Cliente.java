package com.algaworks.brewer.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table()     //@Table(name = "Cliente") se não definir, assume o nome da Classe
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Deve-se gerar o hashCode()
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)  //Salva o código em vez da descrição
	private TipoPessoa tipo;
	
	@Column()
//	@NotBlank(message = "Campo obrigatório")
    private Long inscricao;   //PlacaVeiculo, CNPJ, ...
	
	@NotBlank(message = "Nome obrigatório")
    private String nome;
	
	@Column()
	@NotBlank(message = "Título obrigatório")
	private String titulo;

	@Column()
	private String apelido;
	
	@Column(name = "nome_resp")
    private String nomeResp;
	
	@Column()
    private String sexo;
	
	@Column(name = "estado_civil")
    private String estadoCivil;
	
    @ManyToOne
	@JoinColumn(name = "end_tipo_logradouro")
    private TipoLogradouro endTipoLogradouro;
	
	@Column(name = "end_logradouro")
    private String endLogradouro;
	
	@Column(name = "end_numero")
    private Integer endNumero;
	
	@Column(name = "end_complemento")
    private String endComplemento;
	
	@Column(name = "end_bairro")
    private String endBairro;
    
    @ManyToOne
	@JoinColumn(name = "end_cidade")   //campo associado a Foreign Key da tabela Cliente.
	private Cidade endCidade;
	
//    @CEP
	@Column(name = "end_cep")
    private Integer endCep;
	
	@Column(name = "end_latitude")
    private BigDecimal endLatitude;
	
	@Column(name = "end_longitude")
    private BigDecimal endLongitude;
	
	@Column(name = "e_correio")
    private String eCorreio;
	
	@Column(name = "e_sitio")
    private String eSitio;
	
	@Column(name = "nasc_data")
    private Date nascData;
    
    @ManyToOne
	@JoinColumn(name = "nasc_cidade")
	private Cidade nascCidade;
	
	@Column(name = "pessoa_pai")
    private Long pessoaPai;
	
	@Column(name = "pessoa_mae")
    private Long pessoaMae;
	
	@Column(name = "pessoa_conjuge")
    private Long pessoaConjuge;
	
	@Column()
    private String identidade;
	
	@Column(name = "identidade_orgao")
    private String identidadeOrgao;
	

    //Construtor default é obrigatório para exibição correta pelo framework 
	public Cliente() {   
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Cidade getEndCidade() {
		return endCidade;
	}
	
	public void setEndCidade(Cidade endCidade) {
		this.endCidade = endCidade;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNomeResp() {
		return nomeResp;
	}

	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public TipoLogradouro getEndTipoLogradouro() {
		return endTipoLogradouro;
	}

	public void setEndTipoLogradouro(TipoLogradouro endTipoLogradouro) {
		this.endTipoLogradouro = endTipoLogradouro;
	}

	public String getEndLogradouro() {
		return endLogradouro;
	}

	public void setEndLogradouro(String endLogradouro) {
		this.endLogradouro = endLogradouro;
	}

	public Integer getEndNumero() {
		return endNumero;
	}

	public void setEndNumero(Integer endNumero) {
		this.endNumero = endNumero;
	}

	public String getEndComplemento() {
		return endComplemento;
	}

	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}

	public String getEndBairro() {
		return endBairro;
	}

	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}


	public Integer getEndCep() {
		return endCep;
	}

	public void setEndCep(Integer endCep) {
		this.endCep = endCep;
	}

	public BigDecimal getEndLatitude() {
		return endLatitude;
	}

	public void setEndLatitude(BigDecimal endLatitude) {
		this.endLatitude = endLatitude;
	}

	public BigDecimal getEndLongitude() {
		return endLongitude;
	}

	public void setEndLongitude(BigDecimal endLongitude) {
		this.endLongitude = endLongitude;
	}

	public String geteCorreio() {
		return eCorreio;
	}

	public void seteCorreio(String eCorreio) {
		this.eCorreio = eCorreio;
	}

	public String geteSitio() {
		return eSitio;
	}

	public void seteSitio(String eSitio) {
		this.eSitio = eSitio;
	}

	public Date getNascData() {
		return nascData;
	}

	public void setNascData(Date nascData) {
		this.nascData = nascData;
	}

	public Cidade getNascCidade() {
		return nascCidade;
	}

	public void setNascCidade(Cidade nascCidade) {
		this.nascCidade = nascCidade;
	}

	public Long getPessoaPai() {
		return pessoaPai;
	}

	public void setPessoaPai(Long pessoaPai) {
		this.pessoaPai = pessoaPai;
	}

	public Long getPessoaMae() {
		return pessoaMae;
	}

	public void setPessoaMae(Long pessoaMae) {
		this.pessoaMae = pessoaMae;
	}

	public Long getPessoaConjuge() {
		return pessoaConjuge;
	}

	public void setPessoaConjuge(Long pessoaConjuge) {
		this.pessoaConjuge = pessoaConjuge;
	}

	public Long getInscricao() {
		return inscricao;
	}

	public void setInscricao(Long inscricao) {
		this.inscricao = inscricao;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getIdentidadeOrgao() {
		return identidadeOrgao;
	}

	public void setIdentidadeOrgao(String identidadeOrgao) {
		this.identidadeOrgao = identidadeOrgao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}  
	
}
