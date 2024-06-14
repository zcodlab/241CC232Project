package uni.aed.trees.B;

/**
* Un árbol se puede definir de forma recursiva (localmente) 
* como una colección de nodos (comenzando en un nodo raíz), 
* donde cada nodo es una estructura de datos que consta de un valor, 
* junto con una lista de nodos (los "hijos"), con las restricciones 
* que ningún nodo esté duplicado. 
* Un árbol se puede definir de forma abstracta como un todo (globalmente) 
* como un árbol ordenado, con un valor asignado a cada nodo. 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
import java.util.Collection;
public interface ITree<T> {

    /**
     * Add value to the tree. Tree can contain multiple equal values.     * 
     * @param value to add to the tree.
     * @return True if successfully added to tree.
     */
    public boolean add(T value);

    /**
     * Eliminar la primera ocurrencia de un valor en el árbol..     
     * @param value to remove from the tree.
     * @return T value removed from tree.
     */
    public T remove(T value);

    /**
     * Limpiar toda la pila.
     */
    public void clear();

    /**
     * Verificar si el arbol contiene determinado valor     
     * @param value to locate in the tree.
     * @return True if tree contains value.
     */
    public boolean contains(T value);

    /**
     * Obtener el numero de nodos en el arbol     
     * @return Number of nodes in the tree.
     */
    public int size();

    /**
     * Validar el árbol según las invariantes.     
     * @return V si el arbol es valido.
     */
    public boolean validate();

    /**
     * Obtener un arbol como una coleccion compatible Java     
     * @return Java compatible Collection
     */
    public Collection<T> toCollection();

}
