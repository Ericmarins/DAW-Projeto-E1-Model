/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric_
 */
public class FabricaObjetos {    
    public static List<Condominio> carregaCondominios(){
        List<Condominio> lista= new ArrayList<>();
        UnidadeCondominial u= new UnidadeCondominial();
        u.setId(30);
        u.setNumero("985-D");
        u.setDescricao("AP Com vista para o mar");
        u.setArea(130.00);
        u.setNumeroQuarto(15);
        Condominio c= new Condominio();
        c.setId(25);
        c.setNome("Teste jasper");
        c.setEndereco("Teste relatorio");
        c.setNumero("lalalala");
        c.setCep("99500.000");
        c.adicionarUnidade(u);
        lista.add(c);
        
        Condominio c2= new Condominio();
        c2.setId(26);
        c2.setNome("Teste jasper 2");
        c2.setEndereco("Teste relatorio 2 ");
        c2.setNumero("lalalala 2");
        c2.setCep("99500.000");
        c2.adicionarUnidade(u);
        lista.add(c2);
        
        return lista;
    }
}
