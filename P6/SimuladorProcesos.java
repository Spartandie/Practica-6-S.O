import java.util.Scanner;
import java.io.IOException;


public class SimuladorProcesos{     
	static Scanner in = new Scanner(System.in);
	static String option;

	static int id_count=0;
    //static int[] id_list;

    //Cola colaProcesos;
    //static ColaProcesos cola;
    //RAM ram;
    //Lista listaLocalidades;
    //Lista ffList;
    public static void main(String[] args) {

    	//ColaProcesos cola = ColaProcesos.crearCola();
       

   		limpiarPantalla();

        do{
            System.out.println("Elija una opción:\n1.-Crear Proceso nuevo\n2.-Ver estado actual del sistema");
            System.out.println("3.-Ver estado de la memoria\n4.-Imprimir cola de procesos\n5.-Ver proceso actual");
            System.out.println("6.-Ejecutar proceso actual\n7.-Pasar al proceso siguiente\n8.-Matar proceso actual");
            System.out.print("9.-Desfragmentar memoria\n10.Devmode\n11.Salir\n==>");
            option = in.nextLine();
            //limpiarPantalla();
            switch (option) {
                case "1":
                	System.out.println("----------------Crear Proceso nuevo----------------------");
        			String nombre;
        			System.out.print("Nombre del proceso: ");
        			option = in.nextLine();
                    validarCrear(option);
                    break;
                case "2":
                    estadoProcesos();
                    break;
                case "3":
                    estadoMemoria();
                    break;
                case "4":
                    imprimirCola();
                    break;
                case "5":
                    verActual();
                    break;
                case "6":
                    ejecutarActual();
                    break;
                case "7":
                    pasarSiguiente();
                    break;
                case "8":
                    matarActual();
                    break;

                case "9":
                    desfragmentarMemoria();
                    break;    

                case "10":
                    //Aquí va cualquier cosa que queramos testear
                    //for(int i = 0;i<id_count;i++){
                    	//System.out.println("Elemento #"+id_count+"de id_list: "+id_list[id_count]);
                    //} 
                    break;    

                case "11":
                    salir();
                    break;  

                default:
                    System.out.println("Opción no válida");
                    break;  
            }
        }while (!option.equals("11"));
    }

    public static void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void validarCrear(String nombre){
    	//asignarEspacio();
    	//comprobarEspacio();
    	//id_list[id_count]=id_count;
        MiProceso proceso = MiProceso.crearProceso(id_count, nombre);
        id_count++;
        //cola.addToQueue(proceso);


        //try{
            //proceso.hilo.join();
        //}
        //catch (InterruptedException exc){
        	//exc.getMessage();
        //}
        //System.out.println("uwu");
    }

    public static void estadoProcesos(){
    	System.out.println("Ver estado de los procesos");
    }

    public static void estadoMemoria(){
    	System.out.println("Ver estado de la memoria");
    }

    public static void imprimirCola(){
    	System.out.println("Imprimir cola de procesos");
    }


    public static void verActual(){
    	System.out.println("Ver proceso actual");
    	//cola.acutal();
    }


    public static void ejecutarActual(){
    	System.out.println("Ejecutar proceso actual");
    	//cola.runFirst;

    }


    public static void pasarSiguiente(){
    	System.out.println("Pasar al proceso siguiente");
    }

    public static void matarActual(){
    	System.out.println("Matar proceso actual");
    }

    public static void desfragmentarMemoria(){
    	System.out.println("desfragmentarRAM");
    }

    public static void salir(){
    	System.out.println("Salir del programa");
    	System.out.println("Presiona enter para salir");
    	limpiarPantalla();
    	//option = in.nextLine();
    }


}


