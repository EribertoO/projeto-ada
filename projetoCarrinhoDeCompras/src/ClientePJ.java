

public class ClientePJ extends Cliente {
	
	private String CNPJ;

	public String getCNPJ() {
		return CNPJ;
	}

	public ClientePJ(String nome, String CNPJ) {
		super(nome);
		this.CNPJ = CNPJ;
	}

}
