/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "condominio")
public class Condominio implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40 ,nullable = false)
    private String nome;
    @NotNull(message = "O endereco não pode ser nulo")
    @NotBlank(message = "O endereco não pode ser em branco")
    @Length(max = 50, message = "O endereco não pode ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50 ,nullable = false)
    private String endereco;
    @NotNull(message = "O numero não pode ser nulo")
    @NotBlank(message = "O numero não pode ser em branco")
    @Length(max = 5, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name = "numero", length = 5, nullable = false) 
    private String numero;
    @NotNull(message = "O cep não pode ser nulo")
    @NotBlank(message = "O cep não pode ser em branco")
    @Length(max = 9, message = "O cep não pode ter mais que {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @ManyToMany
    @JoinTable(name = "recursos",
            joinColumns = 
            @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false))
    private List<Recurso> recursos= new ArrayList<>();
    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UnidadeCondominial> unidades= new ArrayList<>();
    
    public Condominio(){
        
    }

    public void adicionarUnidade(UnidadeCondominial unidade){
        unidade.setCondominio(this);
        this.unidades.add(unidade);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public List<UnidadeCondominial> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadeCondominial> unidades) {
        this.unidades = unidades;
    }
    
    
}
