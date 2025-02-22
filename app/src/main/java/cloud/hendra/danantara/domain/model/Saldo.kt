package cloud.hendra.danantara.domain.model

data class Saldo(
    val id: Int,
    val shift: String,
    val date: String,
    val awal: Double,
    val open: Boolean
)

data class SaldoRequest(
    val shift: String,
    val awal: Double
)

data class SaldoResponse(
    val hasOpenSaldo: Boolean,
    val saldo: Saldo
)