package id.nexteam.kotlinspringhello.model

data class RestResponse<T>(
        val code: Int,
        val status: String,
        val data: T
)
