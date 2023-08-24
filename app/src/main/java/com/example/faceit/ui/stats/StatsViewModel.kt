package com.example.faceit.ui.stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faceit.data.model.MatchEntity
import com.example.faceit.data.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(private val matchRepository: MatchRepository) :
    ViewModel() {

    private val _statsLiveData = MutableLiveData<List<MatchEntity>>()
    val statsLiveData: LiveData<List<MatchEntity>>
        get() = _statsLiveData
    private val _errorLiveData = MutableLiveData<Exception>()
    val errorLiveData: LiveData<Exception>
        get() = _errorLiveData

    fun getStats(nickname: String) {
        viewModelScope.launch {
            try {
                _statsLiveData.value = matchRepository.getMatchEntity(nickname)
            } catch (e: Exception) {
                _errorLiveData.value = e
            }
        }

    }

}


