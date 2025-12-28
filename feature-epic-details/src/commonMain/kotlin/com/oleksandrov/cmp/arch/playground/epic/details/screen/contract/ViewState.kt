package com.oleksandrov.cmp.arch.playground.epic.details.screen.contract

import androidx.compose.runtime.Immutable
import com.oleksandrov.cmp.arch.playground.epic.details.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.mvi.MviViewState
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.mvi.MviViewStateSaver

@Immutable
//@Parcelize
internal data class ViewState(
    val epicUiModel: EpicUiModel? = null,
) : MviViewState {
//    Parcelable {
    companion object {
        private const val VIEW_STATE_KEY = "com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.ViewState"
    }

    class StateSaver : MviViewStateSaver<ViewState> {
//        override fun ViewState.toBundle(): Bundle = bundleOf(VIEW_STATE_KEY to this)

//        override fun restore(bundle: Bundle?): ViewState = bundle
//            ?.parcelable<ViewState>(VIEW_STATE_KEY)
//            ?.copy(isProcessing = false)
//            ?: ViewState()
    }
}
