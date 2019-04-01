package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.ManterLoginPage;
import cucumber.api.junit.Types.Usuario;

public class ManterLoginStepDefinitions {

	WebDriver driver;
	ManterLoginPage manterLoginPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;

	public ManterLoginStepDefinitions(SharedClass sharedClass){
	        this.sharedClass = sharedClass;
	        this.driver = sharedClass.getDriver();
	        this.manterLoginPage = new ManterLoginPage(driver);
	        this.loginPage = new LoginPage(driver);
	    }

	@Given("o usuario abriu a pagina do Mantis$")
	public void oUsuarioAcessouApagina() {
		loginPage.AbrirPagina();

	}

	// usuario invalido
	@When("^autenticou o login com \"([^\"]*)\", \"([^\"]*)\"$")
	public void autenticouOloginCom(String usuarioInvalido, String senhaInvalida) {
		manterLoginPage.preenchoUsuarioInvalido(usuarioInvalido);
		manterLoginPage.clicarEntrarUsuario();
		manterLoginPage.preenchoSenhaInvalida(senhaInvalida);
		manterLoginPage.clicarEntrarUsuario();
	}

	@Then("^o sistema exibiu a mensagem de usuario incorreto$")
	public void oSistemaExibiuAmensagemDeUsuarioIncorreto() {
		manterLoginPage.mensagemUsuarioInvalido();

	}

	// deslogar do sistema
	@When("^digitar o \"([^\"]*)\", \"([^\"]*)\"$")
	public void digitarO(String usuario, String senha) {
		manterLoginPage.preenchoUsuario(usuario);
		manterLoginPage.clicarEntrarUsuario();
		manterLoginPage.preenchoSenha(senha);
		manterLoginPage.clicarEntrarUsuario();
	}

	@When("^acesso a aba de administrador$")
	public void acessoAabaDeAdministrador() {
		manterLoginPage.clicarNoAdministrador();
	}

	@Then("^clico para deslogar do sistema$")
	public void clicoParaDeslogarDoSistema() {
		manterLoginPage.clicoParaDeslogar();
	}

	@When("^o sistem direciona para a pagina de login$")
	public void oSistemaDirecionaParaApaginaDeLogin() {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/login_page.php");
		
	}

	// esqueceu a senha
	@When("^digitou o \"([^\"]*)\"$")
	public void digitouOadministrator(String usuarioForgot) {
		manterLoginPage.preenchoUsuarioRecupera(usuarioForgot);
		manterLoginPage.clicarEntrarUsuario();

	}

	@When("^selecinou a opcao de perdeu a senha$")
	public void selecinouAopcaoDePerdeuAsenha() {
		manterLoginPage.clicarEmPerdeuAsenha();
	}

	@When("^informou o campo \"([^\"]*)\"$")
	public void informouOcampo(String emailRecupera) {
		manterLoginPage.preenchoemailRecupera(emailRecupera);

	}

	@When("^enviou a solicitacao de recuperacao$")
	public void enviouAsolicitacaoDeRecuperacao() {
		manterLoginPage.clicoParaEnviar();
	}

	@When("^o sistema voltou pra pagina inicial$")
	public void oSistemaVoltouPraPaginaInicial() {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/login_page.php?return=lost_pwd.php");
	}

}
