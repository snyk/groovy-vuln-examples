import java.io.File;
import groovy.xml.XmlSlurper;

// Get XML
def tainted_xml = new File("someFile.xml");

// Parse XML 
def parser = new XmlSlurper(false,false,true);
parser.parseText(tainted_xml.text); // XXE VULNERABILITY HERE