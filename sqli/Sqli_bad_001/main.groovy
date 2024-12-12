@Grab('mysql:mysql-connector-java:5.1.46')
@GrabConfig(systemClassLoader = true)

// Based on https://groovy-lang.org/databases.html

import groovy.sql.Sql

Class.forName("com.mysql.jdbc.Driver");
def url = 'jdbc:mysql://localhost:3306/test_db'
def user = 'root'
def password = 'password'
def driver = 'com.mysql.jdbc.Driver'
def sql = Sql.newInstance(url, user, password, driver)

def taint_key = System.getenv("TAINTED_INPUT")

// Sqli VULNERABILITY HERE
sql.query("SELECT id, name, value FROM TEST WHERE name='$taint_key'", { resultSet ->
  while (resultSet.next()) {
    def id = resultSet.getString("id")
    def name = resultSet.getString('name')
    def value = resultSet.getString('value')

    println "Id is ${id}, name is ${name}, value is ${value}"
  }
})


sql.close()
