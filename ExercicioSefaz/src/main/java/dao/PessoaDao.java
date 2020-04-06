package dao;

import java.util.List;

import entidade.Pessoa;

/**
 * 
 * @author Viviane
 *
 */

public interface PessoaDao {

public boolean inserir(Pessoa pessoa);
	
	public void alterar(Pessoa pessoa);

	public void remover(Pessoa pessoa);

	public Pessoa pesquisar(String cpf);

	public List<Pessoa> listarTodos();
	
}

