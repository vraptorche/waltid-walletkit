package id.walt.webwallet.backend.clients.metaco.models.account

import kotlinx.serialization.Serializable

@Serializable
data class PublicKey(
    val chainCode: String,
    val type: String,
    val value: String
)