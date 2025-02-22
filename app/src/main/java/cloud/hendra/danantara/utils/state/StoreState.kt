package cloud.hendra.danantara.utils.state

sealed class StoreState {
    object Loading : StoreState()
    object Closed : StoreState()
    object Open : StoreState()
}