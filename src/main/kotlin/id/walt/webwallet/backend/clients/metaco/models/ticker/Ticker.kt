package id.walt.webwallet.backend.clients.metaco.models.ticker

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Ticker(
    @Json(serializeNull = false)
    val data: Data?,
    val decimals: Int,
    val id: String,
    val kind: String,
    val ledgerDetails: LedgerDetails,
    val ledgerId: String,
    @Json(serializeNull = false)
    val name: String?,
    @Json(serializeNull = false)
    val signature: String?,
    @Json(serializeNull = false)
    val symbol: String?
)