package dao;

import model.Conexao;
import model.Livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivrosDAO {

    public void inserir(Livros livros){
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livros.getTitulo());
            stmt.setString(2, livros.getAutor());
            stmt.setInt(3, livros.getAnoPublicacao());
            stmt.executeUpdate();

            System.out.println("Livro inserido com sucesso!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarAutor(Livros livros){
        String sql = "UPDATE livros SET autor = ? WHERE titulo = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, livros.getAutor());
            stmt.setString(2, livros.getTitulo());
            stmt.executeUpdate();

            System.out.println("Autor atualizado com sucesso!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteLivro(Livros livros){
        String sql = "DELETE FROM livros WHERE titulo = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, livros.getTitulo());
            stmt.executeUpdate();

            System.out.println("Livro " + livros.getTitulo() + " deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
