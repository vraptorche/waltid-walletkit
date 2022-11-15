package id.walt.webwallet.backend.clients.metaco.models.transfer

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Transfer(
    val id: String,
    val kind: String,
    @Json(serializeNull = false)
    val metadata: Metadata?,
    @Json(serializeNull = false)
    val quarantined: Boolean?,
    @Json(serializeNull = false)
    val recipient: Recipient?,
    @Json(serializeNull = false)
    val registeredAt: String?,
    @Json(serializeNull = false)
    val sender: Sender?,
    @Json(serializeNull = false)
    val senders: List<Sender>?,
    val tickerId: String,
    val transactionId: String,
    val value: String
)