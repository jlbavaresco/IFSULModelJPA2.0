package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import java.util.Calendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirDesejos {
    
    EntityManager em;
    
    public TestePersistirDesejos() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {        
        em.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            PessoaFisica pf = em.find(PessoaFisica.class, 2);
            Produto p = em.find(Produto.class, 2);
            pf.getDesejos().add(p);
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
        
    }
    
}
