package id.walt.webwallet.backend.clients.metaco.models.account

import kotlinx.serialization.Serializable

@Serializable
data class KeyInformation(
    val derivationPath: String,
    val publicKey: PublicKey,
    val type: String
)