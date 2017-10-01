package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Condominio;
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
public class TestePersistirCondominio {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCondominio() {
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
           
           Condominio c  = new Condominio();
           c.setEndereco("Rua Teste 1");
           c.setNome("Condominio Teste");
           c.setNumero("1697");
           c.setCep("99500-000");
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
