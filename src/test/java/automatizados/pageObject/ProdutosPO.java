package automatizados.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutosPO extends BasePO {

	public ProdutosPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "btn-adicionar")
	public WebElement botaoCriar;
	
	@FindBy(id = "btn-salvar")
	public WebElement botaoSalvar;
	
	@FindBy(id = "btn-sair")
	public WebElement botaoSair;
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement inputData;
	
//	@FindBy(css = "form.form-login>div.alert>span")
//	public WebElement spanMensagem;
	
	@FindBy(css = "div.modal-dialog>div.modal-content>div.modal-body>div.alert>span")
	public WebElement spanMensagem;
	
	@FindBy(css = "table.table>tbody>tr>td")
	public WebElement tdEditarExcluir;
	
	public String encontrarEditarExcluir() {
		return tdEditarExcluir.getText();
	}

	public String obterMensagem() {
		return this.spanMensagem.getText();
	}

	public void executarCadastroDeProduto(String codigo, String nome, String quantidade, String valor, String data) {
		botaoCriar.click();
		botaoCriar.click();
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		botaoSalvar.click();
		
	}
	
	public void fecharModalDeCadastro() {
		botaoSair.click();
	}

	private void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
		
	}

}