package frameworkPruebas.Libreria.acciones;

import org.openqa.selenium.By;

public class ConstructorDeXpath {




//div[@class='mini-tours']//a
//*[text()='España']/parent::div//a[contains(text(),'strenos')]
//*[@class='movie-card-13']//div[starts-with(text(),'The')]
//*[text()='España' and @class='lsmheader']/parent::div//a[contains(text(),'strenos')]   =   //*[text()='España'][@class='lsmheader']/parent::div//a[contains(text(),'strenos')]

    //XpathBuilder.any("div").text("España").attribute("class", "lsmheader).toBy

    private StringBuilder constructorXpath = new StringBuilder();


//  busque todo los que contenga
    public ConstructorDeXpath todo(){
        constructorXpath.append("//*");
        return this;
    }

    public ConstructorDeXpath abajo(String value){
        constructorXpath.append("//").append(value);
        return this;
    }

    public ConstructorDeXpath hijo(String value){
        constructorXpath.append("/").append(value);
        return this;
    }

//    public XpathBuilder down(String value){
//        sb.append("//").append(value);
//        return this;
//    }

    public ConstructorDeXpath atributo(String class_id_etiqueta, String valor_class_id_etiqueta){
        constructorXpath.append("[@").append(class_id_etiqueta).append("='").append(valor_class_id_etiqueta).append("']");
        return this;
    }

    public ConstructorDeXpath Tiene_Texto(String valor_texto){
        constructorXpath.append("[text()='").append(valor_texto).append("']");
        return this;
    }

    public ConstructorDeXpath texto_Contiene(String value){
        constructorXpath.append("[contains(text(),'").append(value).append("')]");
        return this;
    }


    public ConstructorDeXpath padre(String valor_padre){
        constructorXpath.append("/parent::").append(valor_padre);
        return this;
    }

    public ConstructorDeXpath contiene_Atributo(String class_id_etiqueta, String valor_class_id_etiqueta){
        constructorXpath.append("[contains(@").append(class_id_etiqueta).append(",'").append(valor_class_id_etiqueta).append("')]");
        return this;
    }

    public ConstructorDeXpath Inicia_con_atributo(String class_id_etiqueta, String valor_class_id_etiqueta){
        constructorXpath.append("[starts-with(@").append(class_id_etiqueta).append(",'").append(valor_class_id_etiqueta).append("')]");
        return this;
    }

    public ConstructorDeXpath texto_inicia_con(String texto){
        constructorXpath.append("[starts-with(text(),'").append(texto).append("')]");
        return this;
    }

    public ConstructorDeXpath seguido_por(String valor){
        constructorXpath.append("/following::").append(valor);
        return this;
    }

    public ConstructorDeXpath id(String valor_id){

        return this.atributo("id", valor_id);
    }

    public ConstructorDeXpath clase(String valor_class){

        return this.atributo("class", valor_class);
    }


    public By toBy(){
        return By.xpath(constructorXpath.toString());
    }


    @Override
    public String toString(){
        return constructorXpath.toString();
    }









}
