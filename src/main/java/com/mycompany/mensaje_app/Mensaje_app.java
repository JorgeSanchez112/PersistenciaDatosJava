/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mensaje_app;

import java.util.Scanner;

/**
 *
 * @author Jorge
 */
public class Mensaje_app {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion=0;
        
        do{
            System.out.println("-----------------------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. Crear mensajes");
            System.out.println(" 2. Listar mensajes");
            System.out.println(" 3. Eliminar mensajes");
            System.out.println(" 4. Editar mensajes");
            System.out.println(" 5. Salir");
            //Leemos la opcion del usuario
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    System.out.println("Ha seleccionado una opcion fuera del rango");
                    break;
            }
        }while(opcion != 5);
        
        
    }
}
