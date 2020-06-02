
package Entidades;

public class Equipo {
    int codigo;
    String nombre;
    String procedencia;
    String estadio;
    String division;
    String jugadores;
    
    public Equipo (){
    }
        
       public Equipo (int codigo, String nombre, String procedencia, String estadio, String division, String jugadores){
           
           this.codigo = codigo;
           this.nombre = nombre;
           this.procedencia = procedencia;
           this.estadio = estadio;
           this.division = division;
           this.jugadores = jugadores;
              
    }

    public Equipo(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getJugadores() {
        return jugadores;
    }

    public void setJugadores(String jugadores) {
        this.jugadores = jugadores;
    }

    public Object getcodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
}
