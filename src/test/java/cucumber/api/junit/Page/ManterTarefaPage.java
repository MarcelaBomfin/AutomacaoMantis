package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ManterTarefaPage extends PaginaInicialPage {

	public ManterTarefaPage(WebDriver driver) {
		super(driver);
	}

	// elemento comum
	By elementoComumVerTarefa = (By.xpath("//a[contains(@href, 'view_all_bug_page.php')]"));
	By atualizarButton = (By.xpath("//input[@value='Atualizar']"));
	By atualizarInformacao = (By.xpath("//input[@value='Atualizar Informação']"));

	// elementos por passos

	By menuCriarNovaTarefa = (By.xpath("//a[contains(@href, 'bug_report_page.php')]"));
	By salvarProjeto = (By.xpath("//input[@value='Selecionar Projeto']"));
	By preenchoResumo = By.id("summary");
	By preenchoDescricao = By.id("description");
	By buttonTarefaCriar = (By.xpath("//input[@value='Criar Nova Tarefa']"));
	By tarefaCriadaSucesso = (By.xpath("//*[contains(., 'Operação realizada com sucesso.')]"));

	// EDITAR ESTADO
	By tarefaComumCenarios = (By.xpath("//a[contains(@href, 'view.php?id=52')]"));

	// ADICIONAR TAREFA USUARIO
	By atribuirUsuario = (By.xpath("//a[contains(@href, 'view.php?id=52')]"));

	// fechar tarefa
	By tarefaParaFechar = (By.xpath("//a[contains(@href, 'view.php?id=52')]"));
	By buttonFecharTarefa = (By.xpath("//input[@value='Fechar']"));
	By preencherAnotacao = By.id("bugnote_text");
	By fecharTarefaButton = (By.xpath("//input[@value='Fechar Tarefa']"));
	
	//adicionar marcador tarefa
	By aplicarMarcador = (By.xpath("//input[@value='Aplicar']"));
	By historicoTarefa = (By.xpath("//*[contains(., 'Marcador Aplicado: Projeto Desafio Mantis')]"));

	// METODO COMUM

	public void selecionoVerTarefa() {
		WebElement verTarefaMenu = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumVerTarefa)));
		verTarefaMenu.click();
	}

	public void iniciarEdicaoButton() {
		WebElement buttonAtualizar = wait.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarButton)));
		buttonAtualizar.click();
	}

	// CRIAR TAREFA

	public void escolherOprojeto(String projeto) {
		Select dropdown = new Select(driver.findElement(By.id("select-project-id")));
		dropdown.selectByVisibleText(projeto);
	}

	public void buttonSalvaProjeto() {
		WebElement salvarProjetoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(salvarProjeto)));
		salvarProjetoField.click();
	}

	public void menuCriarTarefas() {
		WebElement menuCriarTarefas = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(menuCriarNovaTarefa)));
		menuCriarTarefas.click();
	}

	public void selecionarCategoria(String Categoria) {
		Select dropdown = new Select(driver.findElement(By.id("category_id")));
		dropdown.selectByVisibleText(Categoria);
	}

	public void digitarResumo(String resumo) {
		WebElement informarOresumo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(preenchoResumo)));
		informarOresumo.sendKeys(resumo);
	}

	public void digitarDescricao(String descricao) {
		WebElement informoAdescricao = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(preenchoDescricao)));
		informoAdescricao.sendKeys(descricao);

	}

	public void criarTarefabutton() {
		WebElement tarefaButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttonTarefaCriar)));
		tarefaButton.click();	
		
	}
	

	public void tarefaCriadaComSucesso() {
		WebElement tarefaCriada = wait.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaCriadaSucesso)));
		tarefaCriada.getText();
		
	}

	// EDITAR ESTADO
	public void selecionaTarefaEdicao() {
		WebElement editarTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaComumCenarios)));
		editarTarefa.click();
	}

	public void alterarEstado(String Estado) {
		Select dropdown = new Select(driver.findElement(By.id("status")));
		dropdown.selectByVisibleText(Estado);
	}

	public void atualizarButton() {
		WebElement atualizarInformacaoButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarInformacao)));
		atualizarInformacaoButton.click();
	}
	
	//adicionar marcador a tarefa
		public void selecionarTarefaAddMarcador() {
			WebElement atualizarTarefaMarcador = wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaComumCenarios)));
			atualizarTarefaMarcador.click();
		}

		public void selecionarMarcador(String nomeMarcadorTarefa) {
			Select dropdown = new Select(driver.findElement(By.id("tag_select")));
			dropdown.selectByVisibleText(nomeMarcadorTarefa);
		}

		public void aplicarMarcadorTarefa() {
			WebElement aplicarMarcadorButton = wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(aplicarMarcador)));
			aplicarMarcadorButton.click();
		}

		public void validarHistoricoTarefa() {
			WebElement validarHistorico = wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(historicoTarefa)));
			validarHistorico.click();
		}
	
	// ADICIONAR TAREFA USUARIO
	public void selecionoTarefaUsuario() {
		WebElement atribuirUsuarioSelecionarTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(atribuirUsuario)));
		atribuirUsuarioSelecionarTarefa.click();
	}

	public void atualizarButtonTarefa() {
		WebElement buttonAtualizar = wait.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarButton)));
		buttonAtualizar.click();
	}

	public void editarOcampoAtribuira(String atribuirA) {
		Select dropdown = new Select(driver.findElement(By.id("handler_id")));
		dropdown.selectByVisibleText(atribuirA);
	}

	public void atualizarButtonUsuario() {
		WebElement atualizarUsuario = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarInformacao)));
		atualizarUsuario.click();
	}

	// FECHAR TAREFA

	public void selecionoFecharTarefa() {
		WebElement selecionarTarefaFechar = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaParaFechar)));
		selecionarTarefaFechar.click();
	}

	public void fecharButtonTarefa() {
		WebElement fecharTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(buttonFecharTarefa)));
		fecharTarefa.click();
	}

	public void alterarCampoAnotacao(String adicionarAnotacao) {
		WebElement campoAnotacao = wait.until(ExpectedConditions.visibilityOf(driver.findElement(preencherAnotacao)));
		campoAnotacao.sendKeys(adicionarAnotacao);
	}

	public void concluirFecharTarefaButton() {
		WebElement concluirResolucaoTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(fecharTarefaButton)));
		concluirResolucaoTarefa.click();
	}
		
}


