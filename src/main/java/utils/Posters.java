package utils;

import java.util.Scanner;

public class Posters {

    private final Utils utils = new Utils();
    private static final String BASKETBALL_FRAME = "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓";
    private static final int BASKETBALL_INNER_WIDTH = BASKETBALL_FRAME.length() - 2;

    /**
     * Metodo que muestra el menu de unicio.
     *
     */
    public void showInitialMenu() {

        utils.cleanScreem();

        System.out.println("┏══━━━━━━━━━━━━━━━━JavaMiniGames━━━━━━━━━━━━━━━══┓");
        System.out.println("║                                                ║");
        System.out.println("┃          1. Iniciar un juego aleatorio         ┃");
        System.out.println("┃          2. Yo quero elegir el juego           ┃");
        System.out.println("┃          3. Cerra                              ┃");
        System.out.println("║                                                ║");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n\n");

    }

    /**
     * Este metodo mostrara las opciones que tiene el meni principal
     */
    public void showPrincipalMenu() {
        utils.cleanScreem();
        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━MENU━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("║                                                ║");
        System.out.println("┃                   1.Wordle                     ┃");
        System.out.println("┃                   2.Basketball                 ┃");
        System.out.println("┃                   3.2048                       ┃");
        System.out.println("┃                   4.Registros                  ┃");
        System.out.println("┃                   0.Salir                      ┃");
        System.out.println("║                                                ║");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n\n");
    }

    /**
     * Este metodo mustra un mensaje de advertencia
     *
     */
    public void showMesageWarningMemu(Scanner imputUSer) {
        utils.cleanScreem();
        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("       Por favor, ingresar un valor valido!.");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛");
        System.out.println(" Presione enter para continuar.");
        imputUSer.nextLine();
        utils.cleanScreem();
    }

    /**
     * Este metodo muestra el menu del juego wordle
     * 
     */
    public void showWordleMenu() {
        this.utils.cleanScreem();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                                                         ━                  ┃");
        System.out.println("┃╲                  ╱                                ┃     ┃                 ┃");
        System.out.println("┃ ╲                ╱                                 ┃     ┃                 ┃");
        System.out.println("┃  ╲              ╱   ━━━━━━━━    ━━━━━━━━   ━━━━━━━━┃     ┃        ━━━━━━━━ ┃");
        System.out.println("┃   ╲            ╱   ┃        ┃  ┃        ┃ ┃        ┃     ┃       ┃        ┃┃");
        System.out.println("┃    ╲    ╱╲    ╱    ┃        ┃  ┃          ┃        ┃     ┃       ┃━━━━━━━━ ┃");
        System.out.println("┃     ╲  ╱  ╲  ╱     ┃        ┃  ┃          ┃        ┃     ┃       ┃         ┃");
        System.out.println("┃      ╲╱    ╲╱       ━━━━━━━━   ┃           ━━━━━━━━   ╲━━━━━━━    ━━━━━━━━ ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                               1.Instrucciones                              ┃");
        System.out.println("┃                               2.Jugar con amigos                           ┃");
        System.out.println("┃                               3.Jugar solitario                            ┃");
        System.out.println("┃                               4.Regresar                                   ┃");
        System.out.println("┃                                                                            ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

    }

    /**
     * Shows Wordle instructions.
     */
    public void showWordleInstructions() {
        this.utils.cleanScreem();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ Instrucciones Wordle:                                                      ┃");
        System.out.println("┃ - Adivina la palabra en un máximo de 6 intentos.                           ┃");
        System.out.println("┃ - Verde: letra correcta en la posición correcta.                           ┃");
        System.out.println("┃ - Amarillo: letra correcta en otra posición.                               ┃");
        System.out.println("┃ - Rojo: letra no está en la palabra.                                       ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println("Presione enter para continuar.");
    }

    public void showImputWordle() {
        this.utils.cleanScreem();
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                          Ingrese palabra a ocultar                         ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" Presione enter para continuar.");

    }

    public void showWarningWord(Scanner imputUSer) {
        this.utils.cleanScreem();
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃ Ingrese palabra a valida! (La palabra debe contener vocales y consonantes).┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" Presione enter para reintentar.");
        imputUSer.nextLine();
    }

    public void showWarningWordIsEmpy(Scanner imputUSer) {
        this.utils.cleanScreem();
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃              Ingrese palabra a valida! (Se ha ingresado vacio).            ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" Presione enter para reintentar.");
        imputUSer.nextLine();
    }

    public void showWarningWordIsLength(Scanner imputUSer) {
        this.utils.cleanScreem();
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.err.println("┃         La palabra deber tener el numero de latras que la original!        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" Presione enter para reintentar.");
        imputUSer.nextLine();
    }
    public void showWordWordle(String word) {

        this.utils.cleanScreem();
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                            La plabra oculta es:                            ┃");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                                                                            ┃");
        System.out.println("                             " + word + "                                     ");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                            1.Guardar y continuar                           ┃");
        System.out.println("┃                            2.Editar                                        ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

    }

    public void showOportinityNumber(int OportinityNumber){
        System.out.println("┃                               Intento No." + OportinityNumber + "                                 ┃");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                            ingrese una palabra                             ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

    }

    public void showHistoryWords(String[][] historyWords) {

        this.utils.cleanScreem();

        String top =    "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓";
        String bottom = "┗                                                                            ┛";

        int boxWidth = top.length() - 2;

        System.out.println("\n\n" + top);

        printCentered("Historial de palabras", boxWidth);

        System.out.println("┃" + " ".repeat(boxWidth) + "┃");

        for (String[] historyRow : historyWords) {

            StringBuilder row = new StringBuilder();

            for (String cell : historyRow) {

                if (cell != null) {
                    row.append(cell).append(" ");
                }
            }

            String finalRow = row.toString().stripTrailing();

            String visibleRow = finalRow.replaceAll("\u001B\\[[;\\d]*m", "");

            int padding = (boxWidth - visibleRow.length()) / 2;

            if (padding < 0) {
                padding = 0;
            }

            System.out.print("┃");
            System.out.print(" ".repeat(padding));
            System.out.print(finalRow);
            System.out.print(" ".repeat(
                    Math.max(0, boxWidth - padding - visibleRow.length())
            ));
            System.out.println("┃");
        }

        System.out.println("┃" + " ".repeat(boxWidth) + "┃");

        System.out.println(bottom + "\n");
    }

    private void printCentered(String text, int width) {

        int padding = (width - text.length()) / 2;

        System.out.println(
                "┃"
                + " ".repeat(Math.max(0, padding))
                + text
                + " ".repeat(Math.max(0, width - padding - text.length()))
                + "┃"
        );
    }


    public void showCongratulations(Scanner imputUser) {
        this.utils.cleanScreem();
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                         ¡Felicidades, has ganado!                          ┃");
        System.out.println("┃                                                                            ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println(" Presione enter para continuar.");
        imputUser.nextLine();

    }


    

    public void showDefeat(Scanner imputUser, String[] word) {
        this.utils.cleanScreem();

        String top    = "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓";
        String bottom = "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛";
        int inner = top.length() - 2;

        String wordStr  = String.join("", word); // ["h","o","l","a"] → "hola"
        String wordLine = "La palabra era: " + wordStr;
        String empty    = "┃" + " ".repeat(inner) + "┃";

        System.out.println("\n\n" + top);
        System.out.println(empty);
        System.out.println(centeredRow("¡Has perdido!", inner));
        System.out.println(empty);
        System.out.println(centeredRow(wordLine, inner));
        System.out.println(empty);
        System.out.println(bottom + "\n");
        System.out.println("Presione enter para continuar.");
        imputUser.nextLine();
    }

    private String centeredRow(String text, int width) {
        int padding = (width - text.length()) / 2;
        return "┃"
                + " ".repeat(Math.max(0, padding))
                + text
                + " ".repeat(Math.max(0, width - padding - text.length()))
                + "┃";
    }

    /**
     * Shows the Basketball banner.
     */
    public void showBasketballBanner() {
        utils.cleanScreem();
        
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                                                                                                                    ┃");
        System.out.println("┃ ━━━━━━                             ┃      ╱                   ┃      ┃                          ━          ━       ┃");
        System.out.println("┃┃      ╲                            ┃     ╱                    ┃      ┃                           ┃          ┃      ┃");
        System.out.println("┃┃       ┃                           ┃    ╱                  ━━━┃━━━━  ┃                           ┃          ┃      ┃");
        System.out.println("┃┃━━━━━━╱     ━━━━━━━━    ━━━━━━━━   ┃━━━━╲       ━━━━━━━━      ┃      ┃━━━━━━━━    ━━━━━━━━       ┃          ┃      ┃");
        System.out.println("┃┃       ╲   ┃        ┃  ┃           ┃     ╲     ┃        ┃     ┃      ┃        ┃  ┃        ┃      ┃          ┃      ┃");
        System.out.println("┃┃        ┃  ┃        ┃  ┃━━━━━━━━   ┃      ╲    ┃        ┃     ┃      ┃        ┃  ┃        ┃      ┃          ┃      ┃");
        System.out.println("┃┃        ┃  ┃        ┃           ┃  ┃       ╲   ┃━━━━━━━━      ┃      ┃        ┃  ┃        ┃      ┃          ┃      ┃");
        System.out.println("┃┃       ╱   ┃        ┃           ┃  ┃        ╲  ┃        ╻     ┃      ┃        ┃  ┃        ┃      ┃          ┃      ┃");
        System.out.println("┃ ━━━━━━━     ━━━━━━━━ ╲_ ━━━━━━━━   ┃         ╲  ━━━━━━━━       ━━━━   ━━━━━━━━    ━━━━━━━━ ╲_ `━━━━━━━━  `━━━━━━━━ ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

    }

    /**
     * Shows the Basketball menu.
     */
    public void showBasketballMenu() {
        System.out.println(BASKETBALL_FRAME);
        System.out.println(basketballRow("1. Instrucciones"));
        System.out.println(basketballRow("2. Jugar"));
        System.out.println(basketballRow("3. Regresar"));
        System.out.println(BASKETBALL_FRAME.replace('┏', '┗').replace('┓', '┛') + "\n");
    }

    /**
     * Shows Basketball instructions.
     */
    public void showBasketballInstructions() {
        utils.cleanScreem();
        System.out.println(BASKETBALL_FRAME);
        System.out.println(basketballRow("Instrucciones:"));
        System.out.println(basketballRow("- Cada ronda tiene dos posesiones, una por jugador."));
        System.out.println(basketballRow("- El atacante elige el tiro (2 o 3 puntos)."));
        System.out.println(basketballRow("- El defensor elige la defensa (estándar o agresiva)."));
        System.out.println(basketballRow("- La defensa agresiva aumenta los bloqueos, pero puede generar faltas."));
        System.out.println(basketballRow("- Si hay falta, se lanzan 2 tiros libres."));
        System.out.println(BASKETBALL_FRAME.replace('┏', '┗').replace('┓', '┛') + "\n");
        System.out.println("Presione enter para continuar.");
    }

    /**
     * Shows a generic Basketball prompt.
     *
     * @param message message to display
     */
    public void showBasketballInputPrompt(String message) {
        utils.cleanScreem();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ " + message); 
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
    }

    /**
     * Shows the current round number.
     *
     * @param round current round
     * @param totalRounds total rounds
     */
    public void showBasketballRound(int round, int totalRounds) {
        utils.cleanScreem();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                               RONDA " + round + " DE " + totalRounds + "                               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
    }

    /**
     * Shows the action menu for the attacking player.
     *
     * @param player player name
     */
    public void showBasketballActionMenu(String player) {
        System.out.println(BASKETBALL_FRAME);
        System.out.println(basketballRow("Turno de " + player + " - Elija el lanzamiento:"));
        System.out.println(basketballRow("1. Tiro de 3 puntos"));
        System.out.println(basketballRow("2. Tiro de 2 puntos"));
        System.out.println(BASKETBALL_FRAME.replace('┏', '┗').replace('┓', '┛'));
    }

    /**
     * Shows the defense menu for the defending player.
     *
     * @param player player name
     */
    public void showBasketballDefenseMenu(String player) {
        System.out.println(BASKETBALL_FRAME);
        System.out.println(basketballRow("Defensa de " + player + " - Elija la defensa:"));
        System.out.println(basketballRow("1. Defensa estándar"));
        System.out.println(basketballRow("2. Defensa agresiva"));
        System.out.println(BASKETBALL_FRAME.replace('┏', '┗').replace('┓', '┛'));
    }

    /**
     * Formats a basketball menu row using the banner width.
     *
     * @param text row content
     * @return formatted row with borders
     */
    private String basketballRow(String text) {
        String trimmed = text == null ? "" : text;
        if (trimmed.length() > BASKETBALL_INNER_WIDTH) {
            trimmed = trimmed.substring(0, BASKETBALL_INNER_WIDTH);
        }
        return "┃" + String.format("%-" + BASKETBALL_INNER_WIDTH + "s", trimmed) + "┃";
    }

    /**
     * Shows the Basketball scoreboard.
     *
     * @param playerOne first player name
     * @param scoreOne first player score
     * @param playerTwo second player name
     * @param scoreTwo second player score
     */
    public void showBasketballScoreboard(String playerOne, int scoreOne, String playerTwo, int scoreTwo) {
        System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                              MARCADOR ACTUAL                               ┃");
        System.out.println("┃ " + playerOne + ": " + scoreOne); 
        System.out.println("┃ " + playerTwo + ": " + scoreTwo); 
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
    }

    /**
     * Waits for the user to continue.
     *
     * @param inputUser scanner used for input
     */
    public void showBasketballContinue(Scanner inputUser) {
        System.out.println("Presione enter para continuar.");
        inputUser.nextLine();
    }

    /**
     * Shows a foul message.
     *
     * @param attacker attacker name
     * @param defender defender name
     */
    public void showBasketballFoul(String attacker, String defender) {
        System.out.println("\nFalta de " + defender + ". Tiros libres para " + attacker + ".");
    }

    /**
     * Shows a message for a made shot.
     *
     * @param attacker attacker name
     * @param points points scored
     */
    public void showBasketballShotMade(String attacker, int points) {
        System.out.println("\n" + attacker + " anota " + points + " puntos.");
    }

    /**
     * Shows a message for a missed shot.
     *
     * @param attacker attacker name
     */
    public void showBasketballShotMissed(String attacker) {
        System.out.println("\n" + attacker + " falla el tiro.");
    }

    /**
     * Shows the free throw result.
     *
     * @param player player name
     * @param points points scored
     */
    public void showBasketballFreeThrowResult(String player, int points) {
        System.out.println(player + " anota " + points + " puntos desde la línea de libres.");
    }

    /**
     * Shows the Basketball match result.
     *
     * @param playerOne first player name
     * @param scoreOne first player score
     * @param playerTwo second player name
     * @param scoreTwo second player score
     * @param imputUser scanner used for input
     */
    public void showBasketballWinner(String playerOne, int scoreOne, String playerTwo, int scoreTwo, Scanner imputUser) {
        utils.cleanScreem();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        if (scoreOne == scoreTwo) {
            System.out.println("┃                                   EMPATE                                   ┃");
            System.out.println("┃ " + playerOne + " " + scoreOne + " - " + scoreTwo + " " + playerTwo + "                              ┃");
        } else if (scoreOne > scoreTwo) {
            System.out.println("┃                                  GANADOR                                   ┃");
            System.out.println("┃ " + playerOne + " con " + scoreOne + " puntos                               ┃");
        } else {
            System.out.println("┃                                  GANADOR                                   ┃");
            System.out.println("┃ " + playerTwo + " con " + scoreTwo + " puntos                               ┃");
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println("Presione enter para continuar.");
        imputUser.nextLine();
    }

    /**
     * Shows the 2048 banner.
     */
    public void show2048Banner() {
        utils.cleanScreem();
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        System.out.println("┃    ━━━━━━━━━━     ━━━━━━━━━━    ┃          ┃    ━━━━━━━━━━    ┃");
        System.out.println("┃              ┃   ┃          ┃   ┃          ┃   ┃          ┃   ┃");
        System.out.println("┃              ┃   ┃          ┃   ┃          ┃   ┃          ┃   ┃");
        System.out.println("┃              ┃   ┃          ┃   ┃          ┃   ┃          ┃   ┃");
        System.out.println("┃    ━━━━━━━━━━    ┃          ┃    ━━━━━━━━━━     ━━━━━━━━━━    ┃");
        System.out.println("┃   ┃              ┃          ┃              ┃   ┃          ┃   ┃");
        System.out.println("┃   ┃              ┃          ┃              ┃   ┃          ┃   ┃");
        System.out.println("┃   ┃              ┃          ┃              ┃   ┃          ┃   ┃");
        System.out.println("┃    ━━━━━━━━━━     ━━━━━━━━━━               ┃    ━━━━━━━━━━    ┃");
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");

    }

    /**
     * Shows the 2048 menu.
     */
    public void show2048Menu() {
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        System.out.println("┃                       1. Instrucciones                       ┃");
        System.out.println("┃                       2. Jugar                               ┃");
        System.out.println("┃                       3. Regresar                            ┃");
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");
    }

    /**
     * Shows 2048 instructions.
     */
    public void show2048Instructions() {
        utils.cleanScreem();
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        System.out.println("┃ Instrucciones:                                               ┃");
        System.out.println("┃ - Usa W/A/S/D para mover las fichas.                         ┃");
        System.out.println("┃ - Las fichas iguales se fusionan al chocar.                  ┃");
        System.out.println("┃ - Llega a 2048 para ganar.                                   ┃");
        System.out.println("┃ - Si no hay movimientos disponibles, pierdes.                ┃");
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");
        System.out.println("Presione enter para continuar.");
    }

    /**
     * Shows the 2048 movement menu.
     */
    public void show2048MoveMenu() {
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        System.out.println("┃                          w:Arriba                            ┃");
        System.out.println("┃                          a:Izquierda                         ┃");
        System.out.println("┃                          s:Abajo                             ┃");
        System.out.println("┃                          d:Derecha                           ┃");
        System.out.println("┃                          0:Salir                             ┃");
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");
    }

    /**
     * Shows the 2048 board.
     *
     * @param board current board
     */
    public void show2048Board(int[][] board) {
        utils.cleanScreem();
        String top = "═════━━━━━━━━━━━━━━━━━━━━━━═══2048═══━━━━━━━━━━━━━━━━━━━━━━━═════";
        String bottom = "═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════";
        int inner = top.length() - 2;

        System.out.println(top);
        for (int[] boardRow : board) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int col = 0; col < boardRow.length; col++) {
                int value = boardRow[col];
                String display = value == 0 ? "" : String.valueOf(value);
                rowBuilder.append(color2048(value))
                        .append(String.format("%-9s", display))
                        .append("\u001B[0m");
            }

            String rawRow = rowBuilder.toString();
            String visibleRow = rawRow.replaceAll("\u001B\\[[;\\d]*m", "");
            int padding = Math.max(0, inner - visibleRow.length());

            System.out.println("┃" + rawRow + " ".repeat(padding) + "┃");
        }
        System.out.println(bottom + "\n");
    }

    /**
     * Shows the 2048 victory message.
     *
     * @param imputUser scanner used for input
     */
    public void show2048Win(Scanner imputUser) {
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        System.out.println("┃                   ¡Felicidades! Has ganado                  ┃");
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");
        System.out.println("Presione enter para continuar.");
        imputUser.nextLine();
    }

    /**
     * Shows the 2048 defeat message.
     *
     * @param imputUser scanner used for input
     */
    public void show2048Lose(Scanner imputUser) {
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        System.out.println("┃                   ¡Que lastima! Has perdido                 ┃");
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");
        System.out.println("Presione enter para continuar.");
        imputUser.nextLine();
    }

    /**
     * Shows an invalid movement message.
     *
     * @param imputUser scanner used for input
     */
    public void show2048InvalidMove(Scanner imputUser) {
        System.out.println("Movimiento inválido. Presione enter para continuar.");
        imputUser.nextLine();
    }

    /**
     * Returns the ANSI color for a given 2048 value.
     *
     * @param value tile value
     * @return ANSI color code
     */
    private String color2048(int value) {
        return switch (value) {
            case 2 -> "\u001B[41m";
            case 4 -> "\u001B[42m";
            case 8 -> "\u001B[43m";
            case 16 -> "\u001B[44m";
            case 32 -> "\u001B[45m";
            case 64 -> "\u001B[46m";
            case 128 -> "\u001B[47m";
            case 256 -> "\u001B[41m";
            case 512 -> "\u001B[42m";
            case 1024 -> "\u001B[43m";
            case 2048 -> "\u001B[44m";
            default -> "\u001B[0m";
        };
    }

    /**
     * Shows the statistics menu.
     */
    public void showStatsMenu() {
        utils.cleanScreem();
        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("┃            1. Estadisticas (WORDLE)             ┃");
        System.out.println("┃            2. Estadisticas (BASKETBALL)         ┃");
        System.out.println("┃            3. Estadisticas (2048)               ┃");
        System.out.println("┃            0. Regresar                          ┃");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n");
    }

    /**
     * Shows Wordle statistics.
     *
     * @param started games started
     * @param attempts attempts made
     * @param wins wins
     * @param losses losses
     */
    public void showWordleStats(int started, int attempts, int wins, int losses) {
        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("┃ Wordle iniciado: " + started + " veces                       ┃");
        System.out.println("┃ Intentos realizados: " + attempts + "                       ┃");
        System.out.println("┃ Victorias: " + wins + "                                     ┃");
        System.out.println("┃ Derrotas: " + losses + "                                     ┃");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n");
    }

    /**
     * Shows Basketball statistics.
     *
     * @param started games started
     */
    public void showBasketballStats(int started) {
        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("┃ Basketball iniciado: " + started + " veces                 ┃");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n");
    }

    /**
     * Shows 2048 statistics.
     *
     * @param started games started
     * @param wins wins
     * @param exits exits without finishing
     */
    public void show2048Stats(int started, int wins, int exits) {
        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("┃ 2048 iniciado: " + started + " veces                       ┃");
        System.out.println("┃ Victorias: " + wins + "                                     ┃");
        System.out.println("┃ Salidas sin terminar: " + exits + "                        ┃");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n");
    }

}

