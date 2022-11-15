package id.walt.webwallet.backend.clients.metaco.models.transfer

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Sender(
    @Json(serializeNull = false)
    val accountId: String?,
    @Json(serializeNull = false)
    val addresses: List<String>?,
    @Json(serializeNull = false)
    val addressesDetails: List<AddressesDetail>?,
    @Json(serializeNull = false)
    val domainId: String?,
    val type: String
)