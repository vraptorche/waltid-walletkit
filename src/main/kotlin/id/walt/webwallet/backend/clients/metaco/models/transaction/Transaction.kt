package id.walt.webwallet.backend.clients.metaco.models.transaction

import com.beust.klaxon.Json
import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val id: String,
    @Json(serializeNull = false)
    val ledgerId: String?,
    @Json(serializeNull = false)
    val ledgerTransactionData: LedgerTransactionData?,
    @Json(serializeNull = false)
    val orderReference: OrderReference?,
    @Json(serializeNull = false)
    val processing: Processing?,
    @Json(serializeNull = false)
    val registeredAt: String?,
    @Json(serializeNull = false)
    val relatedAccounts: ArrayList<RelatedAccount>?
)