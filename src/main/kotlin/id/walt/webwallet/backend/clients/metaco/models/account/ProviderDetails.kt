package id.walt.webwallet.backend.clients.metaco.models.account

import kotlinx.serialization.Serializable

@Serializable
data class ProviderDetails(
    val keyInformation: KeyInformation,
    val keyStrategy: String,
    val type: String,
    val vaultId: String
)