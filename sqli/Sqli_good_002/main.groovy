@Grab('mysql:mysql-connector-java:5.1.46')
@Grab('org.jooq:jooq:3.14.6')
@Grab('org.jooq:jooq-meta:3.14.6')
@Grab('org.jooq:jooq-codegen:3.14.6')
@GrabConfig(systemClassLoader = true)

import org.jooq.*
import org.jooq.impl.DSL
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.PreparedStatement

def taint_key = System.getenv("TAINTED_INPUT")
def url = "jdbc:mysql://localhost:3306/test_db"
def username = "root"
def password = "password"

try (Connection conn = DriverManager.getConnection(url, username, password)) {
  // NOT VULNERABLE TO Sqli HERE
  String query = "SELECT id, name, value FROM TEST WHERE name = ?"
  PreparedStatement pstmt = conn.prepareStatement(query)
  pstmt.setString(1, taint_key)
  ResultSet rs = pstmt.executeQuery()

  while (rs.next()) {
    def id = rs.getInt("id")
    def name = rs.getString("name")
    def value = rs.getString("value")
    println("Got: $id, $name and $value")
  }
} catch (Exception e) {
  e.printStackTrace()
}

