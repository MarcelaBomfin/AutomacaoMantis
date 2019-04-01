package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Types.Usuario;

public class AutenticarLoginStepDefinitions {
	
	WebDriver driver;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
	 public AutenticarLoginStepDefinitions(SharedClass sharedClass){
	        this.sharedClass = sharedClass;
	        this.driver = sharedClass.getDriver();
	        this.loginPage = new LoginPage(driver);
	    }
	
	@Given("^o usuario administrador acessou a pagina de login$")
	public void oUsuarioAdministradorAcessouApaginaDeLogin() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@When("^o usuario realizar o login$")
	public void oUsuarioRealizarOlogin() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Then("^o sistema exibira a tela inicial do Mantis$")
	public void oSistemaExibiraAtelaInicialDoMantis() {
		
		WebElement administrador = driver.findElement(By.className("administrador"));
		String textoNoElementoDdministrador = administrador.getText();
		
		Assert.assertEquals("administrador", textoNoElementoDdministrador);
	}
}
