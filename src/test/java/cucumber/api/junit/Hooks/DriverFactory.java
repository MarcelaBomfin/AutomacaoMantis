package cucumber.api.junit.Hooks;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.junit.Hooks.Propriedades.TipoExecucao;

public class DriverFactory {

private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
};

private DriverFactory() {}

public static WebDriver getDriver(){
	return threadDriver.get();
}

public static WebDriver initDriver() {
	WebDriver driver = null;
	if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
		switch (Propriedades.BROWSER) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case InternetExplorer:
			driver = new InternetExplorerDriver();
			break;
		
		}
	}
	if (Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
		DesiredCapabilities cap = null;
		switch (Propriedades.BROWSER) {
		case CHROME:
			cap = DesiredCapabilities.chrome();
			break;
		case FIREFOX:
			cap = DesiredCapabilities.firefox();
			break;
		case InternetExplorer:
			cap = DesiredCapabilities.internetExplorer();
			break;
		
		default:
			break;
		}
		
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.0.184:4444/wd/hub"), cap);
		} catch (MalformedURLException e) { 
			System.err.println("Falha na conexão com o GRID");
			e.printStackTrace();
		}
	}
	driver.manage().window().setSize(new Dimension(1200, 765));
	return driver;
	}

public static void killDriver() {
	WebDriver driver = getDriver();
	if (driver != null) {
		driver.quit();
		driver = null;
	}
	if (threadDriver != null) {
		threadDriver.remove();
	}
  }
}
