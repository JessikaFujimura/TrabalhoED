
public class Principal {

	public static void main(String[] args) {
		Fila aprovados = new Fila();
		
		Candidato cand1 = new Candidato("Fulano" , 1, 10);
		Candidato cand2 = new Candidato("Ciclano" , 2, 30);
		Candidato cand3 = new Candidato("Beltrano" , 10, 40);
		Candidato cand4 = new Candidato("Dilano" , 20, 20);
		
		
		aprovados.enfileira(cand1);
		aprovados.enfileira(cand2);
		aprovados.enfileira(cand3);
		aprovados.enfileira(cand4);
		
		
	
	}

}
