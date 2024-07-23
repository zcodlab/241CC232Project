package uni.aed.workschedule.Solucion;

// Clase trabajo en el que se almacenan los distintos datos junto con su prioridad, el tiempo que tiene de ejecución y su tiempo de llegada a la computadora
// Contara con las típicas funciones constructora, getters, setters y toString para su visualización
class Trabajo{
	private int prioridad;
        private int tiempoEjecIni;
	private int tiempoEjecucion;
	private int tiempoLlegada;
        private int tiempoEspera;   
        private char estado='P';   //{E:Ejecucion,F:Finalizado,P:Pendiente}   
	
	public Trabajo(int prioridad, int tiempoEjecIni, int tiempoLlegada, int tiempoEspera) {
		this.prioridad = prioridad;
		this.tiempoEjecIni = tiempoEjecIni;
                this.tiempoEjecucion = tiempoEjecIni;
		this.tiempoLlegada = tiempoLlegada;
                this.tiempoEspera = tiempoEspera;
	}    
	
	public int getPrioridad() {
		return prioridad;
	}
	
	public int getTiempoEjecucion() {
		return tiempoEjecucion;
	}
	
	public void setTiempoEjecucion(int tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	
	public int getTiempoLlegada() {
		return tiempoLlegada;
	}
	
	public void setTiempoLlegada(int tiempoLlegada) {
		this.tiempoLlegada = tiempoLlegada;
	}
        
        public int getTiempoEspera() {
            return tiempoEspera;
        }

        public void setTiempoEspera(int tiempoEspera) {
            this.tiempoEspera = tiempoEspera;
        }

        public void setEstado(char estado) {
            this.estado = estado;
        }

        public char getEstado() {
            return estado;
        }
        
        
        @Override
        public String toString() {
            return "Trabajo{T"+tiempoLlegada+ ", Estado=(" + estado + "), prioridad=" + prioridad 
                    + ", TEjecIni=" + tiempoEjecIni
                    + ", tiempoEjecucion=" + tiempoEjecucion 
                    + ", tiempoLlegada=" + tiempoLlegada + ", tiempoEspera=" + tiempoEspera + "}";
        }
}
	