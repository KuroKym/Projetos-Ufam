package br.ufam.edu.icomp.Trabalho1;

import java.util.*;

public class ListaProjetosPesquisa {
	ArrayList<ProjetoPesquisa> listaProjetos = new ArrayList<ProjetoPesquisa>();
	
	public void adicionarProjeto(ProjetoPesquisa projetoPesquisa) {
		listaProjetos.add(projetoPesquisa);
	}
	
	public void alterarTituloProjeto(String descricao, String novoTitulo) {
		ProjetoPesquisa p;
		for(int i = 0; i < listaProjetos.size(); i++) {
			p = listaProjetos.get(i);
			if(p.getNomeProjetoPesquisa().equals(descricao)) {
				p.setNomeProjetoPesquisa(novoTitulo);
			}
		}
	}
	
	public void alterarProfProjeto(String descricao, String novoProf) {
		ProjetoPesquisa p;
		for(int i = 0; i < listaProjetos.size(); i++) {
			p = listaProjetos.get(i);
			if(p.getNomeProjetoPesquisa().equals(descricao)) {
				p.setProfessorResponsavel(novoProf);
			}
		}
	}
	
	public void removerProjetoLista(String titulo) {
		ProjetoPesquisa p;
		for(int i = 0; i < listaProjetos.size(); i++) {
			p = listaProjetos.get(i);
			if(p.getNomeProjetoPesquisa().equals(titulo)) {
				listaProjetos.remove(p);
			}
		}
	}
	
	public String mostrarListaProjetos() {
		ProjetoPesquisa lista;
		String res = "";
		for(int i = 0; i < listaProjetos.size(); i++) {
			lista = listaProjetos.get(i);
			res += lista.relatorioProjeto();
		}
		return res;
	}
}
