package id.walt.webwallet.backend.clients.metaco.models.account

import kotlinx.serialization.Serializable

@Serializable
data class AccountList(
    val items: List<Account>
)