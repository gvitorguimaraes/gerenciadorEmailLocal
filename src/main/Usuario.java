package main;

import java.util.Random;

public class Usuario {
	
	private String email;
	
	private String senha;
	
	public Usuario()
	{
	}
	
	public String gerarEmail(String nome, String setor)
	{
		return "";
	}
	
	public String gerarSenhaAleatoria()
	{
		return "";
	}
	
	public String alterarSenha(String senha) {
		
		return "";
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
