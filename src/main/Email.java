package main;

public class Email {
	
	private Integer id;
	
	private String remetente;
	
	private String destinatario;
	
	private String assunto;
	
	private String mensagem;
	
	public Email()
	{
	}
	
	public Email(String destinatario, String assunto, String mensagem)
	{
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnderecoEmail() {
		return remetente;
	}

	public void setEnderecoEmail(String remetente) {
		this.remetente = remetente;
	}
	
	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
