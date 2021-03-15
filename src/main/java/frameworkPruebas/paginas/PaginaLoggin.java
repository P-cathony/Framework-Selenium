package frameworkPruebas.paginas;

import org.openqa.selenium.By;

public class PaginaLoggin extends PaginaBase{


    public PaginaLoggin() {
        this.confirmarIdentidad();
    }






    @Override
    public void confirmarIdentidad() {
        AFIRME.elemento_PaginaWeb_Y_Texto_mostrado_EsIgual(
                By.id("main-title"),
                "Inicio de sesión",
                "validar pagina loggin"
        );
    }



    public void introduce_Email(String email){

        DRIVER_A_S.llenarCampoPaginaWeb(By.name("username"), email, "introduce email: "+ email);
    }
    public void introduce_Password(String password){
        DRIVER_A_S.llenarCampoPaginaWeb(By.name("password"), password, "introduce password: "+ password);
    }

    public void click_boton_ok(){
        DRIVER_A_S.clickEnElementopagina(By.name("ok"), "click en boton OK");
    }






}
