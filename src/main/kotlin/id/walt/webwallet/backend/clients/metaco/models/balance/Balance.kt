package id.walt.webwallet.backend.clients.metaco.models.balance

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Balance(
    val count: Int,
    @Json(serializeNull = false)
    val currentStartingAfter: String?,
    @Json(serializeNull = false)
    val items: List<Item>?,
    @Json(serializeNull = false)
    val nextStartingAfter: String?
)