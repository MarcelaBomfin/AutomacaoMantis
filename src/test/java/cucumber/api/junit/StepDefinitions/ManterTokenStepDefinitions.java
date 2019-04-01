package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.ManterTokenPage;
import cucumber.api.junit.Types.Usuario;

public class ManterTokenStepDefinitions {

	WebDriver driver;
	ManterTokenPage manterTokenPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
    public ManterTokenStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.manterTokenPage = new ManterTokenPage(driver);
        this.loginPage = new LoginPage(driver);
    }
	

	@Given("^o usuario administrador esta logado no mantis$")
	public void o_usuario_administrador_esta_logado_no_mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^seleciono o Administrator no cabecalho$")
	public void seleciono_o_Administrator_no_cabecalho() {
		manterTokenPage.selecionarAdministrator();
	}

	@Given("^seleciono no Menu Minha Conta$")
	public void seleciono_no_Menu_Minha_Conta() {
		manterTokenPage.selecionarMinhaConta();
	}

	@Given("^seleciono a aba Tokens API$")
	public void seleciono_a_aba_Tokens_API() {
		manterTokenPage.selecionarAbaTokenApi();
	}

	@Given("^preencho \"([^\"]*)\"$")
	public void preencho(String nomeDoToken) {
		manterTokenPage.preenchoOnomeTokenApi(nomeDoToken);
	}

	@When("^seleciono para criar o token$")
	public void seleciono_para_criar_o_token() {
		manterTokenPage.criarTokenApi();
	}

	@Then("^o sistema conclui a criacao do token$")
	public void o_sistema_conclui_a_criacao_do_token() {
		manterTokenPage.validarCriacaoToken();
	}

	@Then("^retornar para Token Api$")
	public void retornar_para_token_api() {
		manterTokenPage.retornarTelaTokensApi();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/api_tokens_page.php");
	}

	// revogar token
	@When("^seleciono para revogar o token$")
	public void seleciono_para_revogar_o_token() {
		manterTokenPage.selecionarTokenRevogar();
	}

	@Then("^o sistema conclui a revogacao do token$")
	public void o_sistema_conclui_a_revogacao_do_token() {
		manterTokenPage.revogarButton();
	}

	@Then("^retorno para a tela de tokens$")
	public void retorno_para_a_tela_de_tokens() {
		// manterTokenPage.validaMensagem();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/api_tokens_page.php");
	}

}
