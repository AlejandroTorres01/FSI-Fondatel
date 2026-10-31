/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aleja
 */
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Alimentos {
    
    Conexion cnx;
    
    int idalimentos, ordenes_folio;
    String nombrea, descripcion, estadoa, categoria;
    float precio;
    byte[] foto;
    
    static String todos = "SELECT * FROM alimentos ORDER BY nombrea";
    static String idalimentos_query = "SELECT idalimentos FROM alimentos ORDER BY idalimentos";
    
    public Alimentos() {
    }
    
    public void obtenerconexion(Conexion cnx) {
        this.cnx = cnx;
    }

    public Alimentos(int idalimentos, String nombrea, String descripcion, float precio, byte[] foto, String estadoa, String categoria, int ordenes_folio) {
        this.idalimentos = idalimentos;
        this.nombrea = nombrea;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.estadoa = estadoa;
        this.categoria = categoria;
        this.ordenes_folio = ordenes_folio;
    }
   
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO alimentos VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalimentos);
            ps.setString(2, nombrea);
            ps.setString(3, descripcion);
            ps.setFloat(4, precio);
            ps.setBytes(5, foto);
            ps.setString(6, estadoa);
            ps.setString(7, categoria);
            ps.setInt(8, ordenes_folio);
            
            resultado = ps.executeUpdate(); 
            return resultado;
            
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM alimentos WHERE idalimentos = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, idalimentos);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE alimentos SET nombrea = ? , descripcion = ?, precio = ?, foto = ?, estadoa = ?, categoria = ?, ordenes_folio = ? WHERE idalimentos = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrea);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBytes(4, foto);
            ps.setString(5, estadoa);
            ps.setString(6, categoria);
            ps.setInt(7, ordenes_folio);
            ps.setInt(8, idalimentos);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
}