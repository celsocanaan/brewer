package com.algaworks.brewer.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table()
public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	@JsonIgnore
	private Estado estado;
	
	@Column(name = "cod_municipio")
	private Integer codMunicipio;
	
	@Column(name = "fone_area")
	private Integer foneArea; 
	
	@Column()
	private BigDecimal latitude; 
	
	@Column()
	private BigDecimal longitude; 
	
	@OneToMany(mappedBy = "endCidade")  //mapeado pelo atributo endCidade de pessoa (não é end_cidade 
	private List<Cliente> pessoas;

	public Cidade() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getFoneArea() {
		return foneArea;
	}

	public void setFoneArea(Integer foneArea) {
		this.foneArea = foneArea;
	}

	public Integer getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public Integer getFoneFarea() {
		return foneArea;
	}

	public void setFoneFarea(Integer foneArea) {
		this.foneArea = foneArea;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public List<Cliente> getPessoas() {
		return pessoas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public void setPessoas(List<Cliente> pessoas) {
		this.pessoas = pessoas;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
