/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica_Cliente;

import Logica_Negocio.Contacto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jsml
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializacion de las variables
        String Nombre = "";
        String Nombre_buscar = "";
        int Numero = 0;
        int Num_con = 0;

        //Menu
        int opc = 0;
        int bandera = 0;

        Scanner scan = new Scanner(System.in);
        ArrayList<Contacto> Lscontactos = new ArrayList<>();

        do {
            System.out.println("\n");
            System.out.println("Zona Virtual S.A");
            System.out.println("\n");
            System.out.println("****Aplicacion de lista de contactos****");
            System.out.println("1. Agregar contacto/s");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por burbuja a partir de los nombres");
            System.out.println("5. Ordenar por insercion a partir de los numeros");
            System.out.println("6. Salir");
            System.out.println("\n");
            System.out.println("Ingrese la opcion");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Digite el numero de contactos que desea registrar: ");
                    Num_con = scan.nextInt();
                    scan.nextLine();

                    for (int i = 0; i < Num_con; i++) {
                        System.out.println("Digite el nombre del contacto " + (i + 1) + " :");
                        Nombre = scan.nextLine();

                        System.out.println("Digite el numero del contacto " + (i + 1) + " :");
                        Numero = scan.nextInt();
                        scan.nextLine();

                        Contacto objContacto = new Contacto(Nombre, Numero);
                        Lscontactos.add(objContacto);

                    }

                    System.out.println("\n");
                    System.out.println("Contactos registrados correctamente : " + Num_con);
                    System.out.println("\n");

                    break;

                case 2:
                    if (!Lscontactos.isEmpty()) {
                        MostrarContactos(Lscontactos);
                    } else {
                        System.out.println("La lista de contactos se encuentra vacia");
                    }

                    break;

                case 3:
                    if (!Lscontactos.isEmpty()) {
                        scan.nextLine();
                        System.out.println("Digite el nombre del contacto que desea buscar: ");
                        Nombre_buscar = scan.nextLine();

                        for (int i = 0; i < Lscontactos.size(); i++) {
                            if (Lscontactos.get(i).getNombre().equalsIgnoreCase(Nombre_buscar)) {
                                bandera = 1;
                                System.out.println("\n");
                                System.out.println("Contacto ");
                                System.out.println("Nombre: " + Lscontactos.get(i).getNombre());
                                System.out.println("Numero: " + Lscontactos.get(i).getNumero());

                            }
                        }
                        if (bandera == 0) {

                            System.out.println("Contacto no encontrado");

                        }
                        bandera = 0;

                    } else {
                        System.out.println("La lista de contactos se encuentra vacia");
                    }
                    break;

                case 4:
                    if (!Lscontactos.isEmpty()) {
                        OrdenamientoporBurbuja(Lscontactos);
                        MostrarContactos(Lscontactos);

                    } else {
                        System.out.println("La lista de contactos se encuentra vacia");
                    }

                    break;

                case 5:
                    if (!Lscontactos.isEmpty()) {
                        ordenarPorInsercion(Lscontactos);
                        MostrarContactos(Lscontactos);
                    } else {
                        System.out.println("La lista de contactos se encuentra vacia");
                    }

                    break;

                case 6:
                    //Salir
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opc != 6);
    }

    public static void MostrarContactos(ArrayList<Contacto> Lscontactos) {
        for (int i = 0; i < Lscontactos.size(); i++) {
            System.out.println("Contacto " + (i + 1));
            System.out.println("Nombre: " + Lscontactos.get(i).getNombre());
            System.out.println("Numero: " + Lscontactos.get(i).getNumero());
            System.out.println("\n");

        }

    }

    public static void OrdenamientoporBurbuja(ArrayList<Contacto> Lscontactos) {
        int Numero = Lscontactos.size();
        for (int i = 0; i < Numero - 1; i++) {
            for (int j = 0; j < Numero - i - 1; j++) {
                Contacto uno = Lscontactos.get(j);
                Contacto dos = Lscontactos.get(j + 1);
                // Comparar los nombres en lugar de los tiempos
                if (uno.getNombre().compareTo(dos.getNombre()) > 0) {
                    // Intercambiar los atletas
                    Contacto temp = Lscontactos.get(j);
                    Lscontactos.set(j, Lscontactos.get(j + 1));
                    Lscontactos.set(j + 1, temp);
                }
            }
        }
    }

    public static void ordenarPorInsercion(ArrayList<Contacto> Lscontactos) {
        for (int i = 1; i < Lscontactos.size(); i++) {
            boolean agregado = false;
            for (int j = i; j > 0 && !agregado; j--) {
                Contacto uno = Lscontactos.get(j);
                Contacto dos = Lscontactos.get(j - 1);
                if (uno.getNumero() < dos.getNumero()) {
                    Lscontactos.set(j, dos);
                    Lscontactos.set(j - 1, uno);
                } else {
                    agregado = true;
                }
            }
        }
    }

}
