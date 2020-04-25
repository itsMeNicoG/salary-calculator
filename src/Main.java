import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el número de empleados: ");
		int numeroEmpleados = entrada.nextInt();
		Empleado listaEmpleados[] = new Empleado[numeroEmpleados];
		System.out.println("");
		System.out.print("Ingrese el salario (sin puntos ni comas): ");
		double salarioInicial = entrada.nextDouble();
		listaEmpleados = crearSalarios(numeroEmpleados, salarioInicial, listaEmpleados);
		for(int i=0; i<numeroEmpleados; i++) {
			System.out.println(listaEmpleados[i].salarioBase);
		}		
	}
	
	public static Empleado[] crearSalarios(int numeroEmpleados, double salarioInicial, Empleado listaEmpleados[]){
		
		// create employees Array 
		
		for(int i=0; i<numeroEmpleados; i++) {
			listaEmpleados[i] = new Empleado(salarioInicial);
			salarioInicial += salarioInicial * 0.1;
		}
		return listaEmpleados;
	}
	
	
}
