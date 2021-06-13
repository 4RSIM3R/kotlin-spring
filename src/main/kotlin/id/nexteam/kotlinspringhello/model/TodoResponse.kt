package id.nexteam.kotlinspringhello.model

import java.util.*

data class TodoResponse(
        val task: String,
        val createdAt: Date?,
        val updateAt : Date?
)
