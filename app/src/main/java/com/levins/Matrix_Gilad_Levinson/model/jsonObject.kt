package com.levins.Matrix_Gilad_Levinson.model

data class jsonObject(
    val DataObject: DataObject
)

data class DataObject(
    val DataListCat: List<DataCat>,
    val DataListObject: List<DataObjectX>
)

data class DataCat(
    val CTitle: String,
    val CatId: Int
)

data class DataObjectX(
    val CatId: Int,
    val ClET: Boolean,
    val DataListAddr: List<DataAddr>,
    val Id: Int,
    val Imag: String,
    val NOV: String,
    val STitle: String,
    val Title: String
)

data class DataAddr(
    val Addr: String,
    val DAd: String
)