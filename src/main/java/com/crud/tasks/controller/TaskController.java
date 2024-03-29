package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/v1/task")
public class Controller {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;
    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTasskDtoList(service.getAllTasks());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto  getTask(Long taskId){
        return new TaskDto(1L,"test title","test_content");
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(Long taskId){
    }
    @RequestMapping(method = RequestMethod.GET, value = "updateTask")
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto(1L,"Edited test title","Test content");
    }
    @RequestMapping(method = RequestMethod.PUT, value = "createTask")
    public void createTask(TaskDto taskDto){

    }
}

