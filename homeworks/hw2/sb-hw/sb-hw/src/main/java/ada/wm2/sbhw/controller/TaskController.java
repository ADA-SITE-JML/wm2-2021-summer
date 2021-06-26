package ada.wm2.sbhw.controller;


import ada.wm2.sbhw.entity.Employee;
import ada.wm2.sbhw.entity.Task;
import ada.wm2.sbhw.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/list")
    public String getTaskList(Model model) {
        List<Task> taskList = taskService.getTaskList();

        model.addAttribute("tasks",taskList);
        return "task_list";
    }
}