package uni.aed.sort;
public class SortMain {
    
    static Sort sort=new Sort();
    
    public static void main(String[] args){
        carga();
        visualizar();
        insercionSort();
        visualizar();
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
    }
}
