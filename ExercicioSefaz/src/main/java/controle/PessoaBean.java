package controle;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import dao.PessoaDao;
import dao.PessoaDaoImpl;
import entidade.Livro;
import entidade.Pessoa;
import util.JpaUtil;


/**
 * 
 * @author Viviane
 *
 */

@ManagedBean(name = "PessoaBean")
@SessionScoped
public class PessoaBean {

	private Pessoa pessoa;
	private Livro livro;
	private List<Pessoa> listaPessoa;
	private PessoaDao pessoaDao;
	private String cpfSelecionado;

	private static final String MANTER = "manterPessoa.xhtml";
	private static final String PESQUISAR = "pesquisarPessoa.xhtml";

	public PessoaBean() {
		this.pessoa = new Pessoa();
		this.pessoa.setLivros(new ArrayList<Livro>());

		this.livro = new Livro();
		this.listaPessoa = new ArrayList<Pessoa>();

		this.pessoaDao = new PessoaDaoImpl(JpaUtil.getEntityManager());

		this.listaPessoa = this.pessoaDao.listarTodos();

		System.out.println(this.listaPessoa);
	}

	public void pesquisar() {
		this.listaPessoa = this.pessoaDao.listarTodos();
		System.out.println("Pesquisa Ok!");
	}

	public void salvar() throws IOException {
		if (this.pessoaDao.inserir(this.pessoa)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Salvo com sucesso!!!"));

			 abrirPerquisarPessoa();

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro ao inserir !!!"));
		}

	}

	public void adicionarLivro() {
		
		if(!this.existeLivro(livro)) {
			
			
		Livro livroNovo = new Livro();

		livroNovo.setNome(this.livro.getNome());
		livroNovo.setAutor(this.livro.getAutor());
		livroNovo.setAno_lancamento(this.livro.getAno_lancamento());
		livroNovo.setPessoa(this.pessoa);		
		
		this.pessoa.getLivros().add(livroNovo);

		this.livro = new Livro();
		
	}else {
	
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Livro já existe !!!"));}
			}
		
	

	public static String getManter() {
		return MANTER;
	}

	public static String getPesquisar() {
		return PESQUISAR;
	}

	private boolean existeLivro(Livro livro) {
		boolean retorno = false;
		
		for (Livro livroLista : this.pessoa.getLivros()) {
			if(livroLista.getNome() == livro.getNome() && 
					livroLista.getAutor().equals(livro.getAutor())) {
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	public void abrirManterPessoa() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(MANTER);
	}

	public void abrirPerquisarPessoa() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
	}

	public void editar() throws IOException {
		Pessoa pessoaEdicao = this.pessoaDao.pesquisar(cpfSelecionado);
		this.pessoa = pessoaEdicao;
		abrirManterPessoa();
	}
	
	public String remover() {
		Pessoa pessoaRemocao = this.pessoaDao.pesquisar(cpfSelecionado);
		this.pessoaDao.remover(pessoaRemocao);
		this.listaPessoa = this.pessoaDao.listarTodos();
		return "";
	}
	
	public void limpar() {
		this.listaPessoa = new ArrayList<Pessoa>();

	}
	
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public String getCpfSelecionado() {
		return cpfSelecionado;
	}

	public void setCpfSelecionado(String cpfSelecionado) {
		this.cpfSelecionado = cpfSelecionado;
	}

}
