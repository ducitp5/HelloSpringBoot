package viblo.asia.springboottodo.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viblo.asia.springboottodo.Entity.Todo;
import viblo.asia.springboottodo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestApiController{

    @Autowired
    private TodoService todoService;

    List<Todo> todoList;

    @PostConstruct
    public void init(){
        // Thêm null vào List để bỏ qua vị trí số 0;
//        todoList.add(null);
    }

    @GetMapping("/todo")
    public List<Todo> getTodoList(@RequestParam(required = false) Integer limit) {

        return todoList = todoService.findAll(limit);
    }

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        todoList.add(todo);

        return ResponseEntity.ok().body(todo);
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId){

        return todoList.get(todoId);
    }

}
