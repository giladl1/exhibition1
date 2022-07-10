package com.levins.Matrix_Gilad_Levinson

import com.google.android.gms.maps.model.LatLng


data class ItemData(
    val title:String,
    val description:String,
    val locationDescription:String?,
    val latLng: LatLng
)