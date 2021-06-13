package id.nexteam.kotlinspringhello.service

import id.nexteam.kotlinspringhello.model.CreateTodoRequest
import id.nexteam.kotlinspringhello.model.TodoResponse

interface TodoService {

    fun create(createTodoRequest: CreateTodoRequest): TodoResponse

    fun get(id: Long): TodoResponse

    fun update(id: Long, createTodoRequest: CreateTodoRequest): TodoResponse

    fun delete(id: Long)

    fun getAll() : List<TodoResponse>

}