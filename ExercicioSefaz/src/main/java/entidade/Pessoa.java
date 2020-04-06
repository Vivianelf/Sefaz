package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Viviane
 *
 */

//Faz com que o JPAsaiba que aquela classe deve ser manipulada por ele
@Entity
//Define que esta classe possuiuma tabela chamada PESSOA no banco de dados
@Table(name = "PESSOA")
public class Pessoa {
	
	//Chave primaria
	@Id
	// Coluna correspondente no banco de dados
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="idade")
	private int idade;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="senha")
	private String senha;
	
	
	//Se o relacionamento termina com ToMany, então você tem uma lista de entidades relacionadas.
	@OneToMany(mappedBy="pessoa", cascade= CascadeType.ALL) 
	private List<Livro> livros;
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
}
