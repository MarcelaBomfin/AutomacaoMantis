package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.ManterTarefaPage;
import cucumber.api.junit.Types.Usuario;

public class ManterTarefaStepDefinitions {

	WebDriver driver;
	ManterTarefaPage manterTarefaPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
    public ManterTarefaStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.manterTarefaPage = new ManterTarefaPage(driver);
        this.loginPage = new LoginPage(driver);
    }

	@Given("^o administrador acessou o Mantis$")
	public void o_administrador_acessou_o_Mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("^usuario fez o login$")
	public void usuario_fez_o_login() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^acessar no Menu Criar Tarefa$")
	public void acessar_no_Menu_Criar_Tarefa() {
		manterTarefaPage.menuCriarTarefas();
	}

	@When("^escolho o \"([^\"]*)\"$")
	public void escolho_o(String projeto) {
		manterTarefaPage.escolherOprojeto(projeto);
	}

	@When("^confirmo a selecao do projeto$")
	public void confirmo_a_selecao_do_projeto() {
		manterTarefaPage.buttonSalvaProjeto();
	}

	@When("^preencher os tipos \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void preencher_os_campos(String Categoria, String Resumo, String Descricao) {
		manterTarefaPage.selecionarCategoria(Categoria);
		manterTarefaPage.digitarResumo(Resumo);
		manterTarefaPage.digitarDescricao(Descricao);
	}

	@Then("^a tarefa foi criada$")
	public void a_tarefa_foi_criada() {
		manterTarefaPage.criarTarefabutton();
		manterTarefaPage.tarefaCriadaComSucesso();
	}

	// editar estado
	@Given("^seleciono no Menu Ver Tarefa$")
	public void selecionoNoMenuVerTarefa() {
		manterTarefaPage.selecionoVerTarefa();
	}

	@Given("^seleciono a tarefa para atualizar$")
	public void seleciono_a_tarefa_para_atualizar() {
		manterTarefaPage.selecionaTarefaEdicao();
		manterTarefaPage.iniciarEdicaoButton();
	}

	@When("^alterar o campo \"([^\"]*)\"$")
	public void alterar_o_campo(String Estado) {
		manterTarefaPage.alterarEstado(Estado);
	}

	@Then("^a tarefa foi atualizada$")
	public void a_tarefa_foi_atualizada() {
		manterTarefaPage.atualizarButton();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/view.php?id=52");	
	}

	// ADICIONAR USUARIO TAREFA

	@Given("^seleciono Ver Tarefa$")
	public void seleciono_Ver_Tarefa() {
		manterTarefaPage.selecionoVerTarefa();
	}

	@Given("^seleciono a tarefa para atribuir usuario$")
	public void seleciono_a_tarefa_para_atribuir_usuario() {
		manterTarefaPage.selecionoTarefaUsuario();
	}

	@When("^seleciono para atualizar a tarefa$")
	public void seleciono_para_atualizar_a_tarefa() {
		manterTarefaPage.atualizarButtonTarefa();
	}

	@When("^editar o campo \"([^\"]*)\"$")
	public void editar_o_campo(String atribuirA) {
		manterTarefaPage.editarOcampoAtribuira(atribuirA);
	}

	@Then("^o usuario foi atribuido a tarefa$")
	public void o_usuario_foi_atribuido_a_tarefa() {
		manterTarefaPage.atualizarButtonUsuario();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/view.php?id=52");
	}
	
	//adicionar marcador a tarefa
	@Given("seleciontar tarefa marcador")
	public void seleciontar_tarefa_marcador() {
	    manterTarefaPage.selecionarTarefaAddMarcador();
	}

	@When("seleciono qual {string}")
	public void seleciono_qual(String nomeMarcadorTarefa) {
	  manterTarefaPage.selecionarMarcador(nomeMarcadorTarefa);
	}

	@Then("aplico o marcador a tarefa")
	public void aplico_o_marcador_a_tarefa() {
	   manterTarefaPage.aplicarMarcadorTarefa();
	}

	@Then("valido a aplicacao do marcador no historico")
	public void valido_a_aplicacao_do_marcador_no_historico() {
	    manterTarefaPage.validarHistoricoTarefa();
	}

	// fechar tarefa
	@Given("^seleciono Ver Tarefa no menu$")
	public void seleciono_ver_tarefa_no_menu() {
		manterTarefaPage.selecionoVerTarefa();
	}

	@Given("^seleciono a tarefa para fechar$")
	public void seleciono_a_tarefa_para_fechar() {
		manterTarefaPage.selecionoFecharTarefa();
	}

	@When("^selecio o botao de fechar$")
	public void selecio_o_botao_de_fechar() {
		manterTarefaPage.fecharButtonTarefa();
	}

	@When("^mudo o campo \"([^\"]*)\"$")
	public void mudo_o_campo(String adicionarAnotacao) {
		manterTarefaPage.alterarCampoAnotacao(adicionarAnotacao);
	}

	@Then("^concluo o fechamento da terefa$")
	public void concluo_o_fechamento_da_terefa() {
		manterTarefaPage.concluirFecharTarefaButton();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/view.php?id=52");
	}

}
