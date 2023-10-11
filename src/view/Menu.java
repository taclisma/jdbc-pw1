package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import modelo.contatos.Telefone;
import modelo.pessoas.Autor;
import modelo.submissoes.*;
import modelo.util.Situacao;

public class Menu {
	
	public static Autor cadastraAutor() {
		Autor autor = new Autor();
		autor.setNome(JOptionPane.showInputDialog(null, "Nome: "));
		autor.setEmail(JOptionPane.showInputDialog(null, "Email: "));
		autor.setTelefone(
				new Telefone(
						Integer.parseInt(JOptionPane.showInputDialog(null, "DDD: ")), // ddd
						Long.parseLong(JOptionPane.showInputDialog(null, "Numero: ")) /// numero
						)
				);
		autor.insert();
		return autor;

	}
	
	
	public static Autor buscaAutorPorNome(String nome, TreeSet<Autor> autores) {
		for (Autor autor : autores)
			if (nome.equalsIgnoreCase(autor.getNome()))
					return autor;
		return null;
	}
	
	public static TreeSet<Autor> buscaAutores(TreeSet<Autor> autores) {
		TreeSet<Autor> autoresAux = new TreeSet<Autor>();
		boolean flag = true;
		while (flag) {
			Autor auxA = buscaAutorPorNome(JOptionPane.showInputDialog("Busca por nome do autor: "), autores);
			if (auxA != null) {
				autoresAux.add(auxA);
				 JOptionPane.showInputDialog("Autor inserido");

			} else
				JOptionPane.showInputDialog("Autor nao encontrado");
			
			if(JOptionPane.showConfirmDialog(null, "Seguir adicionando autores?") > 0)
				flag = false;
		}
		return autores;
	}
	
	
	public static Submissao cadastraSubmissao(TreeSet<Autor> autores) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    
		switch(Integer.parseInt(JOptionPane.showInputDialog(null, "Cadastrar: \n 1 - Artigo\n 2 - Curso"))) {
			case 1:
				try {
					Artigo art = new Artigo();
					art.setTitulo(JOptionPane.showInputDialog(null, "Titulo: "));
					art.setSituacao(atribuiSituacao());
					art.setData(sdf.parse(JOptionPane.showInputDialog(null, "Data: (dd/mm/yyyy): \n")));
					art.setAbstrato(JOptionPane.showInputDialog(null, "Abstrato: "));
					art.setResumo(JOptionPane.showInputDialog(null, "Resumo: "));
					art.setArquivo(JOptionPane.showInputDialog(null, "Arquivo: "));
					art.setAutores(buscaAutores(autores));
					return art;					
					
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, "Erro ao validar input: " + e.getMessage());
				}
					break;
			case 2:
				try {
					Curso curs = new Curso();
					curs.setTitulo(JOptionPane.showInputDialog(null, "Titulo: "));
					curs.setSituacao(atribuiSituacao());
					curs.setData(sdf.parse(JOptionPane.showInputDialog(null, "Data: (dd/mm/yyyy): \n")));
					curs.setJustificativa(JOptionPane.showInputDialog(null, "Justificativa: "));
					curs.setMaterial(JOptionPane.showInputDialog(null, "Material: "));
					curs.setObjetivo(JOptionPane.showInputDialog(null, "Objetivo: "));
					curs.setDuracao(Double.parseDouble(JOptionPane.showInputDialog(null, "Duração: ")));
					curs.setAutores(buscaAutores(autores));
					return curs;

				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, "Erro ao validar input: " + e.getMessage());
				} 
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida");
				break;
		}
		throw new NullPointerException("Erro ao inserir submissao"); 
	}
	
	// cod menu enum do exemplo aula
	protected static int montaMenuInicial() {
		String str = ""; for(OpcoesMenu opcaoMenu: OpcoesMenu.values()) 
			str += opcaoMenu.getItem()+"\n"; 
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
	
	protected static int montaMenuSituacao() {
		String str = ""; for(Situacao opcaoMenu: Situacao.values()) 
			str += opcaoMenu.getItem()+"\n"; 
			return Integer.parseInt(JOptionPane.showInputDialog(str));
		
	}
	
	protected static Situacao atribuiSituacao() {
		int i = montaMenuSituacao();
		
		for (Situacao situ : Situacao.values())
			if (situ.getValor() == i) return (situ);
		
		throw new NullPointerException("Erro ao atribuir Situação"); 
			
	}


	public static void buscaSumissaoPorData(TreeSet<Submissao> submissoes) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = (sdf.parse(JOptionPane.showInputDialog(null, "Busca por data: (dd/m/yyyy): \n")));
			for (Submissao sub : submissoes)
				if (data.compareTo(sub.getData()) == 0)
					JOptionPane.showMessageDialog(null, "Encontrada Submissao:\n" + sub);
				else
					JOptionPane.showMessageDialog(null, "Não encontrada");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao validar input: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
}

