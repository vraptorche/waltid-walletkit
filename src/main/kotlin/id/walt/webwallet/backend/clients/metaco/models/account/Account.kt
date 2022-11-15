package id.walt.webwallet.backend.clients.metaco.models.account

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    @Json(serializeNull = false)
    val additionalDetails: AdditionalDetails?,
    val data: Data,
    val signature: String
)