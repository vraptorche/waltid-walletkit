package id.walt.webwallet.backend.clients.metaco.models.balance

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @Json(serializeNull = false)
    val accountReference: AccountReference?,
    @Json(serializeNull = false)
    val lastUpdatedAt: String?,
    val quarantinedAmount: String,
    val reservedAmount: String,
    val tickerId: String,
    val totalAmount: String
)