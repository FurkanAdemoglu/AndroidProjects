package com.example.hiltmvvmmvi.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.hiltmvvmmvi.model.Blog
import com.example.hiltmvvmmvi.repository.MainRepository
import com.example.hiltmvvmmvi.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle

):ViewModel(){

    private val _dataState:MutableLiveData<DataState<List<Blog>>> = MutableLiveData()

    val dataState:LiveData<DataState<List<Blog>>>
    get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetBlogEvents->{
                    mainRepository.getBlog()
                        .onEach {dataState ->
                        _dataState.value=dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None->{

                }
            }
        }
    }
}

sealed class MainStateEvent{
    object GetBlogEvents:MainStateEvent()

    object None:MainStateEvent()
}