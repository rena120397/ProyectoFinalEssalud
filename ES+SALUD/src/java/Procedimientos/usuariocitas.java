package Procedimientos;
import conexion.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.*;
public class usuariocitas implements icitas {//utilizar tabla usu
    
    
    public ArrayList listarDoctores()
    {
       ArrayList<doctor> listadoctor = new ArrayList();
       String sql="select COD_MEDICO, NOM_MEDICO, ESPE_MEDICO from MEDICOS";
       conectar con = new conectar();
       Connection co = con.getConnection();
       
       try
       {
           PreparedStatement pst=null;
           pst = co.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           
           while(rs.next())
           {
               doctor doc=new doctor();
               doc.setIdoctor(rs.getString(1));
               doc.setNombred(rs.getString(2));
               doc.setEspecialidad(rs.getString(3));
               listadoctor.add(doc);
           }
            rs.close();
            pst.close();
            co.close();
            co=null;
       }
       catch(Exception e)
       {
           System.out.println("No se pudo obtener los doctores de la base de datos. Mensaje: "+ e.getMessage());
       }
       return listadoctor;
    }
    
    public ArrayList listarcitas()
    {
        ArrayList<cita> listacita = new ArrayList();
        String sql="select PROG_MEDIC.ID_PROG_MEDIC ,MEDICOS.COD_MEDICO, MEDICOS.NOM_MEDICO, MEDICOS.ESPE_MEDICO, PROG_MEDIC.FECHA, PROG_MEDIC.H_INICIO_1,PROG_MEDIC.H_FIN_1, PROG_MEDIC.H_INICIO_2, PROG_MEDIC.H_FIN_2, CUPO_DISP from MEDICOS\n" +
                    "inner join PROG_MEDIC on MEDICOS.COD_MEDICO = PROG_MEDIC.COD_MEDICO where CUPO_DISP >=1";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst=null;
            pst = co.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                cita ci= new cita();
                ci.setIdprogmedic(rs.getString(1));
                ci.setIdmedico(rs.getString(2));
                ci.setNomedico(rs.getString(3));
                ci.setEspemedico(rs.getString(4));
                ci.setFecha(rs.getDate(5));
                ci.setHinicio1(rs.getDate(6));
                ci.setHfin1(rs.getDate(7));
                ci.setHinicio2(rs.getDate(8));
                ci.setHfin2(rs.getDate(9));
                ci.setCupo(rs.getInt(10));
                listacita.add(ci);        
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo obtener las citas de la base de datos. Mensaje: "+ e.getMessage());
        }
        return listacita;
    } 
    
    public perfil validacion(login lo)
    {   perfil per=null;
        padecencia pa=null;
        String sql="select ESSALUD.HI_NOMBRE, ESSALUD.HI_FECNAC , ESSALUD.HI_DIRECC , ESSALUD.HI_SEXO ,ESSALUD.HI_FULTAT, ESSALUD.HI_NDOCUM, PAD.HI_DESCRIP ,PAD.HI_PAD, PAD.T_PROM, ESSALUD.HI_EDAD from  ESSALUD \n" +
        "INNER JOIN PAD ON ESSALUD.HI_PAD = PAD.HI_PAD where ESSALUD.HI_NDOCUM=? and ESSALUD.HI_CONTRA=?";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1, lo.getDni());
            pst.setString(2, lo.getPass());
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                per=new perfil();
                pa=new padecencia();
                per.setNombre(rs.getString(1));
                per.setNfecha(rs.getDate(2));
                per.setDireccion(rs.getString(3));
                per.setSexo(rs.getString(4));
                per.setUfecha(rs.getDate(5));
                per.setNdocum(rs.getString(6));
                pa.setNompadecencia(rs.getString(7));
                pa.setIdpadecencia(rs.getString(8));
                pa.setP(probabilidad(rs.getString(8)));//estadistica
                pa.setTprom(rs.getInt(9));
                per.setEdad(rs.getInt(10));
                per.setPad(pa);
            }
            
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo obtener el perfil de la base de datos. Mensaje: "+ e.getMessage());
        }
        return per;  
    }
    
    public int procita(cita ci)
    {
        int result=0;
        String sql="insert into CITAS (COD_CITAS, ID_PROG_MEDIC, HI_NDOCUM,VISIBLE) values (?,?,?,?)";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1,generarcodigo("C"));
            ps.setString(2,ci.getIdprogmedic());
            ps.setString(3,ci.getNdocum());
            ps.setString(4,"t");
            
            result = ps.executeUpdate();
            ps.close();
            ps = null;
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo insertar la cita en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    public ArrayList listarhistorial(perfil per)
    {
        ArrayList<cita> listahistorial=new ArrayList();
        String sql="SELECT * FROM CITASDES where VISIBLE=? and HI_NDOCUM=?";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,"t");
            pst.setString(2, per.getNdocum());
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                cita ci = new cita();
                ci.setCodcita(rs.getString(1));
                ci.setNdocum(rs.getString(2));
                ci.setNoma(rs.getString(3));
                ci.setIdmedico(rs.getString(4));
                ci.setNomedico(rs.getString(5));
                ci.setEspemedico(rs.getString(6));
                ci.setFecha(rs.getDate(7));
                listahistorial.add(ci);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)   
        {
            System.out.println("No se pudo listar la cita en la base de datos. Mensaje: "+ e.getMessage());
        }
        return listahistorial;
    }
    public int disminuircupo(String c)
    {   int result=0;
        conectar con = new conectar();
        Connection co = con.getConnection();
        String sql="UPDATE PROG_MEDIC SET CUPO_DISP=CUPO_DISP-1 WHERE COD_MEDICO=? ";
        try
        {
            PreparedStatement ps=co.prepareStatement(sql);
            ps.setString(1,c);
            ps.executeUpdate();
            ps.close();
            ps = null;
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo disminuir el cupo en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    private String generarcodigo(String c)
    {
        String codigopedido="";
        String codigocoger=null;
        int numerocodigo=0;
        String numerocodigostring="";
        conectar con = new conectar();
        Connection co = con.getConnection();
        String sql="select max(COD_CITAS) from CITAS where COD_CITAS like ?";
        try
        {
            PreparedStatement pst=null;
            pst = co.prepareStatement(sql);
            pst.setString(1,c+"%");
            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                codigocoger=rs.getString(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo conseguir el registro en la base de datos. Mensaje: "+ e.getMessage());
        }

        if (codigocoger==null)
        {
            codigopedido=c+"00001";
        }
        else
        {
            String[] parte=codigocoger.split(c);
            numerocodigo=Integer.parseInt(parte[1].trim());
            numerocodigo=numerocodigo+1;
            numerocodigostring=numerocodigo+"";
            if(numerocodigostring.length()==1)
            {
                codigopedido=c+"0000"+numerocodigostring;
            }
            else if(numerocodigostring.length()==2)
            {
                codigopedido=c+"000"+numerocodigostring;
            }
            else if(numerocodigostring.length()==3)
            {
                codigopedido=c+"00"+numerocodigostring;
            }
            else if(numerocodigostring.length()==4)
            {
                codigopedido=c+"0"+numerocodigostring;
            }  
            else if(numerocodigostring.length()==5)
            {
                codigopedido=c+""+numerocodigostring;
            }  
        }
        
        return codigopedido;
    }
    
    public int valida_replica(perfil per){
        int result=0;
        String sql="select count(HI_NDOCUM) from citas where HI_NDOCUM=?";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,per.getNdocum());
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                result=rs.getInt(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
            
        }
        catch(Exception e)
        {
            System.out.println("No se pudo contar el registro en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    public double enfermedadesprobabilidad(String cod)       
    {   
        double result=0;
        String sql="select ((select count(HI_PAD) from ESSALUD where HI_PAD like ?)/(select count(HI_PAD) from ESSALUD))*100 from dual";
        conectar con =new conectar();
        Connection co = con.getConnection();
        
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,cod+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                result=rs.getDouble(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo recoger la probabilidad de tal enfermedad. Mensaje: "+ e.getMessage());
        }
        
        return result;
    }
    
    public double enfermedadesespecificasprobabilidad(String cod, int min , int max)
    {   double result=0;
        String sql="SELECT count(HI_PAD) FROM ESSALUD where HI_PAD like ? and HI_EDAD between ? and ?";
        conectar con =new conectar();
        Connection co = con.getConnection();
        
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,cod+"%");
            pst.setInt(2,min);
            pst.setInt(3,max);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                result=rs.getDouble(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo recoger la probabilidad de tal enfermedad en especifica. Mensaje: "+ e.getMessage());
        }
                
        
        return result;
    }
    
    private double probabilidad(String cod)
    {   double result=0;
        String sql="select (((select count(HI_PAD) from ESSALUD where HI_PAD like ?)/(select count(HI_PAD) from ESSALUD)) * ((select count(HI_PAD) from ESSALUD where HI_PAD like ?)/(select count(HI_PAD) from ESSALUD)))*100 from dual";
        char[] codarray = cod.toCharArray();
        
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,codarray[0]+"%");
            pst.setString(2,cod+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                result=rs.getDouble(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo recoger la probabilidad en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    public double estadisticaprobabilidadderivada(String cod)
    {
        double result=0;
        String sql="select ((select count(HI_PAD) from ESSALUD where HI_PAD like ?) / (select count(HI_PAD) from ESSALUD where HI_PAD like ?))*100 from dual";
        char[] codarray = cod.toCharArray();
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,cod+"%");
            pst.setString(2,codarray[0]+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                result=rs.getDouble(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo recoger la probabilidad en la base de datos. Mensaje: "+ e.getMessage());
        }
        
        return result;
    }
    
    public ArrayList listamodal(String cod)    
    {
        ArrayList<String> lista = new ArrayList();
        
        switch(cod)
        {
            case "A01": {
                           lista.add("Daño pulmonar a largo plazo</br>");
                           lista.add("Riesgo de enfisema</br>");
                           lista.add("En el peor de los casos sufrir problemas respiratorions mucho mas agudos");
                        }
            break;  
            case "A02": {
                            lista.add("Insuficiencia coronaria</br>");
                            lista.add("Angina de pecho</br>");
                            lista.add("Arteriorclerosis (cúmulos de coresterol en las arterias</br>");
                            lista.add("Fenómenos de trombosis (puede producir infarto de miocardio o infarto cerebral</br>");
                            lista.add("En el peor de los casos, puede reblandecer las paredes de la aorta y provocar su dilatacion (aneurisma)</br>");
                            lista.add("Rotura (loque inevitablemente causa la muerte)");
                        }
            break;
            case "B01": {
                            lista.add("Daño pulmonar a largo plazo</br>");
                            lista.add("Riesgo de entimesa</br>");
                            lista.add("En el peor de los casos sufrir problemas respiratorios mucho mas agudos</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Se recomienda una visita urgente al medico pues de no ser así sus alergias empeoran");
                        }
            break;
            case "B02": {
                            lista.add("Daño pulmonar a largo plazo</br>");
                            lista.add("Riesgo de entimesa</br>");
                            lista.add("En el peor de los casos sufrir problemas respiratorios mucho mas agudos</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Se recomienda una visita urgente al medico pues de no ser así sufrira </br>mucha mas complicaciones y su salud se vera mucho mas afectada");
                        }
            break;
            case "B03": {
                            lista.add("Daño pulmonar a largo plazo</br>");
                            lista.add("Riesgo de entimesa</br>");
                            lista.add("En el peor de los casos sufrir problemas respiratorios mucho mas agudos</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Se recomienda una visita urgente al medico pues de no ser así sufrira </br>mucha mas complicaciones y su salud se vera mucho mas afectada");
                        }
            break;
            case "C01": {
                            lista.add("Enfermedades del corazón</br>");
                            lista.add("Problemas de los pies</br>");
                            lista.add("Lesiones en los nervios</br>");
                            lista.add("Enfermedades dentales</br>");
                            lista.add("Problemas de los ojos</br>");
                            lista.add("Enfermedades de los riñones</br>");
                            lista.add("Accidentes cerebro-vasculares</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Se recomienda una visita urgente al medico pues de no ser así sufrirá muchas </br>mas complicaciones y su salud se vera mucho mas afectada</span>");
                        }
            break;
            case "C02": {
                            lista.add("Enfermedades del corazón</br>");
                            lista.add("Problemas de los pies</br>");
                            lista.add("Lesiones en los nervios</br>");
                            lista.add("Enfermedades dentales</br>");
                            lista.add("Problemas de los ojos</br>");
                            lista.add("Enfermedades de los riñones</br>");
                            lista.add("Accidentes cerebro-vasculares</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Se recomienda una visita urgente al medico pues de no ser así sufrirá muchas </br>mas complicaciones y su salud se vera mucho mas afectada</span>");
                        }
            break;
            case "C03": {
                            lista.add("Enfermedades del corazón</br>");
                            lista.add("Problemas de los pies</br>");
                            lista.add("Lesiones en los nervios</br>");
                            lista.add("Enfermedades dentales</br>");
                            lista.add("Problemas de los ojos</br>");
                            lista.add("Enfermedades de los riñones</br>");
                            lista.add("Accidentes cerebro-vasculares</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Se recomienda una visita urgente al medico pues de no ser así sufrirá muchas </br>mas complicaciones y su salud se vera mucho mas afectada</span>");
                        }
            break;
            case "D01": {   
                            lista.add("Cotagio</br>");
                            lista.add("A contraer mas enfermedades</br>");
                            lista.add("Se recomienda una visita urgente al medico pues de no ser así sufrirá muchas mas </br>complicaciones y su salud se vera mucho mas afectada");
                            lista.add("A tener en cuenta</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Los pacientes con sintomas activos requeriran un largo proceso de tratamiento con varios tipos de antibioticos</span>");
                        }
            break;
            case "D02": {
                            lista.add("Cotagio</br>");
                            lista.add("A contraer mas enfermedades</br>");
                            lista.add("Se recomienda una visita urgente al medico pues de no ser así sufrirá muchas mas </br>complicaciones y su salud se vera mucho mas afectada");
                            lista.add("A tener en cuenta</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Los pacientes con sintomas activos requeriran un largo proceso de tratamiento con varios tipos de antibioticos</span>");
                        }
            break;
            case "D03": {
                            lista.add("Cotagio</br>");
                            lista.add("A contraer mas enfermedades</br>");
                            lista.add("Se recomienda una visita urgente al medico pues de no ser así sufrirá muchas mas </br>complicaciones y su salud se vera mucho mas afectada");
                            lista.add("A tener en cuenta</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Los pacientes con sintomas activos requeriran un largo proceso de tratamiento con varios tipos de antibioticos</span>");
                        }   
            break;
            case "D04": {
                            lista.add("Cotagio</br>");
                            lista.add("A contraer mas enfermedades</br>");
                            lista.add("Se recomienda una visita urgente al medico pues de no ser así sufrirá muchas mas </br>complicaciones y su salud se vera mucho mas afectada");
                            lista.add("A tener en cuenta</br>");
                            lista.add("<span class=\"textorojo font-weight-bold\">Los pacientes con sintomas activos requeriran un largo proceso de tratamiento con varios tipos de antibioticos</span>");
                        }
            break;
        }
        
        return lista;
    }
    
}