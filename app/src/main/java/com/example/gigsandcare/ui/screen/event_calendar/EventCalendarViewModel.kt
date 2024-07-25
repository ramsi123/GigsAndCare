package com.example.gigsandcare.ui.screen.event_calendar

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.EventCalendar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventCalendarViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    private val _eventCalendar: MutableStateFlow<List<EventCalendar>> = MutableStateFlow(emptyList())
    val eventCalendar: StateFlow<List<EventCalendar>> = _eventCalendar.asStateFlow()

    private val _eventCalendarItem: MutableStateFlow<List<EventCalendar>> = MutableStateFlow(emptyList())
    val eventCalendarItem: StateFlow<List<EventCalendar>> = _eventCalendarItem.asStateFlow()

    fun addEventCalendar(eventCalendar: EventCalendar) {
        viewModelScope.launch {
            repository.addEventCalendar(eventCalendar)
        }
    }

    fun getEventCalendar() {
        viewModelScope.launch {
            repository.getEventCalendar()
                .catch {
                    Log.e("Error", "$it")
                }
                .collect { eventCalendar ->
                    _eventCalendar.value = eventCalendar
                }
        }
    }

    fun getEventCalendarItem(eventCalendarId: String) {
        viewModelScope.launch {
            repository.getEventCalendarItem(eventCalendarId)
                .catch {
                    Log.e("Error", "$it")
                }
                .collect { eventCalendarItem ->
                    _eventCalendarItem.value = eventCalendarItem
                }
        }
    }

}