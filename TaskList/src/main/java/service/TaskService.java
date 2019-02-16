package service;


import model.Task;
import repository.TaskDAO;
import repository.TaskDTO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TaskService {

    @Inject
    private TaskDAO taskDAO;


    public void saveTask (TaskDTO taskDTO) {
        Task task = new Task();

        task.setId(taskDTO.getId());
        task.setContent(taskDTO.getContent());
        task.setDate(taskDTO.getDate());
        task.setStatus(taskDTO.getStatus());

        taskDAO.saveTask(task);
    }
}
