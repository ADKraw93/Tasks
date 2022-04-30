package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksMapperTest {

    private TaskMapper taskMapper = new TaskMapper();

    @Test
    void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title", "content");

        //When
        Task resultTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(Task.class, resultTask.getClass());
        assertEquals(1L, resultTask.getId());
        assertEquals("title", resultTask.getTitle());
        assertEquals("content", resultTask.getContent());
    }

    @Test
    void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "title", "content");

        //When
        TaskDto resultTaskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(TaskDto.class, resultTaskDto.getClass());
        assertEquals(1L, resultTaskDto.getId());
        assertEquals("title", resultTaskDto.getTitle());
        assertEquals("content", resultTaskDto.getContent());
    }

    @Test
    void mapToTaskDtoListTest() {
        //Given
        List<Task> tasksList = new ArrayList<>();
        tasksList.add(new Task(1L, "title", "content"));
        //When
        List<TaskDto> resultList = taskMapper.mapToTaskDtoList(tasksList);
        //Then
        assertEquals(1, resultList.size());
        assertEquals(TaskDto.class, resultList.get(0).getClass());
    }
}
