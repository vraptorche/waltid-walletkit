package id.walt.webwallet.backend.clients.metaco.models.account

import kotlinx.serialization.Serializable

@Serializable
data class LastModifiedBy(
    val domainId: String,
    val id: String
)