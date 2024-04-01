package uni.aed.sort;
public class Sort {
    private Integer[] Y;
    public Sort() {
    }      
    public Sort(Integer[] Y) {
        this.Y = Y;
    }
    public void setY(Integer[] Y) {
        this.Y = Y;
    }
    public Integer[] getY() {
        return Y;
    }
    @Override
    public String toString() {
        return "Sort{" + "Y=" + Y + '}';
    }
    
    public Integer[] insercionSort(){
        Integer[] X=getY().clone();
        int aux,k;
        boolean sw=false;
        for(int i=1;i<X.length;i++){
            aux=X[i];
            k=i-1;
            sw=false;
            while(!sw && k>=0){
                if(aux<X[k]){
                    X[k+1]=X[k];
                    k--;}
                else
                    sw=true;
            }//end while
            X[k+1]=aux;
        }//end for
        return X;
    }

    
    
        
    
}
