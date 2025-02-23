package cloud.hendra.danantara.domain.model

import com.google.gson.annotations.SerializedName

data class Saldo(
    val id: Int,
    val shift: String,
    val date: String,
    val awal: Double,
    val open: Boolean
)

data class SaldoRequest(
    val shift: String,
    val awal: Int
)

data class SaldoResponse(
    @SerializedName("has_open_saldo") val hasOpenSaldo: Boolean,
    val saldo: Saldo
)