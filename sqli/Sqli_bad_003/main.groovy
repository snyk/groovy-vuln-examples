@Grab('org.springframework.boot:spring-boot-starter-jdbc')
@Grab('mysql:mysql-connector-java:5.1.46')
@GrabConfig(systemClassLoader = true)

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource

def dataSource = new DriverManagerDataSource()
dataSource.setDriverClassName('com.mysql.jdbc.Driver')
dataSource.setUrl('jdbc:mysql://localhost:3306/test_db')
dataSource.setUsername('root')
dataSource.setPassword('password')

def taint_key = System.getenv("TAINTED_INPUT")


def jdbcTemplate = new JdbcTemplate(dataSource)
def sql = "SELECT id, name, value FROM TEST WHERE name='$taint_key'"

// Sqli VULNERABILITY HERE
jdbcTemplate.query(sql, new RowMapper<Map<String, Object>>() {
  @Override
  Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {


    def id = rs.getString('id')
    def name = rs.getString('name')
    def value = rs.getString('value')


    println("Got: $id, $name and $value")
  }
})

