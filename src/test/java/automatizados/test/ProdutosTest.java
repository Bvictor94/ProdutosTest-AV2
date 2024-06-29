package automatizados.test;
	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.ProdutosPO;

public class ProdutosTest extends BaseTest{
	
	private static ProdutosPO produtosPage;
	
	@BeforeClass
	public static void prepararTestes() {
		produtosPage = new ProdutosPO(driver);
	}
	
	//Precisa fazer os testes individualmente, pois eles estão falhando ao tentar juntos
	@Test
	public void TC006_naoDeveCadastrarProdutoSemCodigo() {
		produtosPage.executarCadastroDeProduto("", "Relogio", "5", "R$30,00", "28062024");
		String mensagem = produtosPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

	@Test
	public void TC007_naoDeveCadastrarProdutoSemNome() {
		produtosPage.executarCadastroDeProduto("1", "", "5", "R$30,00", "28062024");
		String mensagem = produtosPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC008_naoDeveCadastrarProdutoSemQuantidade() {
		produtosPage.executarCadastroDeProduto("1", "Relogio", "", "R$30,00", "28062024");
		String mensagem = produtosPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	

//	@Test
//	public void TC010_deveAdicionarProdutoDevidamenteCadastrado() {
//		produtosPage.executarCadastroDeProduto("1", "Relogio", "5", "R$30,00", "28062024");
//		produtosPage.fecharModalDeCadastro();
//		String editarExcluir = produtosPage.encontrarEditarExcluir();
//		
//		assertTrue(editarExcluir, editarExcluir.contains("/"));
//	}

}
