public class ColaProcesos{
    
    private Pnode head;
    private Pnode tail;
    

    public ColaProcesos() {
        this.head=null;
        this.tail=null;
    }

    
    //@Override
    public ColaProcesos(Pnode head, Pnode tail) {
        this.head = head;
        this.tail = tail;
    }


    public void correrActual(){
        
        this.head.correrProceso();

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
   
    
    /**
     * 
     * @param head es el head de la lista 
     */
    public void setHead(Pnode head) {
        this.head = head;
    }
    /**
     * 
     * @param tail es el tail de la lista
     */
    public void setTail(Pnode tail) {
        this.tail = tail;
    }
    
     
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
            System.out.println(t.getPid());

            //System.out.println("Proceso #"+t.getPid()+""+t.getNombre());
            
            System.out.println("");
             
        }
        System.out.println(t.getPid());
        //System.out.println("Proceso #"+t.getPid()+""+t.getNombre());
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
            return true;
        }
        return false;
    }
   
    /**
     * Funcion para borrar lista
     * @param l es la lista
     * 
     */
    //@Override
    public void del_list(){
        
        
        this.head=null;
        this.tail=null;
        
    }

    /**
     * Elimina el primer nodo
     * @param l es la lista
     */
    public void del_first_node(){
        if(this.head!=this.tail)
        {
            this.tail.setNext(this.head.getNext());
            this.head.setPrev(null);
            this.head.getNext().setPrev(this.tail);
            this.head.setNext(null);
            this.head=this.tail.getNext();
        }
        else{
            //QUIZAS ESTE MAL
            this.head.setPrev(null);
            this.head.setNext(null);
            this.head=null;
            this.tail=null;
            
        }
        
    }


    /**
     * Elimina el ultimo nodo
     * @param l es la lista
     */
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
    }


    public void sendCurrentToTail(){
        if(this.head!=this.tail){
            this.head=this.head.getNext();
            this.tail=this.tail.getNext();
            //this.head.setNext(this.)
            //this.tail.setPrev(this.head.getNext())

        }
    }



    
}


