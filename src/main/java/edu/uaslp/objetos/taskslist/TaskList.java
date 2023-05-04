package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TaskList {
    private List <Task> taskList;
    public TaskList(){
        taskList = new ArrayList<>();
    }

    public int getSize() {
        return taskList.size();
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public void remove(Task task) {
        taskList.remove(task);
    }

    public Task find(String data) {
        Iterator <Task> iterator = taskList.iterator();
        Task task;
        do{
            task = iterator.next();
        }while(iterator.hasNext() && !data.equals(task.getTitle()));
        if(!data.equals(task.getTitle())){
            throw new TaskNotFoundException("Task with title 'Hacer ejercicio' not found");
        }
        return task;
    }

    public void markAsDone(String data) {
        Iterator <Task> iterator = taskList.iterator();
        Task task;
        int index = -1;
        do{
            task = iterator.next();
            index++;
        }while(iterator.hasNext() && !data.equals(task.getTitle()));
        task.setDone(true);

        taskList.set(index, task);
    }

    public void markAsNotDone(String data) {
        Iterator <Task> iterator = taskList.iterator();
        Task task;
        int index = -1;
        do{
            task = iterator.next();
            index++;
        }while(iterator.hasNext() && !data.equals(task.getTitle()));
        task.setDone(false);

        taskList.set(index, task);
    }

    public Task getNextTask() {
        Iterator <Task> iterator = taskList.iterator();
        iterator.next();
        return iterator.next();
    }

    public List<Task> getNextTasks() {
        List<Task> nextTasks = new ArrayList<>(taskList.size());
        Task taskAux = taskList.get(0);
        int index = -1;

        for (Task task : taskList) {
            if (!task.isDone()) {
                if(task.getDueDate().isAfter(taskAux.getDueDate()) ||task.getDueDate().isEqual(taskAux.getDueDate())){
                    nextTasks.add(task);
                }else{
                    nextTasks.add(task);
                    nextTasks.set(index, task);
                    nextTasks.set(index + 1, taskAux);
                }
                taskAux = task;
                index++;
            }
        }
        return nextTasks;
    }
}
