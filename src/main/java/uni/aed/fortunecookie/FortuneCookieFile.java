package uni.aed.fortunecookie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import uni.aed.linkedlistTDA.LinkedListTDA;

public class FortuneCookieFile {
    private LinkedListTDA<String> lista;

    public FortuneCookieFile() {
        lista = new LinkedListTDA<>();        
        loadFortunesFromFile("src\\main\\java\\uni\\aed\\FortuneCookie\\fortunes.txt");
    }

    public LinkedListTDA<String> getLista() {
        return lista;
    }   

    private void loadFortunesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar mensajes de la suerte desde el archivo: " + e.getMessage());
        }
    }
}
