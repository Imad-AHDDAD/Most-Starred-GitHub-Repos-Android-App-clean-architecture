package com.a7dev.moststarredgithubrepos_cleanarchitecture.ui.getMostStarredRepos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a7dev.domain.entity.ReposModel
import com.a7dev.domain.usecase.GetMostStarredRepos
import com.a7dev.moststarredgithubrepos_cleanarchitecture.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor (private val getMostStarredReposUseCase: GetMostStarredRepos) : ViewModel() {

    private val _mostStarredRepos: MutableStateFlow<ReposModel?> = MutableStateFlow(null)
    val mostStarredRepos : StateFlow<ReposModel?> = _mostStarredRepos
    
    private val _sort = MutableLiveData<String>("descending")
    val sort: LiveData<String>
        get() = _sort

    private val _imageUrl = MutableLiveData<Int>(R.drawable.ic_down)
    val imageUrl: LiveData<Int>
        get() = _imageUrl

    fun onSortMethodChange() {
        if(_sort.value.equals("descending")){
            _sort.value = "ascending"
            _imageUrl.value = R.drawable.ic_up
            getMostStarredRepositories(order = "asc")
        }else {
            _sort.value = "descending"
            _imageUrl.value = R.drawable.ic_down
            getMostStarredRepositories(order = "desc")
        }
    }
    fun getMostStarredRepositories(order: String = "desc") {
        val q = getCreatedValue()
        val sort = "stars"
        val page = 1
        viewModelScope.launch {
            try {
                _mostStarredRepos.value = getMostStarredReposUseCase(q, sort, order, page)
            } catch (e: Exception) {
                Log.e("ERROR_VM", "error: ${e.message}")
            }
        }
    }

    private fun getCreatedValue(): String {
        val date30daysAgo: String
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -30)
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        date30daysAgo = formatter.format(calendar.time)
        return "created:>$date30daysAgo"
    }
}