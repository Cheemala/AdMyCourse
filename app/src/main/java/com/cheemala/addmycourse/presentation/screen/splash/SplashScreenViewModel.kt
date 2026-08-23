package com.cheemala.addmycourse.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheemala.addmycourse.domain.use_cases.DatastoreUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(private val datastoreUsecases: DatastoreUsecases) :
    ViewModel() {

    private val _onBoardingCompletedState = MutableStateFlow(false)
    val onBoardingCompletedState = _onBoardingCompletedState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _onBoardingCompletedState.value =
                datastoreUsecases.readOnboardingState().stateIn(viewModelScope).value
        }
    }

}