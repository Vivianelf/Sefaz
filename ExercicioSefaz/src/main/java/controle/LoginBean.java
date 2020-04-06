package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.PessoaDao;
import dao.PessoaDaoImpl;
import entidade.Pessoa;
import util.JpaUtil;

/**
 * 
 * @author Viviane
 *
 */


@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private String pessoaAdmin = "admin";
	private String senhaAdmin = "admin";

	private String pessoaTXT;
	private String senhaTXT;
	private PessoaDao pessoaDao;
	private String mensagem;


	private static final String PESQUISAR = "paginas/pesquisarPessoa.xhtml";

	
	public LoginBean() {
		this.pessoaDao = new PessoaDaoImpl (JpaUtil.getEntityManager());
	}

	
	  public void entrar() throws IOException {
	 if(this.pessoaTXT.equals(this.pessoaAdmin) && this.senhaTXT.equals(this.senhaAdmin)) {
	  FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
	  }else { Pessoa pessoaPesquisa = this.pessoaDao.pesquisar(this.pessoaTXT);
		if(pessoaPesquisa != null) {
			if(pessoaPesquisa.getSenha().equals(this.senhaTXT)) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
			}else {
				this.mensagem = "Pessoa, senha errada";
			}
		}else {
			this.mensagem = "Pessoa, não existe";
		}
		
	}
}

		 
	 

	public String getPessoaTXT() {
		return pessoaTXT;
	}

	public void setPessoaTXT(String pessoaTXT) {
		this.pessoaTXT = pessoaTXT;
	}

	public String getSenhaTXT() {
		return senhaTXT;
	}

	public void setSenhaTXT(String senhaTXT) {
		this.senhaTXT = senhaTXT;
	}

	public String getPessoaAdmin() {
		return pessoaAdmin;
	}

	public void setPessoaAdmin(String pessoaAdmin) {
		this.pessoaAdmin = pessoaAdmin;
	}

	public String getSenhaAdmin() {
		return senhaAdmin;
	}

	public void setSenhaAdmin(String senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}


	public static String getPesquisar() {
		return PESQUISAR;
	}


	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}


	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	

}
