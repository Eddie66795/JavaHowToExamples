import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDValidator {

    private final String XSD = "/Users/Eduard/RubymineProjects/JavaHowToExamples/JavaExamples/resources/students.xsd";
    private final String XML = "/Users/Eduard/RubymineProjects/JavaHowToExamples/JavaExamples/resources/students.xml";

    public static void main(String[] args) {
        new XSDValidator();
    }

    public boolean fileExist(String fileLocation) {
        File file = new File(fileLocation);
        return file.exists();
    }

    public XSDValidator() {
        if(fileExist(XSD) && fileExist(XML)) {
            boolean isValid = validateXMLSchema(XSD, XML);
            if(isValid) {
                System.out.println("VALID!");
            } else {
                System.out.println("NOT VALID!");
            }
        } else {
            System.out.println("FILE NOT FOUND");
        }
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }catch(SAXException e1){
            System.out.println("SAX Exception: "+e1.getMessage());
            return false;
        }

        return true;
    }
}