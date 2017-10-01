package br.edu.ifsul.testes.junit;


import br.edu.ifsul.modelo.Locatario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirLocatario {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLocatario() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-Projeto-E1");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Locatario obj = new Locatario();
            obj.setNome("Eric");
            obj.setCpf("697.051.030-11");
            obj.setEmail("eric_marins@hotmail.com");
            obj.setTelefone("(54)999223344");
            obj.setRenda(1400.00);
            obj.setLocalTrabalho("Cia Teste");
            obj.setTelefoneTrabalho("3329-3566");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
