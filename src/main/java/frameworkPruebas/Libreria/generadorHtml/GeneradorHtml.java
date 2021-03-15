package frameworkPruebas.Libreria.generadorHtml;

import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneradorHtml {
    private ArrayList<GuardarElementosParaHtml> listaDeMensajesParaElReporte;
    private String nombreCasoPrueba;
    private String pathReporteHtml;
    private int numeroDePruebasFalladas;


    public GeneradorHtml(ArrayList<GuardarElementosParaHtml>listaDeMensajesParaElReporte, ConfiguracionElementosGuardados configuracionParaGuardarElementos){

        this.listaDeMensajesParaElReporte = listaDeMensajesParaElReporte;
        this.nombreCasoPrueba = configuracionParaGuardarElementos.getNombreCasoPrueba();
        this.numeroDePruebasFalladas = configuracionParaGuardarElementos.getNumeroDePruebasFalladas();
        this.pathReporteHtml = configuracionParaGuardarElementos.getPathReporteHtml();

    }



    public void GeneradorHtml() throws IOException{
        Date date = new Date();
        SimpleDateFormat formatoDatos = new SimpleDateFormat("dd.MM.yyyy, kk:mm");

        Html html = new Html();
        Head head = new Head();
        Title title = new Title();
        Hr hr = new Hr();
        Body body = new Body();
        Div cabeceraDiv = new Div();
        File file = new File(pathReporteHtml);

        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter alSalir = new BufferedWriter(fileWriter);

        html.appendChild(body);

        title.appendText("Reporte Html ");
        html.appendChild(title);
        body.appendChild(hr);
        hr.setSize("15");
        hr.setStyle(this.obtenerStiloParaHR(numeroDePruebasFalladas));
        body.appendChild(cabeceraDiv);

        H1  h1ParaCabeceraDiv  = new H1();
        cabeceraDiv.appendChild(h1ParaCabeceraDiv);
        h1ParaCabeceraDiv.appendText(formatoDatos.format(date)+ " - "+ nombreCasoPrueba);


        List<Node> listaDeDivs = new ArrayList<>();
        Div div1;
        H3 h3;
        Ul ul;
        Img img;

        for (GuardarElementosParaHtml elementos:listaDeMensajesParaElReporte ){
            div1 = new Div();
            div1.setStyle(this.obtenerEstiloParaDiv(elementos.isMensajeExito()));

            h3 = new H3();
            h3.setStyle(this.obtenerEstiloParaH3(elementos.isMensajeExito()));
            h3.appendText(elementos.getTiempoAccion()+ " - "+ elementos.getMensajeError()+ " ");

            ul = new Ul();
            for (String linea:elementos.getLineaCodigo()){
                ul.appendChild(new Li().appendText(linea));
            }


            img = new Img("screenshot","data:image/jpg;base64,"+elementos.getImagen());
            img.setHeight("450");
            img.setWidth("800");
            h3.appendChild(ul);
            div1.appendChild(h3);
            div1.appendChild(img);
            listaDeDivs.add(div1);




        }


        body.appendChild(listaDeDivs);

        alSalir.write(html.write());
        alSalir.flush();
        alSalir.close();



    }




    private String obtenerEstiloParaDiv(Boolean exitoso){
        if (exitoso){
            return "border-style: solid; border-width:thin; border-color:Green; border-width: medium;";
        }else{
            return "border-style: solid; border-width:thin; border-color:red; border-width: medium;";
        }
    }




    private String obtenerEstiloParaH3(Boolean exitoso){
        if (exitoso){
            return "background-color:LimeGreen ;color:black; display: inline";
        }else{
            return "background-color:Crimson;color:black; display: inline";
        }
    }



    private String obtenerStiloParaHR(int numeroDeFallas){
        if (numeroDeFallas<1){
            return "background-color:Green";
        }else{
            return "background-color:Red";
        }
    }





}
