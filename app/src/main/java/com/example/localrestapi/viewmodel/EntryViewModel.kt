package com.example.localrestapi.viewmodel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.localrestapi.modeldata.DetailSiswa
import com.example.localrestapi.modeldata.UIStateSiswa
import com.example.localrestapi.modeldata.toDataSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import retrofit2.Response


class EntryViewModel(
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(
        uiState: DetailSiswa = uiStateSiswa.detailSiswa
    ): Boolean {
        return uiState.nama.isNotBlank()
                && uiState.alamat.isNotBlank()
                && uiState.telpon.isNotBlank()
                && uiState.telpon.all { it.isDigit() } // 🔴 PENTING
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    suspend fun addSiswa() {
        if (!validasiInput()) {
            println("Validasi gagal")
            return
        }

        try {
            val response = repositoryDataSiswa.postDataSiswa(
                uiStateSiswa.detailSiswa.toDataSiswa()
            )

            if (response.isSuccessful) {
                println("✅ Sukses tambah data")
            } else {
                println("❌ Gagal: ${response.errorBody()?.string()}")
            }

        } catch (e: Exception) {
            println("🔥 Error kirim data: ${e.message}")
        }
    }
}