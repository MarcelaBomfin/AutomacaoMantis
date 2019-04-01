package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PaginaInicialPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	By autenticarUsuario = By.id("username");
	By usuarioEntrar = By.xpath("//input[@type=\"submit\"]");
	By digitarSenha = By.id("password");

	public void AbrirPagina() {
		AbrirMantis();
	}

	public void preencherUsuario(String usuario) {

		WebElement usuarioField = wait.until(ExpectedConditions.presenceOfElementLocated(autenticarUsuario));
		System.out.println(wait.toString());
		usuarioField.sendKeys(usuario);
	}

	public void preencherSenha(String senha) {
		WebElement senhaField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(digitarSenha)));
		senhaField.sendKeys(senha);

	}

	public void clicarEntrarUsuario() {
		WebElement entrarButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(usuarioEntrar)));
		entrarButton.click();
	}

}
