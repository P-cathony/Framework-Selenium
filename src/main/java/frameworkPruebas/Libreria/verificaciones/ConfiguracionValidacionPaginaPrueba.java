package frameworkPruebas.Libreria.verificaciones;

import frameworkPruebas.Libreria.configuracion.RegistroPruebas;
import frameworkPruebas.Libreria.generadorHtml.GuardarMensajesParaHtml;
import frameworkPruebas.Libreria.generadorHtml.PantallazoParaHtml;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionValidacionPaginaPrueba {

    private final GuardarMensajesParaHtml RECORDER_MESSAGES = new GuardarMensajesParaHtml();
    private final List<WebElement> LISTA_ELEMENTOS_NULOS = new ArrayList<>();

    private StackTraceElement[] seguimientoLineasCodigo(){
        return Thread.currentThread().getStackTrace();
    }


    private void setMensajeParaReporte(String mensaje, boolean exitoso, String imagen){
        if(!mensaje.isEmpty()){
            RECORDER_MESSAGES.setMensajeParaReporte(mensaje, exitoso, imagen);
        }
    }



    private void setLineasCodigoParaReporte(){
        StackTraceElement[] seguimientoLineasCodigo = this.seguimientoLineasCodigo();
        for(int i=1;i<6;i++){
            RegistroPruebas.setReporteDeErrores(seguimientoLineasCodigo[i].toString());
        }
        System.out.println("");
    }




    protected void laPaginaQueSePruebaEsIgualAlaQueSeNavega(String actual, String esperado, String mensaje){
        String imagen = new PantallazoParaHtml(null).getPantallazo(false);
        if(actual.equals(esperado)){
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }
        else{
            this.setMensajeParaReporte(mensaje +". Esperado: "+ esperado + " vs Actual: " + actual, false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". Esperado: "+esperado+" vs Actual: "+actual);
            this.setLineasCodigoParaReporte();
        }
    }




    protected void laPaginaQueSePrueba_NO_EsIgualAlaQueSeNavega(String actual, String esperado, String mensaje){
        String image = new PantallazoParaHtml(null).getPantallazo(false);
        if(!actual.equals(esperado)){
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, image);
        }
        else{
            this.setMensajeParaReporte(mensaje +". Esperado: "+ esperado + " vs Actual: " + actual, false, image);
            RegistroPruebas.setReporteDeErrores(mensaje + ". Esperado: "+esperado+" vs Actual: "+actual);
            this.setLineasCodigoParaReporte();
        }
    }





    protected void elementoPaginaWebYTextoMostradoEsIgualAlaPaginaDePrueba(WebElement elementoPaginaWeb, String esperado, String mensaje){
        String image = new PantallazoParaHtml(elementoPaginaWeb).getPantallazo(true);
        if(elementoPaginaWeb.isDisplayed() && elementoPaginaWeb.getText().trim().equals(esperado)){
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, image);
        }
        else{
            this.setMensajeParaReporte(mensaje +". Esperado: "+ esperado + " vs Actual: " + elementoPaginaWeb.getText().trim(), false, image);
            RegistroPruebas.setReporteDeErrores(mensaje + ". Esperado: "+esperado+" vs Actual: "+elementoPaginaWeb.getText().trim());
            this.setLineasCodigoParaReporte();
        }
    }







    protected void paginaDePruebaContieneElementoMostradoYTexto(WebElement elementoPagina, String esperado, String mensaje){
        String imagen = new PantallazoParaHtml(elementoPagina).getPantallazo(true);
        if(elementoPagina.isDisplayed() && elementoPagina.getText().trim().contains(esperado)){
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }
        else{
            this.setMensajeParaReporte(mensaje +". Esperado: "+ esperado + " vs Actual: " + elementoPagina.getText().trim(), false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje + ". Esperado: "+esperado+" vs Actual: "+elementoPagina.getText().trim());
            this.setLineasCodigoParaReporte();
        }
    }







    protected void laPaginaDePruebaEsVerdadera(boolean bool, String mensaje){
        String imagen = new PantallazoParaHtml(null).getPantallazo(false);
        if(bool){
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }
        else{
            this.setMensajeParaReporte(mensaje + ". Esperado: true vs Actual: " + bool, false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje);
            this.setLineasCodigoParaReporte();
        }
    }




    protected void laPaginaDePruebaEsFalsa(boolean bool, String mensaje){
        String imagen = new PantallazoParaHtml(null).getPantallazo(false);
        if(!bool){
            RegistroPruebas.setInformacionDePrueba(mensaje);
            this.setMensajeParaReporte(mensaje, true, imagen);
        }
        else{
            this.setMensajeParaReporte(mensaje + ". Esperado: true vs Actual: " + bool, false, imagen);
            RegistroPruebas.setReporteDeErrores(mensaje);
            this.setLineasCodigoParaReporte();
        }
    }

}
