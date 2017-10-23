package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Endereco;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class UtilRelatorios {

    public static List<Produto> listaProdutos() {
        List<Produto> lista = new ArrayList<>();
        Categoria c = new Categoria();
        c.setNome("Eletrônicos");
        Marca samsung = new Marca();
        samsung.setNome("Samsung");
        Marca dell = new Marca();
        dell.setNome("Dell");
        Produto p1 = new Produto();
        p1.setNome("Mouse Laser");
        p1.setDescricao("Mouse com alta precisão");
        p1.setPreco(130.00);
        p1.setQuantidadeEstoque(40.0);
        p1.setCategoria(c);
        p1.setMarca(dell);
        Produto p2 = new Produto();
        p2.setNome("Impressora Deskjet");
        p2.setDescricao("Impressora jato de Tinta");
        p2.setPreco(180.00);
        p2.setQuantidadeEstoque(3.0);
        p2.setCategoria(c);
        p2.setMarca(samsung);
        Produto p3 = new Produto();
        p3.setNome("HD USB 1TB");
        p3.setDescricao("HD Externo USB 1TB");
        p3.setPreco(450.00);
        p3.setQuantidadeEstoque(30.0);
        p3.setCategoria(c);
        p3.setMarca(samsung);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        return lista;
    }
    
    public static List<PessoaFisica> listaPessoas(){
        List<PessoaFisica> lista = new ArrayList<>();
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Jorge Bavaresco");
        pf.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
        pf.setTelefone("(54)9984-5983");
        pf.setRg("9847593043");
        pf.setCpf("984.384.234-98");
        Endereco e = new Endereco();
        e.setEndereco("Av Brasil");
        e.setNumero("4598");
        e.setComplemento("AP 407");
        e.setBairro("Centro");
        e.setCep("98756-988");
        Cidade c = new Cidade();
        c.setNome("Passo Fundo");
        e.setCidade(c);
        pf.adicionarEndereco(e);
        Produto p1 = new Produto();
        p1.setNome("Mouse Sem Fio");
        Produto p2 = new Produto();
        p2.setNome("Teclado sem fio");
        pf.getDesejos().add(p1);
        pf.getDesejos().add(p2);
        lista.add(pf);
        return lista;
    }

}
