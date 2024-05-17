package uni.aed.tagsHTML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import uni.aed.listTDA.NoSuchElementException;

public class HTMLRecuperaEtiq {
    private BufferedReader reader;

    public HTMLRecuperaEtiq(String nomArchivo) throws IOException{
        reader=new BufferedReader(new FileReader(nomArchivo));        
    }
    
    public HTMLEtiq etiqSiguiente() throws IOException{
        String linea =reader.readLine();
        if(linea==null)
            throw new NoSuchElementException("No hay mas etiquetas por leer");
        else{
            linea=linea.trim();//retira los espacios en blanco del texto
            return new HTMLEtiq(linea);
        }
    }
    
    public boolean hayMasEtiq(){
        try{
            return reader.ready();
        }catch(IOException e){
            return false;
        }
    }
    
    public void cerrar() throws IOException{
        reader.close();
    }
    
    public void reset(){
        try{
            reader.reset();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void restablece(String nomArchivo) throws IOException{
        reader.close();
        reader=new BufferedReader(new FileReader(nomArchivo));   
    }
    
}
