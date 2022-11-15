package id.walt.webwallet.backend.clients.metaco.models.transaction

import kotlinx.serialization.Serializable

@Serializable
data class OrderReference(
    val domainId: String,
    val id: String
)