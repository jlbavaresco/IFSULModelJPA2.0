package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.PessoaFisica;
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
public class TestePersistirPessoaFisica {
    
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("459.933.470-74");
            pf.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Jorge Bavaresco");
            pf.setNomeUsuario("jorgebavaresco");
            pf.setRg("8945067864");
            pf.setSenha("usuario");
            pf.setTelefone("(54)7896-0956");
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
