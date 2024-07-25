package com.example.gigsandcare.ui.screen.event_calendar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.components.AddEventBottomSheet
import com.example.gigsandcare.data.model.EventCalendar
import com.example.gigsandcare.ui.screen.event_calendar.component.EventCalendarContent
import com.example.gigsandcare.util.Constants.EVENT_CALENDAR
import com.example.gigsandcare.util.Constants.PICK_DATE
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCalendarScreen(
    modifier: Modifier = Modifier,
    viewModel: EventCalendarViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val calendarState = rememberUseCaseState()
    var search by remember { mutableStateOf("") }
    var showSheet by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isDateSelected by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val selectedDateText by remember { mutableStateOf(PICK_DATE) }
    val eventCalendar by viewModel.eventCalendar.collectAsState()
    val eventCalendarItem by viewModel.eventCalendarItem.collectAsState()

    // get latest event calendar everytime there is changes in bottom sheet
    LaunchedEffect(key1 = showSheet) {
        viewModel.getEventCalendar()
    }

    // get event calendar data
    LaunchedEffect(key1 = eventCalendarItem) {
        if (eventCalendarItem.isNotEmpty()) {
            title = eventCalendarItem[0].title
            selectedDate = LocalDate.parse(eventCalendarItem[0].date, DateTimeFormatter.ISO_LOCAL_DATE)
            description = eventCalendarItem[0].description
            showSheet = true
        }
    }

    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true,
            style = CalendarStyle.MONTH
        ),
        selection = CalendarSelection.Date(
            selectedDate = selectedDate
        ) { date ->
            selectedDate = date
        }
    )

    if (showSheet) {
        AddEventBottomSheet(
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
            title = title,
            onTitleChange = {
                title = it
            },
            date = if (isDateSelected || eventCalendarItem.isNotEmpty()) selectedDate.toString() else selectedDateText,
            description = description,
            onDescriptionChange = {
                description = it
            },
            onDismiss = { showSheet = false },
            onClickDatePicker = {
                isDateSelected = true
                calendarState.show()
            },
            onClickAddEvent = {
                viewModel.addEventCalendar(
                    eventCalendar = EventCalendar(
                        title = title,
                        date = selectedDate.toString(),
                        description = description
                    )
                )
                showSheet = false
                title = ""
                description = ""
                isDateSelected = false
                selectedDate = LocalDate.now()
            }
        )
    }

    EventCalendarContent(
        modifier = modifier,
        title = EVENT_CALENDAR,
        search = search,
        eventCalendar = eventCalendar,
        onSearchChange = {
            search = it
        },
        onClickFab = {
            showSheet = true
        },
        navigateToEventItem = {
            viewModel.getEventCalendarItem(it)
        }
    )
}