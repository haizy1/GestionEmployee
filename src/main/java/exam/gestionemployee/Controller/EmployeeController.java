package exam.gestionemployee.Controller;

import exam.gestionemployee.Entity.Employee;
import exam.gestionemployee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/save")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/find/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }


    @Autowired
    private MessageSource messageSource;

    @GetMapping("/notfound")
    public String employeeNotFound(Locale locale) {
        return messageSource.getMessage("message.employee.notfound", null, locale);
    }

    @GetMapping("/email-exists")
    public String emailExists(Locale locale) {
        return messageSource.getMessage("message.employee.email.exists", null, locale);
    }

    @GetMapping("/added")
    public String employeeAdded(Locale locale) {
        return messageSource.getMessage("message.employee.added.success", null, locale);
    }
}
