package view;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		autor.setEmail(JOptionPane.showInputDialog(null, "Titulo: "));
		autor.setTelefone(
				new Telefone(
						Integer.parseInt(JOptionPane.showInputDialog(null, "DDD: ")), // ddd
						Long.parseLong(JOptionPane.showInputDialog(null, "Numero: ")) /// numero
						)
				);
		// TODO autor dao insert
		return autor;
	}
	
	public static TreeSet<Autor> buscaAutores() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static Submissao cadastraSubmissao() {
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
					// TODO buscar e adicionar autores
					
					return art;					
					
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
					//TODO buscar e adicionar autores
					curs.setAutores(buscaAutores());
					return curs;
					
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					// erros estao so fechando a janela e seguindo sem inserir
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.toString());
					e.printStackTrace();
				}	
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida");
				break;
		}
		return null;
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
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(str));
		} catch ( NumberFormatException e) {
			//TODO
			e.printStackTrace();
		}
		return 0;
	}
	
	protected static Situacao atribuiSituacao() {
		int i = montaMenuSituacao();
		
		try {
			for (Situacao situ : Situacao.values())
				if (situ.getValor() == i) return (situ);					
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			e.printStackTrace();
		}
		
		
		return null;
			
	}
}

