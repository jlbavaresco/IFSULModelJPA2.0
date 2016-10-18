package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaItens;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirVenda {

    EntityManager em;

    public TestePersistirVenda() {
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
    public void teste() {
        // o teste não deve gerar exceção se tudo estiver correto
        boolean exception = false;
        try {
   
            Produto p = em.find(Produto.class, 2);
            PessoaFisica pf = em.find(PessoaFisica.class, 2);
            Venda v = new Venda();
            v.setData(Calendar.getInstance());
            v.setParcelas(3);
            v.setPessoaFisica(pf);
            VendaItens vi = new VendaItens();
            vi.setProduto(p);
            vi.setQuantidade(5.0);
            vi.setValorUnitario(p.getPreco());
            vi.setValorTotal(vi.getQuantidade()*vi.getValorUnitario());
            v.adicionarItem(vi);     
            em.getTransaction().begin();
            em.persist(v);            
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }

}
