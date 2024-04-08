package uni.aed.sort;
public class SortMain {
    
    static Sort sort=new Sort();
    
    public static void main(String[] args){
        carga();
        visualizar();
        mergeSort();
//       quickSort();
//        heapSort();
//        insercionSort();
//        visualizar();
//        selectionWuSort();
//        visualizar();
//        bubbleWuSort();
//        visualizar();
    }
    public static void carga(){
        Integer X[]={5,14,24,39,43,65,84,45};
        sort.setY(X);
    }
    public static void visualizar(){
        System.out.println("El array origen contiene los siguientes elementos");
        System.out.println(sort.toString());
    }
    public static void insercionSort(){
        for(Integer y: sort.insercionSort())
            System.out.print(y.toString()+ ","); 
        System.out.println(" nComp= "+sort.getnComp()+" nInt= "+sort.getnInt()+" tEjec(ns)= "+ sort.gettEjec());
    }
    public static void selectionWuSort(){
        for(Integer y: sort.selectionWuSort())
            System.out.print(y.toString()+ ",");   
        System.out.println("");
    }        
    public static void bubbleWuSort(){
        for(Integer y: sort.bubbleWuSort())
            System.out.print(y.toString()+ ",");   
        System.out.println("");
    }            
    
    public static void heapSort(){        
        for(Integer y: sort.heapSort())
            System.out.print(y.toString()+ ",");   
        System.out.println("");
    }            
    
    public static void quickSort(){                
        for(Integer y: sort.CallQuickSort())
            System.out.print(y.toString()+ ",");   
        System.out.println("");
    }  
    
    public static void mergeSort(){                
        for(Integer y: sort.CallMergeSort())
            System.out.print(y.toString()+ ",");   
        System.out.println("");
    }  
    
}
