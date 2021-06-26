package ada.wm2.sbhw.controller;

import ada.wm2.sbhw.bean.EmployeeBean;
import ada.wm2.sbhw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/list")
    public String getEmployeeList(Model model){
        List<EmployeeBean> employeeList= employeeService.getEmployeeList();
        model.addAttribute("employees", employeeList);
    return "employee_list";
    }
}
