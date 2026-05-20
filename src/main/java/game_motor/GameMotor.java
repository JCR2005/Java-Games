package game_motor;

import java.util.Random;
import java.util.Scanner;

import games.Wordle;
import utils.Posters;

public class GameMotor {

    private final Posters posters = new Posters();

    private final Scanner imputUSer = new Scanner(System.in);

    private final Wordle wordleGame = new Wordle();

    /**
     * Este metodo inicia el motor del juego.
     * 
     */
    public void startGemaMotor() {

        this.startInitialMenu();

    }

    private void startInitialMenu() {

        do {
            // munu inicial
            this.posters.showInitialMenu();

            // entrada del usuario
            String option = this.imputUSer.nextLine();

            switch (option) {

                // Este caso lleva a una seleecion aleatoria de uno de los tres juegos
                case "1" -> {
                    this.randomSelection();
                }

                // Este caso lleva a el menu principal
                case "2" -> {
                    this.startPrincipalMenu();
                    return;
                }

                // Este caso cierra el programa
                case "3" -> {
                    return;
                }

                default -> {
                    this.posters.showMesageWarningMemu(this.imputUSer);
                    this.imputUSer.nextLine();
                }
            }
            //
            // Dirige al usuario al menu principal
        } while (true);
    }

    /**
     * Este metodo ejecutara el menu principal donde el usuairo podra elegir
     * cualquier juego
     */
    private void startPrincipalMenu() {

        String option; // variables que almacena el valor que ingresa el uasrio

        do {

            this.posters.showPrincipalMenu();

            option = this.imputUSer.nextLine();

            switch (option) {
                case "1" -> this.wordleGame.startWordle();

                case "0" -> {
                    return;
                }

                default -> this.posters.showMesageWarningMemu(this.imputUSer);
            }
        } while (true);

    }

    /**
     * Este metodo hace una seleecion aleatoria de uno de los tres juegos
     *
     */
    private void randomSelection() {

        Random ram = new Random();

        int option = ram.nextInt(3) + 1; // variables que almacena el valor que ingresa el usuario

        switch (option) {

            // Este caos dirige al usuario al juego uno
            case 1 ->
                this.wordleGame.startWordle();

            default ->
                throw new AssertionError();
        }
    }
}

