import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mesas {
    
    Conexion cnx;
    
    int numero, capacidad;
    String estado_mesas;
    
    static String todos = "SELECT * FROM mesas ORDER BY numero";
    static String numeros = "SELECT numero FROM mesas ORDER BY numero";
    
    public Mesas() {
    }
    
    public void obtenerconexion(Conexion cnx) {
        this.cnx = cnx;
    }

    public Mesas(int numero, String estado_mesas, int capacidad) {
        this.numero = numero;
        this.estado_mesas = estado_mesas;
        this.capacidad = capacidad;
    }
   
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO mesas VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.setString(2, estado_mesas);
            ps.setInt(3, capacidad);
            
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
            String sql = "DELETE FROM mesas WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, numero);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE mesas SET estado_mesas = ? , capacidad = ? WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estado_mesas);
            ps.setInt(2, capacidad);
            ps.setInt(3, numero);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return resultado;
        }
    }
}