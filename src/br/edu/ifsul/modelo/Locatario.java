/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eric_
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "locatario")
public class Locatario extends Pessoa implements Serializable{
    
    @NotNull(message = "A renda deve ser informada")
    @Column(name = "renda", nullable = false, columnDefinition = "decimal(12,2)")
    private Double renda;
    @NotNull(message = "O local de trabalho deve ser informado")
    @NotBlank(message = "O local de trabalho não pode ser em branco")
    @Length(max = 50, message = "O local de trabalho não pode ter mais que {max} caracteres")
    @Column(name = "localTrabalho", length = 50, nullable = false)
    private String localTrabalho;
    @NotNull(message = "O numero não pode ser nulo")
    @NotBlank(message = "O numero não pode ser em branco")
    @Length(max = 15, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name = "telefoneTrabalho", length = 15 ,nullable = false) 
    private String telefoneTrabalho;
    
    public Locatario(){
        
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }
}
