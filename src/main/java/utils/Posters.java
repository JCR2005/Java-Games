package utils;

import java.util.Scanner;

public class Posters {

    private final Utils utils = new Utils();

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

        for (int idx = 0; idx < historyWords.length; idx++) {

            StringBuilder row = new StringBuilder();

            for (int jdx = 0; jdx < historyWords[idx].length; jdx++) {

                if (historyWords[idx][jdx] != null) {
                    row.append(historyWords[idx][jdx]).append(" ");
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
}
