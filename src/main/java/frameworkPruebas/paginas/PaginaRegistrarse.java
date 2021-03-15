package frameworkPruebas.paginas;

import frameworkPruebas.Libreria.acciones.ConstructorDeXpath;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class PaginaRegistrarse extends PaginaBase{

    public PaginaRegistrarse() {
        this.confirmarIdentidad();
    }





    @Override
    public void confirmarIdentidad() {
        AFIRME.elemento_PaginaWeb_Y_Texto_mostrado_EsIgual(
                By.id("main-title"),
                "Regístrate (es gratis)",
                "validando pagina Registrarse"
        );
    }





    public void introduce_nombre(String nombre){

        DRIVER_A_S.llenarCampoPaginaWeb(By.name("nick"), nombre, "introduce nombre: "+ nombre);
    }




    public void introduce_año(String año){
        DRIVER_A_S.llenarCampoPaginaWeb(By.name("year"), 12 , año, "introduce año: "+ año);
    }




    public void comprobar_etiquetas(SoftAssert softAssert) {
        VERIFIQUE.elemento_PaginaWeb_mostrado_Y_Texto_EsIgual(
                softAssert,
                new ConstructorDeXpath().abajo("input").atributo("name", "nick").padre("div").hijo("div").toBy(),
                "Nombre/Nick",
                "verificando etiqueta Nombre/nick"        //input[@name='nick']/parent::div/div
        );

        VERIFIQUE.elemento_PaginaWeb_mostrado_Y_Texto_EsIgual(
                softAssert,
                new ConstructorDeXpath().abajo("input").atributo("name", "year").padre("div").hijo("div").toBy(),
                "Año de nacimiento:",
                "verificando etiqueta Año"            //input[@name='year']/parent::div/div
        );

    }

}
