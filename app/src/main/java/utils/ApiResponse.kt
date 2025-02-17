package utils

sealed class ApiResponse<out T>() {

    class Success<T>(val data: T) : ApiResponse<T>()
    class Failure(val message: String, val e: Throwable?=null) : ApiResponse<Nothing>()

    object Loading : ApiResponse<Nothing>()

}
