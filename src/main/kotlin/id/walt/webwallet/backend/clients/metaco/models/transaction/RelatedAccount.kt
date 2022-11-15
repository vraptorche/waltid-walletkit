package id.walt.webwallet.backend.clients.metaco.models.transaction

import kotlinx.serialization.Serializable

@Serializable
data class RelatedAccount(
    val domainId: String,
    val id: String,
    val sender: Boolean
)