package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManterTokenPage extends PaginaInicialPage {

	public ManterTokenPage(WebDriver driver) {
		super(driver);
	}

	By menuAdministrator = (By.xpath("//*[@class=\"user-info\"]"));
	By menuMinhaConta = (By.xpath("//a[contains(@href, 'account_page.php')]"));
	By nomeTokenApi = By.id("token_name");
	By criarTokenApiButton = (By.xpath("//input[@value='Criar Token API']"));
	By validarCriacao = (By.xpath("//*[contains(., 'Token que deve ser usado ao acessar API.')]"));
	By comumTokenApi = (By.xpath("//a[contains(@href, 'api_tokens_page.php')]"));
	By tokenRevogar = (By.xpath("//input[@value='Revogar']"));
	
	public void selecionarAdministrator() {
		WebElement menuAdminField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(menuAdministrator)));
		menuAdminField.click();
	}

	public void selecionarMinhaConta() {
		WebElement menuMinhaContaField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(menuMinhaConta)));
		menuMinhaContaField.click();
	}

	public void selecionarAbaTokenApi() {
		WebElement abaTokenApiField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(comumTokenApi)));
		abaTokenApiField.click();
	}

	public void preenchoOnomeTokenApi(String nomeDoToken) {
		WebElement preenchoNomeTokenField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(nomeTokenApi)));
		preenchoNomeTokenField.sendKeys(nomeDoToken);
	}

	public void criarTokenApi() {
		WebElement criarTokenField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(criarTokenApiButton)));
		criarTokenField.click();
	}

	public void validarCriacaoToken() {
		WebElement validaCriacaoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(validarCriacao)));
		validaCriacaoField.getText();
	}

	public void retornarTelaTokensApi() {
		WebElement retornarTelaTokenField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(comumTokenApi)));
		retornarTelaTokenField.click();
	}

	// revogar token
	public void selecionarTokenRevogar() {
		WebElement revogarButtonField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(tokenRevogar)));
		revogarButtonField.click();
	}

	public void revogarButton() {
		WebElement retornarTelaTokenField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(comumTokenApi)));
		retornarTelaTokenField.click();
	}
}
