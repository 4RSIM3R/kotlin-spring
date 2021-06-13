package id.nexteam.kotlinspringhello.service.impl

import id.nexteam.kotlinspringhello.entity.Todo
import id.nexteam.kotlinspringhello.error.NotFoundException
import id.nexteam.kotlinspringhello.model.CreateTodoRequest
import id.nexteam.kotlinspringhello.model.TodoResponse
import id.nexteam.kotlinspringhello.repository.TodoRepository
import id.nexteam.kotlinspringhello.service.TodoService
import id.nexteam.kotlinspringhello.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TodoServiceImpl(
    val todoRepository: TodoRepository,
    val validationUtil: ValidationUtil,
) : TodoService {


    override fun create(createTodoRequest: CreateTodoRequest): TodoResponse {

        validationUtil.validate(createTodoRequest)

        val todo = Todo(
            task = createTodoRequest.task,
            createdAt = null,
            id = null,
            updatedAt = null
        )

        todoRepository.save(todo)

        return TodoResponse(
            task = todo.task,
            createdAt = todo.createdAt!!,
            updateAt = todo.updatedAt,
        )
    }

    override fun get(id: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(id)
        if (todo == null) {
            throw NotFoundException(message = "Task not found")
        } else {
            return TodoResponse(
                task = todo.task,
                createdAt = todo.createdAt!!,
                updateAt = todo.updatedAt,
            )
        }

    }

    override fun update(id: Long, createTodoRequest: CreateTodoRequest): TodoResponse {
        val todo = todoRepository.findByIdOrNull(id) ?: throw NotFoundException(message = "Task not found")

        todo.apply {
            task = createTodoRequest.task
        }

        todoRepository.save(todo)

        return TodoResponse(
            task = todo.task,
            updateAt = todo.updatedAt,
            createdAt = todo.createdAt,
        )

    }

    override fun delete(id: Long) {
        val todo = todoRepository.findByIdOrNull(id) ?: throw NotFoundException(message = "Task not found")
        todoRepository.delete(todo)
    }

    override fun getAll(): List<TodoResponse> {
        val todos = todoRepository.findAll()
        return todos.map {
            TodoResponse(
                task = it.task,
                updateAt = it.updatedAt,
                createdAt = it.createdAt
            )
        }
    }

}