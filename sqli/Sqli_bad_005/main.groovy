@Grab('mysql:mysql-connector-java:5.1.46')
@GrabConfig(systemClassLoader = true)
import groovy.sql.Sql

// Testing DB source to Sqli

Class.forName("com.mysql.jdbc.Driver");
url = 'jdbc:mysql://localhost:3306/test_db'
def user = 'root'
def password = 'password'
def driver = 'com.mysql.jdbc.Driver'

Sql.withInstance(url, user, password, driver) { sqlClient ->
    
    def dataFromDb = sqlClient.firstRow("select * from test order by id desc")
    def prevId = dataFromDb.id 
    println "Got ${prevId}"

    def newId = prevId + 1;

    // Sqli VULNERABILITY HERE
    def returnVal = sqlClient.execute "INSERT INTO Test (id, name, value) VALUES ($newId, 'NewName', 'NewValue')"

    println "Inserted and got $returnVal"
}
