package uni.aed.directorio;

import uni.aed.model.Persona;

/**
 *
 * @author hp
 */
public interface Directorio {
    public void add( Persona newPersona );
    public boolean delete( String searchName );          
    public Persona search( String searchName );       
    public Persona[ ] sort ( int attribute);        
}
