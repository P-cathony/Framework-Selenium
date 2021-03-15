package frameworkPruebas.Libreria.acciones;

import frameworkPruebas.Libreria.configuracion.ConfiguracionFramework;
import frameworkPruebas.Libreria.configuracion.RegistroPruebas;
import frameworkPruebas.Libreria.generadorHtml.GuardarMensajesParaHtml;
import frameworkPruebas.Libreria.generadorHtml.PantallazoParaHtml;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccionesSelenium {
    private final GuardarMensajesParaHtml GUARDAR_MENSAJE_PARA_REPORTE = new GuardarMensajesParaHtml();
    private final List<WebElement> LISTA_ELEMENTOS_NULOS = new ArrayList<>();
    private StackTraceElement[] seguirLineasEjecutadas_Errores(){
        return Thread.currentThread().getStackTrace();
    }



    private void lineasCodigoParaReporte(){
        StackTraceElement[] seguirLineasEjecutadasErrores = this.seguirLineasEjecutadas_Errores();
        for(int i=1;i<6;i++){
            RegistroPruebas.setInformacionDePrueba(seguirLineasEjecutadasErrores[i].toString());
        }
        System.out.println("");
    }




    private void setMensajeParaReporte(String mensaje, boolean Exitoso, String imagen){
        if(!mensaje.isEmpty()){
            GUARDAR_MENSAJE_PARA_REPORTE.setMensajeParaReporte(mensaje, Exitoso, imagen);
        }
    }







    public WebElement encontrarElemento(By por, String mensaje){
        String imagen;
        try{
            WebElement Elemento_De_La_Pagina = ConfiguracionFramework.driver.findElement(por);
            imagen = new PantallazoParaHtml(Elemento_De_La_Pagina).getPantallazo(true);
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
            return Elemento_De_La_Pagina;
        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }




    public WebElement encontrarElemento(WebElement contexto,By por, String mensaje){
        String imagen;
        try{
            WebElement Elemento_De_La_Pagina = contexto.findElement(por);
            imagen = new PantallazoParaHtml(Elemento_De_La_Pagina).getPantallazo(true);
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
            return Elemento_De_La_Pagina;
        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }





    public WebElement encontrarElemento(By por, int finTiempoEspera, String mensaje) {
        String imagen;
        WebDriverWait espere = new WebDriverWait(ConfiguracionFramework.driver, Long.valueOf(finTiempoEspera));

        try{
            WebElement Elemento_De_La_Pagina = espere.until(ExpectedConditions.presenceOfElementLocated(por));
            imagen = new PantallazoParaHtml(Elemento_De_La_Pagina).getPantallazo(true);
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
            return Elemento_De_La_Pagina;
        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }






    public List<WebElement> encontrarElementos(By por, String mensaje){
        String imagen;
        try{
            List<WebElement> lista_Elementos_Pagina = ConfiguracionFramework.driver.findElements(por);
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
            return lista_Elementos_Pagina;

        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }






    public void clickEnElementopagina(By por, String mensaje){
        String imagen;
        try{
            WebElement webElement = ConfiguracionFramework.driver.findElement(por);
            imagen = new PantallazoParaHtml(webElement).getPantallazo(true);
            webElement.click();
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }






    public void clickEnElementopagina(WebElement elementoDepagina, String mensaje){
        String imagen;
        try{
            imagen = new PantallazoParaHtml(elementoDepagina).getPantallazo(true);
            elementoDepagina.click();
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }








    public void clickEnElementopagina(WebElement contexto,By por, String mensaje){
        String imagen;
        try{
            WebElement elementoPaginaWeb = contexto.findElement(por);
            imagen = new PantallazoParaHtml(elementoPaginaWeb).getPantallazo(true);
            elementoPaginaWeb.click();
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }








    public void clickEnElementopagina(By por, int finTiempoEspera  ,String mensaje){
        String imagen;
        WebDriverWait espere = new WebDriverWait(ConfiguracionFramework.driver, Long.valueOf(finTiempoEspera));
        try{
            WebElement elementoPaginaWeb = espere.until(ExpectedConditions.presenceOfElementLocated(por));
            imagen = new PantallazoParaHtml(elementoPaginaWeb).getPantallazo(true);
            elementoPaginaWeb.click();
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }




    public void llenarCampoPaginaWeb(By por, String campo, String mensaje){
        String imagen;
        try{
            WebElement elementoPaginaWeb = ConfiguracionFramework.driver.findElement(por);
            imagen = new PantallazoParaHtml(elementoPaginaWeb).getPantallazo(true);
            elementoPaginaWeb.clear();
            elementoPaginaWeb.sendKeys(campo);
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }
        catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }







    public void llenarCampoPaginaWeb(WebElement elementoPaginaWeb, String campo, String mensaje){
        String imagen;
        try{
            imagen = new PantallazoParaHtml(elementoPaginaWeb).getPantallazo(true);
            elementoPaginaWeb.clear();
            elementoPaginaWeb.sendKeys(campo);
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }
        catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }





    public void llenarCampoPaginaWeb(By por,int finTiempoEspera, String campo, String mensaje){
        String imagen;
        WebDriverWait espere = new WebDriverWait(ConfiguracionFramework.driver, Long.valueOf(finTiempoEspera));
        try{
            WebElement elementoPaginaWeb = espere.until(ExpectedConditions.presenceOfElementLocated(por));
            imagen = new PantallazoParaHtml(elementoPaginaWeb).getPantallazo(true);
            elementoPaginaWeb.clear();
            elementoPaginaWeb.sendKeys(campo);
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }
        catch(Exception e){
            this.lineasCodigoParaReporte();
            imagen = new PantallazoParaHtml(null).getPantallazo(false);
            this.setMensajeParaReporte(mensaje + ". -> "+ e.getMessage(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". -> " + e.toString());
            throw new NoSuchElementException("");
        }
    }





}
