package ada.wm2.sbhw.service;


import ada.wm2.sbhw.bean.EmployeeBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public List<EmployeeBean> getEmployeeList(){
        List<EmployeeBean> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeBean("Khanim Huseynzada", "Graphic Designer", "10:00–20:00"));
        employeeList.add(new EmployeeBean("Adalat Huseynzada", "Sales Manager", "9:00–19:00"));
        employeeList.add(new EmployeeBean("Narmina Aghayeva", "Web Designer", "9:00–18:00"));
        employeeList.add(new EmployeeBean("Nazrin Ibrahimli", "IOS Developer", "10:00–20:00"));

        return employeeList;
    }
}
