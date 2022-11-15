package id.walt.webwallet.backend.clients.metaco.models.account

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class AdditionalDetails(
    @Json(serializeNull = false)
    val lastBalancesUpdateProcessedAt: String?,
    @Json(serializeNull = false)
    val lastBalancesUpdateRequestedAt: String?,
    val processing: Processing
)