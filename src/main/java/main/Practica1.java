package main;

/**
 *
 * @author carlosrodriguez
 */


import java.util.Random;
import java.util.Scanner;

public class Practica1 {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    // Variables "Globales de registro"
    private static int registro_viWordle;//Variable de registro de vese iniciado el juego Wordle
    private static int registro_vpWordle;//Variable registro veces perdido Wordle
    private static int registro_viapWordle;//Variable registro veces intentado adivinar una palabra Wordle
    private static int registro_viBasketball;//Variable de registro de veces iniciado el juego Basketball
    private static int registro_vi2048;//Variable de registro de veces iniciado el juego 2048
    private static int registro_sdjst2048;// Variable de registro de salida del jueg sin terminar 2048
    private static int registro_vg2048;//Variable registro veces ganado 2048


    //Metodos para establecer los distintos registro
    private static void registroVeseIniciadoBasketball() {
        registro_viBasketball++;
    }

    private static void registroSalidoSinTerminar2048() {
        registro_sdjst2048++;
    }

    private static void registroVeseIniciado2048() {
        registro_vi2048++;
    }

    private static void registroVeseGandodo2048() {
        registro_vg2048++;
    }

    private static void agregarUnInicioWordleAContador() {
        registro_viWordle++;
    }

    private static void registroVesesPerdidoWordle() {
        registro_vpWordle++;
    }

    private static void registroVesesIntetoAdivarPalabra() {
        registro_viapWordle++;
    }

    /**
     * Metodo main
     *
     * @param args
     */
    public static void main(String[] args) {

        do {
            //munu inicial
            mostrarMenuInicial();

            //entrada del usuario 
            String opcion = entradaTeclado.nextLine();
            switch (opcion) {

                //Este caso lleva a una seleecion aleatoria de uno de los tres juegos
                case "1" -> {
                    selecciónAleatoria();
                }

                //Este caso lleva a el menu principal
                case "2" -> {
                    Menu();
                    return;
                }

                //Este caso cierra el programa
                case "3" -> {
                    return;
                }

                default -> {
                    mostrarMensajeDeAdvertenciaMenu();
                }
            }
            //
            //Dirige al usuario al menu principal
        } while (true);

    }

    /**
     * Este metodo mustra un mensaje de advertencia
     *
     */
    public static void mostrarMensajeDeAdvertenciaMenu() {
        limpiarPantalla();
        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("       Por favor, ingresar un valor valido!.");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛");
        System.out.println(" Presione enter para continuar.");
        entradaTeclado.nextLine();
    }

    /**
     * Metodo que da un borron o salto de 50 lineas
     *
     */
    public static void limpiarPantalla() {

        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }

    }

    /**
     * Metodo que muestra mensaje de bienbenida.
     *
     */
    /**
     * Metodo que muestra el menu de unicio.
     *
     */
    public static void mostrarMenuInicial() {

        limpiarPantalla();
        System.out.println("┏══━━━━━━━━━━━━━━━━JavaMiniGames━━━━━━━━━━━━━━━══┓");
        System.out.println("║                                                ║");
        System.out.println("┃          1. Iniciar un juego aleatorio         ┃");
        System.out.println("┃          2. Yo quero elegir el juego           ┃");
        System.out.println("┃          3. Cerra                              ┃");
        System.out.println("║                                                ║");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n\n");

    }

    /**
     * Este metodo hace una seleecion aleatoria de uno de los tres juegos
     *
     */
    public static void selecciónAleatoria() {

        Random ram = new Random();

        int opcion = ram.nextInt(3) + 1;      //variables que almacena el valor que ingresa el usuario

        switch (opcion) {

            //Este caos dirige al usuario al juego uno
            case 1 ->
                Wordle();

            //Este caos dirige al usuario al juego dos
            case 2 ->
                Basketball();

            //Este caos dirige al usuario al juego tres
            case 3 ->
                juegoTres();

            default ->
                throw new AssertionError();
        }
    }

    /**
     * Este metodo mostrara las opciones que tiene el meni principal
     */
    public static void mostrarOpcionesMenuPrincipal() {
        limpiarPantalla();
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
     * Este metodo ejecutara el menu principal donde el usuairo podra elegir
     * cualquier juego
     */
    public static void Menu() {

        String opcion;  //variables que almacena el valor que ingresa el uasrio  

        do {
            mostrarOpcionesMenuPrincipal();
            opcion = entradaTeclado.nextLine();
            switch (opcion) {
                case "1" -> Wordle();
                case "2" -> Basketball();
                case "3" -> juegoTres();
                case "4" -> estadisticas_de_juego();
                case "0" -> {
                    return;
                }

                default -> mostrarMensajeDeAdvertenciaMenu();
            }
        } while (true);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //Metodo donde se muetra los registro de los juegos
    public static void estadisticas_de_juego() {

        Scanner entrada = new Scanner(System.in);

        //Variables que almacenar las opciones que el jugador selecciona
        String opciont;
        int opcion = 0;

        System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
        System.out.println("┃            1.Estadisticas(WORDLE)               ┃");
        System.out.println("┃                                                 ┃");
        System.out.println("┃            2.Estadisticas(BASKETBALL)           ┃");
        System.out.println("┃                                                 ┃");
        System.out.println("┃            3.Estadisticas(2048)                 ┃");
        System.out.println("┃                                                 ┃");
        System.out.println("┃            0.Salir                              ┃");
        System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n\n");

        while (true) {

            opciont = entrada.nextLine();

            if ("1".equals(opciont) || "2".equals(opciont) || "3".equals(opciont)) {

                opcion = Integer.parseInt(opciont);
                break;
            } else {
                System.out.println("┃             Ingrese un valor valido             ┃\n\n");

            }

        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        switch (opcion) {

            //regresa la menu
            case 0:
                Menu();
                break;

            case 3://Muestra registro de juego 2048
                System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
                System.out.println("┃                                                 ┃");
                System.out.println("┃Se ha iniciado el juego " + registro_vi2048 + " veces                  ┃");
                System.out.println("┃                                                 ┃");
                System.out.println("┃Han salido sin finalizar el juego:" + registro_sdjst2048 + " veces        ┃");
                System.out.println("┃                                                 ┃");
                System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n\n");
                System.out.println("┃     introduzca el numero 0, para continuar      ┃\n\n");

                do {
                    opciont = entrada.nextLine();

                    if ("0".equals(opciont)) {

                        opcion = Integer.parseInt(opciont);

                    } else {

                        System.out.println("┃            Ingrese un valor valido!            ┃\n\n");

                    }

                } while (opcion != 0);

                break;

            case 2://Muestra registros de juego Basketball
                System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
                System.out.println("┃                                                 ┃");
                System.out.println("┃Se ha iniciado el juego " + registro_viBasketball + " veces                  ┃");
                System.out.println("┃                                                 ┃");
                System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n\n");
                System.out.println("┃     introduzca el numero 0, para continuar      ┃\n\n");
                do {
                    opciont = entrada.nextLine();

                    if ("0".equals(opciont)) {

                        opcion = Integer.parseInt(opciont);

                    } else {

                        System.out.println("┃            Ingrese un valor valido!            ┃\n\n");

                    }

                } while (opcion != 0);
                break;

            case 1://Muestra registro de juego Wordle
                System.out.println("┏══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┓");
                System.out.println("┃                                                 ┃");
                System.out.println("┃Se ha iniciado el juego " + registro_viWordle + " veces                  ┃");
                System.out.println("┃                                                 ┃");
                System.out.println("┃Se ha intentado adivinar una palabra : " + registro_viapWordle + " veces   ┃");
                System.out.println("┃                                                 ┃");
                System.out.println("┃Se ha intentado adivinar una palabra : " + registro_vpWordle + " veces   ┃");
                System.out.println("┃                                                 ┃");
                System.out.println("┗══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━══┛\n\n");
                System.out.println("┃     introduzca el numero 0, para continuar      ┃\n\n");
                do {
                    opciont = entrada.nextLine();

                    if ("0".equals(opciont)) {

                        opcion = Integer.parseInt(opciont);

                    } else {

                        System.out.println("┃            Ingrese un valor valido!            ┃\n\n");

                    }

                } while (opcion != 0);
                break;
        }

    }

    ///////////////////////////////////////////////////////////////////////WORDLE/////////////////////////////////////////////////////////////////////////
    
    /**
     * Este metodo se encarga de ejecutar el primer juego 
     * Wordle
     */
    public static void Wordle() {

        agregarUnInicioWordleAContador();

        //variables que almacenan colores, para indetificar caracteristicas de la palabra a encontrar
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        String rojo = "\033[31m";
        String b = "\u001B[0m";

        int opcion = 0;

        Scanner entrada = new Scanner(System.in);

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

        //Menu del juego Wordle
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                                                                            ┃");
        System.out.println("┃                               1.Instrucciones                              ┃");
        System.out.println("┃                               2.Jugar                                      ┃");
        System.out.println("┃                               3.Regresar                                   ┃");
        System.out.println("┃                                                                            ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        do {
            //recile la opcion del usuario y valida que se un valor valido
            String opciont = entrada.nextLine();

            if ("1".equals(opciont) || "2".equals(opciont) || "3".equals(opciont)) {

                opcion = Integer.parseInt(opciont);

            } else {

                System.out.println("┃                           Ingrese un valor valido                          ┃");
            }

            //instrucciones
            if (opcion == 1) {

            }

            //inicia el juego
            if (opcion == 2) {

                //arreglo que contendra la palabra original
                String[] palabraOriginal = new String[5];

                //arreglo que contendra la palabra que el usuario ingrese
                String[] palabraPrueba = new String[5];

                //arreglo contendra el historial de cada
                //palabra que ingrese el usuario
                String Historial[][] = new String[6][5];

                //aqui se almacenara la palabra original
                String palabra;

                Scanner ingreso = new Scanner(System.in);

                do {
                    do {
                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("┃                          Ingrese palabra a ocultar                         ┃");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                        //recibe la palabra que se buscara
                        palabra = ingreso.nextLine();
                        if (palabra.length() == 5) {
                            //cada letra de la palabra ingresada se
                            //almacena en este array si y silo tiene 5 letras
                            palabraOriginal = palabra.split("");

                        } else {

                            System.out.println("┃                      Ingrese una palabra de 5 letras!!!!                   ┃");

                        }

                    } while (palabra.length() != 5);

                    //se verifica si la palabra se escribio correctamente
                    // y permite al usurio editarla
                    System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃                                                                            ┃");
                    System.out.println("┃                            La plabra oculta es                             ┃");
                    System.out.println("┃                                                                            ┃");
                    System.out.println("┃                                   " + palabraOriginal[0] + palabraOriginal[1] + palabraOriginal[2] + palabraOriginal[3] + palabraOriginal[4] + "                                    ┃");
                    System.out.println("┃                                                                            ┃");
                    System.out.println("┃                                                                            ┃");
                    System.out.println("┃                           1.Guardar y continuar                            ┃");
                    System.out.println("┃                           2.Editar                                         ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                    opciont = entrada.nextLine();

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                    if ("1".equals(opciont) || "2".equals(opciont)) {

                        opcion = Integer.parseInt(opciont);

                    } else {

                        System.out.println("┃                           Ingrese un valor valido                          ┃");

                    }

                } while (opcion != 1);

                //aqui se inicializa la matriz que contendra 
                //el historial de palabras ingresadas por el usuario
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 5; j++) {

                        Historial[i][j] = "";
                    }
                    System.out.println(" ");
                }

                int q = 0; //contador para la matriz historial

                boolean d = false; //verificador para saber si perdio o gano el jugador

                boolean w = false; //verificador para saber si el jugador gano

                String color1 = ""; //Estado de la primera letra
                String color2 = ""; //Estado de la segunda letra
                String color3 = ""; //Estado de la tercera letra
                String color4 = ""; //Estado de la cuarta letra
                String color5 = ""; //Estado de la quinta letra

                do {

                    registroVesesIntetoAdivarPalabra();
                    //verificadores para comprobar que todas
                    //las letras esten en el lugar correcto
                    // e indicar que el jugador gano

                    int var1 = 0; //Verifica que la pocision de la primera letra se correcta
                    int var2 = 0; //Verifica que la pocision de la segunda letra se correcta
                    int var3 = 0; //Verifica que la pocision de la tercera letra se correcta
                    int var4 = 0; //Verifica que la pocision de la cuarta letra se correcta
                    int var5 = 0; //Verifica que la pocision de la quinta letra se correcta

                    System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃                               Intento No." + (q + 1) + "                                 ┃");
                    System.out.println("┃                                                                            ┃");
                    System.out.println("┃                            ingrese una palabra                             ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                    switch (q) {
                        case 1 -> {
                            Historial[0][0] = "                                   " + color1 + palabraPrueba[0];
                            Historial[0][1] = color2 + palabraPrueba[1];
                            Historial[0][2] = color3 + palabraPrueba[2];
                            Historial[0][3] = color4 + palabraPrueba[3];
                            Historial[0][4] = color5 + palabraPrueba[4] + b;
                        }
                        case 2 -> {
                            Historial[1][0] = "                                   " + color1 + palabraPrueba[0];
                            Historial[1][1] = color2 + palabraPrueba[1];
                            Historial[1][2] = color3 + palabraPrueba[2];
                            Historial[1][3] = color4 + palabraPrueba[3];
                            Historial[1][4] = color5 + palabraPrueba[4] + b;
                        }
                        case 3 -> {
                            Historial[2][0] = "                                   " + color1 + palabraPrueba[0];
                            Historial[2][1] = color2 + palabraPrueba[1];
                            Historial[2][2] = color3 + palabraPrueba[2];
                            Historial[2][3] = color4 + palabraPrueba[3];
                            Historial[2][4] = color5 + palabraPrueba[4] + b;
                        }
                        case 4 -> {
                            Historial[3][0] = "                                   " + color1 + palabraPrueba[0];
                            Historial[3][1] = color2 + palabraPrueba[1];
                            Historial[3][2] = color3 + palabraPrueba[2];
                            Historial[3][3] = color4 + palabraPrueba[3];
                            Historial[3][4] = color5 + palabraPrueba[4] + b;
                        }
                        case 5 -> {
                            Historial[4][0] = "                                   " + color1 + palabraPrueba[0];
                            Historial[4][1] = color2 + palabraPrueba[1];
                            Historial[4][2] = color3 + palabraPrueba[2];
                            Historial[4][3] = color4 + palabraPrueba[3];
                            Historial[4][4] = color5 + palabraPrueba[4] + b;
                        }
                    }

                    q += 1;

                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 5; j++) {

                            System.out.print(Historial[i][j]);

                        }

                        System.out.println("");
                    }

                    do {
                        palabra = ingreso.nextLine();

                        if (palabra.length() == 5) {
                            //cada letra de la palabraPrueba ingresada se
                            //almacena en este array si y silo tiene 5 letras
                            palabraPrueba = palabra.split("");
                        } else {
                            System.out.println("┃                      Ingrese una palabra de 5 letras!!!!                   ┃");

                        }
                    } while (palabra.length() != 5);

                    if (palabraPrueba[0].equals(palabraOriginal[0])) {

                        var1 = 1;

                        System.out.println("\n\n┃                                                                            ┃");
                        System.out.print("                                    " + verde + palabraPrueba[0] + b);

                        color1 = verde;

                    } else if (palabraPrueba[0].equals(palabraOriginal[1]) || palabraPrueba[0].equals(palabraOriginal[2]) || palabraPrueba[0].equals(palabraOriginal[3]) || palabraPrueba[0].equals(palabraOriginal[4])) {

                        System.out.println("\n\n┃                                                                            ┃");
                        System.out.print("                                   " + amarillo + palabraPrueba[0] + b);

                        color1 = amarillo;

                    } else {

                        System.out.println("\n\n┃                                                                            ┃");
                        System.out.print("                                   " + rojo + palabraPrueba[0] + b);
                        color1 = rojo;

                    }

                    if (palabraPrueba[1].equals(palabraOriginal[1])) {

                        System.out.print(verde + palabraPrueba[1] + b);

                        var2 = 1;

                        color2 = verde;

                    } else if (palabraPrueba[1].equals(palabraOriginal[0]) || palabraPrueba[1].equals(palabraOriginal[2]) || palabraPrueba[1].equals(palabraOriginal[3]) || palabraPrueba[1].equals(palabraOriginal[4])) {

                        System.out.print(amarillo + palabraPrueba[1] + b);

                        color2 = amarillo;

                    } else {

                        System.out.print(rojo + palabraPrueba[1] + b);

                        color2 = rojo;

                    }

                    if (palabraPrueba[2].equals(palabraOriginal[2])) {

                        System.out.print(verde + palabraPrueba[2] + b);
                        var3 = 1;
                        color3 = verde;
                    } else if (palabraPrueba[2].equals(palabraOriginal[0]) || palabraPrueba[2].equals(palabraOriginal[1]) || palabraPrueba[2].equals(palabraOriginal[3]) || palabraPrueba[2].equals(palabraOriginal[4])) {

                        System.out.print(amarillo + palabraPrueba[2] + b);
                        color3 = amarillo;
                    } else {

                        System.out.print(rojo + palabraPrueba[2] + b);
                        color3 = rojo;
                    }

                    if (palabraPrueba[3].equals(palabraOriginal[3])) {

                        System.out.print(verde + palabraPrueba[3] + b);
                        var4 = 1;
                        color4 = verde;
                    } else if (palabraPrueba[3].equals(palabraOriginal[0]) || palabraPrueba[3].equals(palabraOriginal[1]) || palabraPrueba[3].equals(palabraOriginal[2]) || palabraPrueba[3].equals(palabraOriginal[4])) {

                        System.out.print(amarillo + palabraPrueba[3] + b);
                        color4 = amarillo;
                    } else {

                        System.out.print(rojo + palabraPrueba[3] + b);
                        color4 = rojo;
                    }

                    if (palabraPrueba[4].equals(palabraOriginal[4])) {
                        System.out.println(verde + palabraPrueba[4] + b);
                        System.out.println("┃                                                                            ┃");
                        var5 = 1;
                        color5 = verde;

                    } else if (palabraPrueba[4].equals(palabraOriginal[0]) || palabraPrueba[4].equals(palabraOriginal[1]) || palabraPrueba[4].equals(palabraOriginal[2]) || palabraPrueba[4].equals(palabraOriginal[3])) {

                        System.out.println(amarillo + palabraPrueba[4] + b);
                        System.out.println("┃                                                                            ┃");
                        color5 = amarillo;
                    } else {

                        System.out.println(rojo + palabraPrueba[4] + b);
                        System.out.println("┃                                                                            ┃");
                        color4 = rojo;
                    }

                    System.out.println("\n\n");

                    if (var1 == 1 && var2 == 1 && var3 == 1 && var4 == 1 && var5 == 1) {

                        d = true;
                        w = true;

                    } else if (q == 6) {

                        d = true;

                    }

                } while ((d != true));

                if (q == 6 && w != true) {//Evalua si el jugador perdio

                    registroVesesPerdidoWordle();

                    System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃                            Que lastima perdiste                            ┃");
                    System.out.println("┃                                                                            ┃");
                    System.out.println("┃                           La palabra era  " + palabraOriginal[0] + palabraOriginal[1] + palabraOriginal[2] + palabraOriginal[3] + palabraOriginal[4] + "                            ┃");
                    System.out.println("┃                                                                            ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                } else if (d == true) {//Evalua si el jugador gano

                    System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃                                Ganasteee!!!!                               ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                }
                System.out.println("┃                     introduzca el numero 0, para continuar                 ┃\n\n");

                do {
                    opciont = entrada.nextLine();

                    if ("0".equals(opciont)) {

                        opcion = Integer.parseInt(opciont);

                    } else {

                        System.out.println("┃                           Ingrese un valor valido                          ┃");
                    }

                } while (opcion != 0);

            }

        } while (opcion != 3);
        Menu();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo motor del juego Basketball
    public static void Basketball() {

        registroVeseIniciadoBasketball();

        Scanner entrada = new Scanner(System.in);
        Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);

        //Variables que almacenan las opciones que el jugador decide
        int opcion = 0;
        String opciont;

        int rondas;//contado de rondas

        boolean turno = false;// ayuda a cambiar de turno

        String nombrejugador1; //Variable que almacena el nombre del jugador1
        String nombrejugador2; //Variable que almacena el nombre del jugador2

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

        do {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                                                                                                                    ┃");
            System.out.println("┃                                                  1.Instrucciones                                                   ┃");
            System.out.println("┃                                                  2.Jugar                                                           ┃");
            System.out.println("┃                                                  3.Regresar                                                        ┃");
            System.out.println("┃                                                                                                                    ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
            System.out.println("\n\n┃                                              Ingrese un valor valido                                               ┃\n");
            while (true) {

                opciont = entrada.nextLine();

                if ("1".equals(opciont) || "2".equals(opciont)) {

                    opcion = Integer.parseInt(opciont);
                    break;

                } else {

                    System.out.println("\n\n┃                                              Ingrese un valor valido                                               ┃\n");
                }

            }

            switch (opcion) {

                case 1: {

                }

                case 2: {
                    //Aqui se ingresa el nombre del jugador 1 
                    do {

                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("|                                           Ingrese nombre del jugador 1                                             |");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                        while (true) {

                            nombrejugador1 = entrada2.nextLine();

                            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.println("                                                  Tu nombre es: " + nombrejugador1);
                            System.out.println("|                                                                                                                    |");
                            System.out.println("|                                                 1.Guardar y continuar                                              |");
                            System.out.println("|                                                 2.Editar                                                           |");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                            System.out.println("");

                            opciont = entrada.nextLine();

                            if ("1".equals(opciont) || "2".equals(opciont)) {

                                opcion = Integer.parseInt(opciont);
                                break;

                            } else {

                                System.out.println("\n\n┃                                              Ingrese un valor valido                                               ┃\n");

                            }

                        }

                    } while (opcion == 2);

                    //Aqui se ingresa el nombre del jugador 2 
                    do {

                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("|                                           Ingrese nombre del jugador 2                                             |");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                        System.out.println("");

                        while (true) {

                            nombrejugador2 = entrada2.nextLine();

                            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.println("                                                  Tu nombre es: " + nombrejugador2);
                            System.out.println("|                                                                                                                    |");
                            System.out.println("|                                                 1.Guardar y continuar                                              |");
                            System.out.println("|                                                 2.Editar                                                           |");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                            System.out.println("");

                            opciont = entrada.nextLine();
                            if ("1".equals(opciont) || "2".equals(opciont)) {

                                opcion = Integer.parseInt(opciont);
                                break;

                            } else {

                                System.out.println("\n\n┃                                              Ingrese un valor valido                                               ┃\n");

                            }

                        }

                    } while (opcion == 2);

                    //Aqui se pide el numero de rondas a jugar
                    do {

                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("|                                           Digite el numero de rondas a jugar                                       |");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                        while (true) {
                            rondas = entrada1.nextInt();

                            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.println("                                                  Rondas a jugar : " + rondas);
                            System.out.println("|                                                                                                                    |");
                            System.out.println("|                                                 1.Guardar y continuar                                              |");
                            System.out.println("|                                                 2.Editar                                                           |");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                            opciont = entrada.nextLine();

                            if ("1".equals(opciont) || "2".equals(opciont)) {

                                opcion = Integer.parseInt(opciont);
                                break;

                            } else {

                                System.out.println("\n\n┃                                              Ingrese un valor valido                                               ┃\n");

                            }

                        }

                    } while (opcion != 1);

                    //Aqui se define a quien le tocara el primer turno(es aleatorio
                    if (probabilidadDeAcciones() <= 50) {

                        turno = true;

                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("                                                  Empieazas tu " + nombrejugador1);
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                    } else if (probabilidadDeAcciones() <= 100) {

                        turno = false;

                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("                                                  Empieazas tu " + nombrejugador2);
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                    }

                    //Variables donde se almacenan los puntos de cada jugador
                    int puntosj1 = 0;
                    int puntosj2 = 0;

                    //variable que indica el numero de rondas jugadas
                    int ronda = 1;
                    for (int i = 0; i < rondas; i++) {

                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("                                              RONDA NUMERO " + ronda++ + " DEL JUEGO                                       ");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                        int opcionLanzamientoj1 = 0;
                        int opcionLanzamientoj2 = 0;
                        int opcionDefensaj1 = 0;
                        int opcionDefensaj2 = 0;
                        boolean ver1;

                        if (turno == true) {

                            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.println("                                                Es tu turno de: " + nombrejugador1);
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                            //Comienza jugador 1 y se muestran distintos menus donde el jugador podra elejir la accion
                            do {
                                ver1 = false;
                                MenuAccion();
                                opcion = entrada1.nextInt();

                                switch (opcion) {

                                    case 1:
                                        MenuLanzamiento();
                                        opcionLanzamientoj1 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    case 2:
                                        MenuDefensa();
                                        opcionDefensaj1 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    default:
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                        System.out.println("|                                               Digite un valor valido                                               |");
                                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                        System.out.println("");
                                        ver1 = false;
                                        break;
                                }

                            } while (ver1 != true);

                            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.println("                                                 Es tu turno : " + nombrejugador2);
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                            do {
                                ver1 = false;
                                MenuAccion();
                                opcion = entrada1.nextInt();

                                switch (opcion) {

                                    case 1:
                                        MenuLanzamiento();
                                        opcionLanzamientoj2 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    case 2:
                                        MenuDefensa();
                                        opcionDefensaj2 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    default:
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                        System.out.println("|                                               Digite un valor valido                                               |");
                                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                        System.out.println("");
                                        ver1 = false;
                                        break;
                                }

                            } while (ver1 != true);

                            //Comienza jugador 2 y se muestran distintos menus donde el jugador podra elejir la accion
                        } else if (turno == false) {

                            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.println("                                                 Es tu turno : " + nombrejugador2);
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                            do {
                                ver1 = false;
                                MenuAccion();
                                opcion = entrada1.nextInt();

                                switch (opcion) {

                                    case 1:
                                        MenuLanzamiento();
                                        opcionLanzamientoj2 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    case 2:
                                        MenuDefensa();
                                        opcionDefensaj2 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    default:
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                        System.out.println("|                                               Digite un valor valido                                               |");
                                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                        System.out.println("");
                                        ver1 = false;
                                        break;
                                }

                            } while (ver1 != true);

                            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.println("                                                 Es tu turno : " + nombrejugador1);
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                            do {
                                ver1 = false;
                                MenuAccion();
                                opcion = entrada1.nextInt();

                                switch (opcion) {

                                    case 1:
                                        MenuLanzamiento();
                                        opcionLanzamientoj1 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    case 2:
                                        MenuDefensa();
                                        opcionDefensaj1 = entrada1.nextInt();
                                        ver1 = true;
                                        break;

                                    default:
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                        System.out.println("|                                               Digite un valor valido                                               |");
                                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                        System.out.println("");
                                        ver1 = false;
                                        break;
                                }

                            } while (ver1 != true);

                        }

                        //Metodo que ejecutara todas las acciones, como lanzamientos, defensas y faltas, y asignara los puntos correspondientes
                        String e = EjecutarAcciones(opcionLanzamientoj1, opcionLanzamientoj2, opcionDefensaj1, opcionDefensaj2, nombrejugador1, nombrejugador2);

                        //variables donde se ara un cambo de cadea a int
                        String p1 = e.split(",")[0];
                        String p2 = e.split(",")[1];
                        String p3 = e.split(",")[2];
                        String p4 = e.split(",")[3];

                        //variables donde se almacenaran los puntajes
                        int pj1;
                        int pj2;
                        int pfj1;
                        int pfj2;

                        pj1 = Integer.parseInt(p1);
                        pj2 = Integer.parseInt(p2);
                        pfj1 = Integer.parseInt(p3);
                        pfj2 = Integer.parseInt(p4);

                        puntosj1 = puntosj1 + pj1 + pfj1;
                        puntosj2 = puntosj2 + pj2 + pfj2;

                        //Aqui se visualizaran cuantos puntos se acumulan en cada ronda de cada jugador
                        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("|                                                      PUNTOS                                                        |");
                        System.out.println("|Puntos jugador 1 :" + puntosj1);
                        System.out.println("|Puntos jugador 2 :" + puntosj2);
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                        //Aqui se hara el cambio de primer turno en cada ronda 
                        if (turno == true) {
                            turno = false;
                        } else if (turno == false) {
                            turno = true;
                        }

                    }

                    if (puntosj2 > puntosj1) {//Aqui se indica si el jugado 2 gano
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

                        System.out.println("                                  |━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                        System.out.println("                                  |                   GANASTE!!!!!!!               |");
                        System.out.println("                                  |                                                |");
                        System.out.println("                                                       " + nombrejugador2);
                        System.out.println("                                                       CON:" + puntosj2 + " puntos");
                        System.out.println("                                  |                                                |");
                        System.out.println("                                  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                    } else if (puntosj1 == puntosj2) {//Aqui se indica si el jugador 1 y el jugador 2 quedaron en empate
                        System.out.println("                                  |━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                        System.out.println("                                  |                   EMPATE!!!!!!!!!              |");
                        System.out.println("                                  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    } else {//Aqui se indica si el jugador 1 gano
                        System.out.println("                                  |━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
                        System.out.println("                                  |                   GANASTE!!!!!!!               |");
                        System.out.println("                                  |                                                |");
                        System.out.println("                                                       " + nombrejugador1);
                        System.out.println("                                                       CON:" + puntosj1 + " puntos");
                        System.out.println("                                  |                                                |");
                        System.out.println("                                  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    }

                    System.out.println("                                  ┃     introduzca el numero 0, para continuar     ┃\n\n");

                    do {
                        opciont = entrada.nextLine();

                        if ("0".equals(opciont)) {

                            opcion = Integer.parseInt(opciont);

                        } else {

                            System.out.println("                                  ┃            Ingrese un valor valido!            ┃");

                        }

                    } while (opcion != 0);
                    break;

                }

                case 3:
                    Menu();
                    break;

            }

        } while (opcion != 3);

        //temina el juego
    }

    ////Metodos para el funcionamiento de Basketball
    
    //Metodo para calcular las probabilidades de las acciones
    public static int probabilidadDeAcciones() {

        Random ram = new Random();
        int probabilidad = ram.nextInt(100) + 1;
        return probabilidad;

    }

    //menu para escojer lanzaminto o defensa
    public static void MenuAccion() {

        System.out.println("");
        System.out.println("");
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("|                                                                                                                    |");
        System.out.println("|                                             Elija la accion a realizar                                             |");
        System.out.println("|                                                                                                                    |");
        System.out.println("|                                                   1.Lanzamiento                                                    |");
        System.out.println("|                                                   2.Defensa                                                        |");
        System.out.println("|                                                                                                                    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println("");

    }

    //menu de lanzamiento
    public static void MenuLanzamiento() {

        System.out.println("");
        System.out.println("");
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("|                                                                                                                    |");
        System.out.println("|                                            Elija el lanzamiento a realizar                                         |");
        System.out.println("|                                                                                                                    |");
        System.out.println("|                                         1.Salto largo desde 5 metros(3 puntos)                                     |");
        System.out.println("|                                         2.Salto corto desde 3 metros(2 puntos)                                     |");
        System.out.println("|                                                                                                                    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println("");

    }

    //el menu de defensa
    public static void MenuDefensa() {

        System.out.println("");
        System.out.println("");
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("|                                                                                                                    |");
        System.out.println("|                                             Elije tu defensa a realizar                                            |");
        System.out.println("|                                                                                                                    |");
        System.out.println("|                                              1.Defensa cuerpo a cuerpo                                             |");
        System.out.println("|                                              2.Defensa fuerte                                                      |");
        System.out.println("|                                                                                                                    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println("");

    }

    //Este metodo se encarga de ejecutar todas las acciones de los jugadores y retornar sus puntaje respectivos
    public static String EjecutarAcciones(int opcionLanzamientoj1, int opcionLanzamientoj2, int opcionDefensaj1, int opcionDefensaj2, String nombrejugador1, String nombrejugador2) {

        String puntosj1 = "0";
        String puntosj2 = "0";
        String puntosfj1 = "0";
        String puntosfj2 = "0";

        String pts = "";

        int veriProbabilidad = 0;
        int veriProbabilidadFalta = 0;

        for (int i = 1; i <= 3; i++) {

            int j = i;

            if (pts == "") {

                pts = "3";
                veriProbabilidad = 65;
                veriProbabilidadFalta = 35;
            } else if (pts == "3") {
                pts = "2";
                veriProbabilidad = 80;
                veriProbabilidadFalta = 65;
            }

            //en cada if se verifica si los parametros ingresado, tinene valores los cuales
            //tienen una accion, depende de los parametros se ejecuta cada accion
            if ((opcionLanzamientoj1 == j) && (opcionLanzamientoj2 == 1)) {

                if (probabilidadDeAcciones() <= veriProbabilidad) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste " + pts + " puntos " + nombrejugador1);
                    puntosj1 = pts;
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador1);
                }

                if (probabilidadDeAcciones() <= 65) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste 3 puntos " + nombrejugador2);
                    puntosj2 = "3";
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador2);
                }

            } else if ((opcionLanzamientoj1 == j) && (opcionLanzamientoj2 == 2)) {

                if (probabilidadDeAcciones() <= veriProbabilidad) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste " + pts + " puntos " + nombrejugador1);
                    puntosj1 = pts;
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador1);
                }

                if (probabilidadDeAcciones() <= 80) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste 2 puntos " + nombrejugador2);
                    puntosj2 = "2";
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador2);
                }
            } else if ((opcionLanzamientoj1 == j) && (opcionDefensaj2 == 1)) {

                if (probabilidadDeAcciones() <= veriProbabilidad - 15) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste " + pts + " puntos " + nombrejugador1);
                    puntosj1 = pts;
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador1);
                }

                if (probabilidadDeAcciones() <= (35)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador2);
                    System.out.println("|Tiro Libre para " + nombrejugador1);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador1);
                        puntosfj1 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador1);
                    }
                }
            } else if ((opcionLanzamientoj1 == j) && (opcionDefensaj2 == 2)) {

                if (probabilidadDeAcciones() <= veriProbabilidad - 15) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste " + pts + " puntos " + nombrejugador1);
                    puntosj1 = pts;
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador1);
                }

                if (probabilidadDeAcciones() <= (35)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador2);
                    System.out.println("|Tiro Libre para " + nombrejugador1);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador1);
                        puntosfj1 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador1);
                    }
                }
            } else if ((opcionLanzamientoj1 == j) && (opcionDefensaj2 == 2)) {

                if (probabilidadDeAcciones() <= veriProbabilidad - 30) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste " + pts + " puntos " + nombrejugador1);
                    puntosj1 = pts;
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador1);
                }

                if (probabilidadDeAcciones() <= (65)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador2);
                    System.out.println("|Tiro Libre para " + nombrejugador1);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador1);
                        puntosfj1 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste " + nombrejugador1);
                    }
                }
            }
        }

        for (int i = 1; i <= 3; i++) {

            pts = "";

            int j = i;

            if (pts == "") {

                pts = "3";
                veriProbabilidad = 15;
                veriProbabilidadFalta = 35;
            } else if (pts == "3") {
                pts = "2";
                veriProbabilidad = 30;
                veriProbabilidadFalta = 65;
            }

            if ((opcionDefensaj1 == j) && (opcionLanzamientoj2 == 1)) {

                if (probabilidadDeAcciones() <= (65 - veriProbabilidad)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste 3 puntos " + nombrejugador2);
                    puntosj2 = "3";
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador2);
                }

                if (probabilidadDeAcciones() <= (veriProbabilidadFalta)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador1);
                    System.out.println("|Tiro Libre para " + nombrejugador2);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador2);
                        puntosfj2 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador2);
                    }
                }
            } else if ((opcionDefensaj1 == j) && (opcionLanzamientoj2 == 2)) {

                if (probabilidadDeAcciones() <= (80 - veriProbabilidad)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Anotaste 2 puntos " + nombrejugador2);
                    puntosj2 = "2";
                } else {
                    System.out.println("|******************************************|");
                    System.out.println("|fallaste " + nombrejugador2);
                }

                if (probabilidadDeAcciones() <= (veriProbabilidadFalta)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador1);
                    System.out.println("|Tiro Libre para " + nombrejugador2);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador2);
                        puntosfj2 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador2);
                    }
                }
            } else if ((opcionDefensaj1 == j) && (opcionDefensaj2 == 1)) {

                if (probabilidadDeAcciones() <= (35)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador2);
                    System.out.println("|Tiro Libre para " + nombrejugador1);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador1);
                        puntosfj1 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador1);
                    }

                }

                if (probabilidadDeAcciones() <= (veriProbabilidadFalta)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador1);
                    System.out.println("|Tiro Libre para " + nombrejugador2);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador2);
                        puntosfj2 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador2);
                    }
                }
            } else if ((opcionDefensaj1 == j) && (opcionDefensaj2 == 2)) {

                if (probabilidadDeAcciones() <= (65)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador2);
                    System.out.println("|Tiro Libre para " + nombrejugador1);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador1);
                        puntosfj1 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador1);
                    }

                }

                if (probabilidadDeAcciones() <= (veriProbabilidadFalta)) {
                    System.out.println("|******************************************|");
                    System.out.println("|Faltaaaaa! de " + nombrejugador1);
                    System.out.println("|Tiro Libre para " + nombrejugador2);

                    if (probabilidadDeAcciones() <= (90)) {
                        System.out.println("|******************************************|");
                        System.out.println("|Anotaste 2 puntos " + nombrejugador2);
                        puntosfj2 = "2";

                    } else {
                        System.out.println("|******************************************|");
                        System.out.println("|fallaste " + nombrejugador2);
                    }
                }
            }
        }

        String datos = puntosj1 + "," + puntosj2 + "," + puntosfj1 + "," + puntosfj2;
        return datos;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
public static void juegoTres() {

        //Se llama al metodo para registrar cuantas veses se ha iniciado el juego
        registroVeseIniciado2048();

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

        Scanner entrada = new Scanner(System.in);
        Scanner m = new Scanner(System.in);

        //se crea una matriz para formar el tablero
        int[][] tablero = new int[4][4];

        //menu 2048
        System.out.println("\n\n═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        System.out.println("┃                       1.Instrucciones                         ┃");
        System.out.println("┃                       2.Jugar                                 ┃");
        System.out.println("┃                       3.Regresar                              ┃");
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");

        int opcion = entrada.nextInt();
        String opciont;

        switch (opcion) {

            case 1:

                break;

            case 2:

                //Se al metodo para egregar un nuemro al tablero
                agregarNumero(tablero);

                //mneu de movimiento de objetos en el tablero
                while (true) {

                    tablero(tablero);

                    System.out.println("\n\n═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
                    System.out.println("┃                          w:Arriba                             ┃");
                    System.out.println("┃                          a:Derecha                            ┃");
                    System.out.println("┃                          d:Izquierda                          ┃");
                    System.out.println("┃                          s:Abajo                              ┃");
                    System.out.println("┃                          0:salir                              ┃");
                    System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");

                    // Realizar el movimiento
                    boolean ver;

                    do {
                        String mover = m.nextLine();
                        ver = false;
                        switch (mover) {

                            case "w":
                                moverArriba(tablero);
                                ver = true;
                                break;

                            case "a":
                                moverIzquierda(tablero);
                                ver = true;
                                break;

                            case "d":
                                moverDerecha(tablero);
                                ver = true;
                                break;

                            case "s":
                                moverAbajo(tablero);
                                ver = true;
                                break;

                            case "0":

                                registroSalidoSinTerminar2048();
                                Menu();

                                break;

                            default:
                                System.out.println("Movimiento inválido");
                                ver = false;
                                break;
                        }
                    } while (ver != true);

                    //verifica si el jugador gano
                    if (verificarGanar(tablero)) {
                        registroVeseGandodo2048();
                        System.out.println("\n\n═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
                        System.out.println("┃                   ¡Felicidades! Has ganado                    ┃");
                        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");

                        System.out.println("        ┃     introduzca el numero 0, para continuar     ┃\n\n");

                        do {
                            opciont = entrada.nextLine();

                            if ("0".equals(opciont)) {

                                opcion = Integer.parseInt(opciont);

                            } else {
                                System.out.println("         ┃            Ingrese un valor valido!            ┃");

                            }

                        } while (opcion != 0);
                        break;
                    }

                    // Verificar si se ha perdido
                    if (verificarPerder(tablero)) {

                        System.out.println("\n\n═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════");
                        System.out.println("┃                  ¡Que lastima! Has perdido!                   ┃");
                        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══━━━━═══━━━━━━━━━━━━━━━━━━━━━━━═════\n");
                        System.out.println("        ┃     introduzca el numero 0, para continuar     ┃\n\n");

                        do {
                            opciont = entrada.nextLine();

                            if ("0".equals(opciont)) {

                                opcion = Integer.parseInt(opciont);

                            } else {

                                System.out.println("        ┃            Ingrese un valor valido!            ┃");

                            }

                        } while (opcion != 0);
                        break;
                    }

                    //vuelve a agregar un numero 2 al tablero
                    agregarNumero(tablero);

                }
                break;
            case 3:
                Menu();
                break;

        }

    }

//metiodo que imprime el tablero
    public static void tablero(int[][] tablero) {
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━═══2048═══━━━━━━━━━━━━━━━━━━━━━━━═════");
        for (int i = 0; i < 4; i++) {
            System.out.print("┃");
            for (int j = 0; j < 4; j++) {
                System.out.print(color(tablero[i][j]) + tablero[i][j] + "         \t\u001B[0m┃");
            }
            System.out.println("");
        }
        System.out.println("═════━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━═════");
    }

//Metodo que retorna un color de fondo segun el valor que esta e la celda
    public static String color(int numero) {
        switch (numero) {
            case 2:
                return "\u001B[41m   "; // asigna el color rojo
            case 4:
                return "\u001B[42m   "; // asigna el color verde
            case 8:
                return "\u001B[43m   "; // asigna el color amarillo
            case 16:
                return "\u001B[44m  "; // asigna el color azul
            case 32:
                return "\u001B[45m  "; // asigna el color morado
            case 64:
                return "\u001B[46m  "; // asigna el color celeste
            case 128:
                return "\u001B[47m "; // asigna el color blanco
            case 256:
                return "\u001B[41m "; // asigna el color rojo
            case 512:
                return "\u001B[42m "; // asigna el color verde
            case 1024:
                return "\u001B[43m"; // asigna el color amarillo
            case 2048:
                return "\u001B[44m"; // asigna el color azul
            default:
                return "\u001B[0m   "; // borrar color
        }
    }

    //Metodo que agraga un dos o un cuantro en cada turno en una casi vacia aleatoriamente
    public static void agregarNumero(int[][] tablero) {

        Random rand = new Random();
        int fil, col;

        do {
            fil = rand.nextInt(4);
            col = rand.nextInt(4);
        } while (tablero[fil][col] != 0);

        tablero[fil][col] = (2) + 1 * 2;

    }

    //metodo que verifica si el jugado gano
    public static boolean verificarGanar(int[][] tablero) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int celda = tablero[i][j];
                if (celda == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    //metodo que verifica si el jugado perdio
    public static boolean verificarPerder(int[][] tablero) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int celda = tablero[i][j];
                if (celda == 0) {

                    return false;
                }
            }

        }
        return true;
    }

    //Metodo que ejecuta el movimiento de arriba
    public static void moverArriba(int[][] tablero) {
        // Recorre cada columna del tablero
        for (int col = 0; col < 4; col++) {
            // Comienza desde la segunda fila (índice 1)
            for (int fil = 1; fil < 4; fil++) {
                // Si la casilla actual no está vacía
                if (tablero[fil][col] != 0) {
                    int filtemp = fil; // Almacena temporalmente la fila actual
                    // Mientras no estemos en la fila superior y la casilla superior está vacía o tiene el mismo valor que la casilla actual
                    while (filtemp > 0 && (tablero[filtemp - 1][col] == 0 || (tablero[filtemp - 1][col] == tablero[filtemp][col]))) {
                        // Si la casilla superior tiene el mismo valor que la casilla actual
                        if (tablero[filtemp - 1][col] == tablero[filtemp][col]) {
                            // Combina las casillas sumando sus valores
                            tablero[filtemp - 1][col] *= 2; // Duplica el valor de la casilla superior
                            tablero[filtemp][col] = 0; // Vacía la casilla actual
                            break; // Sal del bucle mientras
                        }
                        // Si la casilla superior está vacía
                        tablero[filtemp - 1][col] = tablero[filtemp][col]; // Mueve la casilla actual hacia arriba
                        tablero[filtemp][col] = 0; // Vacía la casilla actual
                        filtemp--; // Mueve la posición temporal hacia arriba
                    }
                }
            }
        }
    }

    //Metodo que ejecuta el movimiento de Abajo
    public static void moverAbajo(int[][] tablero) {

        for (int col = 0; col < 4; col++) {
            for (int fil = 2; fil >= 0; fil--) {
                if (tablero[fil][col] != 0) {
                    int filtemp = fil;

                    while (filtemp < 3 && ((tablero[filtemp + 1][col] == 0) || (tablero[filtemp + 1][col] == tablero[filtemp][col]))) {

                        if (tablero[filtemp + 1][col] == tablero[filtemp][col]) {

                            tablero[filtemp + 1][col] *= 2;
                            tablero[filtemp][col] = 0;
                            break;
                        }

                        tablero[filtemp + 1][col] = tablero[filtemp][col];
                        tablero[filtemp][col] = 0;
                        filtemp++;
                    }
                }
            }
        }
    }

    //Metodo que ejecuta el movimiento de izquierda
    public static void moverIzquierda(int[][] tablero) {

        for (int fil = 0; fil < 4; fil++) {
            for (int col = 1; col < 4; col++) {

                if (tablero[fil][col] != 0) {
                    int coltemp = col;

                    while (coltemp > 0 && ((tablero[fil][coltemp - 1] == 0) || (tablero[fil][coltemp - 1] == tablero[fil][coltemp]))) {
                        if (tablero[fil][coltemp - 1] == tablero[fil][coltemp]) {

                            tablero[fil][coltemp - 1] *= 2;
                            tablero[fil][coltemp] = 0;
                            break;
                        }

                        tablero[fil][coltemp - 1] = tablero[fil][coltemp];
                        tablero[fil][coltemp] = 0;
                        coltemp--;

                    }
                }
            }
        }
    }

    //Metodo que ejecuta el movimiento de derecha
    public static void moverDerecha(int[][] tablero) {

        for (int fil = 0; fil < 4; fil++) {
            for (int col = 2; col >= 0; col--) {

                if (tablero[fil][col] != 0) {
                    int coltemp = col;

                    while (coltemp < 3 && ((tablero[fil][coltemp + 1] == 0) || (tablero[fil][coltemp + 1] == tablero[fil][coltemp]))) {
                        if (tablero[fil][coltemp + 1] == tablero[fil][coltemp]) {

                            tablero[fil][coltemp + 1] *= 2;
                            tablero[fil][coltemp] = 0;
                            break;
                        }

                        tablero[fil][coltemp + 1] = tablero[fil][coltemp];
                        tablero[fil][coltemp] = 0;
                        coltemp++;

                    }
                }
            }
        }
    }

}//fin clase practica1

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

