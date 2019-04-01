package cucumber.api.junit.StepDefinitions;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.CriarUsuarioPerfilPage;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Types.Usuario;

public class CriarUsuarioPerfilStepDefinitions {

	WebDriver driver;
	CriarUsuarioPerfilPage criarUsuarioPerfilPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;

	public CriarUsuarioPerfilStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.criarUsuarioPerfilPage = new CriarUsuarioPerfilPage(driver);
        this.loginPage = new LoginPage(driver);
    }

	@Given("o usuario acessou a pagina de login$")
	public void oUsuarioAdministradorAcessouApaginaDeLogin() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();

	}

	@Given("usuario realizar o login$")
	public void oUsuarioRealizarOlogin() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();

	}

	@Given("^acessar Gerenciar$")
	public void acessarGerenciar() {
		criarUsuarioPerfilPage.manterGerenciar();

	}

	@Given("^acessar a aba Gerenciar$")
	public void acessarAabaGerenciar() {
		criarUsuarioPerfilPage.manterGerenciarUsuarios();
	}

	@Given("^acessar Criar nova Conta$")
	public void acessarCriarNovaConta() {
		criarUsuarioPerfilPage.criarNovaConta();

	}

	@When("^preencher os campos \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void preencherOsCampos(String nomeUsuario, String nomeVerdadeiro, String nomeEmailUsuario,
			String nivelDeAcesso) {
		criarUsuarioPerfilPage.preencherNomeUsuario(nomeUsuario);
		criarUsuarioPerfilPage.preencherNomeVerdadeiro(nomeVerdadeiro);
		criarUsuarioPerfilPage.preencherEmail(nomeEmailUsuario);
		criarUsuarioPerfilPage.selecionarNivelAcesso(nivelDeAcesso);
	}

	@Then("^o sistema ira criar os usuarios$")
	public void oSistemaIraCriarOsUsuarios() {
		criarUsuarioPerfilPage.finalizarCriarUsuario();

	}

}
