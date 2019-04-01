package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManterLoginPage extends PaginaInicialPage {

	public ManterLoginPage(WebDriver driver) {
		super(driver);
	}

	By digitarOusuario = By.id("username");
	By usuarioLogar = (By.xpath("//input[@type=\"submit\"]"));
	By digitarAsenha = By.id("password");
	By clicarMenuAdmin = (By.xpath("//*[@class=\"user-info\"]"));
	By efetuarLogout = (By.xpath("//a[contains(@href, 'logout_page.php')]"));
	By perdeuAsenhaButton = (By.xpath("//a[contains(@href, 'lost_pwd_page.php?username=administrator')]"));
	By digitarEmail = By.id("email-field");
	By buttonEnvioRecupera = (By.xpath("//input[@value='Enviar']"));
	By usuarioIncorreto = (By.xpath(
			"//*[contains(., 'Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.')]"));

	public void preenchoUsuarioInvalido(String usuarioInvalido) {
		WebElement usuarioIncorretoField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(digitarOusuario)));
		usuarioIncorretoField.clear();
		usuarioIncorretoField.sendKeys(usuarioInvalido);
	}

	public void preenchoSenhaInvalida(String senhaInvalida) {
		WebElement senhaIncorretoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(digitarAsenha)));
		senhaIncorretoField.clear();
		senhaIncorretoField.sendKeys(senhaInvalida);

	}

	public void clicarEntrarUsuario() {
		WebElement entrarButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(usuarioLogar)));
		entrarButton.click();
	}

	public void mensagemUsuarioInvalido() {
		WebElement mensagemIncorretaField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(usuarioIncorreto)));
		mensagemIncorretaField.getText();
		System.out.println(usuarioIncorreto);
	}

	public void preenchoUsuario(String usuario) {
		WebElement usuarioDeslogarField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(digitarOusuario)));
		usuarioDeslogarField.clear();
		usuarioDeslogarField.sendKeys(usuario);

	}

	public void preenchoSenha(String senha) {
		WebElement senhaDeslogarField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(digitarAsenha)));
		senhaDeslogarField.clear();
		senhaDeslogarField.sendKeys(senha);

	}

	public void clicarNoAdministrador() {
		WebElement clicarAdminMenu = wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicarMenuAdmin)));
		clicarAdminMenu.click();
	}

	public void clicoParaDeslogar() {
		WebElement logoutAdmin = wait.until(ExpectedConditions.visibilityOf(driver.findElement(efetuarLogout)));
		logoutAdmin.click();

	}

	public void preenchoUsuarioRecupera(String usuarioForgot) {
		WebElement usuarioRecuperaField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(digitarOusuario)));
		usuarioRecuperaField.clear();
		usuarioRecuperaField.sendKeys(usuarioForgot);

	}

	public void clicarEmPerdeuAsenha() {
		WebElement perdeuAsenhaField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(perdeuAsenhaButton)));
		perdeuAsenhaField.click();
	}

	public void preenchoemailRecupera(String emailRecupera) {
		WebElement emailField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(digitarEmail)));
		emailField.sendKeys(emailRecupera);
	}

	public void clicoParaEnviar() {
		WebElement buttonEnviar = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttonEnvioRecupera)));
		buttonEnviar.click();

	}

}
