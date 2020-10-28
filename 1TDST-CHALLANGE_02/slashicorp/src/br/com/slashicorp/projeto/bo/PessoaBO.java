package br.com.slashicorp.projeto.bo;

import java.util.List;

import br.com.slashicorp.projeto.beans.Pessoa;
import br.com.slashicorp.projeto.dao.PessoaDAO;

public class PessoaBO {
	
	public static List<Pessoa> pesquisar() throws Exception{
		PessoaDAO dao = new PessoaDAO();
		List<Pessoa> resposta = dao.getAll();
		dao.fechar();
		return resposta;
	}
	
	public static String apagarPessoa(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		PessoaDAO dao = new PessoaDAO();
		dao.delete(id);
		dao.fechar();
		return "Deletado!";
	}
	
	public static Pessoa pesquisarPessoa(int id) throws Exception{
		if(id < 1) {
			return new Pessoa();
		}
		PessoaDAO dao = new PessoaDAO();
		Pessoa resposta = dao.getPessoa(id);
		return resposta;
	}

	public static String novoPessoa(Pessoa pessoa) throws Exception{
		if(pessoa.getIdPessoa() < 1) {
			return "ID inválido";
		}
		if(pessoa.getNome() == null || pessoa.getNome().length() < 3) {
			return "Nome inválido da Pessoa";
		}
		if(pessoa.getNome().length() > 60) {
			return "Nome da Pessoa muito grande";
		}
		
		pessoa.setNome(pessoa.getNome().toUpperCase());

		PessoaDAO dao = new PessoaDAO();
		Pessoa resposta = dao.getPessoa(pessoa.getIdPessoa());
		if (resposta.getIdPessoa() != 0) {
			dao.fechar();
			return "ID existente";
		}
		dao.add(pessoa);
		dao.fechar();
		return "OK";
	}
}