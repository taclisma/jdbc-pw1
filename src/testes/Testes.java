package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

import dao.ConnectionFactory;
import modelo.pessoas.Autor;
import modelo.submissoes.*;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM pessoa WHERE id_pessoa = ?");
			stmt.setInt(1, 1);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				System.out.println(nome + endereco);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TreeSet<Autor> autores = new TreeSet<Autor>();
		
		autores.add(new Autor("mari"));
		//autores.add(new Autor("be"));
		autores.add(new Autor("lu"));
		System.out.println(autores.toString());

		Submissao sub1 = new Artigo();
		try {
		    sub1.setTitulo("aaa");
		    
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		    String dateInString = "15-10-2015";
		    Date date = sdf.parse(dateInString);
		    
			sub1.setData(date);
		
		} catch ( ParseException e) {
			System.out.println("erro ao parsear data " + e.toString());
		} catch (IllegalArgumentException e) {
		    System.out.println("erro ao setar data para submissao " + e.toString());
		}
		
	    Submissao sub2 = new Curso();
		sub2.setTitulo("ccccc");
	    Submissao sub3 = new Curso();
		sub3.setTitulo("bbbbbb");		
		sub1.setAutores(autores);
		TreeSet<Submissao> subs = new TreeSet<Submissao>();
		subs.add(sub1);
		subs.add(sub2);
		subs.add(sub3);
		
		System.out.println(subs.toString() + Submissao.getTotal());
	}
}
