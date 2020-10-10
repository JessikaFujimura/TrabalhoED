package EtapaAnalise;

public class Candidato {
	private String nome;
	private String sobrenome;
	private String email;
	private String lattes;
	private String tipo;
	private String anexos;
	private int cod;

	public Candidato(int cod) {
		super();
		this.cod = cod;
	}
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getLattes() {
		return lattes;
	}



	public void setLattes(String lattes) {
		this.lattes = lattes;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getAnexos() {
		return anexos;
	}


	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}


	@Override
	public String toString() {
		return "[" + cod + ", " + tipo + ", " + nome + ", " + sobrenome +", " + email + ", " + lattes + "," + anexos + "]";
	}


}
