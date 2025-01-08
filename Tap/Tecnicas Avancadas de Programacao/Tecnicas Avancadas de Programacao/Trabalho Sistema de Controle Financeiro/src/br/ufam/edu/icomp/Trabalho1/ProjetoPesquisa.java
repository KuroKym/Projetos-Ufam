package br.ufam.edu.icomp.Trabalho1;
import java.util.*;

public class ProjetoPesquisa {
	private String nomeProjetoPesquisa;
	private String professorResponsavel;
	private double valorGasto;
	ArrayList<DespesaCapital> despesaCapital = new ArrayList<DespesaCapital>();
	ArrayList<DespesaMaterialConsumo> despesaMaterialConsumo = new ArrayList<DespesaMaterialConsumo>();
	ArrayList<DespesaComTerceirosPessoaFisica> servicosPessoaFisica = new ArrayList<DespesaComTerceirosPessoaFisica>();
	ArrayList<DespesaComTerceirosPessoaJuridica> servicosPessoaJuridica = new ArrayList<DespesaComTerceirosPessoaJuridica>();
	ArrayList<Diarias> diarias = new ArrayList<Diarias>();
	ArrayList<Passagens> passagens = new ArrayList<Passagens>();
	
	public ProjetoPesquisa(String nomeProjetoPesquisa, String professorResponsavel, double valorGasto) {
		setNomeProjetoPesquisa(nomeProjetoPesquisa);
		setProfessorResponsavel(professorResponsavel);
		setValorGasto(valorGasto);
	}
	
	public double getValorGasto() {
		return valorGasto;
	}

	public void setValorGasto(double valorGasto) {
		this.valorGasto = valorGasto;
	}

	public String getNomeProjetoPesquisa() {
		return nomeProjetoPesquisa;
	}
	public void setNomeProjetoPesquisa(String nomeProjetoPesquisa) {
		this.nomeProjetoPesquisa = nomeProjetoPesquisa;
	}
	public String getProfessorResponsavel() {
		return professorResponsavel;
	}
	public void setProfessorResponsavel(String professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}
	
	public void adicionarNovaDespesaCapital(String descricao, double valor) throws NumeroNegativo {
		DespesaCapital d = new DespesaCapital(descricao, valor);
		despesaCapital.add(d);
	}
	
	public boolean removerDespesaCapital(String descricao) {
		for(int i = 0; i < despesaCapital.size(); i++) {
			DespesaCapital desp = despesaCapital.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				despesaCapital.remove(desp);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarValorDespesaCapital(String descricao, double novoValor) {
		for(int i = 0; i < despesaCapital.size(); i++) {
			DespesaCapital desp = despesaCapital.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setValor(novoValor);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarDescricaoDespesaCapital(String descricao, String novaDescricao) {
		for(int i = 0; i < despesaCapital.size(); i++) {
			DespesaCapital desp = despesaCapital.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setDescricao(novaDescricao);
				return true;
			}
		}
		return false;
	}
	
	public void adicionarNovaDespesaMaterialConsumo(String descricao, double valor) throws NumeroNegativo{
		DespesaMaterialConsumo d = new DespesaMaterialConsumo(descricao, valor);
		despesaMaterialConsumo.add(d);
	}
	
	public boolean removerDespesaMaterialConsumo(String descricao) {
		for(int i = 0; i < despesaMaterialConsumo.size(); i++) {
			DespesaMaterialConsumo desp = despesaMaterialConsumo.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				despesaMaterialConsumo.remove(desp);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarValorDespesaMaterialConsumo(String descricao, double novoValor) {
		for(int i = 0; i < despesaMaterialConsumo.size(); i++) {
			DespesaMaterialConsumo desp = despesaMaterialConsumo.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setValor(novoValor);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarDescricaoDespesaMaterialConsumo(String descricao, String novaDescricao) {
		for(int i = 0; i < despesaMaterialConsumo.size(); i++) {
			DespesaMaterialConsumo desp = despesaMaterialConsumo.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setDescricao(novaDescricao);
				return true;
			}
		}
		return false;
	}
	
	public void adicionarNovaDespesaServicosPessoaFisica(String descricao, double valor, String responsaveis, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida {
		DespesaComTerceirosPessoaFisica s = new DespesaComTerceirosPessoaFisica(descricao, responsaveis, valor, dia, mes, ano);
		servicosPessoaFisica.add(s);
	}
	
	public boolean removerDespesaServPessoaFisica(String descricao) {
		for(int i = 0; i < servicosPessoaFisica.size(); i++) {
			DespesaComTerceirosPessoaFisica desp = servicosPessoaFisica.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				servicosPessoaFisica.remove(desp);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarValorDespesaServPessoaFisica(String descricao, double novoValor) {
		for(int i = 0; i < servicosPessoaFisica.size(); i++) {
			DespesaComTerceirosPessoaFisica desp = servicosPessoaFisica.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setValor(novoValor);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarDescricaoDespesaServPessoaFisica(String descricao, String novaDescricao) {
		for(int i = 0; i < servicosPessoaFisica.size(); i++) {
			DespesaComTerceirosPessoaFisica desp = servicosPessoaFisica.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setDescricao(novaDescricao);
				return true;
			}
		}
		return false;
	}
	
	public void adicionarNovaDespesaServicosPessoaJuridica(String descricao, double valor, String responsaveis, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida {
		DespesaComTerceirosPessoaJuridica s = new DespesaComTerceirosPessoaJuridica(descricao, responsaveis, valor, dia, mes, ano);
		servicosPessoaJuridica.add(s);
	}
	
	public boolean removerDespesaServPessoaJuridica(String descricao) {
		for(int i = 0; i < servicosPessoaJuridica.size(); i++) {
			DespesaComTerceirosPessoaJuridica desp = servicosPessoaJuridica.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				servicosPessoaJuridica.remove(desp);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarValorDespesaServPessoaJuridica(String descricao, double novoValor) {
		for(int i = 0; i < servicosPessoaJuridica.size(); i++) {
			DespesaComTerceirosPessoaJuridica desp = servicosPessoaJuridica.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setValor(novoValor);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarDescricaoDespesaServPessoaJuridica(String descricao, String novaDescricao) {
		for(int i = 0; i < servicosPessoaJuridica.size(); i++) {
			DespesaComTerceirosPessoaJuridica desp = servicosPessoaJuridica.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setDescricao(novaDescricao);
				return true;
			}
		}
		return false;
	}
	
	public void adicionarNovaDespesaDiarias(String descricao, double valor, String local, String nomeEvento, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida {
		Diarias d = new Diarias(descricao, local, nomeEvento, valor, dia, mes, ano);
		diarias.add(d);
	}
	
	public boolean removerDiaria(String descricao) {
		for(int i = 0; i < diarias.size(); i++) {
			Diarias desp = diarias.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				diarias.remove(desp);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarValorDiaria(String descricao, double novoValor) {
		for(int i = 0; i < diarias.size(); i++) {
			Diarias desp = diarias.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setValor(novoValor);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarDescricaoDiaria(String descricao, String novaDescricao) {
		for(int i = 0; i < diarias.size(); i++) {
			Diarias desp = diarias.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setDescricao(novaDescricao);
				return true;
			}
		}
		return false;
	}
	
	public void adicionarNovaDespesaPassagens(String descricao, String local, String nomeEvento, String empresa, double valor, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida {
		Passagens p = new Passagens(descricao, local, nomeEvento, empresa, valor, dia, mes, ano);
		passagens.add(p);
	}
	
	public boolean removerPassagem(String descricao) {
		for(int i = 0; i < passagens.size(); i++) {
			Diarias desp = passagens.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				passagens.remove(desp);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarValorPassagem(String descricao, double novoValor) {
		for(int i = 0; i < passagens.size(); i++) {
			Diarias desp = passagens.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setValor(novoValor);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarDescricaoPassagem(String descricao, String novaDescricao) {
		for(int i = 0; i < passagens.size(); i++) {
			Diarias desp = passagens.get(i);
			if(desp.getDescricaoDespesa().equals(descricao)) {
				desp.setDescricao(novaDescricao);
				return true;
			}
		}
		return false;
	}
	
	public double totalDespCapital() {
		DespesaCapital despCap;
		double total = 0;
		for(int i = 0; i < despesaCapital.size(); i++) {
			despCap = despesaCapital.get(i);
			total += despCap.getValor();
		}
		return total;
	}
	
	public double totalDespMatCons() {
		DespesaMaterialConsumo despMatCons;
		double total = 0;
		for(int i = 0; i < despesaMaterialConsumo.size(); i++) {
			despMatCons = despesaMaterialConsumo.get(i);
			total += despMatCons.getValor();
		}
		return total;
	}
	
	public double totalDespTercPesFis() {
		DespesaComTerceirosPessoaFisica despTercPesFis;
		double total = 0;
		for(int i = 0; i < servicosPessoaFisica.size(); i++) {
			despTercPesFis = servicosPessoaFisica.get(i);
			total += despTercPesFis.getValor();
		}
		return total;
	}
	
	public double totalDespTercPesJur() {
		DespesaComTerceirosPessoaJuridica despTercPesJur;
		double total = 0;
		for(int i = 0; i < servicosPessoaJuridica.size(); i++) {
			despTercPesJur = servicosPessoaJuridica.get(i);
			total += despTercPesJur.getValor();
		}
		return total;
	}
	
	public double totalDiarias() {
		Diarias diar;
		double total = 0;
		for(int i = 0; i < diarias.size(); i++) {
			diar = diarias.get(i);
			total += diar.getValor();
		}
		return total;
	}
	
	public double totalPass() {
		Passagens pass;
		double total = 0;
		for(int i = 0; i < passagens.size(); i++) {
			pass = passagens.get(i);
			total += pass.getValor();
		}
		return total;
	}
	
	public double totalProjeto() {
		return totalDespCapital() + totalDespMatCons() + totalDespTercPesFis() + totalDespTercPesJur() + totalDiarias() + totalPass();
	}
	
	public String relatorioProjeto() {
		DespesaCapital despCap;
		DespesaMaterialConsumo despMatCons;
		DespesaComTerceirosPessoaFisica servPesFis;
		DespesaComTerceirosPessoaJuridica servPesJur;
		Diarias diar;
		Passagens pass;
		String relat = "Nome do projeto de pesquisa: " + getNomeProjetoPesquisa() + "\nProfessor responsavel: " + getProfessorResponsavel() + "\n";
		relat += "Valor total do projeto: R$ " + totalProjeto() + "\n";
		
		relat += "\nRelatorio de Despesas de Capital: \n";
		for(int i = 0; i < despesaCapital.size(); i++) {
			relat += "\t--------Despesa " + (i+1) + "---------\n";
			despCap = despesaCapital.get(i);
			relat += despCap.toString() + "\n";
		}
		relat += "\tSoma das Despesas: R$ " + totalDespCapital() + "\n";
		
		relat += "\nRelatorio de Despesas de Material de Consumo: \n";
		for(int j = 0; j < despesaMaterialConsumo.size(); j++) {
			relat += "\t--------Despesa " + (j+1) + "---------\n";
			despMatCons = despesaMaterialConsumo.get(j);
			relat += despMatCons.toString() + "\n";
		}
		relat += "\tSoma das Despesas: R$ " + totalDespMatCons() + "\n";
		
		relat += "\nRelatorio com Servicos de Terceiros/ Pessoa fisica: \n";
		for(int k = 0; k < servicosPessoaFisica.size(); k++) {
			relat += "\t--------Despesa " + (k+1) + "---------\n";
			servPesFis = servicosPessoaFisica.get(k);
			relat += servPesFis.getDescricao() +"\n";
		}
		relat += "\tSoma das Despesas: R$ " + totalDespTercPesFis() + "\n";
		
		relat += "\nRelatorio com Servicos de Terceiros/ Pessoa Juridica: \n";
		for(int m = 0; m < servicosPessoaJuridica.size(); m++) {
			relat += "\t--------Despesa " + (m+1) + "---------\n";
			servPesJur = servicosPessoaJuridica.get(m);
			relat += servPesJur.getDescricao() + "\n";
		}
		relat += "\tSoma das Despesas: R$ " + totalDespTercPesJur() + "\n";
		
		relat += "\nRelatorio das Diarias: \n";
		for(int n = 0; n < diarias.size(); n++) {
			relat += "\t--------Despesa " + (n+1) + "---------\n";
			diar = diarias.get(n);
			relat += diar.getDescricao() + "\n";
		}
		relat += "\tSoma das Despesas: R$ " + totalDiarias() + "\n";
		
		relat += "\nRelatorio das Passagens: \n";
		for(int o = 0; o < passagens.size(); o++) {
			relat += "\t--------Despesa " + (o+1) + "---------\n";
			pass = passagens.get(o);
			relat += pass.pegarDescricao() + "\n";
		}
		relat += "\tSoma das Despesas: R$ " + totalPass() + "\n\n";

		return relat;
	}
}
