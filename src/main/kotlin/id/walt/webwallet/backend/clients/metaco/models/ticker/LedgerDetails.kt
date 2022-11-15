package id.walt.webwallet.backend.clients.metaco.models.ticker

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class LedgerDetails(
    @Json(serializeNull = false)
    val properties: Properties?,
    val type: String
)