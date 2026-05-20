
package utils;

import java.io.File;
import java.util.List;

public class DiccionaryWords {

    private final List<String> words = new java.util.ArrayList<>();

    private final String filePath = "src/main/java/utils/diccionary.txt";

  
    public List<String> getWords() {
        return this.words;
    }



    public void readWordsFromFile() {
        try {
            File file = new File(this.filePath);
            java.util.Scanner scanner = new java.util.Scanner(file);
            int index = 0;
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
                index++;
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}