package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirProduto {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirProduto() {
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
    public void teste() {
        boolean exception = false;
        try {
            Grupo g = new Grupo();
            g.setNome("Eletrônicos");
            Marca m = new Marca();
            m.setNome("Microsoft");
            Produto p = new Produto();
            p.setNome("Mouse Microsoft");
            p.setDescricao("Mouse Laser");
            p.setPreco(80.00);
            p.setEstoque(10.0);
            p.setGrupo(g);
            p.setMarca(m);
            em.getTransaction().begin();
            em.persist(g);
            em.persist(m);
            em.persist(p);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }
        // verifica que o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }

}
