/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

/**
 *
 * @author jsml
 */
public class Contacto {
    //Declaracion de atributos
    private String Nombre;
    private int Numero;
    
    //Constructor no parametrizado

    public Contacto() {
    }
    
    //Constructor parametrizado

    public Contacto(String Nombre, int Numero) {
        this.Nombre = Nombre;
        this.Numero = Numero;
    }
    
    //Setter y getters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
    
    
    
}
