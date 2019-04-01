package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TarefaPegajosaPage extends PaginaInicialPage {

	public TarefaPegajosaPage(WebDriver driver) {
		super(driver);
	}

	// elemento comum
	By elementoVerTarefa = (By.xpath("//a[contains(@href, 'view_all_bug_page.php')]"));
	By abrirTarefa = (By.xpath("//a[contains(@href, 'view.php?id=24')]"));
	By marcarPegajosaButton = (By.xpath("//input[@value='Marcar como Pegajoso']"));
	By desmarcarPegajosa = (By.xpath("//input[@value='Desmarcar como Pegajoso']"));
	By validaTarefaPegajosa = (By.xpath("//*[contains(., 'Não => Sim')]"));
	By validaDesmarcaPegajosa = (By.xpath("//*[contains(., 'Sim => Não')]"));

	// metodo comum
	public void selecionarVerTarefasNoMenu() {
		WebElement selecionarVerTarefas = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(elementoVerTarefa)));
		selecionarVerTarefas.click();
	}

	public void selecionarTarefaPegajosa() {
		WebElement selecionarTarefaPegajosa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(abrirTarefa)));
		selecionarTarefaPegajosa.click();
	}

	public void macarTarefa() {
		WebElement tarefaPegajosaButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(marcarPegajosaButton)));
		tarefaPegajosaButton.click();

		WebElement historicoAlteracaoTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(validaTarefaPegajosa)));
		historicoAlteracaoTarefa.getText();
		System.out.println("Printing " + historicoAlteracaoTarefa);
	}

	// Desmarcar a tarefa como pegajosa
	public void desmarcarTarefaButton() {
		WebElement desmarcarTarefaPegajosa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(desmarcarPegajosa)));
		desmarcarTarefaPegajosa.click();

		WebElement historicoAlteracaoDesmarca = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(validaDesmarcaPegajosa)));
		historicoAlteracaoDesmarca.getText();
		System.out.println("Printing " + historicoAlteracaoDesmarca);
	}
}
