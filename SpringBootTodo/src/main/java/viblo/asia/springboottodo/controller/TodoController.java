package viblo.asia.springboottodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import viblo.asia.springboottodo.Entity.Todo;
import viblo.asia.springboottodo.service.TodoService;

import java.util.Optional;

@Controller
@RequestMapping("/db")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /*
    @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
    Nó sẽ gán dữ liệu của param-name tương ứng vào biến
     */
    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList.
        model.addAttribute("todoList", todoService.findAll(limit));
        // Trả về template "listTodo.html"
        return "db/listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "db/addTodo";
    }

    /*
    @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
     */
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        return Optional.ofNullable(todoService.add(todo))
                .map(t -> "db/success") // Trả về success nếu save thành công
                .orElse("failed"); // Trả về failed nếu không thành công

    }
}

