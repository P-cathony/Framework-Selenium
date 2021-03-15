package frameworkPruebas.Libreria.configuracion;

import frameworkPruebas.Libreria.generadorHtml.ConfiguracionElementosGuardados;
import frameworkPruebas.Libreria.generadorHtml.GeneradorHtml;
import frameworkPruebas.Libreria.generadorHtml.GuardarElementosParaHtml;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ConfiguracionFramework {

    public static WebDriver driver;

    private final String PROPIEDAD_PATH ="C:\\Users\\toni\\Documents\\Selenium\\Framework_selenium\\propiedades\\config.properties";
    private final String PROPIEDAD_PATH_LOG4J = "C:\\Users\\toni\\Documents\\Selenium\\Framework_selenium\\propiedades\\log4j.properties";

    protected ConfigLectorDatosNavegador configLectorDatosNavegador = new  ConfigLectorDatosNavegador();

    public static long tiempoInicial;
    protected String nombreCasoPrueba;
    private StringBuilder reporteHtmlSB;
    public static ArrayList<GuardarElementosParaHtml> listaDeMensajesParaReporte = new ArrayList<>();
    public static ArrayList<String[]> listaDeLineasParaElReporte;



    @BeforeClass
    public void configFramework() throws FileNotFoundException, IOException{
        tiempoInicial = new Date().getTime();
        configLectorDatosNavegador.extraerParametrosNavegador();

        String navegador = configLectorDatosNavegador.obtenerMapeo().get("navegador");
        InputStream inputStream = new FileInputStream(PROPIEDAD_PATH);
        InputStream inputStreamLog4J = new FileInputStream(PROPIEDAD_PATH_LOG4J);

        Properties propiedadesNavegador = new Properties();
        Properties propiedadLog4J = new Properties();

        propiedadesNavegador.load(inputStream);
        propiedadLog4J.load(inputStreamLog4J);
        PropertyConfigurator.configure(propiedadLog4J);

//        llamando los drivers
        if (navegador.equals("chrome")){
            System.setProperty(propiedadesNavegador.getProperty("propiedadDriverChrome"), propiedadesNavegador.getProperty("pathDriverChrome"));
            driver = new ChromeDriver();
        } else if (navegador.equals("firefox")){
            System.setProperty(propiedadesNavegador.getProperty("propiedadDriverFirefox"), propiedadesNavegador.getProperty("propiedadDriverFirefox"));
            driver = new FirefoxDriver();

        } else {
            throw new IllegalArgumentException("El navegador no es valido: "+navegador);
        }




        reporteHtmlSB = new StringBuilder().append(propiedadesNavegador.getProperty("pathReporteHtml")).append("//");

//      Administracion de la pagina
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(configLectorDatosNavegador.obtenerMapeo().get("linkPaginaWeb"));


    }



    @AfterClass
    public void reporte_HTML(ITestContext contexto){
        String pathReporteHtml = reporteHtmlSB.
                append("reporteHtml_").
                append(nombreCasoPrueba).
                append("_").
                append(new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date())).
                append(".html").toString();

        ConfiguracionElementosGuardados configGuardarElementos = new ConfiguracionElementosGuardados();
        configGuardarElementos.setNombreCasoPrueba(nombreCasoPrueba);
        configGuardarElementos.setPathReporteHtml(pathReporteHtml);


        ConfigLectorDatosNavegador configLectorDatosNavegador = new ConfigLectorDatosNavegador();
        configLectorDatosNavegador.extraerParametrosNavegador();

        if (configLectorDatosNavegador.obtenerMapeo().get("cerrarNavegador").equals("true")){
            driver.quit();
        }

        GeneradorHtml generadorHtml = new GeneradorHtml(listaDeMensajesParaReporte, configGuardarElementos);
        try{
            generadorHtml.GeneradorHtml();
        }catch (Exception e){
            RegistroPruebas.setReporteDeErrores("Error en la generacion del reporte HTML");
        }

    }




}
