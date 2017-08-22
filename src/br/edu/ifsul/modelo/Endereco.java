
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O apelido não pode ser nulo")
    @NotBlank(message = "O apelido não ser em branco")
    @Length(max = 20, message = "O apelido não pode ter mais de {max} caracteres")
    @Column(name = "nickname", length = 20, nullable = false)    
    private String nickname;
    @NotNull(message = "O Endereço não pode ser nulo")
    @NotBlank(message = "O Endereço não ser em branco")
    @Length(max = 50, message = "O Endereço não pode ter mais de {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)        
    private String endereco;
    @NotNull(message = "O numero não pode ser nulo")
    @NotBlank(message = "O numero não ser em branco")
    @Length(max = 10, message = "O numero não pode ter mais de {max} caracteres")
    @Column(name = "numero", length = 10, nullable = false)        
    private String numero;
    @Length(max = 20, message = "O complemento não pode ter mais de {max} caracteres")
    @Column(name = "complemento", length = 20)        
    private String complemento;
    @NotNull(message = "O cep não pode ser nulo")
    @NotBlank(message = "O cep não ser em branco")
    @Length(max = 9, message = "O cep não pode ter mais de {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)        
    private String cep;
    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não ser em branco")
    @Length(max = 40, message = "O bairro não pode ter mais de {max} caracteres")
    @Column(name = "bairro", length = 40, nullable = false)        
    private String bairro;
    @Length(max = 30, message = "A referência não pode ter mais de {max} caracteres")
    @Column(name = "referencia", length = 30)        
    private String referencia;
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pessoa_id")
    private Pessoa pessoa;
    @NotNull(message = "O tipo de endereço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tipo_endereco", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_tipo_endereco_id")    
    private TipoEndereco tipoEndereco;
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_cidade_id")        
    private Cidade cidade;

    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
