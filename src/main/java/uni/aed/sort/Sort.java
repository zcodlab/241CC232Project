package uni.aed.sort;
public class Sort {
    private Integer[] Y;
    private int nComp=0;    //# Comparaciones
    private int nInt=0;     //# Intercambios
    private long tEjec=0;   //tiempo de Ejecucion (nanosegundos)
    
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

    public void setnComp(int nComp) {
        this.nComp = nComp;
    }

    public void setnInt(int nInt) {
        this.nInt = nInt;
    }

    public void settEjec(long tEjec) {
        this.tEjec = tEjec;
    }

    public int getnComp() {
        return nComp;
    }

    public int getnInt() {
        return nInt;
    }

    public long gettEjec() {
        return tEjec;
    }
    @Override
    public String toString() {
        String result="";    
        clear();
        for(Integer y: Y)
            if (result.length()==0)
                result=y.toString();
            else
                result=result+","+y.toString();        
        return "{"+result+"}, nComp= "+getnComp()+" nInt= "+getnInt()+" tEjec(nano)= "+ gettEjec();
    }
    
    private void clear(){
        this.setnComp(0);
        this.setnInt(0);
        this.settEjec(0);
    }
    
    public Integer[] insercionSort(){
        Integer[] X=getY().clone();
        int aux,k;
        boolean sw=false;
        clear();
        long tIni=System.nanoTime();
        for(int i=1;i<X.length;i++){
            aux=X[i];
            k=i-1;
            sw=false;
            while(!sw && k>=0){
                nComp++;
                if(aux<X[k]){
                    nInt++;
                    X[k+1]=X[k];
                    k--;}
                else
                    sw=true;
            }//end while
            X[k+1]=aux;
        }//end for
        long tFin=System.nanoTime();
        this.setnComp(nComp);
        this.setnInt(nInt);
        this.settEjec(tFin-tIni);
        return X;
    }
    public Integer[] selectionWuSort(){
        Integer[] X=getY().clone();
        int startIndex, minIndex, lenght, temp;
        lenght=X.length;
        for(startIndex=0;startIndex<=lenght-2;startIndex++){
            minIndex=startIndex;
            for(int i=startIndex+1; i<=lenght-1;i++){
                if(X[i]<X[minIndex])minIndex=i;
            }
            temp=X[startIndex];
            X[startIndex]=X[minIndex];
            X[minIndex]=temp;            
        }
        return X;
    }   
    public Integer[] bubbleWuSort(){//burbuja
        Integer[] X=getY().clone();
        int temp, bottom;
        boolean exchanged=true;
        bottom=X.length-2;
        while(exchanged){
            exchanged=false;
            for(int i=0;i<=bottom;i++){
                if(X[i]>X[i+1]){                    
                    temp=X[i];
                    X[i]=X[i+1];
                    X[i+1]=temp;                    
                    exchanged=true;
                }
            }
            bottom--;
        }
        return X;
    }
    
}
