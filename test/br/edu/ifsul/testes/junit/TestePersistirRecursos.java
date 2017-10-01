package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Recurso;
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
public class TestePersistirRecursos {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirRecursos() {
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
           
           Condominio c = em.find(Condominio.class, 1);           
           Recurso r = em.find(Recurso.class, 1);
           c.getRecursos().add(r);
           em.getTransaction().begin();
           em.persist(c);
           em.getTransaction().commit();
       } catch (Exception e){
           e.printStackTrace();
           exception = true;
       }
       // verifica que o valor do atributo exception continua falso
       Assert.assertEquals(false, exception);
    }
    
}
