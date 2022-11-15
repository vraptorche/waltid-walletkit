package id.walt.webwallet.backend.clients.metaco.models.transaction

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Input(
    val accountReference: AccountReference,
    val address: String,
    val index: Int,
    @Json(serializeNull = false)
    val scriptPubKey: String?,
    @Json(serializeNull = false)
    val transactionHash: String?
)