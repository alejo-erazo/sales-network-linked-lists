package listasEnlazadasVendedores;

public class ListaVendedores {
	
	NodoVendedor head;
	float porcentajeComision;
	float porcentajeDescuentoInicial;
	int tamanio;
	float valorInicial;
	
	
	
	public ListaVendedores(float porcentajeComision, float porcentajeDescuentoInicial, float valorInicial) {
		super();
		this.porcentajeComision = porcentajeComision;
		this.porcentajeDescuentoInicial = porcentajeDescuentoInicial;
		this.valorInicial = valorInicial;
	}

	public void agregar (Vendedor vendedor) {
		NodoVendedor nuevoValor = new NodoVendedor();
		vendedor.balance=valorInicial-((valorInicial*porcentajeDescuentoInicial)/100);
		nuevoValor.valor= vendedor;
		
		if (head== null) {
			head= nuevoValor;
		}
		else {
			NodoVendedor tmp= head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			
			
			tmp.next= nuevoValor;
		}
		tamanio ++;
		
	}
	
	public void listar() {
		NodoVendedor tmp= head;
		while (tmp.next != null) {
			System.out.println(tmp.valor.balance);
			tmp = tmp.next;
		}
		System.out.println(tmp.valor.balance);
	}
	
	public void obtenerBalance() {
		NodoVendedor tmp= head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		auxiliar(tamanio -1, tmp.valor.balance);;
	}
	
	public void auxiliar(int i, float valor) {
		if (i>1) {
			NodoVendedor tmp= head;
			int j= 0;
			while(j<i-2) {
				tmp= tmp.next;
				j++;
			}
			
			if (i<tamanio-1) {
				tmp.valor.balance = tmp.valor.balance + ((valor*porcentajeComision)/100) + 
						((tmp.next.valor.balance*porcentajeComision)/100);
			}
			
			else {
				tmp.next.valor.balance = tmp.next.valor.balance +  ((valor*porcentajeComision)/100);
				tmp.valor.balance = tmp.valor.balance + ((valor*porcentajeComision)/100) + ((tmp.next.valor.balance*porcentajeComision)/100);
			}
			
			auxiliar(i-1,tmp.next.valor.balance );
		}
		}
	public void obtenerTotal () {
		float total=0;
		NodoVendedor tmp= head;
		while (tmp.next != null) {
			total= total + tmp.valor.balance;
			tmp = tmp.next;
		}
		total=total + tmp.valor.balance;
		System.out.println("el balance total de la red es de: " + total);
	}
	
	public void obtenerMenor() {
	
		NodoVendedor tmp= head;
		Vendedor menor= tmp.valor;
		while (tmp.next != null) {
			if(menor.balance > tmp.valor.balance) {
				
				menor= tmp.valor;
			}
		
			tmp = tmp.next;
		}
		
		if(menor.balance > tmp.valor.balance) {
			
			menor= tmp.valor;
		}
		
		System.out.println("el asesor con menor balance es: " + menor.nombre + "con un valor de: " + menor.balance);
	}
	
	public void obtenerMayor() {
		
		NodoVendedor tmp= head;
		Vendedor mayor= tmp.valor;
		while (tmp.next != null) {
			if(mayor.balance < tmp.valor.balance) {
				
				mayor= tmp.valor;
			}
		
			tmp = tmp.next;
		}
		
		if(mayor.balance < tmp.valor.balance) {
			
			mayor= tmp.valor;
		}
		
		System.out.println("el asesor con menor balance es: " + mayor.nombre + "con un valor de: " + mayor.balance);
	}
	
	}



