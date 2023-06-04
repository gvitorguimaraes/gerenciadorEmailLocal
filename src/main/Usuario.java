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
		String[] nomeSep = nome.toLowerCase().split(" ");
		
		return nomeSep[0]+"."+nomeSep[nomeSep.length-1]+"@"+setor.toLowerCase()+".exemplo.com";
	}
	
	public String gerarSenhaAleatoria()
	{
		String senha = "";
		Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        for (int i = 0; i < 8; i++) {
            int randomCharIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomCharIndex);
            if(randomCharIndex % 2 == 0)
            {
            	senha = senha+Character.toUpperCase(randomChar);
            }
            else 
            {
            	senha = senha+Character.toLowerCase(randomChar);
            }
        }
        
		return senha;
	}
	
	public String alterarSenha(String senha) {
		
		if(senha.equals(this.senha))
		{
			String novaSenha = gerarSenhaAleatoria();
			this.senha = novaSenha;
			return novaSenha;
		}
		return "Senha não alterada pois a senha informada não está correta!";
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
