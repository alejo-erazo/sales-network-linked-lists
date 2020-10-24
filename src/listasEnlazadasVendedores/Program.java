package listasEnlazadasVendedores;

public class Program {

	public static void main(String[] args) {
		
		Vendedor  v1= new Vendedor("Juan");
		
		Vendedor  v2= new Vendedor("pedro");
		
		Vendedor  v3= new Vendedor("luis");
		
		Vendedor  v4= new Vendedor("carlos");
	
		
		ListaVendedores lista= new ListaVendedores(25, 10, 1000);
		lista.agregar(v1);
		lista.agregar(v2);
		lista.agregar(v3);
		lista.agregar(v4);
		
		lista.obtenerBalance();
		
		lista.obtenerTotal();
		
		lista.obtenerMenor();
		
		lista.obtenerMayor();
		
		lista.listar();
		
		

}
}