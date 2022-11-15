package id.walt.webwallet.backend.clients.metaco.models.transaction

import kotlinx.serialization.Serializable

@Serializable
data class Output(
    val accountReference: AccountReference,
    val address: String,
    val amount: String,
    val index: Int,
    val scriptPubKey: String
)