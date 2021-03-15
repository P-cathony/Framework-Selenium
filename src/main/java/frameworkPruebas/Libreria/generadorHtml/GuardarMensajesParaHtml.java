package frameworkPruebas.Libreria.generadorHtml;

import frameworkPruebas.Libreria.configuracion.ConfiguracionFramework;

import java.util.Date;

public class GuardarMensajesParaHtml {


    private String[] setLineasCodigoParaReporte(){
        String[] arrayLineasEjecutadas = new String[6];
        StackTraceElement[] lineasCodigo = this.seguirLineasEjecutadasReporte();
        for (int i=1;i<7;i++){
            arrayLineasEjecutadas[i-1] = lineasCodigo[i+1].toString();
        }
        return arrayLineasEjecutadas;
    }


    private String obtenerTiempoDeAccion(long tiempoInicial){
        long tiempoDeAccion_ = new Date().getTime();
        long tiempoDeAccion = tiempoDeAccion_ - tiempoInicial;
        int minutos = (int) ((tiempoDeAccion / 1000) / 60);
        int segundos = (int) (tiempoDeAccion / 1000) % 60;
        return minutos + ":" + segundos;
    }






    private StackTraceElement[] seguirLineasEjecutadasReporte(){
        return Thread.currentThread().getStackTrace();
    }




    public void setMensajeParaReporte(String mensaje, boolean exitoso, String imagen){
        GuardarElementosParaHtml elementosParaHtml = new GuardarElementosParaHtml();
        elementosParaHtml.setMensajeError(mensaje);
        elementosParaHtml.setMensajeExito(exitoso);
        elementosParaHtml.setImagen(imagen);
        elementosParaHtml.setTiempoAccion(this.obtenerTiempoDeAccion(ConfiguracionFramework.tiempoInicial));
        elementosParaHtml.setLineaCodigo(this.setLineasCodigoParaReporte());
        ConfiguracionFramework.listaDeMensajesParaReporte.add(elementosParaHtml);
    }



    public void setMensajeParaReporte(String mensaje, boolean exitoso){
        GuardarElementosParaHtml elementosParaHtml = new GuardarElementosParaHtml();
        elementosParaHtml.setMensajeError(mensaje);
        elementosParaHtml.setMensajeExito(exitoso);
        elementosParaHtml.setTiempoAccion(this.obtenerTiempoDeAccion(ConfiguracionFramework.tiempoInicial));
        elementosParaHtml.setLineaCodigo(this.setLineasCodigoParaReporte());
        ConfiguracionFramework.listaDeMensajesParaReporte.add(elementosParaHtml);
    }

}
