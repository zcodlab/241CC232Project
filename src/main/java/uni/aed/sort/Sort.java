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
    
    public Integer[] heapSort(){
        Integer[] X=getY().clone();
        HeapSortConstruct(X);// 1)fase de construccion
        return HeapSortExtract(X);//2)fase de extraccion        
    }
    private void HeapSortConstruct(Integer[] X){
        int current=0,maxChildIndex;
        boolean hecho;
        for(int i=(X.length-2)/2;i>=0;i--){
            current=i;
            hecho=false;
            while(!hecho){//2*i+1,2*i+2
                if(2*current+1>X.length-1)
                    //nodo actual no tiene hijos
                    hecho=true;                
                else{//el nodo actual tiene por lo menos un hijo
                    maxChildIndex=HeapSortMaxChild(X,current,X.length-1);
                    if(X[current]<X[maxChildIndex])//si el nodo padre es mas pequeño que alguno de los hijos
                    {   intercambio(X,current,maxChildIndex);
                        current=maxChildIndex;                        
                    }else
                        hecho=true;
                }                
            }//end while
        }//end for    
    }
    
    private int HeapSortMaxChild(Integer[] X,int loc,int end){//loc=ubicacion, end=tope del array
        int result,izq,der;
        izq=2*loc+1;//posicionamiento impar=nodo izq
        der=2*loc+2;//posicionamiento par=nodo der
        if(der<=end && X[izq]<X[der])
            result=der;
        else
            result=izq;
        return result; //contiene la posicion del hijo con el maximo valor
    }
    private void intercambio(Integer[] X,int p,int q){
        int temp=X[p];
        X[p]=X[q];
        X[q]=temp;
    }
    
    private Integer[] HeapSortExtract(Integer[] X){//X representa el heap
        Integer[] Y=new Integer[X.length];//Array ordenado resultante
        int current, maxChildIndex;
        boolean hecho;
        for(int i=X.length-1; i>=0; i--){
            Y[i]=X[0];//consignamos la raiz del heap en el nuevo array ordenado
            X[0]=X[i];
            current=0;
            hecho=false;
            while(!hecho){
                if(2*current+1 > i)//aplicando la logica de la restriccion estructural: 0,1,2,...N-1
                    hecho=true;
                else{//si el nodo actual tiene al menos un hijo
                    maxChildIndex=HeapSortMaxChild(X, current, i);
                    if(X[current]<X[maxChildIndex])//si el nodo padre es mas pequeño que alguno de los hijos
                    {   intercambio(X,current,maxChildIndex);
                        current=maxChildIndex;                        
                    }else
                        hecho=true;                    
                }                
            }//end while
        }//end for
        return Y;
    }
    
    public Integer[] CallQuickSort(){
        Integer[] X=getY().clone();
        return QuickSort(X,0, X.length - 1);
    }
    
    private Integer[] QuickSort(Integer[] X, int start,int end){
        if(start<end){
            int pIndex=QuickSortPartition(X,start,end);
            QuickSort(X, start, pIndex - 1 );
            QuickSort(X, pIndex + 1, end);
        }
        return X;
    }
    private int QuickSortPartition(Integer[] X, int start,int end){
        int pivot=X[end];
        int pIndex=start;
        for(int i=start;i<end;i++){
            if(X[i]<=pivot){
                intercambio(X,i,pIndex);
                pIndex++;
            }//end if
        }//end for
        intercambio(X,pIndex,end);
        return pIndex;
    }
    
    public Integer[] CallMergeSort(){
        Integer[] X=getY().clone();
        return MergeSort(X);
    }
    private Integer[] MergeSort(Integer[] X){
        int n=X.length;
        if(n<2) return X;
        int mid=n/2;
        Integer[] left=new Integer[mid];
        Integer[] right=new Integer[n - mid];
        for(int i=0;i<mid;i++)
            left[i]=X[i];
        for(int i=mid;i<n;i++)
            right[i - mid]=X[i];
        MergeSort(left);
        MergeSort(right);
        Merge(X,left,right);
        return X;        
    }
    private void Merge(Integer[] X,Integer[] left,Integer[] right){
        int nL=left.length;
        int nR=right.length;
        int i=0,j=0,k=0;
        while(i<nL && j<nR){
            if(left[i]<=right[j]){
                X[k]=left[i];
                i++;
            }else{
                X[k]=right[j];
                j++;
            }
            k++;               
        }
        while(i<nL){
            X[k]=left[i];
            i++;
            k++;
        }
        while(j<nR){
            X[k]=right[j];
            j++;
            k++;
        }
    }
}
