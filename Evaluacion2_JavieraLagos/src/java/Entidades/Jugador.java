
package Entidades;


public class Jugador {
    String id;
    String nombre;
    String apellido;
    String edad;
    String posicion;
    int sueldo;
    String equipo;
    
 public Jugador(){
 }
  
    public Jugador(String id, String nombre, String apellido, String edad, String posicion, int sueldo, String equipo){
         
         this.id = id;
         this.nombre = nombre;
         this.apellido = apellido;
         this.edad = edad;
         this.posicion = posicion;
         this.sueldo = sueldo;
         this.equipo = equipo;
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
     
     
}
