package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Mensalidades;
import br.edu.ifsul.modelo.Aluguel;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirMensalidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMensalidade() {
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
           Aluguel a= em.find(Aluguel.class, 1);
           Mensalidades m= new Mensalidades();
           m.setAluguel(a);
           m.setValor(800.00);
           m.setValorPagamento(800.00);
           m.setVencimento(new GregorianCalendar(2017, Calendar.NOVEMBER, 10));
           m.setDataPagamento(new GregorianCalendar(2017, Calendar.OCTOBER, 9));                
           em.getTransaction().begin();
           em.persist(m);
           em.getTransaction().commit();
       } catch (Exception e){
           e.printStackTrace();
           exception = true;
       }
       // verifica que o valor do atributo exception continua falso
       Assert.assertEquals(false, exception);
    }
    
}
