package id.walt.webwallet.backend.clients.metaco.models.ticker

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val decimals: Int,
    val id: String,
    val kind: String,
    @Json(serializeNull = false)
    val ledgerDetails: LedgerDetails?,
    val ledgerId: String,
    val lock: String,
    @Json(serializeNull = false)
    val metadata: String?,
    @Json(serializeNull = false)
    val name: String?,
    @Json(serializeNull = false)
    val symbol: String?
)