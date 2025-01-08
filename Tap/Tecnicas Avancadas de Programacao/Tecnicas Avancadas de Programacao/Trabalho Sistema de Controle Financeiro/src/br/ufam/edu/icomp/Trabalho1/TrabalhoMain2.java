package br.ufam.edu.icomp.Trabalho1;

public class TrabalhoMain2 {
	public static void main(String[] args) throws NumeroNegativo, DataInvalida {
		ListaProjetosPesquisa lista = new ListaProjetosPesquisa();
		
		ProjetoPesquisa p1 = new ProjetoPesquisa("Contagem das Estrelas do Ceu", "Arlindo dos Santos Lima", 2500);
		p1.adicionarNovaDespesaCapital("Comprar 5 monitores Dell 6770-X", 12000);
		p1.adicionarNovaDespesaCapital("Comprar 10 exemplares O Universo eh Infinito?", 570);
		p1.adicionarNovaDespesaMaterialConsumo("Comprar 10 rolos de filme fotografico Kodak 441-M", 350);
		p1.adicionarNovaDespesaMaterialConsumo("Comprar 3 placas de video NVIDIA 4070", 15000);
		p1.adicionarNovaDespesaServicosPessoaFisica("Ajeitar o telescopio MSHX-9900", 5500, "Tiago Lima e Armandio Nogueira", 19, 3, 2001);
		p1.adicionarNovaDespesaServicosPessoaJuridica("Comprar 3 seguros de saude", 3000, "Hapvida", 9, 11, 2009);
		p1.adicionarNovaDespesaDiarias("Hospedagem no Hotel Copacaba", 4750, "Hotel Copacabana", "Metodos formais de contagem infinitas", 26, 2, 2014);
		p1.adicionarNovaDespesaPassagens("Viagem para o Rio de Janeiro", "Rio de Janeiro", "Metodos Formais de contagem infinitas", "Varig", 1400, 26, 2, 2014);
		//p1.removerDespesaCapital("Comprar 5 monitores Dell 6770-X");
		//p1.removerDespesaMaterialConsumo("Comprar 10 rolos de filme fotografico Kodak 441-M");
		//p1.removerDespesaServPessoaFisica("Ajeitar o telescopio MSHX-9900");
		//p1.removerDespesaServPessoaJuridica("Comprar 3 seguros de saude");
		//p1.removerDiaria("Hospedagem no Hotel Copacaba");
		//p1.removerPassagem("Viagem para o Rio de Janeiro");
		lista.adicionarProjeto(p1);
		
		ProjetoPesquisa p2 = new ProjetoPesquisa("Inteligencia Artificial Contra o Desmatamento da Floresta Amazonica", "Caio Bruno dos Anjos", 4000);
		p2.adicionarNovaDespesaCapital("Comprar 3 notebooks Dell G15", 17980);
		p2.adicionarNovaDespesaCapital("Comprar um servidor IBM-3RTU", 22350);
		p2.adicionarNovaDespesaMaterialConsumo("Comprar 3 placas de video NVIDIA GEFORCE RTX-7700", 44500);
		p2.adicionarNovaDespesaServicosPessoaFisica("Calibrar o satelite BRSPACE-UX5540", 8000, "Amanda Roque e Dainara Cardoso", 4, 7, 2016);
		p2.adicionarNovaDespesaServicosPessoaJuridica("Pagar a taxa de utilizacao do sistema de monitoramento via satelite do IBGE", 7000, "IBGE", 2, 9, 2015);
		lista.adicionarProjeto(p2);
		
		System.out.println(lista.mostrarListaProjetos());
	}
}