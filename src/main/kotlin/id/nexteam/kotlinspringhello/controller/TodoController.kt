package id.nexteam.kotlinspringhello.controller

import id.nexteam.kotlinspringhello.model.CreateTodoRequest
import id.nexteam.kotlinspringhello.model.RestResponse
import id.nexteam.kotlinspringhello.model.TodoResponse
import id.nexteam.kotlinspringhello.service.TodoService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class TodoController(val todoService: TodoService) {

    @GetMapping(
        value = ["/todo/{id}"],
        produces = ["application/json"]
    )
    fun getTodo(@PathVariable("id") id: Long): RestResponse<TodoResponse> {
        val todoResponse = todoService.get(id)
        return RestResponse(
            code = 200,
            status = "Success getting a todo",
            data = todoResponse
        )
    }

    @GetMapping(
        value = ["/todos"],
        produces = ["application/json"]
    )
    fun getAllTodo(): RestResponse<List<TodoResponse>> {
        val todos = todoService.getAll()
        return RestResponse(
            code = 200,
            status = "Success getting all todo",
            data = todos
        )
    }

    @PostMapping(
        value = ["todo"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createTodo(@RequestBody body: CreateTodoRequest): RestResponse<TodoResponse> {
        val todoResponse = todoService.create(body)
        return RestResponse(
            code = 200,
            status = "Success add new todo",
            data = todoResponse
        )
    }


    @PutMapping(
        value = ["/todo/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTodo(
        @PathVariable("id") id: Long,
        @RequestBody createTodoRequest: CreateTodoRequest
    ): RestResponse<TodoResponse> {
        val todoResponse = todoService.update(id, createTodoRequest)
        return RestResponse(
            code = 200,
            status = "Success updating todo",
            data = todoResponse
        )
    }


    @DeleteMapping(
        value = ["/todo/{id}"],
        produces = ["application/json"]
    )
    fun deleteTodo(@PathVariable("id") id: Long): RestResponse<String> {
        todoService.delete(id)
        return RestResponse(
            data = "",
            status = "Success deleting todo",
            code = 200,
        )
    }


}