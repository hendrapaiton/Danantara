package cloud.hendra.danantara.utils.state

sealed class ResultState<out T> {
    object Initial: ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val message: String? = "") : ResultState<Nothing>()
}