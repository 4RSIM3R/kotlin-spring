package id.nexteam.kotlinspringhello.model

import javax.validation.constraints.NotBlank

data class CreateTodoRequest(
        @field:NotBlank
        val task: String
)
