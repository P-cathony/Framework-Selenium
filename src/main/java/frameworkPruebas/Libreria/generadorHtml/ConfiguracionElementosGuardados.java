package frameworkPruebas.Libreria.generadorHtml;

public class ConfiguracionElementosGuardados {

    private String nombreCasoPrueba;
    private int numeroDePruebasFalladas;
    private String pathReporteHtml;


    public String getNombreCasoPrueba() {
        return nombreCasoPrueba;
    }

    public void setNombreCasoPrueba(String nombreCasoPrueba) {
        this.nombreCasoPrueba = nombreCasoPrueba;
    }



    public int getNumeroDePruebasFalladas() {
        return numeroDePruebasFalladas;
    }

    public void setNumeroDePruebasFalladas(int numeroDePruebasFalladas) {
        this.numeroDePruebasFalladas = numeroDePruebasFalladas;
    }



    public String getPathReporteHtml() {
        return pathReporteHtml;
    }

    public void setPathReporteHtml(String pathReporteHtml) {
        this.pathReporteHtml = pathReporteHtml;
    }
}
