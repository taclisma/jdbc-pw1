package view;

import java.util.TreeSet;

import javax.swing.JOptionPane;

import modelo.pessoas.Autor;
import modelo.submissoes.Submissao;

public class Inicio {
	public static void main(String[] args) {
		
		TreeSet<Submissao> submissoes = new TreeSet<Submissao>();
		TreeSet<Autor> autores = new TreeSet<Autor>();

		
		while (true) {
			try {
				switch(Menu.montaMenuInicial()) {
				case 1:// Cadastrar Submissão
					try{
						submissoes.add(Menu.cadastraSubmissao());
						

					} catch	(NullPointerException e) {
						// TODO
					} catch (Exception e) {
						// TODO
					}
					break;
				case 2: // Pesquisar Submissão pela data
					
					break;
				case 3: // Cadastrar autor
					try {
						autores.add(Menu.cadastraAutor());					
					} catch	(ClassCastException e) {
						// TODO
					} catch	(NullPointerException e) {
						// TODO
					} catch (Exception e) {
						// TODO
					}
					break;
				case 4: // Pesquisar autor pelo nome
					Menu.buscaAutores();
					break;
					
				case 5: // Listar todas as Submissões
					if (submissoes.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Sem submissões cadastradas", "Submissoes\n", 3);
						break;
					}
					
					String auxS = "----\n";
					for (Submissao sub: submissoes) {
						auxS += sub + "\n----\n";
					}
					JOptionPane.showMessageDialog(null, auxS, "Submissoes\n", 3);
					break;
					
				case 6: // Listar todos os autores
					if (autores.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Sem autores cadastradas", "Autores\n", 3);
						break;
					}
					
					String auxA = "----\n";
					for (Submissao sub: submissoes) {
						auxA += sub + "\n----\n";
					}
					JOptionPane.showMessageDialog(null, auxA, "Autores\n", 3);
					break;
				case 7:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção invalida");
					break;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Opção invalida");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro desconhecido encontrado: \n" + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
