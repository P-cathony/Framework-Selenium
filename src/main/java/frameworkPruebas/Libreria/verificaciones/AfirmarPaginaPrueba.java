package frameworkPruebas.Libreria.verificaciones;

import frameworkPruebas.Libreria.acciones.AccionesSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AfirmarPaginaPrueba extends ConfiguracionValidacionPaginaPrueba{

    private AccionesSelenium accionesSelenium = new AccionesSelenium();


    public void Pagina_Prueba_Es_Igual_Navegada(String actual, String esperado, String mensaje){
        laPaginaQueSePruebaEsIgualAlaQueSeNavega(actual, esperado, "AFIRMAR: " + mensaje);
        Assert.assertEquals(actual, esperado);
    }




    public void elemento_pagina_Web_Y_Texto_Es_Igual_mostrado(WebElement elementoPaginaWeb, String esperado, String mensaje){
        elementoPaginaWebYTextoMostradoEsIgualAlaPaginaDePrueba(elementoPaginaWeb, esperado, "AFIRMAR: " + mensaje);
        Assert.assertEquals(elementoPaginaWeb.getText().trim(), esperado);
    }



    public void es_Verdadero(boolean bool, String mensaje){
        laPaginaDePruebaEsVerdadera(bool, "AFIRMAR: " + mensaje);
        Assert.assertTrue(bool);
    }




    public void elemento_Mostrado_Y_Texto_Contiene(WebElement elementoPaginaWeb, String esperado, String mensaje){
        paginaDePruebaContieneElementoMostradoYTexto(elementoPaginaWeb, esperado, "AFIRMAR: " + mensaje);
        Assert.assertTrue(elementoPaginaWeb.getText().contains(esperado));
    }


    public void pagina_Prueba_NoIgual(String actual, String esperado, String mensaje){
        laPaginaQueSePrueba_NO_EsIgualAlaQueSeNavega(actual, esperado, "AFIRMAR: " + mensaje);
        Assert.assertNotEquals(actual, esperado);
    }



    public void es_Falsa(boolean bool, String mensaje){
        laPaginaDePruebaEsFalsa(bool, "ASSERT: " + mensaje);
        Assert.assertFalse(bool);
    }





    public void elemento_PaginaWeb_Y_Texto_mostrado_EsIgual(By por, String esperado, String mensaje){
        WebElement elementoPaginaWeb = accionesSelenium.encontrarElemento(por,"");
        elementoPaginaWebYTextoMostradoEsIgualAlaPaginaDePrueba(elementoPaginaWeb, esperado, "AFIRMAR: " + mensaje);
        Assert.assertEquals(elementoPaginaWeb.getText().trim(), esperado);
    }





}
