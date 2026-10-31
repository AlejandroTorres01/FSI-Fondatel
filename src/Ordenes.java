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

public class Ordenes {
    
    Conexion cnx;
    
    int folio, silla, mesas_numero;
    String fecha_hora, observaciones, estadoo, clientes_codigoc, empleado_codigo_mesero, empleado_codigo_cocinero;
    
    static String todos = "SELECT * FROM ordenes ORDER BY folio";
    static String folios = "SELECT folio FROM ordenes ORDER BY folio";
    
    public Ordenes() {
    }
    
    public void obtenerconexion(Conexion cnx) {
        this.cnx = cnx;
    }

    public Ordenes(int folio, String fecha_hora, String observaciones, String estadoo, int silla, String clientes_codigoc, int mesas_numero, String empleado_codigo_mesero, String empleado_codigo_cocinero) {
        this.folio = folio;
        this.fecha_hora = fecha_hora;
        this.observaciones = observaciones;
        this.estadoo = estadoo;
        this.silla = silla;
        this.clientes_codigoc = clientes_codigoc;
        this.mesas_numero = mesas_numero;
        this.empleado_codigo_mesero = empleado_codigo_mesero;
        this.empleado_codigo_cocinero = empleado_codigo_cocinero;
    }
   
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO ordenes VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, folio);
            ps.setString(2, fecha_hora);
            ps.setString(3, observaciones);
            ps.setString(4, estadoo);
            ps.setInt(5, silla);
            ps.setString(6, clientes_codigoc);
            ps.setInt(7, mesas_numero);
            ps.setString(8, empleado_codigo_mesero);
            ps.setString(9, empleado_codigo_cocinero);
            
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
            String sql = "DELETE FROM ordenes WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, folio);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE ordenes SET fecha_hora = ? , observaciones = ?, estadoo = ?, silla = ?, clientes_codigoc = ?, mesas_numero = ?, empleado_codigo_mesero = ?, empleado_codigo_cocinero = ? WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha_hora);
            ps.setString(2, observaciones);
            ps.setString(3, estadoo);
            ps.setInt(4, silla);
            ps.setString(5, clientes_codigoc);
            ps.setInt(6, mesas_numero);
            ps.setString(7, empleado_codigo_mesero);
            ps.setString(8, empleado_codigo_cocinero);
            ps.setInt(9, folio);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
}
