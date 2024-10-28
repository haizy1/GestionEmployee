package exam.gestionemployee.Service;

import exam.gestionemployee.Entity.Employee;
import exam.gestionemployee.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    //CRUD
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }
    public Employee findById(int id) {
        return employeeRepo.findById(id).get();
    }

    public void delete(int id) {
        employeeRepo.deleteById(id);
    }
}
