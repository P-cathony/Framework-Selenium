package frameworkPruebas.Libreria.configuracion;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigLectorDatosNavegador {
    private String navegador;
    private String usuario;
    private String contrasena;
    private String linkPaginaWeb;
    private String cerrarNavegador;


//    metodos getter and setter


    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public String getLinkPaginaWeb() {
        return linkPaginaWeb;
    }

    public void setLinkPaginaWeb(String linkPaginaWeb) {
        this.linkPaginaWeb = linkPaginaWeb;
    }

    public String getCerrarNavegador() {
        return cerrarNavegador;
    }

    public void setCerrarNavegador(String cerrarNavegador) {
        this.cerrarNavegador = cerrarNavegador;
    }



    public void extraerParametrosNavegador(){
        SAXBuilder construir = new SAXBuilder();
        File config_navegador = new File("C:\\Users\\toni\\Documents\\Selenium\\Framework_selenium\\configNavegador.xml");
        try {
            Document documento = (Document) construir.build(config_navegador);
            Element nodoRaiz = documento.getRootElement();
            List listaParametros = nodoRaiz.getChildren("parametros");
                Element nodo = (Element) listaParametros.get(0);

                this.setNavegador(nodo.getChildText("navegador"));
                this.setContrasena(nodo.getChildText("contrasena"));
                this.setLinkPaginaWeb(nodo.getChildText("linkPaginaWeb"));
                this.setUsuario(nodo.getChildText("usuario"));
                this.setCerrarNavegador(nodo.getChildText("cerrarNavegador"));

        }catch (IOException | JDOMException io){
            System.out.println(io.getMessage());
        }

    }



    public Map<String, String> obtenerMapeo(){
        Map<String, String> mapeo = new HashMap<>();

        mapeo.put("navegador", this.getNavegador());
        mapeo.put("contrasena", this.getContrasena());
        mapeo.put("linkPaginaWeb", this.getLinkPaginaWeb());
        mapeo.put("usuario", this.getUsuario());
        mapeo.put("cerrarNavegador", this.getCerrarNavegador());
        return mapeo;
    }



}
