package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.Usuario;
import main.Main;
import main.Email;

class EmailTests {
	
	Main main = new Main();
	
	/**
	 * Verifica se o e-mail gerado corresponde ao esperado
	 */
	@Test
	void gerarEmailTest() 
	{
		Usuario usuario = new Usuario();
		
		String emailCriado = usuario.gerarEmail("Paola de Souza Ferreira", "Comercial");
		assertEquals("paola.ferreira@comercial.exemplo.com", emailCriado);
	}
	
	/**
	 * Verifica se a senha gerada não é nula e possui 8 caracteres
	 */
	@Test
	void gerarSenhaAleatoriaTest() 
	{
		Usuario usuario = new Usuario();
		
		String senha = usuario.gerarSenhaAleatoria();
		assertNotNull(senha);
		assertEquals(8, senha.length());
	}
	
	/**
	 * Verifica se o método retornou uma nova string de 8 digitos diferente da que foi passada como parametro
	 */
	@Test
	void alterarSenhaTest() 
	{	
		Usuario usuario = new Usuario();
		usuario.setEmail("test@test.example.com");
		usuario.setSenha("12345678");
		
		String senhaAnterior = "12345678";
		String novaSenha = usuario.alterarSenha(senhaAnterior);
		assertNotEquals(novaSenha, senhaAnterior);
		assertEquals(8, novaSenha.length());
	}
	
	/**
	 * Verifica se o método retornou uma lista não nula
	 */
	@Test
	void listarEmailsTest() 
	{
		Usuario usuario = new Usuario();
		usuario.setEmail("teste@test.exemplo.com");
		usuario.setSenha("12345678");
		
		List<Email> lista = main.listarEmails(usuario);
		
		assertNotNull(lista);
		Assertions.assertInstanceOf(List.class, lista);
	}
	
}
