package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class VerTarefasPage extends PaginaInicialPage {

	public VerTarefasPage(WebDriver driver) {
		super(driver);
	}
	
	//apagar tarefa
	By elementoVerTarefaComum = (By.xpath("//a[contains(@href, 'view_all_bug_page.php')]"));
	By tarefaExclusao = (By.xpath("//a[contains(@href, 'view.php?id=43')]"));
	By apagarTarefaButtonConfirmar = (By.xpath("//input[@value='Apagar']"));
	By apagarTarefaButton = (By.xpath("//input[@value='Apagar Tarefas']"));

	//clonar tarefa
	By selectClonarTarefa = (By.xpath("//a[contains(@href, 'view.php?id=45')]")); 
	By criarClone = (By.xpath("//input[@value='Criar Clone']")); 
	By digitarTextoResumo = By.id("summary");
	By concluirCriarClone = (By.xpath("//input[@value='Criar Nova Tarefa']"));
	
	//enviar lembrete
	By selecionarTarefaLembrete = (By.xpath("//a[contains(@href, 'view.php?id=32')]"));
	By enviarLembrete = (By.xpath("//a[contains(@href, 'bug_reminder_page.php?bug_id=32')]"));
	By preencherTextoLembrete = (By.xpath("//*[@id=\"send-reminder-div\"]"
			+ "/form/div/div[2]/div[1]/div/table/tbody/tr/td[2]/textarea"));
	By buttonEnviarLembrete = (By.xpath("//input[@value='Enviar']"));
	By confirmarEnvioSucesso = (By.xpath("//*[contains(., 'Operação realizada com sucesso.')]"));
	
	//pesquisar atrefa
	By clicoRelator = By.id("reporter_id_filter");
	By selecionarAtribuidoA = By.id("handler_id_filter");
	By clicarPrioridade = By.id("show_priority_filter");
	By clicarResolucao = By.id("show_resolution_filter");
	By pesquisarTarefa = (By.xpath("//input[@value='Aplicar Filtro']"));
	By tarefaRetornada = (By.xpath("//*[contains(., '1 - 2 / 2')]"));
	
	//salvar o filtro
	By salvarOfiltro = (By.xpath("//input[@value='Salvar Filtro Atual']"));
	By digitarNomeFiltro = (By.xpath("//*[@id=\"save-filter\"]/div[2]/div/form[1]/input[2]"));
	By salvarOfiltroDefinitivo = (By.xpath("//input[@value='Salvar Filtro Atual']"));
	
	//usar filtro salvo
	By aplicarFiltroSalvo = (By.xpath("//input[@value='Aplicar Filtro']"));
	
	//imprimir tarefas
	By imprimirTodasTarefas = (By.xpath("//a[contains(@href, 'print_all_bug_page.php')]"));
	
	public void selecionarMenuVerTarefas() {
		WebElement verTarefaMenuComum = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(elementoVerTarefaComum)));
		verTarefaMenuComum.click();
	}

	public void selecionarTarefaExcluir() {
		WebElement tarefaDeExclusao = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaExclusao)));
		tarefaDeExclusao.click();
	}

	public void buttonApagarTarefa() {
		WebElement apagarTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(apagarTarefaButtonConfirmar))); 
		apagarTarefa.click();
	}

	public void confirmaApagarTarefa() {
		WebElement confirmarApagarTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(apagarTarefaButton)));
		confirmarApagarTarefa.click();
	}

	//criar tarefa clone
	public void selecionarTarefaClonar() {
		WebElement tarefaDeClone = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selectClonarTarefa))); 
		tarefaDeClone.click();
	}

	public void criarCloneTarefa() {
		WebElement criarCloneDaTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(criarClone))); 
		criarCloneDaTarefa.click();	
	}

	public void preencherCampoDescricao(String Resumo) {
		WebElement campoResumoField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(digitarTextoResumo))); 
		campoResumoField.clear();
		campoResumoField.sendKeys(Resumo);
	}

	public void concluirCriacaoClone() {
		WebElement concluirCloneDaTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(concluirCriarClone))); 
		concluirCloneDaTarefa.click();
	}
	
	//enviar lembrete
	public void selecionarTarefaLembrete() {
		WebElement selecionarTarefaDeLembrete = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarTarefaLembrete))); 
		selecionarTarefaDeLembrete.click();		
	}

	public void enviarLembreteTarefa() {
		WebElement enviarLembreteField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(enviarLembrete))); 
		enviarLembreteField.click();
	}

	public void informarOusuario(String usuarioRecebe) {
		Select dropdown = new Select(driver.findElement(By.id("recipient")));
		dropdown.selectByVisibleText(usuarioRecebe);
	}

	public void ecrevoMensagemLembrete(String textoLembrete) {
		WebElement enviarLembreteField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(preencherTextoLembrete))); 
		enviarLembreteField.sendKeys(textoLembrete);
	}

	public void enviarLembrete() {
		WebElement enviarLembreteButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(buttonEnviarLembrete))); 
		enviarLembreteButton.click();
	}

	public void visualizoMensagemEnvioSucesso() {
		WebElement mensagemLembrete = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(confirmarEnvioSucesso))); 
		mensagemLembrete.getText();
	}
	
	//realizar a pesquisa
	public void selecionarRelator(String relator) {
		WebElement habilitarRelator = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(clicoRelator))); 
		habilitarRelator.click();
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='reporter_id_filter_target']/select")));
		dropdown.selectByVisibleText(relator);
	}

	public void selecionarAtribuidoA(String atribuidoA) {
		WebElement selectatribuidoA = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarAtribuidoA))); 
		selectatribuidoA.click();
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='handler_id_filter_target']/select")));
		dropdown.selectByVisibleText(atribuidoA);
	}

	public void selecionarPrioridade(String prioridade) {
		WebElement clicoPrioridade = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(clicarPrioridade))); 
		clicoPrioridade.click();
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='show_priority_filter_target']/select")));
		dropdown.selectByVisibleText(prioridade);
	}

	public void clicoParaPesquisar() {
		WebElement clicoPesquisar = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(pesquisarTarefa))); 
		clicoPesquisar.click();
	}
	
	//
	public void validarPesquisa() {
		WebElement validarPesquisaTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaRetornada))); 
		validarPesquisaTarefa.getText();
	}
	
	//salvar o filtro
	public void informarRelator(String relator) {
		WebElement selecionarLink = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(clicoRelator))); 
		selecionarLink.click();
	}

	public void informarAtribuir(String atribuidoA) {
		WebElement selecionarLinkAtribuir = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarAtribuidoA))); 
		selecionarLinkAtribuir.click();
	}

	public void salvarFitroSucesso() {
		WebElement salvarFitro = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(salvarOfiltro))); 
		salvarFitro.click();
	}

	public void informarNomeDoFiltro(String nomeDoFiltro) {
		WebElement nomeDoFiltroField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(digitarNomeFiltro))); 
		nomeDoFiltroField.sendKeys(nomeDoFiltro);
	}

	public void salvarFitroDefinitivo() {
		WebElement salvarFitroDefinitivo = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(salvarOfiltroDefinitivo))); 
		salvarFitroDefinitivo.click();
	}

	public void selecionarNomeFiltro(String nomeDoFiltro) {
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='filter-queries-form']/select")));
				dropdown.selectByVisibleText(nomeDoFiltro);
	}

	public void validarRetornoFiltro() {
		WebElement validarRetorno= wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaRetornada))); 
		validarRetorno.getText();
	}
	
	//imprimir tarefas
	public void imprimirTarefas() {
		WebElement imprimirTarefasButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(imprimirTodasTarefas))); 
		imprimirTarefasButton.click();
	}

}
