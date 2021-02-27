package net.javaci.dbsample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

@SpringBootApplication
public class SpringJdbcTemplateApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Uygulama acildi : " + jdbcTemplate.getDataSource().getConnection());
        
        createTableIfNotExists();
        addRecords();
        readResults1();
        readResults2();
        readResults3();
        
        System.out.println("Uygulama kapandi");
        
    }

    private void readResults3() {
        
        System.out.println("readResults3 : ");
        
        List<Customer> resultList = jdbcTemplate.query("SELECT * FROM customer", 
            new BeanPropertyRowMapper<Customer>(Customer.class)
        );
        resultList.forEach(System.out::println);
        
    }
    
    private static class Customer {
        private int id;
        private String name;
        public void setId(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "id: " + id + "," + "name:"+name;
        }
    }

    private List<Customer> readResults2() {
        
        List<Customer> resultList = new ArrayList<>();
        
        System.out.println("readResults2 : ");
        
        List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM customer");
        for (Map<String, Object> columnData : result) {
            int id = (Integer) columnData.get("id");
            String name = (String) columnData.get("name");
            System.out.printf("id: %d , name: %s\n", id, name);
            
            Customer temp = new Customer();
            temp.setId(id);
            temp.setName(name);
            resultList.add(temp);
            
        }

        return resultList;
    }

    private void readResults1() {
        System.out.println("readResults1 : ");
        
        ResultSetExtractor<Boolean> rse1 = resultSet -> printResultSet(resultSet);
        
        ResultSetExtractor<Boolean> rse2 = new ResultSetExtractor<Boolean>() {
            @Override
            public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
                return printResultSet(rs);
            }
        };
        
        ResultSetExtractor<Boolean> rse3 = new MyResultSetExtractor();
        jdbcTemplate.query("SELECT * FROM customer", rse3 );
    }
    
    private static class MyResultSetExtractor implements ResultSetExtractor<Boolean> {

        @Override
        public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
            return printResultSet(rs);
        }     
    }

    private static Boolean printResultSet(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            
            String name = resultSet.getString(2);
            int id = resultSet.getInt("id");
            System.out.printf("id: %d , name: %s\n", id, name);
            
        }
        return true;
    }

    private void addRecords() {
        jdbcTemplate.execute("INSERT INTO customer VALUES (1, 'tom')");
    }

    private void createTableIfNotExists() {
        jdbcTemplate.execute("CREATE TABLE customer (id int primary key, name varchar(30) )");
    }

}
