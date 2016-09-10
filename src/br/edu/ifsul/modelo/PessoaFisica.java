
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {
    @NotNull(message = "O RG não pode ser nulo")
    @NotBlank(message = "O RG não ser em branco")
    @Length(max = 10, message = "O RG não pode ter mais de {max} caracteres")
    @Column(name = "RG", length = 10, nullable = false)        
    private String rg;
    @NotNull(message = "O CPF não pode ser nulo")
    @NotBlank(message = "O CPF não ser em branco")
    @Length(max = 14, message = "O CPF não pode ter mais de {max} caracteres")
    @CPF(message = "O CPF deve ser válido")
    @Column(name = "CPF", length = 14, nullable = false)        
    private String cpf;
    @NotNull(message = "O nascimento não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @NotNull(message = "O nome de usuario não pode ser nulo")
    @NotBlank(message = "O nome de usuario não ser em branco")
    @Length(max = 20, message = "O nome de usuario não pode ter mais de {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false, unique = true)           
    private String nomeUsuario;
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não ser em branco")
    @Length(max = 10, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 10, nullable = false)        
    private String senha;

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
