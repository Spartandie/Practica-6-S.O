import java.util.Random;

public class MiProceso implements Runnable{
    Thread hilo;
    int pid;
    static int numeroAleatorio;
    //int id;
    //Lista/Arreglo pageTable;
     

     public static MiProceso crearProceso(int pid, String nombre){
         MiProceso proceso = new MiProceso(pid,nombre);
         proceso.hilo.start();
         return proceso;
     }
     
     public MiProceso(int pid, String nombre){
         hilo= new Thread(this,nombre);
         this.pid=pid;
     }
     
    //Punto de entrada de hilo.
    @Override
     public void run(){
     	Random random = new Random();
		this.numeroAleatorio = random.nextInt(21) + 10; // Genera un número aleatorio entre 10 y 30 (ambos incluidos)

        System.out.println(hilo.getName()+" iniciado.");


    }

    public void ejecutarProceso(){
         for (int count=0; count<numeroAleatorio;count++){
            //for (int  r=1;r<5;r++ ) {
                System.out.println("Proceso #"+pid+" \""+hilo.getName()+"\" ejecuta su instruccion #"+(count+1));    
            //}
        }
        System.out.println(hilo.getName()+" terminado.");

     }
}