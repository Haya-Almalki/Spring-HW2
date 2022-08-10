package com.example.task_tracker_system.controller;
import com.example.task_tracker_system.model.APIResponse;
import com.example.task_tracker_system.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TaskController {

    ArrayList<Task> tasks=new ArrayList<>();


    @GetMapping("/task")
    public ArrayList getTask(){
        return tasks;
    }

    @PostMapping("/task")
    public APIResponse addTask(@RequestBody Task task){
        tasks.add(task);
        return new APIResponse("Task added");
    }
    @PutMapping("/task/{index}")
    public APIResponse updateTask(@PathVariable int index, @RequestBody Task task){
        tasks.set(index,task);
        return new APIResponse("Task updated");

    }
    @DeleteMapping("/task/{index}")
    public APIResponse deleteTask(@PathVariable int index){
        tasks.remove(index);
        return new APIResponse("Task deleted");
    }

    @PostMapping ("task/change")
    public APIResponse changeStatus(@RequestParam int index, @RequestParam String status){
        Task task=tasks.get(index);
        task.setStatus(status);
        return new APIResponse(" status Change ok");
    }

    @GetMapping("task/search")
    public ArrayList getTaskByTitle(@RequestParam String title){
        ArrayList<Task> task=new ArrayList<>();
        for (int i = 0; i <tasks.size() ; i++) {
            if(tasks.get(i).getTitle().equals(title)){
                task.add(tasks.get(i));
            }
        }
        return task;
    }
}
