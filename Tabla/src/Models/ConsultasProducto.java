package Models;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FJ
 */
public class ConsultasProducto extends Conexion {

    public boolean registrar(Producto prod) {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();

        String sql = "INSERT INTO productos (codigo, nombre, precio, cantidad) VALUES (?,?,?,?)";
        
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setDouble(3, prod.getPrecio());
            ps.setInt(4, prod.getCantidad());
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }
    
    public boolean modificar(Producto prod) {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();

        String sql = "UPDATE productos SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?";
        
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setDouble(3, prod.getPrecio());
            ps.setInt(4, prod.getCantidad());
            ps.setInt(5, prod.getId());
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }
    
    public boolean buscar(Producto prod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();

        String sql = "SELECT * FROM productos WHERE codigo=?";
        
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            rs = ps.executeQuery();
            if(rs.next()) {
                prod.setId(Integer.parseInt(rs.getString("id")));
                prod.setCodigo(rs.getString("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(Double.parseDouble(rs.getString("precio")));
                prod.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
            } 
            return false; // sin resultados
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }
    
    public boolean eliminar(Producto prod) {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();

        String sql = "DELETE FROM productos WHERE id=?";
        
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1, prod.getId());
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }
    
}
