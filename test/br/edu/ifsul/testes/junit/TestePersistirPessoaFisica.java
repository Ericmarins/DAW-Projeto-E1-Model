package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirPessoaFisica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-PU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
       boolean exception = false;
       try {
           Cidade c = em.find(Cidade.class, 4);
           PessoaFisica pf = new PessoaFisica();
           pf.setCidade(c);
           pf.setNome("Jorge Bavaresco");
           pf.setBairro("Vila Luiza");
           pf.setCep("99874-098");
           pf.setComplemento("blablabla");
           pf.setCpf("454.183.067-15");
           pf.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
           pf.setEndereco("Rua tal...");
           pf.setNascimento(new GregorianCalendar(1979, Calendar.OCTOBER, 25));
           pf.setRg("8758940394");           
           em.getTransaction().begin();
           em.persist(pf);
           em.getTransaction().commit();
       } catch (Exception e){
           e.printStackTrace();
           exception = true;
       }
       // verifica que o valor do atributo exception continua falso
       Assert.assertEquals(false, exception);
    }
    
}
