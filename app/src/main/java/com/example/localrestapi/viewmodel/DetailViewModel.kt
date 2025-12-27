package com.example.localrestapi.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localrestapi.modeldata.DataSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import com.example.localrestapi.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi
import java.io.IOException
import retrofit2.HttpException
import retrofit2.Response