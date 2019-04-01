package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.MinhaVisaoPage;
import cucumber.api.junit.Types.Usuario;

public class MinhaVisaoStepDefinitions {

	WebDriver driver;
	MinhaVisaoPage minhaVisaoPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;

	public MinhaVisaoStepDefinitions(SharedClass sharedClass) {
		this.sharedClass = sharedClass;
		this.driver = sharedClass.getDriver();
		this.minhaVisaoPage = new MinhaVisaoPage(driver);
		this.loginPage = new LoginPage(driver);
	}

	@Given("^o administrador está logado no mantis$")
	public void o_administrador_está_logado_no_mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("^o usuario fez o login$")
	public void o_usuario_fez_o_login() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^seleciono no Menu Minha Visão$")
	public void seleciono_no_Menu_Minha_Visão() {
		minhaVisaoPage.selecionarMinhaVisao();
	}

	@When("^seleciono a tarefa$")
	public void seleciono_a_tarefa() {
		minhaVisaoPage.selecionarAtarefa();
	}

	@When("^preencho a \"([^\"]*)\"$")
	public void preencho_a(String Anotacao) {
		minhaVisaoPage.escreverAnotacao(Anotacao);
	}

	@Then("^concluo a inclusão da anotacao$")
	public void concluo_a_inclusão_da_anotacao() {
		minhaVisaoPage.concluirAnotacaoButton();
	}

	// mover tarefa
	@Given("^selecionei a tarefa para mover$")
	public void selecionei_a_tarefa_para_mover() {
		minhaVisaoPage.tarefaMover();
	}

	@Given("^seleciono para mover de projeto$")
	public void seleciono_para_mover_de_projeto() {
		minhaVisaoPage.moverTarefaProjeto();
	}

	@Given("^altero a tarefa em \"([^\"]*)\"$")
	public void altero_a_tarefa_em(String moverTarefasPara) {
		minhaVisaoPage.alterarProjetoTarefa(moverTarefasPara);
	}

	@Then("^concluo a mudança de projeto$")
	public void concluo_a_mudança_de_projeto() {
		minhaVisaoPage.moverButton();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/view_all_bug_page.php");

	}

}
