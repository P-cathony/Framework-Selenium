package frameworkPruebas.Libreria.configuracion;

import org.apache.log4j.Logger;

public class RegistroPruebas {

    private static Logger registroPrueba = Logger.getLogger(RegistroPruebas.class);

    public static void setInformacionDePrueba(String mensaje){
        if (!mensaje.isEmpty()){
            registroPrueba.info(mensaje);
        }
    }

    public static void setReporteDeErrores(String mensaje){registroPrueba.error(mensaje);}

}
