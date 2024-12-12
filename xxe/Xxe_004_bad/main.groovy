import java.io.File;
import groovy.xml.XmlParser;

// Parse XML 
XmlParser parser = new XmlParser(false,false,true);
parser.parseText(System.getenv("TAINTED_INPUT")); // XXE VULNERABILITY HERE