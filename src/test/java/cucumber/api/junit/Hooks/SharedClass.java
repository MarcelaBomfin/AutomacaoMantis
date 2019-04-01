package cucumber.api.junit.Hooks;

import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SharedClass {

	private static boolean startBrowser = false;

	private WebDriver driver;
	public String title = "";
	private static Properties props = Propriedades.getProperties();

	@Before
	public void init() throws Exception {
		if (!startBrowser) {

			String driverType = props.getProperty(Propriedades.P_WEBDRIVER_DRIVER);
			String tipoExecucao = props.getProperty(Propriedades.P_TIPO_EXECUCAO);
			if ("local".equals(tipoExecucao)) {
				if ("chrome".equals(driverType)) {
					chromeDriver();
				} else if ("firefox".equals(driverType)) {
					firefoxDriver();
				} else if ("MicrosoftWebDriver".equals(driverType)) {
					MicrosoftWebDriver();
				} else if ("OperaDriver".equals(driverType)) {
					OperaDriver();
				} else if ("InternetExplorerDriver".equals(driverType)) {
					InternetExplorerDriver();
				}

			// remote webdriver
			} else if ("grid".equals(tipoExecucao)) {
				String url = props.getProperty(Propriedades.P_REMOTE_DRIVER_URL);
				URL remoteUrl = new URL(url);
				if ("chrome".equals(driverType)) {
					ChromeOptions cap = new ChromeOptions();
					remoteDriver(remoteUrl, cap);
				} else if ("firefox".equals(driverType)) {
					FirefoxOptions cap = new FirefoxOptions();
					remoteDriver(remoteUrl, cap);
				}
			}

			driver.get("about:blank");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			startBrowser = false;

		}
	}

	private void chromeDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/melbr/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	private void firefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "/Users/melbr/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	private void InternetExplorerDriver() {
		System.setProperty("webdriver.ie.driver", "/Users/melbr/Drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	private void MicrosoftWebDriver() {
		System.setProperty("webdriver.edge.driver", "/Users/melbr/Drivers/MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
	}

	private void OperaDriver() {
		System.setProperty("webdriver.opera.driver", "/Users/melbr/Drivers/operadriver.exe");
		driver = new OperaDriver();
	}

	private void remoteDriver(URL url, Capabilities cap) {
		driver = new RemoteWebDriver(url, cap);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@After()
	public void cleanUp() {
		// driver.close();
		driver.quit();
	}
}