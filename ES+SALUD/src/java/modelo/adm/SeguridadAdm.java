package modelo.adm;
import conexion.conectar;
import modelo.vo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeguridadAdm {
    
    public Usuario validarUsuario(String uname,String uclave){
        Usuario usuObj = null;
        conectar conecta = new conectar();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("SELECT COD_USU, NOMBRE, CONTRA, ID_PERFIL  FROM T_ADMIN WHERE NOMBRE = ? and CONTRA = ?");
            ps.setString(1, uname);
            ps.setString(2, uclave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuObj = new Usuario();
                usuObj.setID_USU(rs.getString(1));
                usuObj.setNOMBRE(rs.getString(2));
                usuObj.setCONTRA(rs.getString(3));
                usuObj.setID_PERFIL(rs.getInt(4));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        
        return usuObj;
    }
    
}
