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

public class Clientes {
    
    Conexion cnx;
    
    String codigoc, nombrec, rfc;
    
    static String todos = "SELECT * FROM clientes ORDER BY nombrec";
    static String codigos = "SELECT codigoc FROM clientes ORDER BY codigoc";
    
    public Clientes() {
    }
    
    public void obtenerconexion(Conexion cnx) {
        this.cnx = cnx;
    }

    public Clientes(String codigoc, String nombrec, String rfc) {
        this.codigoc = codigoc;
        this.nombrec = nombrec;
        this.rfc = rfc;
    }
   
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO clientes VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoc);
            ps.setString(2, nombrec);
            ps.setString(3, rfc);
            
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
            String sql = "DELETE FROM clientes WHERE codigoc = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, codigoc);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE clientes SET nombrec = ? , rfc = ? WHERE codigoc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrec);
            ps.setString(2, rfc);
            ps.setString(3, codigoc);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
}