package id.nexteam.kotlinspringhello.controller

import id.nexteam.kotlinspringhello.error.NotFoundException
import id.nexteam.kotlinspringhello.model.RestResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletResponse
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(
        constraintViolationException: ConstraintViolationException,
        response: HttpServletResponse
    ): RestResponse<String> {
        response.status = 400
        return RestResponse(
            code = 400,
            status = "Bad Request",
            data = constraintViolationException.message!!,
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(notFoundException: NotFoundException, response: HttpServletResponse): RestResponse<String> {
        response.status = 404
        return RestResponse(
            code = 404,
            status = "Data Not Found",
            data = notFoundException.message,
        )
    }


}