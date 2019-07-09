package modelo.adm;


import conexion.conectar;
import modelo.vo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.citasdes;
import modelo.doctor;
import modelo.paciente;


public class UsuarioAdm {
    public ArrayList<Usuario> getListaUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        conectar conecta = new conectar();
        
        try {
            Connection conn = conecta.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COD_USU, NOMBRE, CONTRA, ID_PERFIL FROM T_ADMIN");
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setID_USU(rs.getString(1));
                usu.setNOMBRE(rs.getString(2));
                usu.setCONTRA(rs.getString(3));
                usu.setID_PERFIL(rs.getInt(4));

                listaUsuarios.add(usu);
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println("Se conecto a la bd");
        } catch (Exception e) {
                System.out.println("No se pudo obtener los registros de usuarios de la base de datos. Mensaje: "+ e.getMessage());
        }
        
        return listaUsuarios;
    }
    
    public ArrayList<doctor> getListaMedicos(){
        ArrayList<doctor> listaMedicos = new ArrayList();
        conectar conecta = new conectar();
        
        try {
            Connection conn = conecta.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COD_MEDICO, NOM_MEDICO, ESPE_MEDICO FROM MEDICOS");
            while (rs.next()) {
                doctor doc = new doctor();
                doc.setIdoctor(rs.getString(1));
                doc.setNombred(rs.getString(2));
                doc.setEspecialidad(rs.getString(3));

                listaMedicos.add(doc);
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println("Se conecto a la bd");
        } catch (Exception e) {
                System.out.println("No se pudo obtener los registros de medicos de la base de datos. Mensaje: "+ e.getMessage());
        }
        
        return listaMedicos;
    }
    
    public ArrayList<paciente> getListaPacientes(){
        ArrayList<paciente> listaPacientes = new ArrayList();
        conectar conecta = new conectar();
        
        try {
            Connection conn = conecta.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ESSALUD");
            while (rs.next()) {
                paciente pac = new paciente();
                pac.setHI_NREG(rs.getString(1));    
                pac.setHI_NOMBRE(rs.getString(2));
                pac.setHI_FECNAC(String.valueOf(rs.getDate(3)));
                pac.setHI_DIRECC(rs.getString(4));
                pac.setHI_SEXO(rs.getString(5));
                pac.setHI_FULTAT(String.valueOf(rs.getDate(6)));
                pac.setHI_NDOCUM(rs.getInt(7));
                pac.setHI_ESTCIV(rs.getString(8));
                pac.setHI_CONTRA(rs.getString(9));
                pac.setHI_PAD(rs.getString(10));

                listaPacientes.add(pac);
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println("Se conecto a la bd");
        } catch (Exception e) {
                System.out.println("No se pudo obtener los registros de pacientes de la base de datos. Mensaje: "+ e.getMessage());
        }
        
        return listaPacientes;
    }
    
    public ArrayList<citasdes> getListaCitasDes(){
        ArrayList<citasdes> listaMedicos = new ArrayList();
        conectar conecta = new conectar();
        
        try {
            Connection conn = conecta.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CITASDES");
            while (rs.next()) {
                citasdes cit = new citasdes();
                cit.setCODCITAS(rs.getString(1));
                cit.setHI_NDOCUM(rs.getInt(2));
                cit.setHI_NOMBRE(rs.getString(3));
                cit.setID_MEDICO(rs.getString(4));
                cit.setNOM_MEDICO(rs.getString(5));
                cit.setESPE_MEDICO(rs.getString(6));
                cit.setFECHA(String.valueOf(rs.getDate(7)));
                cit.setVISIBLE(rs.getString(8));

                listaMedicos.add(cit);
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println("Se conecto a la bd");
        } catch (Exception e) {
                System.out.println("No se pudo obtener los registros de medicos de la base de datos. Mensaje: "+ e.getMessage());
        }
        
        return listaMedicos;
    }
    public int registrarUsuario(Usuario usu){
        int result = 0;
        conectar conecta = new conectar();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("INSERT INTO T_ADMIN "+
                "VALUES (?,?,?,?)");
                ps.setString(1, usu.getID_USU());
                ps.setString(2, usu.getNOMBRE());
                ps.setString(3, usu.getCONTRA());
                ps.setInt(4, usu.getID_PERFIL());
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    public int registrarMedico(doctor doc){
        int result = 0;
        conectar conecta = new conectar();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("INSERT INTO MEDICOS "+
                "VALUES (?,?,?,'3')");
                ps.setString(1, doc.getIdoctor());
                ps.setString(2, doc.getNombred());
                ps.setString(3, doc.getEspecialidad());
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro doctor en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    public int registrarPaciente(paciente pac){
        int result = 0;
        conectar conecta = new conectar();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("INSERT INTO ESSALUD (HI_NREG, HI_NOMBRE, HI_FECNAC, HI_DIRECC, HI_SEXO, HI_FULTAT, HI_NDOCUM, HI_ESTCIV, HI_CONTRA, HI_PAD, ID_PERFIL) "+
                "VALUES (?, ?, to_date(?, 'MM/DD/RR'), ?, ?, to_date(?, 'MM/DD/RR'), ?, ?, ?, ?, '4')");  
            
                ps.setString(1, pac.getHI_NREG());
                ps.setString(2, pac.getHI_NOMBRE());
                ps.setString(3, pac.getHI_FECNAC());
                ps.setString(4, pac.getHI_DIRECC());
                ps.setString(5, pac.getHI_SEXO());
                ps.setString(6, pac.getHI_FULTAT());
                ps.setInt(7, pac.getHI_NDOCUM());
                ps.setString(8, pac.getHI_ESTCIV());
                ps.setString(9, pac.getHI_CONTRA());
                ps.setString(10, pac.getHI_PAD());
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro paciente en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }

    public int eliminarUsuario(Usuario usu) {
         int result = 0;
        conectar conecta = new conectar();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("DELETE FROM T_ADMIN WHERE COD_USU  = ?");
                ps.setString(1, usu.getID_USU());
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo Eliminar el registro en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    public int eliminarMedico(doctor doc) {
         int result = 0;
        conectar conecta = new conectar();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("DELETE FROM MEDICOS WHERE COD_MEDICO = ?");
                ps.setString(1, doc.getIdoctor());
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
                System.out.println("Se elimino medico "+doc.getNombred());
        } catch (Exception e) {
            System.out.println("No se pudo Eliminar el registro medico de la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    public int eliminarPaciente(paciente p) {
         int result = 0;
        conectar conecta = new conectar();
        Connection conn = conecta.getConnection();
        try {
            String nreg = p.getHI_NREG();
            System.out.println("Paciente id "+p.getHI_NREG());
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ESSALUD WHERE HI_NREG = "+nreg);
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
                
        } catch (Exception e) {
            System.out.println("No se pudo Eliminar el registro paciente de la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    public paciente getPaciente(String id) {
        conectar conecta = new conectar();
        paciente pac = new paciente();
        try {
            Connection conn = conecta.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ESSALUD WHERE HI_NREG = "+id);
            while (rs.next()) {
                pac.setHI_NREG(rs.getString(1));    
                pac.setHI_NOMBRE(rs.getString(2));
                pac.setHI_FECNAC(String.valueOf(rs.getDate(3)));
                pac.setHI_DIRECC(rs.getString(4));
                pac.setHI_SEXO(rs.getString(5));
                pac.setHI_FULTAT(String.valueOf(rs.getDate(6)));
                pac.setHI_NDOCUM(rs.getInt(7));
                pac.setHI_ESTCIV(rs.getString(8));
                pac.setHI_CONTRA(rs.getString(9));
                pac.setHI_PAD(rs.getString(10));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
                System.out.println("No se pudo obtener registro paciente: "+ e.getMessage());
        }
        
        return pac;
    }
    
}

