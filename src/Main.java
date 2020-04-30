import java.util.*;
//%.0f

public class Main{


	public static void main(String[] args) {
		double[] listaSalarios; 
		int numeroEmpleados; 
		double salarioInicial;
		double[] salariosConDescuentos;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingresa el numero de empleados: ");
		numeroEmpleados = entrada.nextInt();
		System.out.println("Ingresa el salario inicial: ");
		salarioInicial = entrada.nextDouble();
		System.out.println(numeroEmpleados);
		System.out.println(salarioInicial);
		listaSalarios = crearSalarios(numeroEmpleados, salarioInicial);
		netoAPagar(listaSalarios);
		entrada.close();
	}
	
	static double[] crearSalarios(int numeroEmpleados, double salarioInicial) {
		double salarioActual;
		salarioActual = salarioInicial;
		double[] listaSalarios = new double[numeroEmpleados];
		for (int i=0; i<numeroEmpleados; i++) {
			listaSalarios[i] = salarioActual;
			salarioActual += salarioActual * 0.1;
			System.out.printf("Salario empleado %s: %.2f\n", i+1, listaSalarios[i]);
		}
		return listaSalarios;
	}
	
	static void netoAPagar(double[] listaSalarios){
		double[][] listaConDescuentos;
		double salud = -0.04;
		double pension = -0.04;
		double reteFuente = -0.14; 
		listaConDescuentos = new double[listaSalarios.length][4];
		for (int i=0; i<listaSalarios.length; i++) {
			double[] listaTemporal = new double[4];
			listaTemporal[0] = listaSalarios[i];
			listaTemporal[1] = listaSalarios[i] * salud; 
			listaTemporal[2] = listaSalarios[i] * pension;
			listaTemporal[3] = listaSalarios[i] * reteFuente;
			listaConDescuentos[i] = listaTemporal; 
			System.out.println();
			System.out.println();
			double aPagarEmpleado = listaTemporal[0]+listaTemporal[1]+listaTemporal[2]+listaTemporal[3];
			System.out.println("El total a pagar para el empleado " + (i+1) + " es: " + aPagarEmpleado);
			System.out.printf("Salario Inicial: %.2f ", listaConDescuentos[i][0]);
			System.out.printf("Pensión: %.2f ", listaConDescuentos[i][1]);
			System.out.printf("Salud: %.2f ", listaConDescuentos[i][2]);
			System.out.printf("Retención en la fuente: %.2f ", listaConDescuentos[i][3]);
		}
	}
}