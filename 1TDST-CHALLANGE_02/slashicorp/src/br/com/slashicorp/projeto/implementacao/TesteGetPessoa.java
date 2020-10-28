package br.com.slashicorp.projeto.implementacao;

import br.com.slashicorp.projeto.beans.Pessoa;
import br.com.slashicorp.projeto.dao.PessoaDAO;
import br.com.slashicorp.projeto.excecao.Excecao;
import br.com.slashicorp.projeto.util.Magic;

public class TesteGetPessoa {

	public static void main(String[] args) {
		try {
			PessoaDAO dao = new PessoaDAO();
			Pessoa resposta = dao.getPessoa(Magic.i("ID"));
			System.out.println(resposta.getIdPessoa());
			System.out.println(resposta.getCpf());
			System.out.println(resposta.getCnpj());
			System.out.println(resposta.getNome());
			System.out.println(resposta.getTelefone());
			System.out.println(resposta.getTipoUsuario());
			dao.fechar();
		} catch (Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
