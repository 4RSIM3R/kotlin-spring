package id.nexteam.kotlinspringhello.repository

import id.nexteam.kotlinspringhello.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {



}