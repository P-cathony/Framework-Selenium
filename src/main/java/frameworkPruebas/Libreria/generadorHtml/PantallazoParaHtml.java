package frameworkPruebas.Libreria.generadorHtml;

import frameworkPruebas.Libreria.configuracion.ConfiguracionFramework;
import frameworkPruebas.Libreria.configuracion.RegistroPruebas;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class PantallazoParaHtml {
    public PantallazoParaHtml(WebElement webElement) {
        this.webElement = webElement;
    }

    private WebElement webElement;


    public String getPantallazo(boolean dibujoRectangulo){
        File pantallazo = ((TakesScreenshot) ConfiguracionFramework.driver).getScreenshotAs(OutputType.FILE);
        BufferedImage imagenCompleta = null;

        // Get page screenshot
        try{
            imagenCompleta = ImageIO.read(pantallazo);
        }catch(IOException e){
            RegistroPruebas.setReporteDeErrores("Error en tomar pantallazo");
        }

        if (dibujoRectangulo){
            // obtener localizacion de elemento en la pagina
            Point point = webElement.getLocation();

            // stroke establecer estilos para graficos primitivos
            Stroke stroke1 = new BasicStroke(6f);

            // obtener alto y ancho
            int webElementWidth = webElement.getSize().getWidth();
            int webElementHeight = webElement.getSize().getHeight();

            // dibujar rectangulo
            Graphics2D g2d = imagenCompleta.createGraphics();
            g2d.setColor(Color.MAGENTA);
            g2d.setStroke(stroke1);
            g2d.drawRect(point.getX(), point.getY(), webElementWidth, webElementHeight);
            g2d.dispose();
        }

        // convertir archivos en byte
        ByteArrayOutputStream convertirBytes = new ByteArrayOutputStream();
        try {

            ImageIO.write(imagenCompleta, "png", convertirBytes);

        } catch (Exception e) {
            System.out.println("[ERROR] no se pudo guardar la imagen.");
        }

        return new String(Base64.getEncoder().encodeToString(convertirBytes.toByteArray()));
    }


}
