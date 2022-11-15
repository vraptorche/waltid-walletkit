package id.walt.webwallet.backend.clients.metaco.models.balance

import kotlinx.serialization.Serializable

@Serializable
data class AccountReference(
    val domainId: String,
    val id: String
)