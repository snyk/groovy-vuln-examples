import java.io.File;
import java.net.URLEncoder;

import groovy.xml.XmlSlurper;

// Get XML
def tainted_xml = new File("someFile.xml");

def tainted_string = tainted_xml.text;

// Technically wouldn't be valid XML, but also not vulnerable to XXE
def sanitized_string = URLEncoder.encode(tainted_string);

// Parse XML 
def vulnerable_slurper = new XmlSlurper(false,false,true);
vulnerable_slurper.parseText(); // NOT VULNERABLE TO XXE HERE