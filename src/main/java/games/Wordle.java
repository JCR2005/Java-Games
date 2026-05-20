package games;

import java.util.Scanner;

import utils.Posters;

public class Wordle {

    // variables que almacenan colores, para indetificar caracteristicas de la palabra ingresada por el usuario en cada intento.
    private final String green = "\033[32m";
    private final String yellow = "\033[33m";
    private final String red = "\033[31m";
    private final String reset = "\u001B[0m";

    // variable que almacena la clase Posters, para mostrar los carteles del juego.
    private final Posters posters = new Posters();

    // variable que almacena la clase Scanner, para obtener la entrada del usuario.
    private final Scanner imputUSer = new Scanner(System.in);

    // variable que almacena la palabra ingresada por el usuario para el juego wordle, dividida en letras.
    private String[] originalWords;

    // variable que almacena las palabras ingresadas por el usuario en cada intento, divididas en letras.
    private String historyWords[][];

    // variable que almacena la palabra ingresada por el usuario para el juego wordle, sin dividir en letras.
    private String wordleWord;

    // variable que almacena el numero de intentos para el juego wordle.
    private final int attempts = 6;

    // variable que almacena el numero de letras de la palabra ingresada por el usuario para el juego wordle.
    private boolean onePlayer;

    /**
     * Este metodo inicia el juego wordle.
     * 
     */
    public void startWordle() {

        this.startWordleMenu();

    }

    /**
     * Este metodo inicia el menu del wordle.
     * 
     */
    private void startWordleMenu() {

        String optionMenu = "";

        do {
            posters.showWordleMenu();
            optionMenu = imputUSer.nextLine();
            switch (optionMenu) {
                case "1" -> {
                }
                case "2" -> {
                    this.setOnePlayer(false);
                    this.playWordle();
                }
                case "3" -> {
                    return;
                }
                case "4" -> {
                    return;
                }

                default -> posters.showMesageWarningMemu(imputUSer);

            }
        } while (true);

    }

    /**
     * Este metodo inicia la logica del juego wordle.
     * 
     */
    private void playWordle() {

        preparationGame();
        gameMotor();

    }

    /**
     *  Este metodo prepara el juego wordle.
     */
    private void preparationGame() {

       
        do{
               this.wordleWord = getWordleWord();
        }while (!this.wordConfirmation());

        this.preparationArrays();

    }

    /**
     * Este metodo es el motor del juego wordle, se encarga de controlar el flujo del juego, 
     * desde que el usuario ingresa una palabra hasta que se comprueba si la palabra es correcta o no.
     * 
     */
    private void gameMotor(){

        int attempstGame=1;
        do{
            this.getWordGame(attempstGame);
            this.comprobationWord(attempstGame);
            
            attempstGame++;

        } while (attempstGame-1 < this.attempts);    
        
    }


    
       

    /**
     * Este metodo obtiene la palabra ingresada por el usuario para el juego wordle.
     * 
     * @param attemp
     * @return
     */
    private  String getWordGame(int  attemp){

        String wordImout="";
      
        int sideWordImput;
        int sideWordOriginal = this.originalWords.length;

        do { 
            
            this.posters.showHistoryWords(this.historyWords);
            this.posters.showOportinityNumber(attemp);
            wordImout=imputUSer.nextLine();

            sideWordImput = wordImout.length();
            if (isWordleWordNotEmpy(wordImout)) {
                posters.showWarningWordIsEmpy(imputUSer);
            }else if (isWordleWordValid(wordImout)) {
                posters.showWarningWord(imputUSer);
            }else if(sideWordImput != sideWordOriginal){
                posters.showWarningWordIsLength(imputUSer);
            }else{
              historyWords[attemp-1] = wordImout.split("");

              return wordImout;

            }
        } while (true);
         
    }

    /**
     * Este metodo comprueba la palabra ingresada por el usuario en cada intento.
     * @param attemp
     */
    private void comprobationWord(int attemp){

        boolean wordIsCorrect = true;
        for (int idx = 0; idx < originalWords.length; idx++) {
             
            if (comprobationPositionLetter(idx, attemp) == 1) {
                case1WordImput(idx, attemp);
            }else if(compobationContainsLetter(idx, attemp ) == 2){
                wordIsCorrect = false;
                case2WordImput(idx, attemp);
            }else{
                wordIsCorrect = false;
                case0WordImput(idx, attemp);
            }
        }

        if(wordIsCorrect){
            playerWin(attemp);
        }else if(attemp == this.attempts){
            playerWin(attemp);

            System.out.println("Has perdido, la palabra era: " + this.wordleWord);
        }

    }


    /**
     * Este metodo muestra el mensaje de victoria o derrota al usuario, dependiendo del numero de intentos que haya realizado.
     * @param attemp
     */
    private void playerWin(int attemp){

        if(attemp < this.attempts){
            this.posters.showHistoryWords(this.historyWords);
            this.posters.showCongratulations(this.imputUSer);
        }else{
            this.posters.showHistoryWords(this.historyWords);
            this.posters.showDefeat(this.imputUSer, this.originalWords);
        }

    }

    /**
     * Este metodo cambia el color de la letra ingresada por el usuario en cada intento, si la letra esta en la posicion correcta.
     * 
     * @param posx
     * @param attemp
     */
    private void case1WordImput(int posx, int attemp){

        String letterImput = this.historyWords[attemp-1][posx];

        this.historyWords[attemp-1][posx] =   this.green + "["+ letterImput + "]" + this.reset;

    }


    /**
     * Este metodo cambia el color de la letra ingresada por el usuario en cada intento, 
     * si la letra esta en la palabra pero no en la posicion correcta.
     * 
     * @param posx
     * @param attemp
     */
    private void case2WordImput(int posx, int attemp){

        String letterImput = this.historyWords[attemp-1][posx];
        
        this.historyWords[attemp-1][posx] = this.yellow + "["+ letterImput + "]" + this.reset;


    }


    /**
     * Este metodo cambia el color de la letra ingresada por el usuario en cada intento, si la letra no esta en la palabra.
     * 
     * @param posx
     * @param attemp
     */
    private void case0WordImput(int posx, int attemp){

        String letterImput = this.historyWords[attemp-1][posx];

        this.historyWords[attemp-1][posx] = this.red + "["+ letterImput + "]" + this.reset;

    }

    /**
     * Este metodo comprueba si la letra ingresada por el usuario en cada intento, esta en la posicion correcta.
     * 
     * @param posx
     * @param attemp
     * @return
     */
    private int comprobationPositionLetter(int posx, int attemp){

        String letterOriginal = this.originalWords[posx];
        String letterImput = this.historyWords[attemp-1][posx];

        if(letterImput.equals(letterOriginal)){
            return 1;
        }
        return 0;
    }


    /**
     * Este metodo comprueba si la letra ingresada por el usuario en cada intento, esta en la palabra pero no en la posicion correcta.
     * 
     * @param posx
     * @param attemp
     * @return
     */
    private int compobationContainsLetter(int posx, int attemp){

        
        String letterImpu = historyWords[attemp-1][posx];
        for (int idx = 0; idx < originalWords.length; idx++) {
            
            if(letterImpu.equals(originalWords[idx])){
                return 2;
            }
        }

        return 0;

    }

    /**
     * Este metodo prepara los arrays para el juego wordle.
     * 
     */
    private void preparationArrays(){

        
        int numberOfLetters=this.numberOfLetters(wordleWord);

        this.startArrayOriginalWords(numberOfLetters);
        this.startArrayHistoryWords(this.attempts, numberOfLetters);

        this.originalWords = wordleWord.split(""); 


      
    }

    /**
     * Este metodo obtiene la palabra ingresada por el usuario para el juego wordle, 
     * y valida que la palabra no este vacia, que tenga vocales y consonantes.
     * 
     * @return
     */
    private String getWordleWord() {
        String word = "";
        do {
            posters.showImputWordle();
            word = imputUSer.nextLine();
            if (isWordleWordNotEmpy(word)) {
                posters.showWarningWordIsEmpy(imputUSer);
            }else if (isWordleWordValid(word)) {
                posters.showWarningWord(imputUSer);
            }
        } while (isWordleWordNotEmpy(word) || isWordleWordValid(word));
 
        return word;
        
    }
    
    /**
     * Este metodo comprueba si la palabra ingresada por el usuario para el juego wordle, esta vacia.
     * 
     * @param wordleWord
     * @return
     */
    private boolean isWordleWordNotEmpy(String wordleWord) {

        return wordleWord.isEmpty();
    }


    /**
     * Este metodo comprueba si la palabra ingresada por el usuario para el juego wordle, tiene vocales y consonantes.
     * 
     * @param wordleWord
     * @return
     */
    private boolean isWordleWordValid(String wordleWord) {

       return  !wordContainsVowels(wordleWord) || !wordContainsConsonants(wordleWord);
    }


    /**
     * Este metodo comprueba si la palabra ingresada por el usuario para el juego wordle, tiene vocales.
     * 
     * @return 
     */
    private boolean wordContainsVowels(String wordleWord) {

        return wordleWord.matches(".*[aeiouAEIOU].*");
    }


    /**
     * Este metodo comprueba si la palabra ingresada por el usuario para el juego wordle, tiene consonantes.
     * 
     * @return 
     */
    private boolean wordContainsConsonants(String wordleWord) {

        return wordleWord.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*");
    }

    /**
     * Este metodo obtiene el numero de intentos para el juego wordle.
     * 
     * @return 
     */
    private int getAttempts() {

        return this.attempts;
    }

    /**
     * Este metodo hace que el usuario confirme 
     * 
     * @return
     */
    private boolean wordConfirmation() {

        String option = "";
        
        do {
            this.posters.showWordWordle(this.wordleWord);
            option = imputUSer.nextLine();
            switch (option) {
                case "1" -> {
                    return true;

                }
                case "2" -> {
                    return false;
                }
                default -> this.posters.showMesageWarningMemu(imputUSer);
            }

        } while (true);

    }

    /**
     * Este metodo obtiene el numero de letras de la palabra ingresada por el usuario para el juego wordle.
     * 
     * @param word
     * @return
     */
    private int numberOfLetters(String word) {

        return word.length();
    }

    /**
     * Este metodo inicia el array originalWords con el tamaño especificado.
     * 
     * @param numberOfLetters
     */
    private void startArrayOriginalWords(int numberOfLetters) {

        originalWords = new String[numberOfLetters];

    }

    /**
     * Este metodo inicia el array historyWords con el tamaño especificado.
     * 
     * @param attempst
     * @param numberOfLetters
     */
    private void startArrayHistoryWords(int attempts, int numberOfLetters) {

        historyWords = new String[attempts][numberOfLetters];

        for (int idx = 0; idx < historyWords.length; idx++) {
            for (int jdx = 0; jdx < historyWords[idx].length; jdx++) {
                historyWords[idx][jdx] = "䷀䷀䷀    ";
            }
        }

    }

    /**
     * Este metodo establece el valor de la variable onePlayer.
     * 
     * @param value
     */
    private void setOnePlayer(boolean value){

        this.onePlayer = value;

    }
}
