import java.io.File;
import groovy.xml.XmlParser;

// Parse XML 
XmlParser parser = new XmlParser(false,false,true);
parser.parseText(new File("someFile.xml").text); // XXE VULNERABILITY HERE