package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner input = new Scanner(System.in);
	
	private static List<Usuario> usuarios = new ArrayList<>();
	
	private static Integer serieId = 31;
	
	private static Map<Integer, Email> log = new HashMap<>();
	
	private static boolean emailEstaRegistrado(String email)
	{
		for(Usuario usr : usuarios)
		{
			if(usr.getEmail().equals(email.toLowerCase()))
				return true;
		}
		return false;
	}
	
	
	
	public static List<Email> listarEmails(Usuario usr)
	{
		return null;
	}
	
	
	
	
	public static boolean enviarEmail(Usuario usr, Email email)
	{	
		email.setRemetente(usr.getEmail());
		
		//if(emailEstaRegistrado(email.getDestinatario()))
		if(!email.getDestinatario().isEmpty())
		{
			email.setId(serieId);
			log.put(serieId, email);
			serieId = serieId+17;
			System.out.println(" > E-mail enviado com sucesso!");
			return true;
		}
		else
		{
			System.out.println(" > Erro! E-mail informado não está registrado no sistema");
			return false;
		}
	}
	
	public static void abrirEmail(int id)
	{
		Email email = log.get(id);
			
		if(email != null)
		{
			System.out.println("\n ID: "+email.getId());
			System.out.println(" Remetente: "+email.getRemetente());
			System.out.println(" Destinatario: "+email.getDestinatario());
			System.out.println(" Assunto: "+email.getAssunto());
			System.out.println(" -----------------------------------------");
			System.out.println("\n "+email.getMensagem());
		}
		else
		{
			System.out.println(" > O ID informado não corresponde a nenhum e-mail do sistema");
		}
		input.nextLine();
	}
	
	public static void alterarSenha(Usuario usr) 
	{
		System.out.println("\n========================");
		System.out.println("      Alterar senha       ");
		System.out.println("========================\n");
		
		System.out.print(" >> Senha antiga: ");
		String msg = usr.alterarSenha(input.nextLine());
		
		System.out.println(" >> "+msg);
	}
	
	
	public static void main(String[] args) {
		
		boolean logado = false;
		Usuario usuarioLogado = new Usuario();
		String prompt = "";
		
		while(true)
		{
			if(logado == false)
			{
				System.out.println("\n================================");
				System.out.println("     Gerenciador de E-mails     ");
				System.out.println("================================\n");
				
				System.out.println("[1] Login");
				System.out.println("[2] Criar usuario");
				System.out.print(">> ");
				prompt = input.nextLine();
			}
			// Fazer login
			if(prompt.equals("1") && logado == false)
			{
				System.out.print(">> E-mail: ");
				String email = input.nextLine();
				
				System.out.print(">> Senha: ");
				String senha = input.nextLine();
				
				for(Usuario usr : usuarios)
				{
					if(email.equals(usr.getEmail()))
					{
						if(senha.equals(usr.getSenha()))
						{
							logado = true;
							usuarioLogado = usr;
						}
					}
				}
				if(logado == false)
				{
					System.out.println("> Erro ao fazer login: E-mail ou senha incorretos!");
					System.out.println("  Por favor tente novamente");
				}
			}
			
			// Registrar usuario
			else if (prompt.equals("2") && logado == false)
			{
				System.out.print(">> Nome Completo: ");
				String nomeCompleto = input.nextLine();
				
				System.out.print(">> Setor: ");
				String setor = input.nextLine();
				
				Usuario usr = new Usuario();
				String email = usr.gerarEmail(nomeCompleto, setor);
				String senha = usr.gerarSenhaAleatoria();
				usr.setEmail(email);
				usr.setSenha(senha);
				
				usuarios.add(usr);
				
				System.out.println("\n > Você foi registrado com sucesso!");
				System.out.println("\n > Seus dados de acesso: \n > E-mail: "+email+"\n > Senha: "+senha+"\n\n ** Você foi logado no sistema **\n");
			
				logado = true;
				usuarioLogado = usr;
			}
			
			if(logado == true)
			{
				System.out.println("\n================================\n");
				System.out.println("[1] Enviar novo E-mail");
				System.out.println("[2] Listar E-mails");
				System.out.println("[3] Abrir E-mail ");
				System.out.println("[4] Alterar senha da conta ");
				System.out.println("[5] Sair ");
				System.out.print(">> ");
				prompt = input.nextLine();
				
				switch(prompt) 
				{
					case "1":
						enviarEmail(usuarioLogado, new Email());
						break;
					case "2":
						listarEmails(usuarioLogado);
						break;
					case "3":
						System.out.print(">> ID do e-mail: ");
						abrirEmail(input.nextInt());
						break;
					case "4":
						alterarSenha(usuarioLogado);
						break;
					case "5":
						logado = false;
						break;
				}	
			}
		}
		
	}
}
