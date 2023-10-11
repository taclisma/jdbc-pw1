package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import modelo.pessoas.Autor;

public class AutorDAO implements BaseDAO<Autor>{

	@Override
	public int insert(Autor a) {
		int chavePrimaria = -1;
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement("insert into autor(nome, email) values (?, ?)",
								Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getEmail());
			stmt.execute();
			ResultSet chaves = stmt.getGeneratedKeys();
			if (chaves.next())  chavePrimaria= chaves.getInt(1);
		} catch (CommunicationsException e ) {
			JOptionPane.showMessageDialog(null, "Erro na conexão com o banco");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro interno com o banco");
			System.out.println("Exceptiono em autor insert");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "Erro interno com o banco");
			System.out.println("Classe desconhecida em autor insert");
			e.printStackTrace();
		}
		return chavePrimaria;
	}
	
}
