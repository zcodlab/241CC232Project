package uni.aed.tagsHTML;
import java.io.IOException;
import uni.aed.stackTDA.ArrayStackTDA;
import uni.aed.stackTDA.StackTDA;

public class HTMLRevisaEtiq {
    private StackTDA<HTMLEtiq> etiquetasEnPila;
    private HTMLRecuperaEtiq etiqRecuperada;

    public HTMLRevisaEtiq(String nomArchivo) throws IOException {
        etiquetasEnPila=new ArrayStackTDA<>();
        etiqRecuperada=new HTMLRecuperaEtiq(nomArchivo);
    }

    public StackTDA<HTMLEtiq> getEtiquetasEnPila() {
        return etiquetasEnPila;
    }

    public HTMLRecuperaEtiq getEtiqRecuperada() {
        return etiqRecuperada;
    }
    public boolean esValido(){
        HTMLEtiq etiqSiguiente=null,etiqTop=null;
        boolean nohayError=true, termina=false;
        etiquetasEnPila.clear();
        while(!termina){
            if(!etiqRecuperada.hayMasEtiq()){
                termina=true;
                if(!etiquetasEnPila.isEmpty())
                    nohayError=false;
            }else{
                try{
                    etiqSiguiente=etiqRecuperada.etiqSiguiente();
                }catch(IOException e){            
                    e.printStackTrace();
                }
                if(etiqSiguiente.esEtiquetaApertura())
                    etiquetasEnPila.push(etiqSiguiente);
                else if(etiqSiguiente.esEtiquetaCierre()){
                    etiqTop=etiquetasEnPila.pop();
                    if(!etiqTop.compara(etiqSiguiente)){
                        nohayError=false;
                        termina=true;
                    }
                }
                    
            }
                
        }
        return nohayError;
    }
    
}
