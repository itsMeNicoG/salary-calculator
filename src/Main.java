import java.util.*;

/* @Authors: 
 * 
 * Nicolás Góngora
 * Sergio Quintero 
 * 
 */

public class Main{


	public static void main(String[] args) {
		//iniciamos creando las variables necesarias para el programa
		
		double[] listaSalarios; 
		int numeroEmpleados = 0; 
		double salarioInicial = 0;
		double[][] salariosConDescuentos;
		boolean valido;
		boolean reiniciar;
		String deseaReiniciar; 
		
		//creamos el objeto scanner para recibir los datos ingresados
		
		do {
			reiniciar = true; 
			Scanner entrada = new Scanner(System.in);
			do {
				valido = true; 
				entrada = new Scanner(System.in);
				try{
					//validamos que sea un caracter numero
					System.out.println("Ingresa el numero de empleados: ");
					numeroEmpleados = entrada.nextInt();
				} catch(InputMismatchException e) {
					System.out.println("caracter no valido");
					valido = false; 
				}
				try{
					//validamos que sea un caracter numero	
					System.out.println("Ingresa el salario inicial: ");
					salarioInicial = entrada.nextDouble();
				} catch(InputMismatchException e) {
					System.out.println("caracter no valido");
					valido = false; 
				}
				//volvemos a solicitar los datos mientras estos no sean validos
			} while(!valido);
		   
			
			//usando los datos recibidos, llamamos a la función que crea los salarios iniciales (cada uno 10% mas que el anterior)
			listaSalarios = crearSalarios(numeroEmpleados, salarioInicial);
			//la función anterior nos retorna una lista de salarios sin descuentos la cual usamos para llamar a la función que calcula neto a pagar
			//esta funcion imprime el neto a pagar y retorna una matriz con datos
			salariosConDescuentos = netoAPagar(listaSalarios);
			//la función anterior regresa una matriz con los siguientes datos [[salario1, salud1, pension1, retefuente1],[salario2, salud2, pension2,... 
			//usamos la matriz retornada para llamar a la función que imprime todos los datos
			mostrarDatos(salariosConDescuentos);
			System.out.println("Desea continuar (si/no)");
			deseaReiniciar = entrada.next();
			if(deseaReiniciar.equals("si")) {
				reiniciar = true; 
			} else {
				reiniciar = false; 
				System.out.println("Programa finalizado");
			}
			//reiniciamos el programa si el cliente lo desea
		} while (reiniciar);
	}
	
	
	static double[] crearSalarios(int numeroEmpleados, double salarioInicial) {
		double salarioActual;
		salarioActual = salarioInicial;
		double[] listaSalarios = new double[numeroEmpleados];
		for (int i=0; i<numeroEmpleados; i++) {
			listaSalarios[i] = salarioActual;
			//le agregamos 10% al salario anterior para crear el siguiente y los guardamos en un array 
			salarioActual += salarioActual * 0.1;
			
				
			System.out.printf("Salario básico empleado %s: %.2f\n", i+1, listaSalarios[i]);
		
			}
		return listaSalarios;
	}
	
	static double[][] netoAPagar(double[] listaSalarios){
		double[][] listaConDescuentos;
		//definimos los descuentos por salud, pension y retefuente
		double salud = -0.04;
		double pension = -0.04;
		double reteFuente = -0.14; 
		listaConDescuentos = new double[listaSalarios.length][4];
		//para cada empleado, le restamos los descuentos al salario inicial y guardamos los datos en una matriz 
		for (int i=0; i<listaSalarios.length; i++) {
			double[] listaTemporal = new double[4];
			listaTemporal[0] = listaSalarios[i];
			listaTemporal[1] = listaSalarios[i] * salud; 
			listaTemporal[2] = listaSalarios[i] * pension;
			listaTemporal[3] = listaSalarios[i] * reteFuente;
			listaConDescuentos[i] = listaTemporal; 
			System.out.println();
			System.out.println();
			//imprimimos total a pagar
			double aPagarEmpleado = listaTemporal[0]+listaTemporal[1]+listaTemporal[2]+listaTemporal[3];
			System.out.printf("El total a pagar para el empleado %o es: %.2f", i+1, aPagarEmpleado);
			System.out.println();
		}
		System.out.println();
		System.out.println();
		return listaConDescuentos;
	}
	
	static void mostrarDatos(double[][] listaConDescuentos) {
		//usando la matriz que retorna la función anterior, podemos usar este ciclo for para imprimir todos los datos
		for (int i=0; i<listaConDescuentos.length; i++) {
			double aPagarEmpleado = listaConDescuentos[i][0]+listaConDescuentos[i][1]+listaConDescuentos[i][2]+listaConDescuentos[i][3];
			
			System.out.printf("El total a pagar para el empleado %o es: %.2f", i+1, aPagarEmpleado);
			System.out.println();
			System.out.printf("Salario Inicial: %.2f ", listaConDescuentos[i][0]);
			System.out.println();
			System.out.printf("Pensión %s: %.2f ", "-4%",listaConDescuentos[i][1]);
			System.out.println();
			System.out.printf("Salud %s: %.2f ", "-4%",listaConDescuentos[i][2]);
			System.out.println();
			System.out.printf("Retención en la fuente %s: %.2f ", "-14%",listaConDescuentos[i][3]);
			System.out.println();
			System.out.println();		
		}
	}
	
	
	
	
}