package frameworkPruebas.Libreria.verificaciones;

import frameworkPruebas.Libreria.acciones.AccionesSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class VerificarPaginaPrueba extends ConfiguracionValidacionPaginaPrueba{

    private AccionesSelenium accionesSelenium = new AccionesSelenium();



    public void Pagina_Prueba_Es_Igual_Navegada(SoftAssert verifique,String actual, String esperado, String mensaje){
        laPaginaQueSePruebaEsIgualAlaQueSeNavega(actual, esperado, "VERICAR: " + mensaje);
        verifique.assertEquals(actual, esperado);
    }




    public void elemento_pagina_Web_Y_Texto_Es_Igual_mostrado(SoftAssert verifique,WebElement elementoPaginaWeb, String esperado, String mensaje){
        elementoPaginaWebYTextoMostradoEsIgualAlaPaginaDePrueba(elementoPaginaWeb, esperado, "VERICAR: " + mensaje);
        verifique.assertEquals(elementoPaginaWeb.getText().trim(), esperado);
    }





    public void es_Verdadero(SoftAssert verifique, boolean bool, String mensaje){
        laPaginaDePruebaEsVerdadera(bool, "VERICAR: " + mensaje);
        verifique.assertTrue(bool);
    }




    public void elemento_Mostrado_Y_Texto_Contiene(SoftAssert verifique, WebElement elementoPaginaWeb, String esperado, String mensaje){
        paginaDePruebaContieneElementoMostradoYTexto(elementoPaginaWeb, esperado, "VERICAR: " + mensaje);
        verifique.assertTrue(elementoPaginaWeb.getText().contains(esperado));
    }


    public void pagina_Prueba_NoIgual(SoftAssert verifique, String actual, String esperado, String mensaje){
        laPaginaQueSePrueba_NO_EsIgualAlaQueSeNavega(actual, esperado, "VERICAR: " + mensaje);
        verifique.assertNotEquals(actual, esperado);
    }



    public void es_Falsa(SoftAssert verifique, boolean bool, String mensaje){
        laPaginaDePruebaEsFalsa(bool, "VERICAR: " + mensaje);
        verifique.assertFalse(bool);
    }





    public void elemento_PaginaWeb_mostrado_Y_Texto_EsIgual(SoftAssert verifique, By por, String esperado, String mensaje){
        WebElement elementoPaginaWeb = accionesSelenium.encontrarElemento(por,"");
        elementoPaginaWebYTextoMostradoEsIgualAlaPaginaDePrueba(elementoPaginaWeb, esperado, "VERICAR: " + mensaje);
        verifique.assertEquals(elementoPaginaWeb.getText().trim(), esperado);
    }






}
