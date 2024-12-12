import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory
import java.io.StringReader

// Get XML
String tainted_xml = new File("someFile.xml").text;
def reader = new StringReader(tainted_xml);

// Parse XML
def document = DOMBuilder.parse(reader); // XXE VULNERABILITY HERE