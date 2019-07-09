package Procedimientos;
import java.util.ArrayList;
import modelo.*;
public interface icitas {   
    public ArrayList listarDoctores();
    public ArrayList listarcitas();   
    public perfil validacion(login lo);
    public int procita(cita ci);
    public ArrayList listarhistorial(perfil per);
    public int disminuircupo(String c);
    public int valida_replica(perfil per);
    public ArrayList listamodal(String cod);
    public double enfermedadesprobabilidad(String cod);
    public double enfermedadesespecificasprobabilidad(String cod, int min , int max);
    public double estadisticaprobabilidadderivada(String cod);
}
