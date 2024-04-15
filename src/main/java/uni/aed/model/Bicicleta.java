package uni.aed.model;
public class Bicicleta {
    private String nomPropietario;

    public Bicicleta(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public String getNomPropietario() {
        return nomPropietario;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "nomPropietario=" + nomPropietario + '}';
    }
    
    public int compareTo(Bicicleta o){
        String p2name=o.getNomPropietario();
        return this.nomPropietario.compareTo(p2name);
    }
    
}
