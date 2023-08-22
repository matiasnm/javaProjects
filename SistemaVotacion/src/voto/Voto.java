package voto;

import alumno.Alumno;
import java.util.ArrayList;
import java.util.List;

public class Voto {
    
    Alumno votante = new Alumno();
    List<Alumno> votados = new ArrayList();

    public Voto() {
    }

    public Voto( Alumno votante, List<Alumno> votados) {
        this.votante = votante;
        this.votados = votados;
    }

    public Alumno getVotante() {
        return votante;
    }

    public List<Alumno> getVotados() {
        return votados;
    }
    
    public void setVotante(Alumno votante) {
        this.votante = votante;
    }

    public void setVotados(List<Alumno> votados) {
        this.votados = votados;
    }
    
}
