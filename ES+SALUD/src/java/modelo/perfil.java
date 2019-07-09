package modelo;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
public class perfil {
    private String nombre;
    private int edad;
    private Date nfecha;
    private Date ufecha;
    private String direccion;
    private String ndocum;
    private padecencia pad;
    private String sexo;
    private boolean vermodal=true;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Date getUfecha() {
        return ufecha;
    }

    public void setUfecha(Date ufecha) {
        this.ufecha = ufecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getNfecha() {
        return nfecha;
    }

    public void setNfecha(Date nfecha) {
        this.nfecha = nfecha;
    }

    public String getNdocum() {
        return ndocum;
    }

    public void setNdocum(String ndocum) {
        this.ndocum = ndocum;
    }

    public padecencia getPad() {
        return pad;
    }

    public void setPad(padecencia pad) {
        this.pad = pad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean getVermodal() {
        return vermodal;
    }

    public void setVermodal(boolean vermodal) {
        this.vermodal = vermodal;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}