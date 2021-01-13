package net.javaci.Demo20200109;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/customer")
public class CustomerApi {

    @Autowired
    private CustomerDao customerDao;
    
    @GetMapping("/list")
    @ResponseBody
    public List<Customer> listAll(){
        return customerDao.findAll();
    }
    
    @PostMapping("/add")
    @ResponseBody
    public Customer add(@RequestBody Customer entity) {
        return customerDao.save(entity);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable("id") Long id) {
        customerDao.deleteById(id);
        return true;
    }
    
    @PutMapping("/update/{id}")
    @ResponseBody
    public Customer update(@PathVariable("id") Long id, Customer newValues) {
        if(customerDao.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        newValues.setId(id);
        return customerDao.save(newValues);
    }
}
