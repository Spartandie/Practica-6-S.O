import java.util.Scanner;
import java.io.IOException;

public class Ram{
	static Scanner in = new Scanner(System.in);
	static String option;
	static int[] ram = new int[1024];
	static int espacio_disponible=ram.length;
	static int psize;

	/*
		si se crea y se guarda un proceso 
		entonces espacio_disponible=espacio_disponible-psize

		si se elimina un proceso
		entonces espacio_disponible=espacio_disponible+psize;
	*/

	public void guardarProceso(ColaProcesos l, Pnode proceso){
	
		if (validar(proceso) == true){
			//hay espacio;
			System.out.println("--------------Proceso "+proceso.getPid()+"------------");
			System.out.println("Ram disponible: "+espacio_disponible);
			System.out.println("Tamaño: "+proceso.getSize());
			System.out.println("Sí hay espacio en RAM");
			System.out.print("Resta: "+espacio_disponible+"-"+proceso.getSize());
			System.out.println(" = "+(espacio_disponible-proceso.getSize()));
			l.add_fin(proceso);
			guardardeadebis_ahorasifinal(proceso);
		}
		else{
			do{
				System.out.println("NO hay espacio en RAM ("+espacio_disponible+")");
				System.out.println("Tamaño de proceso:"+proceso.getSize());
				System.out.println("1.-Ejecutar actual\n2.-Matar actual\n3.-Pasar a siguiente");
				System.out.print("==> ");
				option = in.nextLine();

				switch(option){
				case "1":
					//1.-Debe terminar su ejecucion completamente
					//2.-Tamaño de proceso eliminado debe ser mayor o igual al
					//proceso que queremos meter
					psize=l.correrActual(this);
					break;
				case "2":
					//l.del_first_node(this);
					System.out.println("2");
					break;
				case "3":
					//l.sendCurrentToTail();
					System.out.println("3");
					break;
				default:
					
					System.out.println("Opción no valida");
					break;
				}

				if(psize>=proceso.getSize()){
					l.add_fin(proceso);
					guardardeadebis_ahorasifinal(proceso);
					break;
				}

			}while(!option.equals("1") || !option.equals("2") || !option.equals("3"));
			
			System.out.println("se guardo:)"+espacio_disponible+")");
			//l.add_fin(proceso);
			//guardardeadebis_ahorasifinal(proceso);

			System.out.println("Tamaño: "+proceso.getSize());
			//no hay;
			//menu;
		}
	}


	public static Boolean validar(Pnode proceso){

		if (proceso.getSize()<=espacio_disponible){
			return true;
		}

		return false;

	}

	public static void guardardeadebis_ahorasifinal(Pnode proceso){
		//secuencial
		int count = 0;
		for (int i = 0;i<ram.length; i++){
			if (ram[i]==0){
					if(count<proceso.getSize())
					{
						ram[i] = proceso.getPid();
						count++;
					}
					
			}

		}
		espacio_disponible=espacio_disponible-proceso.getSize();

	}

	public static void borrarProceso(Pnode proceso){
		for (int i = 0; i<ram.length;i++ ) {
			if(proceso.getPid()==ram[i]){
				ram[i]=0;
			}
		}
		espacio_disponible=espacio_disponible+proceso.getSize();
		System.out.println("Proceso "+proceso.getPid()+" eliminado con éxito");
	}

	public static void imprimirRam(){
		System.out.println("-------------RAM (localidades) -------");
		System.out.println("N° localidades disponibles: "+espacio_disponible);
		for (int i = 0;i<ram.length ; i++){
			if (ram[i]!=0){
				System.out.print("Localidad "+i+" tiene el proceso: ");
				System.out.println(ram[i]);
			}
			else {
				System.out.println("Localidad "+i+" vacia");
			}
		}
	}



}




