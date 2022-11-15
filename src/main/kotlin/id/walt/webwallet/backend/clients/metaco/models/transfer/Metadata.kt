package id.walt.webwallet.backend.clients.metaco.models.transfer

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
    @Json(serializeNull = false)
    val address: String?,
    @Json(serializeNull = false)
    val outputIndex: Int?,
    @Json(serializeNull = false)
    val scriptPubKey: String?,
    val type: String
)