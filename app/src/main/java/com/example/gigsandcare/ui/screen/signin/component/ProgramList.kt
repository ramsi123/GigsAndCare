package com.example.gigsandcare.ui.screen.signin.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gigsandcare.components.ProgramItem
import com.example.gigsandcare.data.model.Program

@Composable
fun ProgramList(
    modifier: Modifier = Modifier,
    programs: List<Program>,
    onClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier.heightIn(max = 520.dp),
        contentPadding = PaddingValues(bottom = 4.dp)
    ) {
        items(programs) { program ->
            ProgramItem(
                program = program,
                onCLick = onClick
            )
        }
    }
}