package frameworkPruebas.paginas;

import frameworkPruebas.Libreria.acciones.ConstructorDeXpath;
import org.openqa.selenium.By;

public class PaginaVotarLosTours extends PaginaBase{

    public PaginaVotarLosTours(){
        this.confirmarIdentidad();
    }



    @Override
    public void confirmarIdentidad() {
        AFIRME.elemento_PaginaWeb_Y_Texto_mostrado_EsIgual(
                By.id("main-title"),
                "Tours de votación",
                "validar pagina tours de votacion"
        );
    }




    public void click_peliculas_Accion(){
        DRIVER_A_S.clickEnElementopagina(new ConstructorDeXpath().atributo("class", "ttitle").texto_inicia_con("Acción").toBy(), "click en peliculas de acción");
    }






}
