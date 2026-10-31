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

public class Empleados {
    
    Conexion cnx;
    
    String codigo, nombree, puesto, turno, nom_usr, nip, estadoe;
    
    // Las consultas SQL mantienen el nombre de la tabla en singular: "empleado"
    static String todos = "SELECT * FROM empleado ORDER BY nombree";
    static String codigos = "SELECT codigo FROM empleado ORDER BY codigo";
    
    public Empleados() {
    }
    
    public void obtenerconexion(Conexion cnx) {
        this.cnx = cnx;
    }

    public Empleados(String codigo, String nombree, String puesto, String turno, String nom_usr, String nip, String estadoe) {
        this.codigo = codigo;
        this.nombree = nombree;
        this.puesto = puesto;
        this.turno = turno;
        this.nom_usr = nom_usr;
        this.nip = nip;
        this.estadoe = estadoe;
    }
   
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO empleado VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, nombree);
            ps.setString(3, puesto);
            ps.setString(4, turno);
            ps.setString(5, nom_usr);
            ps.setString(6, nip);
            ps.setString(7, estadoe);
            
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
            String sql = "DELETE FROM empleado WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, codigo);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE empleado SET nombree = ? , puesto = ?, turno = ?, nom_usr = ?, nip = ?, estadoe = ? WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombree);
            ps.setString(2, puesto);
            ps.setString(3, turno);
            ps.setString(4, nom_usr);
            ps.setString(5, nip);
            ps.setString(6, estadoe);
            ps.setString(7, codigo);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
}
