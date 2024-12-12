@Grab('mysql:mysql-connector-java:5.1.46')
@GrabConfig(systemClassLoader = true)
import groovy.sql.Sql

Class.forName("com.mysql.jdbc.Driver");
url = 'jdbc:mysql://localhost:3306/test_db'
def user = 'root'
def password = 'password'
def driver = 'com.mysql.jdbc.Driver'

def taint_key = System.env["TAINTED_INPUT"]
  
Sql.withInstance(url, user, password, driver) { sql ->
    
    // Sqli VULNERABILITY HERE
    sql.eachRow("select * from test where id='" + taint_key + "'") { row ->
      println "Got ${row.name}"
    }
 }
