public class ColaProcesos{
    
    private Pnode head;
    private Pnode tail;
    
    private int size=0;

    public ColaProcesos() {
        this.head=null;
        this.tail=null;
    }

    /*
    //@Override
    public ColaProcesos(Pnode head, Pnode tail) {
        this.head = head;
        this.tail = tail;
    }*/


    public boolean correrActual(){
        if(is_empty())
        {
            return false;
        }

        this.head.correrProceso();

        return true;
    }

    /**
     * 
     * @return  head es el head de la lista 
     */
    public Pnode getHead() {
        return head;
    }
    /**
     * 
     * @return tail es el tail de la lista
     */
    public Pnode getTail() {
        return tail;
    }
    
    public int getSize(){
        return this.size;
    }

    /*
    /**
     * 
     * @param head es el head de la lista 
     */
    /*
    public void setHead(Pnode head) {
        this.head = head;
    }*/

    /*
    /**
     * 
     * @param tail es el tail de la lista
     */
    /*
    public void setTail(Pnode tail) {
        this.tail = tail;
    }*/
    
     
    /**
     * Añadir al final
     * @param l es la lista
     * @param n es el nodo
     * @return retorna un boolean
     */
    public boolean add_fin(Pnode n){
        if(this.head==null){
            this.head=n;
            this.tail=n;
            n.setPrev(n);
            n.setNext(n);
            return true;
        }
        this.head.setPrev(n);
        this.tail.setNext(n);
        n.setNext(this.head);
        n.setPrev(this.tail);
        this.tail=n;

        size++;
        
        return true;
    }

    public boolean print_actual(){
        if(is_empty())
        {
            return false;
        }

        System.out.println("\n-------------------Proceso Actual----------------------\n");

        /*
        Nombre
        id
        Instrucciones totales
        Instrucciones ejecutadas
        Direacciones de memoria asignadas
        Tabla de páginas
        */

        System.out.println("Nombre: "+this.head.getThread().getName());
        System.out.println("Pid: "+this.head.getPid());
        System.out.println("Instrucciones totales: "+this.head.getTotalInstructions());

        return true;


    }   

    /**
     * Funcion para imprimir la lista completa
     * @param l es la lista
     * @return boolean
     */
    public boolean print_list(){
        if(is_empty())
        {
            return false;
        }

        Pnode t = new Pnode();
        
        System.out.println("\n------------------- IMPRIMIENDO COLA DE PROCESOS ----------------------\n");
        
        for(t=this.head; t!=this.tail; t=t.getNext()){
            System.out.print("Proceso "+t.getPid()+" \""+t.getThread().getName()+"\"");
            System.out.println(" Size: "+t.getSize());
            System.out.println("");
             
        }
        System.out.print("Proceso "+t.getPid()+" \""+t.getThread().getName()+"\"");
        System.out.println(" Size: "+t.getSize());
        System.out.println("");
        System.out.println("\n-------------------------------------------------------------\n");
        return true;
    }

    
    
    /**
     * Funcion para ver si la lista esta vacia
     * @param l es la lista
     * @return  boolean
     */
    public boolean is_empty(){
        if(this.head==null && this.tail==null){
            System.out.println("Cola vacia");
            return true;
        }
        return false;
    }
   
    /**
     * Funcion para borrar lista
     * @param l es la lista
     * 
     */
    public void del_list(){
        
        
        this.head=null;
        this.tail=null;
        
    }

    /**
     * Elimina el primer nodo
     * @param l es la lista
     */
    public boolean del_first_node(Ram ram){

        if(is_empty())
        {
            return false;
        }

        //Borra proceso de ram
        ram.borrarProceso(this.head);

        //Borra el proceso de la cola
        if(this.head!=this.tail)
        {
            this.tail.setNext(this.head.getNext());
            this.head.setPrev(null);
            this.head.getNext().setPrev(this.tail);
            this.head.setNext(null);
            this.head=this.tail.getNext();
        }
        else{
            this.head.setPrev(null);
            this.head.setNext(null);
            this.head=null;
            this.tail=null;
            
        }

        size--;

        return true;
        
    }

    /*
    /**
     * Elimina el ultimo nodo
     * @param l es la lista
     */
    /*
    public void del_last_node(){
        if(this.head!=this.tail){
            this.head.setPrev(this.tail.getPrev());
            this.tail.getPrev().setNext(this.head);
            this.tail.setPrev(null);
            this.tail.setNext(null);
            this.tail=this.head.getPrev();
        }
        else{
            this.tail.setPrev(null);
            this.tail.setNext(null);
            this.head=null;
            this.tail=null;
        }
    }*/


    public void sendCurrentToTail(){
        if(this.head!=this.tail){
            this.head=this.head.getNext();
            this.tail=this.tail.getNext();
            //this.head.setNext(this.)
            //this.tail.setPrev(this.head.getNext())

        }
    }



    
}


