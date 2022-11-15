package id.walt.webwallet.backend.clients.metaco.models.transfer

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class AddressDetails(
    val address: String,
    @Json(serializeNull = false)
    val resolvedEndpoints: List<String>?
)