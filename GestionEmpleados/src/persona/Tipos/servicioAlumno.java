package persona.Tipos;


public class servicioAlumno {

    public Alumno crear() {
        Alumno alumno = new Alumno();
        return alumno;
    }
    
    
    public Alumno crear(String nombre, String apellido, int dni, int estado, String curso) {
        Alumno alumno = new Alumno();
        alumno.setDatos(nombre, apellido, dni, estado);
        alumno.setCurso(curso);
        return alumno;
    }
    
    
    public void setCurso(Alumno alumno, String curso) {
        alumno.setCurso(curso);
    }
}
