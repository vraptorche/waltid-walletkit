package id.walt.webwallet.backend.clients.metaco.models.account

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val alias: String?,
    val domainId: String,
    val id: String,
    val ledgerId: String,
    val lock: String,
    @Json(serializeNull = false)
    val metadata: Metadata?,
    val providerDetails: ProviderDetails
)