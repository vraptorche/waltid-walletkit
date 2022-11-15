package id.walt.webwallet.backend.clients.metaco.models.transaction

import kotlinx.serialization.Serializable

@Serializable
data class TransactionList(
    val items: List<Transaction>
)
