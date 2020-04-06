package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Viviane
 *
 */

@Entity
@Table(name = "LIVRO")
public class Livro {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "S_LIVRO")
	@SequenceGenerator(name = "S_LIVRO", sequenceName = "S_LIVRO", allocationSize = 1)
    private long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "autor")
	private String autor;

	@Column(name = "ano_lancamento")
	private int ano_lancamento;

	 //Se termina com ToOne, só há uma única entidade relacionada.
	@ManyToOne
	@JoinColumn(name = "cpf_pessoa", referencedColumnName = "cpf", nullable = false)
	private Pessoa pessoa;

	public Livro() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
}
