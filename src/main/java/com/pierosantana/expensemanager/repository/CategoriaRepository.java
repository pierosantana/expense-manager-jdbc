package com.pierosantana.expensemanager.repository;
import com.pierosantana.expensemanager.config.DatabaseConnection;
import com.pierosantana.expensemanager.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository implements CrudGeneric<Categoria> {


    @Override
    public Categoria create(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, categoria.getNombre());
            pstmt.executeUpdate();

           try(ResultSet rs = pstmt.getGeneratedKeys()) {
               if (rs.next()) {
                   categoria.setId(rs.getLong(1));
               }
           }

        }catch (SQLException e){
            System.err.println("Error al conectar: " + e.getMessage());
        }

        return categoria;
    }

    @Override
    public List<Categoria> findAll() {
        String sql = "SELECT * FROM categorias";
        List<Categoria> categorias = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();){

            while(rs.next()) {
                Categoria c = new Categoria(rs.getLong("id"), rs.getString("nombre"));
                categorias.add(c);
            }

        }catch (SQLException e){
            System.err.println("Error al listar categorías: " + e.getMessage());
            e.printStackTrace();
        }

        return categorias;
    }

    @Override
    public Categoria findById(Long id) {
        String sql = "SELECT * FROM categorias WHERE id = ?";
        Categoria categoria = null;
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
            pstmt.setLong(1, id);

            try(ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria(rs.getLong("id"), rs.getString("nombre"));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }catch (SQLException e){
            System.err.println("Error al buscar por id: " + e.getMessage());
            e.printStackTrace();
        }

        return categoria;
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        String sql = "UPDATE categorias SET nombre = ? WHERE id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
            pstmt.setString(1, categoria.getNombre());
            pstmt.setLong(2, id);

            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0) {
                categoria.setId(id);
                return categoria;
            }

        }catch (SQLException e){
            System.err.println("Error al actualizar: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.err.println("Error al eliminar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
