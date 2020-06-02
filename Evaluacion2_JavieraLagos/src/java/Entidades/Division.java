
package Entidades;


public class Division {
    
    int codigo;
    String nombre;
    
    public Division(){
    
}
    public Division(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        
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
    
    
        
    
}
