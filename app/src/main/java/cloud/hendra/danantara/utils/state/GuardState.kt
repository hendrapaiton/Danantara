package cloud.hendra.danantara.utils.state

sealed class GuardState {
    object Authenticated : GuardState()
    object Unauthenticated : GuardState()
    object Loading : GuardState()
    data class Error(val message: String?) : GuardState()
}