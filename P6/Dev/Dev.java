public class Dev {
    static int id_count=0;
    
    public static void main(String[] args) {
    
        //Crea cola de procesos
        ColaProcesos l = new ColaProcesos();
    
        //Crea procesos (aun no valida memoria)
        validarCrear(l,"word");
        validarCrear(l,"exe");
        validarCrear(l,"uwu");
        validarCrear(l,"owo");
    
    
        //Imprime colad de procesos
        if(l.print_list()){
            System.out.println("NO Esta vacia");
        }
        else{
            System.out.println("Esta vacia");
        }

        /*
            Cola se ve así
            <-word->exe->uwu->owo->
        */
        l.correrActual();//corre word
        l.sendCurrentToTail();//mandamos a word al final

        /*
            Cola se ve así
            <-exe->uwu->owo->word->
        */

        l.correrActual();//corre exe
        l.correrActual();//corre exe de nuevo
        l.sendCurrentToTail();//mandamos a exe al final

        /*
            Cola se ve así
            <-uwu->owo->word->exe->
        */

        l.correrActual();//corre uwu
        l.sendCurrentToTail();//mandamos uwu al final

        /*
            Cola se ve así
            <-owo->word->exe->uwu->
        */

        l.correrActual();//corre owo
        l.del_first_node();//se elimina owo

        /*
            Cola se ve así
            <-word->exe->uwu->
        */

        l.correrActual();//corre word

        l.sendCurrentToTail();
        
        /*
            Cola se ve así
            <-exe->uwu->word->
        */

        l.print_list();//imprime lista
        
    
    }

    public static void validarCrear(ColaProcesos l, String nombre){
        Pnode a = new Pnode();
        a.crearProceso(id_count,nombre);
        id_count++;
        l.add_fin(a);
        a.getThread().run();
    }



}