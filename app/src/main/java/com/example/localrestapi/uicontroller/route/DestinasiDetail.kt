package com.example.localrestapi.uicontroller.route

import com.example.localrestapi.R

object DestinasiDetail: DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val ITEM_ID_ARG = "idSiswa"
    val routeWithArgs = "$route/{$ITEM_ID_ARG}"
}