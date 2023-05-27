import java.util.Random;
/**
 * Objeto denominado Pnode (Process node) que sirve de nodo que conformara una Estructura e Datos de tipo
 * Lista Doblemente enlazada Circular, los nodos serviran para guardar la informacion
 * de nuestros productos.
 * @author spart
 */

public class Pnode implements Runnable{
    
    private int pid;
    private Pnode next, prev;
    private Thread hilo;
    private int size;
    private int numeroInstrucciones;
  
    
    /**
     * Contructor de Pnode
     */
    public Pnode(){
        this.next=null;
        this.prev=null; 
    }

    public void crearProceso(int pid, int[] psize, String nombre){
        this.pid=pid;

        Random random = new Random();
        int indiceA= random.nextInt(psize.length);
        this.size=psize[indiceA];
        hilo= new Thread(this,nombre);
        //hilo.run();
    }


    public boolean correrProceso(){

        for (int count=0; count<this.numeroInstrucciones;count++){
            //for (int  r=1;r<5;r++ ) {
                System.out.println("Proceso #"+pid+" \""+hilo.getName()+"\" ejecuta su instruccion #"+(count+1));    
            //}
        }
        System.out.println("Se terminó hilo #"+this.pid+" \""+this.hilo.getName()+"\"");

        return true;
    }


    @Override
    public void run(){
        Random random = new Random();
        this.numeroInstrucciones = random.nextInt(21) + 10; // Genera un número aleatorio entre 10 y 30 (ambos incluidos)

        System.out.println(hilo.getName()+" iniciado.");

    }


    public Thread getThread(){
        return this.hilo;
    }

    public int getSize(){
        return this.size;
    }
    

    /**
     * funcion de tipo get que regresa next.
     * @return next regresa la direccion del nodo que le sigue al nodo actual. 
     */
    public Pnode getNext() {
        return next;
    }

    /**
     * funcion de tipo get que regresa prev
     * @return prev regresa la direccion que esta antes de nuestro nodo actual.
     */
    public Pnode getPrev() {
        return prev;
    }

    

    /**
     * funcion de tipo get que regresa nombre.
     * @return nombre regresa el nombre de nuestro producto guardado en el nodo actual.
     */
    public int getPid() {
        return this.pid;
    }


    /**
     * funcion de tipo setter que se encarga de insertarle una nueva direccion a un nodo existente.
     * @param next es de tipo Pnode y guardara la direccion de un nuevo nodo que le sigue al 
     * nodo actual.
     */
    public void setNext(Pnode next) {
        this.next = next;
    }

    /**
     * funcion de tipo setter que se encargar de insertarle una nueva direccion a un nodo existente.
     * @param prev trae la direccion del nodo o del Null que esta antes del nodo actual.
     */
    public void setPrev(Pnode prev) {
        this.prev = prev;
    }

    

    /**
     * funcion de tipo setter que se encarga de insertarle la id del prodcuto a nuestro nodo.
     * @param id es la id del producto que almacena nuestro nodo.
     */
    public void setPid(int id) {
        this.pid = id;
    }

    /*
    /**
     * funcion dedicada a eleminar un nodo tipo proceso.
     * @param n es un nodo tipo procesos
     */
    /*
    public void remove_node(Pnode n){
        n.setPrev(null);
        n.setNext(null);
    }*/
}