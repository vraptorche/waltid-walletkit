package id.walt.webwallet.backend.clients.metaco.models.transaction

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class LedgerData(
    @Json(serializeNull = false)
    val inputs: List<Input>?,
    @Json(serializeNull = false)
    val outputs: List<Output>?,
    @Json(serializeNull = false)
    val type: String?
)