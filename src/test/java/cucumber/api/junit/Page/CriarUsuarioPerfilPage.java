package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CriarUsuarioPerfilPage extends PaginaInicialPage {

	public CriarUsuarioPerfilPage(WebDriver driver) {
		super(driver);
	}

	By selecionarGerenciar = (By.xpath("//*[contains(@class, 'menu-icon fa fa-gears')]"));
	By menuGerenciarUsuarios = (By.xpath("//a[contains(@href, '/manage_user_page.php')]"));
	By botaoCriarNovaConta = (By.xpath("//button[contains(@class, 'btn btn-primary btn-white btn-round')]"));
	By digitarNomeUsuario = By.id("user-username");
	By digitarNomeVerdadeiro = By.id("user-realname");
	By nomeEmailUsuario = By.id("email-field");
	By botaoCriarUsuario = (By.xpath("//input[@value='Criar Usuário']"));
	By validarUsuarioCriado = (By.xpath("//div[@class=\"alert alert-success center\"]/p"));

	// clicar em gerenciar
	public void manterGerenciar() {
		WebElement selecionarGerenciarUsuarios = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarGerenciar)));
		selecionarGerenciarUsuarios.click();
	}

	// clicar em gerenciar usuarios
	public void manterGerenciarUsuarios() {
		WebElement criarUsuarioField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(menuGerenciarUsuarios)));
		criarUsuarioField.click();
	}

	public void criarNovaConta() {
		WebElement criarContaField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(botaoCriarNovaConta)));
		criarContaField.click();
	}

	public void preencherNomeUsuario(String nomeUsuario) {
		WebElement nomeUsuarioField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(digitarNomeUsuario)));
		nomeUsuarioField.clear();
		nomeUsuarioField.sendKeys(nomeUsuario);
	}

	public void preencherNomeVerdadeiro(String nomeVerdadeiro) {
		WebElement nomeVerdadeiroField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(digitarNomeVerdadeiro)));
		nomeVerdadeiroField.clear();
		nomeVerdadeiroField.sendKeys(nomeVerdadeiro);
	}

	public void preencherEmail(String nomeEmail) {
		WebElement nomeEmailField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(nomeEmailUsuario)));
		nomeEmailField.clear();
		nomeEmailField.sendKeys(nomeEmail);
	}

	public void selecionarNivelAcesso(String nivelDeAcesso) {
		Select dropdown = new Select(driver.findElement(By.id("user-access-level")));
		dropdown.selectByVisibleText(nivelDeAcesso);
	}

	// botao criar usuario
	public void finalizarCriarUsuario() {
		WebElement botaoCriarUsuarioField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(botaoCriarUsuario)));
		botaoCriarUsuarioField.click();
	}

	public String validarCriacaoUsuario() {
		WebElement validarUsuario = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(validarUsuarioCriado)));
		return validarUsuario.getText();
	}
}