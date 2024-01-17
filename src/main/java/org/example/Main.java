package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numrondas;
        int opciondejuego = 1;
        while (opciondejuego != 0) {
            System.out.println("--------------------------------------------");
            System.out.println(" Bienvenido al juego Piedra, papel o tijera ");
            System.out.println("---------------------------------------------");
            System.out.println("1- Jugar a Piedra, papel o tijera.");
            System.out.println("0- Salir");
            System.out.println("Elija opción");
            opciondejuego = input.nextInt();
            switch (opciondejuego) {
                case 1:

                    System.out.print("¿Cuantas rondas quieres jugar? ");
                    numrondas = input.nextInt();
                    MuestraPiedrapapelotijera(numrondas);
                    break;


                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
            }
        }
    }

    public static void MuestraPiedrapapelotijera(int numrondas) {
        Scanner input = new Scanner(System.in);
        int seleccionjuego1;
        int puntosjugador = 0;
        int puntosordenador = 0;
        int num;
        int limInferior = 1;
        int limSuperior = 3;
        for (int i = 1; i <= numrondas; i++) {
            System.out.println("\nRonda " + i);
            do {
                System.out.println("1- Piedra");
                System.out.println("2- Papel");
                System.out.println("3- Tijera");
                System.out.print("Elige:");
                seleccionjuego1 = input.nextInt();
            } while (seleccionjuego1 < 1 || seleccionjuego1 > 3);
            num = generaNumeroAleatorio(limInferior, limSuperior);
            if (num == seleccionjuego1) {
                System.out.println("Empate.\n");
            } else if (num == 1 && seleccionjuego1 == 2) {//Ordenador: piedra y Jugador: papel -- Gana Jugador.
                System.out.println("Jugador: papel -- Gana Jugador.");
                System.out.println("El ordenador ha elegido piedra.");
                puntosjugador++;
            } else if (num == 1 && seleccionjuego1 == 3) {//Ordenador: piedra y Jugador: tijera -- Gana Ordenador.
                System.out.println("Jugador: tijera -- Gana Ordenador.");
                System.out.println("El ordenador ha elegido piedra.\n");
                puntosordenador++;
            } else if (num == 2 && seleccionjuego1 == 1) {//Ordenador: papel y Jugador: piedra -- Gana Ordenador.
                System.out.println("Jugador: piedra -- Gana Ordenador.");
                System.out.println("El ordenador ha elegido papel.\n");
                puntosordenador++;
            } else if (num == 2 && seleccionjuego1 == 3) {//Ordenador: papel y Jugador: tijera -- Gana Jugador.
                System.out.println("Jugador: tijera -- Gana Jugador.");
                System.out.println("El ordenador ha elegido papel.\n");
                puntosjugador++;
            } else if (num == 3 && seleccionjuego1 == 1) {//Ordenador: tijera y Jugador: piedra -- Gana Jugador.
                System.out.println("Jugador: piedra -- Gana Jugador.");
                System.out.println("El ordenador ha elegido tijera.\n");
                puntosjugador++;
            } else if (num == 3 && seleccionjuego1 == 2) {//Ordenador: tijera y Jugador: papel -- Gana Ordenador.
                System.out.println("Jugador: papel -- Gana Ordenador.");
                System.out.println("El ordenador ha elegido tijera.\n");
                puntosordenador++;
                System.out.println("Pierdes la ronda. ");
            }
            System.out.println(" Usuario: " + puntosjugador);
            System.out.println(" Ordenador: " + puntosordenador);
            if (i == numrondas) {
                System.out.println("\nEl juego ha terminado.");
                if (puntosordenador > puntosjugador) {
                    System.out.println(" Has perdido la partida ");
                    System.out.println(" Puntuacion total Usuario: " + puntosjugador);
                    System.out.println(" Puntuacion total Ordenador: " + puntosordenador);
                } else if (puntosordenador < puntosjugador) {
                    System.out.println(" Has ganado la partida ");
                    System.out.println(" Puntuacion total Usuario: " + puntosjugador);
                    System.out.println(" Puntuacion total Ordenador: " + puntosordenador + "\n");
                } else {
                    char desempate;
                    System.out.println(" Empate.");
                    System.out.println(" Puntuacion total Usuario: " + puntosjugador);
                    System.out.println(" Puntuacion total Ordenador: " + puntosordenador + "\n");
                    System.out.print(" ¿Quieres jugar otra ronda(S/N)? ");
                    desempate = input.next().charAt(0);
                    if (desempate == 's' || desempate == 'S') {
                        i--;
                    }
                }
            }
        }
    }

    public static int generaNumeroAleatorio(int limInferior, int limSuperior) {
        Random rand = new Random();
        return limInferior + rand.nextInt(limSuperior + 1 - limInferior);
    }
}


