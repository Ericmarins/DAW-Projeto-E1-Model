package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author eric_
 */
public class TestePersistirPessoa {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoa() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-Projeto-E1");
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
           Pessoa p = new Pessoa();
           p.setNome("Eric Marins");
           p.setCpf("697.051.030-11");
           p.setEmail("eric_marins@hotmail.com");
           p.setTelefone("(54)999223344");           
           em.getTransaction().begin();
           em.persist(p);
           em.getTransaction().commit();
       } catch (Exception e){
           e.printStackTrace();
           exception = true;
       }
       // verifica que o valor do atributo exception continua falso
       Assert.assertEquals(false, exception);
    }
    
}
