package com.example.localrestapi.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.localrestapi.uicontroller.route.DestinasiEdit
import com.example.localrestapi.viewmodel.EditViewModel
import com.example.localrestapi.viewmodel.provider.PenyediaViewModel
import kotlinx.coroutines.launch
