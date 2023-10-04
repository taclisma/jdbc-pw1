package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnectionFactory;

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
	}

}
