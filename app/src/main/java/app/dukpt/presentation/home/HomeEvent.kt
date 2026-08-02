package app.dukpt.presentation.home


sealed interface HomeEvent {

    data class BdkChanged(val value: String) : HomeEvent

    data class KsnChanged(val value: String) : HomeEvent

    data class PlainTextChanged(val value: String) : HomeEvent

    data object GenerateClicked : HomeEvent

    data object ClearClicked : HomeEvent
}