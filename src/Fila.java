
public class Fila {
	private Candidato[] cand;
	private int tamanho;
	
	
	
	public Fila(int capacidade) {
		this.cand = new Candidato[capacidade];
		this.tamanho = 0;
	}
	
	public Fila() {
		this(30);
	}

	protected void enfileira(Candidato cand){
		this.aumentaCapacidade();
		if(this.tamanho < this.cand.length){
			this.cand[this.tamanho] = cand;
			this.tamanho++;
		}
		System.out.println(cand + " entrou na lista de espera para ser analisado!");
	}
	
	
	protected void aumentaCapacidade(){
		if(this.tamanho == this.cand.length){
			Candidato[] candNovos = new Candidato[this.cand.length*2];
			for(int i=0; i <this.cand.length; i++){
				candNovos[i] = this.cand[i];
			}
			this.cand = candNovos;
		}
	}

	public boolean estaVazia(){
		return this.tamanho() == 0;
	}
	
	public int tamanho(){
		return this.tamanho;
	}
	
	public Candidato desinfileira(){
		if(estaVazia()){
			throw new IllegalArgumentException("Fila vazia");
		}
		Candidato elementoRemovido = this.cand[0];
		this.tamanho--;
		return elementoRemovido;
	}
	
	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=0; i<this.tamanho-1; i++){
			s.append(this.cand[i]);
			s.append(", ");
		}
		
		if (this.tamanho>0){
			s.append(this.cand[this.tamanho-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
}
