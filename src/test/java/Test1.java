import frameworkPruebas.Libreria.configuracion.ConfiguracionFramework;
import frameworkPruebas.paginas.PaginaRegistrarse;
import frameworkPruebas.paginas.PaginaVotarLosTours;
import frameworkPruebas.paginas.PaginaLoggin;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 extends ConfiguracionFramework {

    @BeforeSuite
    public void setNombreCasoPrueba(){
        this.nombreCasoPrueba = Test1.class.getName();
    }




    @Test
    public void test1(){
        SoftAssert softAssert = new SoftAssert();
        PaginaVotarLosTours pagina_VotarLosTours = new PaginaVotarLosTours();

        pagina_VotarLosTours.aceptar_cookies();

        PaginaLoggin pagina_loggin = pagina_VotarLosTours.ir_pagina_Loggin();
        pagina_loggin.introduce_Email(configLectorDatosNavegador.obtenerMapeo().get("usuario"));
        pagina_loggin.introduce_Password(configLectorDatosNavegador.obtenerMapeo().get("contrasena"));

        PaginaRegistrarse pagina_Registro = pagina_loggin.ir_pagina_registrarse();
        pagina_Registro.comprobar_etiquetas(softAssert);
        pagina_Registro.introduce_nombre("Pablo");
        pagina_Registro.introduce_año("2020");

        pagina_VotarLosTours = pagina_Registro.ir_a_pagina_votar_los_tours();


        softAssert.assertAll();
    }



}
