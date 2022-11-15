package id.walt.webwallet.backend.clients.metaco.models.transfer

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Recipient(
    @Json(serializeNull = false)
    val accountId: String?,
    @Json(serializeNull = false)
    val address: String?,
    @Json(serializeNull = false)
    val addressDetails: AddressDetails?,
    @Json(serializeNull = false)
    val domainId: String?,
    val type: String
)