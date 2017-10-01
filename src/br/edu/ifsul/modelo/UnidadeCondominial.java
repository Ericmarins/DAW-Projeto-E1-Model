/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eric_
 */
@Entity
@Table(name = "unidade_condominial")
public class UnidadeCondominial implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_unidadeCond", sequenceName = "seq_unidadeCond_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_unidadeCond", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O numero não pode ser nulo")
    @NotBlank(message = "O numero não pode ser em branco")
    @Length(max = 5, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name = "numero", length = 5, nullable = false) 
    private String numero;
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    @NotNull(message = "A area deve ser informada")
    @Column(name = "area", nullable = false, columnDefinition = "decimal(5,2)")
    private Double area; 
    @NotNull(message = "O número do quarto deve ser informado")
    @Column(name = "numero_quarto", nullable = false)
    private Integer numeroQuarto;
    @NotNull(message = "O condominio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    private Condominio condominio;
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa proprietario;
    
    public UnidadeCondominial(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa pessoa) {
        this.proprietario = pessoa;
    }  
    
}
