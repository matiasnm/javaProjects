package persona.Tipos;

import persona.Persona;


public class Alumno extends Persona{

    String curso;

    protected Alumno() {
        super("Alumno");
    }

    protected void setCurso(String curso) {
        this.curso = curso;
    }

    protected String getCurso() {
        return curso;
    }
    
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "\n CURSO: " + curso;
        return msg;
    }
}