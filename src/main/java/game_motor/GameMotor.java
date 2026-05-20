package game_motor;

import java.util.Random;
import java.util.Scanner;

import games.Basketball;
import games.Game2048;
import games.Wordle;
import utils.GameStats;
import utils.Posters;

public class GameMotor {

    private final Posters posters = new Posters();

    private final Scanner imputUSer = new Scanner(System.in);

    private final Wordle wordleGame = new Wordle();
    private final Basketball basketballGame = new Basketball();
    private final Game2048 game2048 = new Game2048();

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
                case "2" -> this.basketballGame.startBasketball();
                case "3" -> this.game2048.start2048();
                case "4" -> this.showStatsMenu();

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
            case 2 ->
                this.basketballGame.startBasketball();
            case 3 ->
                this.game2048.start2048();

            default ->
                throw new AssertionError();
        }
    }

    /**
     * Displays the statistics menu and prints game counters.
     */
    private void showStatsMenu() {
        while (true) {
            posters.showStatsMenu();

            String option = imputUSer.nextLine();
            switch (option) {
                case "1" -> {
                    posters.showWordleStats(
                            GameStats.getWordleStarted(),
                            GameStats.getWordleAttempts(),
                            GameStats.getWordleWins(),
                            GameStats.getWordleLosses()
                    );
                    imputUSer.nextLine();
                }
                case "2" -> {
                    posters.showBasketballStats(GameStats.getBasketballStarted());
                    imputUSer.nextLine();
                }
                case "3" -> {
                    posters.show2048Stats(
                            GameStats.get2048Started(),
                            GameStats.get2048Wins(),
                            GameStats.get2048Exits()
                    );
                    imputUSer.nextLine();
                }
                case "0" -> {
                    return;
                }
                default -> posters.showMesageWarningMemu(imputUSer);
            }
        }
    }
}

