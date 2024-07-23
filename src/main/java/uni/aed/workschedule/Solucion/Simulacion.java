package uni.aed.workschedule.Solucion;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Simulacion {    
    private static final int  N_PRIORIDAD = 5;
    private static final char  STATUS_PENDIENTE = 'P';
    private static final char  STATUS_EJECUCION = 'E';
    private static final char  STATUS_FINALIZADO = 'F';
    //Variable de los minutos que deseamos simular
    private Integer Minutos;    
    // Variable que define el número de trabajos concurrentes que puede manejar la computadora
    private Integer NumTrabajosCon;    
    private int trabajosEjecucion=0;
    // Variable que servirá para definir el tiempo de espera maximo obtenido para cada prioridad
    private int[] tiempoEsperaMaximoPorPrioridad = {-1, -1, -1, -1, -1};       
    private double[] tiempoEsperaPromedioPorPrioridad = {0, 0, 0, 0, 0};       
    private int[] ntrabajosPorPrioridad = {0, 0, 0, 0,0};       
    List<Trabajo> trabajosCreados;           
    //constructor que permite almacenar los parámetros esenciales para la simulación
    public Simulacion (Integer Minutos, Integer NumTrabajosCon){
        this.Minutos = Minutos;
        this.NumTrabajosCon = NumTrabajosCon;                        
    }
    
    public void comenzarSimulacion(){        
        trabajosCreados=new LinkedList<>();          
        Trabajo trabajoAsignado=null;                
        // Cola de prioridad que se encargará de organizar los nuevos trabajos que lleguen
        PriorityQueue<Trabajo> colaPrioridad = new PriorityQueue<>(new ComparadorPrioridad());
        
        for(int minuto = 0; minuto < Minutos; minuto++){
            // Define el nuevo trabajo generado y se le asigna a la cola de prioridad
            Trabajo nuevoTrabajo = new Trabajo(generarPrioridad(), generarTiempoEjecucion(), minuto,0);
            trabajosCreados.add(nuevoTrabajo);        
            //coloca en cola el nuevoTrabajo
            colaPrioridad.offer(nuevoTrabajo);      
            
            if(trabajosEjecucion<=NumTrabajosCon)
            {
                // Se toma al siguiente trabajo proximo a realizarse como trabajoAsignado
                trabajoAsignado = colaPrioridad.poll();
                // Se añade al arreglo de trabajosEjecución mediante el índice anteriormente definido
                trabajosCreados.get(trabajoAsignado.getTiempoLlegada()).setEstado(STATUS_EJECUCION);                                     
            }
            
            // Se calcula el tiempo de espera del nuevo trabajo como la diferencia del tiempo actual menos el tiempo en el que llegó
            trabajosEjecucion=0;
            for(Trabajo t:trabajosCreados){                 
                switch(t.getEstado()){
                    case(STATUS_PENDIENTE)->{
                        t.setTiempoEspera(t.getTiempoEspera()+1);    
                        break;
                    }
                    case(STATUS_EJECUCION)->{
                        t.setTiempoEjecucion(t.getTiempoEjecucion()-1); 
                        trabajosEjecucion++;
                        if(t.getTiempoEjecucion()<=0)
                            trabajosCreados.get(t.getTiempoLlegada()).setEstado(STATUS_FINALIZADO);                                                                                                                
                        break;
                    }                    
                    case(STATUS_FINALIZADO)->{                        
                        if(t.getTiempoEjecucion()>0)
                            t.setTiempoEjecucion(t.getTiempoEjecucion()-1);                        
                        break;
                    }    
                }
                
            }         
        }
    }
    
    public void obtenerTiempoEsperaGeneral(){
        double tiempoEsperaGeneral=0.00;        
        for(Trabajo t:trabajosCreados){ 
            if(t.getTiempoEspera()==0) continue;
            tiempoEsperaGeneral+=t.getTiempoEspera();
        }
        System.out.println("Tiempo de espera promedio general: " + tiempoEsperaGeneral/Minutos);
    }
    
    public void obtenerTiempoEsperaMaximoPrioridad(){
        System.out.println("Tiempo de espera maximo por prioridad:");
        for(Trabajo t:trabajosCreados)
            tiempoEsperaMaximoPorPrioridad[t.getPrioridad()-1] = Math.max(tiempoEsperaMaximoPorPrioridad[t.getPrioridad()-1], t.getTiempoEspera());
        
        for (int i = 0; i < N_PRIORIDAD; i++){
            if(tiempoEsperaMaximoPorPrioridad[i]==-1) continue;
            System.out.println("Prioridad " + (i+1) + ": " + tiempoEsperaMaximoPorPrioridad[i]);
        }
    }
    
    public void obtenerTiempoEsperaPromedioPrioridad(){        
        DecimalFormat df=new DecimalFormat("#.##");
        System.out.println("Tiempo de espera promedio por prioridad:");
        for(Trabajo t:trabajosCreados){
            tiempoEsperaPromedioPorPrioridad[t.getPrioridad()-1] += t.getTiempoEspera();
            ntrabajosPorPrioridad[t.getPrioridad()-1]++;
        }
        
        for (int i = 0; i < N_PRIORIDAD; i++){
            if(ntrabajosPorPrioridad[i]==0) continue;
            System.out.println("Prioridad " + (i+1) + ": " + df.format(tiempoEsperaPromedioPorPrioridad[i]/ntrabajosPorPrioridad[i]));
        }
    }
    
    public void mostrar(){
        System.out.println("Mostrando todos los Trabajos Creados");
        for(Trabajo t:trabajosCreados){ 
            System.out.println(t.toString()+"\n");
        }       
    }
    
    private Integer generarPrioridad(){
        return new Random().nextInt(N_PRIORIDAD) + 1;
    }
    
    private Integer generarTiempoEjecucion(){        
        return new Random().nextInt(Minutos) + 1;
        
    }
}
