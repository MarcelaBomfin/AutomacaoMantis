package cucumber.api.junit.StepDefinitions;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.MonitorarTarefaPage;
import cucumber.api.junit.Types.Usuario;

public class MonitorarTarefaStepDefinitions {

	WebDriver driver;
	MonitorarTarefaPage monitorarTarefaPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
    public MonitorarTarefaStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.monitorarTarefaPage = new MonitorarTarefaPage(driver);
        this.loginPage = new LoginPage(driver);
    }


	@Given("^acessou o Mantis$")
	public void acessou_o_Mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();

	}

	@Given("^logou no sistema$")
	public void logou_no_sistema() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^acessou Ver tarefas$")
	public void acessou_Ver_tarefas() {
		monitorarTarefaPage.selecionarVerTarefas();
	}

	@Given("^cliquei no numero da tarefa$")
	public void cliquei_no_numero_da_tarefa() {
		monitorarTarefaPage.selecionaTarefa();
	}

	@When("^iniciou o Monitoramento$")
	public void iniciouOmonitoramento() {
		monitorarTarefaPage.selecionarMonitoramentoButton();
	}

	@Then("^retornar ver tarefas$")
	public void retornarVerTarefas() {
		monitorarTarefaPage.retornarVerTarefas();
	}

	// alterar o relator
	@Given("^selecionei a tarefa$")
	public void selecionei_a_tarefa() {
		monitorarTarefaPage.selecioneiTarefa();
	}

	@Given("^selecionei para atualizar a tarefa$")
	public void selecionei_para_atualizar_a_tarefa() {
		monitorarTarefaPage.atualizarAtarefa();
	}

	@When("^altero o campo \"([^\"]*)\"$")
	public void preencho_o_campo(String alteraRelator) {
		monitorarTarefaPage.alterarLink();
		monitorarTarefaPage.alteroOrelator(alteraRelator);
	}

	@Then("^adiciono o usuario$")
	public void adiciono_o_usuario() {
		monitorarTarefaPage.atualizarRelator();
	}

	// Parar de monitorar a tarefa
	@Given("^acessou Ver tarefas menu$")
	public void acessou_Ver_tarefas_menu() {
		monitorarTarefaPage.entrarMenuVerTarefa();
	}

	@Given("^clico no numero da tarefa$")
	public void clico_no_numero_da_tarefa() {
		monitorarTarefaPage.clicoTarefaPararMonitorar();
	}

	@When("^parei o Monitoramento$")
	public void parei_o_Monitoramento() {
		monitorarTarefaPage.clicoPararMonitorar();
	}

	@Then("^retornar ver tarefas menu$")
	public void retornar_ver_tarefas_menu() {
		monitorarTarefaPage.retornarVerTarefas();
	}

	// pesquisar quem monitora a tarefa
	@Given("^clico para Ver tarefas$")
	public void clico_para_Ver_tarefas() {
		monitorarTarefaPage.visualizoTarefas();
	}

	@Given("^clico na opção Monitorado Por$")
	public void clico_na_opção_Monitorado_Por() {
		monitorarTarefaPage.clicaLinkMonitoradoPor();
	}

	@Given("^seleciono o \"([^\"]*)\"$")
	public void seleciono_o(String usuarioMonitoradoPor) {
		monitorarTarefaPage.selectUsuario(usuarioMonitoradoPor);
	}

	@When("^aplico o filtro$")
	public void aplico_o_filtro() {
		monitorarTarefaPage.aplicarOfiltro();
	}

	@Then("^o sistema retorna a tarefa monitorada$")
	public void o_sistema_retorna_a_tarefa_monitorada() {
		monitorarTarefaPage.confirmarTarefa();
	}

	// redefinir filtro
	@Given("^Ver Tarefas de redefinicao$")
	public void ver_Tarefas_de_redefinicao() {
		monitorarTarefaPage.verTarefasRedefinicao();
	}

	@When("^seleciono para \"([^\"]*)\"$")
	public void seleciono_para(String redefinirFiltro) {
		monitorarTarefaPage.redefinirFiltro(redefinirFiltro);
	}

	@Then("^o sistema limpa os filtros$")
	public void o_sistema_limpa_os_filtros() {
		monitorarTarefaPage.checarFiltrolimpo();
	}
}
