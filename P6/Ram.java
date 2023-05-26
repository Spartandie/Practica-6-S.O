
class Ram {
    
    private int contents;
    private boolean hay_contenido = false;
    public synchronized int get() {
      while (hay_contenido == false) {//hay algo que pueda tomar?
        System.out.println("no pude tomar");
          try {
            wait();
         }
         catch (InterruptedException e) {
         }
      }
        System.out.println("Pude tomar");
      hay_contenido = false;
      notifyAll();
      return contents;
   }
   
    public synchronized void put(int value) {
        while (hay_contenido == true) {//no hay nada adentro?
        try {
            wait();
        }
        catch (InterruptedException e) { 
        } 
      }
      contents = value;
      hay_contenido = true;
      notifyAll();
   }
}
