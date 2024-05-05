package uni.aed.linkedlistTDA;
/*
    Clase Generica LinkedList TDA(Tipo de Dato Abstracto)
    implementa la interface ListTDA
*/

import uni.aed.listTDA.ListTDA;
import uni.aed.listTDA.IteratorTDA;

public class LinkedListTDA<E> implements ListTDA<E>{
    public static final int NO_ENCONTRADO=-1;
    private Nodo head;
    private Nodo cola;
    private int count;
    
    public LinkedListTDA(){        
        clear();
    }

    @Override
    public void add(E data) {
        Nodo newNodo= new Nodo(data);
        if(count==0)
            head=cola=newNodo;
        else{
            cola.setNext(newNodo);
            cola=newNodo;
        }
        count++;
    }

    @Override
    public void add(int index, E data) throws IndexOutOfBoundsException {
        revisaPosInsercion(index);
        Nodo apt=head;
        Nodo newNodo= new Nodo(data);
        if(index==0){
            newNodo.setNext(head);
            head=newNodo;
        }else{
            for(int i=1;i<index;i++)
                apt=apt.getNext();
            newNodo.setNext(apt.getNext());
            apt.setNext(newNodo);
        }
        if(index==count)
            cola=newNodo;
        count++;
    }
    
    private void revisaPosInsercion(int index){
        if(index<0)
            throw new IndexOutOfBoundsException("Indice ingresado es invalido");
        else if(index>size())
            throw new IndexOutOfBoundsException("Indice es mayor al tamaño de la lista");            
    }
    private void revisaPosAcceso(int index){
        if(size()==0)
            throw new IndexOutOfBoundsException("Indice "+ index+" es invalido. Lista vacia");
        else if(index<0)
            throw new IndexOutOfBoundsException("Indice negativo de "+ index+" es invalido.");
        else if(index>size()-1)
            throw new IndexOutOfBoundsException("Indice "+ index+ " es mayor que limite superior valido "+ (size()-1));        
    }
            

    @Override
    public void clear() {
        head=null;
        cola=null;
        count=0;
    }

    @Override
    public boolean contain(E data) {
        boolean resultado=true;
        int index=indexOf(data);
        if(index==NO_ENCONTRADO)
            resultado=false;
        return resultado;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        E data=null;
        Nodo apt=head;
        for(int i=0;i<index;i++)
            apt=apt.getNext();
        data=(E)apt.getData();
        return data;
    }

    @Override
    public int indexOf(E data) {
        int index=0;
        Nodo apt=head;
        while(index<count && ((Comparable)apt.getData()).compareTo( data)!=0){
            index++;
            apt=apt.getNext();
        }
        if(index==count)
            index=NO_ENCONTRADO;
        return index;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        Nodo nodoDelete;
        Nodo apt=head;        
        if(index==0){
            nodoDelete=apt;
            head=head.getNext();
            if(head==null)
                cola=null;            
        }
        else{
            for(int i=1;i<index;i++)
                apt=apt.getNext();
            nodoDelete=apt.getNext();
            apt.setNext(nodoDelete.getNext());
            if(apt.getNext()==null)
                cola=apt;
        }
        count--;        
        return (E)nodoDelete.getData();
    }

    @Override
    public boolean delete(E data) {
        boolean resultado=false;
        Nodo apt=head;
        Nodo huella=null;
        while(apt!=null && ((Comparable)apt.getData()).compareTo( data)!=0){
            huella=apt;
            apt=apt.getNext();
        }
        if(apt!=null){
            if(huella==null){
                head=head.getNext();
                if(head==null)
                    cola=null;
            }else{
                huella.setNext(apt.getNext());
                if(huella.getNext()==null)
                    cola=huella;
            }
        count--;
        resultado=true;        
        }
        return resultado;
    }

    @Override
    public E modify(int index, E data) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        Nodo apt=head;
        for(int i=0;i<index;i++)
            apt=apt.getNext();
        E anterior=(E)apt.getData();
        apt.setData(data);
        return anterior;
    }

    @Override
    public int size() {
        return count;
    }

//    @Override
//    public void imprimir() {
//        IteratorTDA it=new Iterador(head);
//        while(it.hasNext())
//            System.out.println(it.next().toString());
//    }
    
    @Override
    public String toString() {
        String result="";
        IteratorTDA it=new Iterador(head);
        while(it.hasNext()){
            if(result.length()==0)
                result=""+it.next().toString();
            else
                result=result+"->"+it.next().toString();
        }
        return result;
    }
    
}
