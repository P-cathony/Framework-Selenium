package frameworkPruebas.Libreria.generadorHtml;

public class GuardarElementosParaHtml {

    private String mensajeError;
    private boolean mensajeExito;
    private String[] lineaCodigo;
    private String tiempoAccion;
    private String imagen;


    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }



    public boolean isMensajeExito() {
        return mensajeExito;
    }

    public void setMensajeExito(boolean mensajeExito) {
        this.mensajeExito = mensajeExito;
    }



    public String[] getLineaCodigo() {
        return lineaCodigo;
    }

    public void setLineaCodigo(String[] lineaCodigo) {
        this.lineaCodigo = lineaCodigo;
    }



    public String getTiempoAccion() {
        return tiempoAccion;
    }

    public void setTiempoAccion(String tiempoAccion) {
        this.tiempoAccion = tiempoAccion;
    }



    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
