import java.util.Random;
public class Dev {
    static int id_count=1;
    static int[] psize = {64, 128, 256, 512};
    static Ram ram = new Ram();


    public static void main(String[] args) {

        //Crea cola de procesos
        ColaProcesos l = new ColaProcesos();
    
        //Crea procesos (aun no valida memoria)
        validarCrear(l,"word");
        validarCrear(l,"exe");
        validarCrear(l,"uwu");
        validarCrear(l,"owo");
        validarCrear(l,"ewe");
        validarCrear(l,"iwi");
        validarCrear(l,"AwA");
        validarCrear(l,"aa");
        validarCrear(l,"aaa");
        validarCrear(l,"aaaa");
        validarCrear(l,"aaaaaa");

        ram.imprimirRam();

        l.del_first_node(ram);

        ram.imprimirRam();

        

        

    
    }

    public static void validarCrear(ColaProcesos l, String nombre){
        Pnode a = new Pnode();
        a.crearProceso(id_count, psize, nombre, ram);
        id_count++;
        l.add_fin(a);
        a.getThread().run();
    }

    public static int asignaEspacio(){
        return 1;
    }

}