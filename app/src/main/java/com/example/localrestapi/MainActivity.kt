package com.example.localrestapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.localrestapi.uicontroller.DataSiswaApp
import com.example.localrestapi.ui.theme.LocalRestAPITheme // Sesuaikan dengan nama tema Anda

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengaktifkan tampilan edge-to-edge (opsional, standar project baru)
        enableEdgeToEdge()

        setContent {
            // Ganti 'LocalRestAPITheme' dengan nama tema yang ada di folder ui.theme Anda
            LocalRestAPITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Memanggil fungsi utama aplikasi dan mengirimkan modifier
                    DataSiswaApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}