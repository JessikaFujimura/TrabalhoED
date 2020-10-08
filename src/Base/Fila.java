package Base;

public class Fila<T> extends EstruturaEstatica<T> {
	
	public Fila(){
		this(10);
	}
	
	public Fila(int capacidade){
		super(capacidade);
	}

	
	public void enfileira(T elemento){
		super.adiciona(elemento);
	}
	

	public T topo(){
		return super.estaVazia() ? null : this.elementos[0];
	}
	
	public T desinfileira(){
		if(this.estaVazia()){
			return null;
		}
		T elementoRemovido = this.elementos[0];
		
		this.remove(0);
		
		return elementoRemovido;
	}
}
