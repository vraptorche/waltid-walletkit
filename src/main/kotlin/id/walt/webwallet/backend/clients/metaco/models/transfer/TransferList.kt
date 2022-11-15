package id.walt.webwallet.backend.clients.metaco.models.transfer

import kotlinx.serialization.Serializable

@Serializable
data class TransferList(
    val items: List<Transfer>
)
