

public class ClientePF extends Cliente {
	
	private String CPF;
	
	public String getCPF() {
		return CPF;
	}

	public ClientePF(String nome, String CPF) {
		super(nome);
		this.CPF = CPF;
	}
	
}
