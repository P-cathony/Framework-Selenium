package frameworkPruebas.paginas;

import frameworkPruebas.Libreria.acciones.AccionesSelenium;
import frameworkPruebas.Libreria.acciones.ConstructorDeXpath;
import frameworkPruebas.Libreria.configuracion.ConfiguracionFramework;
import frameworkPruebas.Libreria.verificaciones.AfirmarPaginaPrueba;
import frameworkPruebas.Libreria.verificaciones.VerificarPaginaPrueba;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class PaginaBase {
    protected final AccionesSelenium DRIVER_A_S = new AccionesSelenium();
    protected final AfirmarPaginaPrueba AFIRME = new AfirmarPaginaPrueba();
    protected final VerificarPaginaPrueba VERIFIQUE = new VerificarPaginaPrueba();
    protected WebDriver driver = ConfiguracionFramework.driver;
    public abstract void confirmarIdentidad();



    public PaginaVotarLosTours ir_a_pagina_votar_los_tours(){
        DRIVER_A_S.clickEnElementopagina(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Votar los tours']"), "navegar a la pagina de votar los tours");
        return new PaginaVotarLosTours();
    }




    public PaginaLoggin ir_pagina_Loggin(){
        DRIVER_A_S.clickEnElementopagina(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Iniciar sesión']"), "navegar a la pagina de login");
        return new PaginaLoggin();
    }




    public PaginaRegistrarse ir_pagina_registrarse(){
        DRIVER_A_S.clickEnElementopagina(By.xpath("//*[text()='Usuarios']/parent::div//a[text()='Registrarse']"), "navegar a la pagina de registrarse");
        return new PaginaRegistrarse();
    }


    public void aceptar_cookies(){
        DRIVER_A_S.clickEnElementopagina(By.xpath("//div[@class='qc-cmp2-summary-buttons']/button[@class=' css-flk0bs']"),"aceptar cookies");
    }
    //div[@class='qc-cmp2-summary-buttons']/button[@class=' css-flk0bs']



}
