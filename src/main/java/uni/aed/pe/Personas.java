/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.pe;

/**
 * Prueba de Entrada 241
 * Clase que permite realizar operaciones con la clase persona, como: 
 * insertarPersonas y calcular su edad promedio
 * @author uni.cc232
 */
public class Personas {
    Persona[] personas;
    int cont;

    public Personas(Persona[] personas) {
        this.personas = personas;
    }

    public Personas(int N) {
        personas= new Persona[N];
        cont=0;
    }
    
    public void insertarPersona(Persona p){
        if (cont<personas.length){
            personas[cont]=p;
            cont++;           
        }else
            System.out.println("Registro lleno");
    }
    public float calcularEdadPromedio(){
        int edadSuma=0;        
        for(Persona p:personas)
            edadSuma=edadSuma + p.getEdad();
        return edadSuma/cont;
    }

    @Override
    public String toString() {
        String result="";        
        for(Persona p:personas)
            result=result + p.toString();
        return result;        
    }   
    
}
