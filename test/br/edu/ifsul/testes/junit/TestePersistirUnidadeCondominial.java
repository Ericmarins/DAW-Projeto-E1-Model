package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.UnidadeCondominial;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirUnidadeCondominial {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirUnidadeCondominial() {
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
    public void teste() {
        boolean exception = false;
        try {
            Pessoa p = em.find(Pessoa.class, 2);
            Condominio c = em.find(Condominio.class, 1);
            UnidadeCondominial uc = new UnidadeCondominial();
            uc.setArea(125.00);
            uc.setCondominio(c);
            uc.setProprietario(p);
            uc.setDescricao("Dois quartos, sala, cozinha, banheiro e vaga na garagem.");
            uc.setNumero("456-B");
            uc.setNumeroQuarto(12);
            em.getTransaction().begin();
            em.persist(uc);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }
        // verifica que o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }

}
