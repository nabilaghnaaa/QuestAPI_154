package com.example.localrestapi.uicontroller.route
import com.example.localrestapi.R

object DestinasiEdit: DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val ITEM_ID_ARG = "idSiswa"
    val routeWithArgs = "$route/{$ITEM_ID_ARG}"
}