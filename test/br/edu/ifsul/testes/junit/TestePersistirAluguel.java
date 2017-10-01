package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.UnidadeCondominial;
import br.edu.ifsul.modelo.Locatario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author eric_
 */
public class TestePersistirAluguel {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAluguel() {
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
            UnidadeCondominial uc= em.find(UnidadeCondominial.class, 1);
            Locatario l= em.find(Locatario.class, 2);
            Aluguel a= new Aluguel();
            a.setValor(800.00);
            a.setInicioContrato(new GregorianCalendar(2017, Calendar.OCTOBER, 10));
            a.setFimContrato(new GregorianCalendar(2018, Calendar.JANUARY, 10));
            a.setDiaVencimento(10);
            a.setUnidade(uc);
            a.setLocatario(l);
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
