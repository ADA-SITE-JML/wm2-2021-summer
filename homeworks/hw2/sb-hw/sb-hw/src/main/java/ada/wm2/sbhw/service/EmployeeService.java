package ada.wm2.sbhw.service;


import ada.wm2.sbhw.entity.Employee;
import ada.wm2.sbhw.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getEmployeeList(){
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();


        return employeeList;
    }
}
