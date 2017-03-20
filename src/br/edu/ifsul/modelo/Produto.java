
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50,message = "O nome não deve ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")    
    @Column(name = "nome", length = 50, nullable = false)    
    private String nome;
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    @NotNull(message = "O preço deve ser informado")    
    @Column(name = "preco", nullable = false, columnDefinition = "decimal(12,2)")
    private Double preco;
    @Min(message = "O estoque não pode ser negativo", value = 0)
    @NotNull(message = "A quantidade em estoque deve ser informada")
    @Column(name = "quantidade_estoque", nullable = false, columnDefinition = "decimal(12,2)")    
    private Double quantidadeEstoque;
    @NotNull(message = "A categoria deve ser informada")
    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_categoria")
    private Categoria categoria;
    @NotNull(message = "A marca deve ser informada")
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id", nullable = false)    
    @ForeignKey(name = "fk_marca")
    private Marca marca;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "desejos",
            joinColumns = 
            @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false), 
            uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_fisica","produto"})})    
    private List<PessoaFisica> desejam = new ArrayList<>();
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Foto> fotos = new ArrayList<>();
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Arquivo> arquivos = new ArrayList<>();

    public Produto() {
    }
    
    public void adicionarFoto(Foto obj){
        obj.setProduto(this);
        this.fotos.add(obj);
    }
    
    public void removerFoto(int index){
        this.fotos.remove(index);
    }
    
    public void adicionarArquivo(Arquivo obj){
        obj.setProduto(this);
        this.arquivos.add(obj);
    }
    
    public void removerArquivo(int index){
        this.arquivos.remove(index);
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nome;
    }  

    public List<PessoaFisica> getDesejam() {
        return desejam;
    }

    public void setDesejam(List<PessoaFisica> desejam) {
        this.desejam = desejam;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }



}
