package utils

import retrofit2.Response

suspend fun <T> safeCall(apiCall: suspend () -> Response<T>): ApiResponse<T> {

    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                ApiResponse.Success(it)
            } ?: ApiResponse.Failure("Empty Response")
        } else {
            ApiResponse.Failure("Error ${response.code()} - ${response.message()}")
        }

    } catch (e: Exception) {
        ApiResponse.Failure("Error:${e.localizedMessage}", e)
    }


}