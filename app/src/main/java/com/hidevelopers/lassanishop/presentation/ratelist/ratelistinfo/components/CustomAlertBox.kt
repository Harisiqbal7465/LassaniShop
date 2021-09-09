package com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hidevelopers.lassanishop.data.local.dto.OwnRateListDto
import com.hidevelopers.lassanishop.presentation.components.StandardAlertDialog
import com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.RateListViewModel

@Composable
fun CustomAlertBox(
    navController: NavController,
    openDialog: (Boolean) -> Unit,
    radioButtonOptions: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    listName: String,
    onListNameChange: (String) -> Unit,
    viewModel: RateListViewModel = hiltViewModel()
) {
    val insertOwnRateListValue = viewModel.insertOwnRateListState.value
    val getSizeOwnRateList = viewModel.getSizeOwnRateList.value
    StandardAlertDialog(
        openDialog = { openDialog(it) },
        title = {
            Text(
                text = "RateList Info",
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 10.dp),
                style = MaterialTheme.typography.h2,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .selectableGroup()
            ) {
                Text(text = "")
                OutlinedTextField(
                    modifier = Modifier.padding(top = 5.dp),
                    value = listName,
                    onValueChange = onListNameChange,
                    label = {
                        Text(text = "List Name",color = Color.White,)
                    }
                )
                Text(
                    color = Color.White,
                    text = "List Category",
                    modifier = Modifier.padding(top = 10.dp)
                )
                Row(modifier = Modifier.padding(top = 10.dp)) {
                    radioButtonOptions.forEach { text ->
                        Row(
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .height(40.dp)
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = { onOptionSelected(text) },
                                    role = Role.RadioButton
                                ),
                            //verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            )
                            Text(
                                text = text,
                                style = MaterialTheme.typography.body1.merge(),
                                modifier = Modifier.padding(start = 10.dp),
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = viewModel.dialogErrorMessage.value,
                    color = MaterialTheme.colors.error
                )
            }
        },
        dismissButton = {
            TextButton(onClick = { openDialog(false) }) {
                Text(text = "Close")
            }
        }
    ) {
        Button(
            onClick = {
                if (listName.isNotEmpty()) {
                    if (selectedOption == radioButtonOptions[0]) {

                    } else {
                        val value = OwnRateListDto(
                            ownRateListId = 0,
                            ownRateListName = listName
                        )
                        value.sizeList = getSizeOwnRateList.isSuccess ?: 0
                        viewModel.insertOnwRateList(value)
                    }
                    onListNameChange("")
                    onOptionSelected("Company")
                    openDialog(false)
                } else {
                    viewModel.setDialogErrorMessage("Please put list name")
                }

            }
        ) {
            if (insertOwnRateListValue.isLoading) {
                CircularProgressIndicator()
            } else {
                Text("Confirm")
            }
        }
    }
}

