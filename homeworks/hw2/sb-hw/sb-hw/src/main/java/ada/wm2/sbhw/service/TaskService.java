package ada.wm2.sbhw.service;

import ada.wm2.sbhw.entity.Employee;
import ada.wm2.sbhw.entity.Task;
import ada.wm2.sbhw.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTaskList() {
        List<Task> taskList = (List<Task>) taskRepository.findAll();


        return taskList;
    }
}