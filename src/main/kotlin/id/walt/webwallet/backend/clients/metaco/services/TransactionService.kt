package id.walt.webwallet.backend.clients.metaco.services

import com.metaco.harmonize.HarmonizeContext
import id.walt.webwallet.backend.clients.metaco.models.transaction.Transaction
import id.walt.webwallet.backend.clients.metaco.models.transaction.TransactionList


class TransactionService(
    override val context: HarmonizeContext
) : BaseService<Transaction, TransactionList>(context) {
    private val listEndpoint = "/v1/domains/%s/transactions"
    private val detailEndpoint = "/v1/domains/%s/transactions/%s"

    override fun list(domainId: String) = get<TransactionList>(String.format(listEndpoint, domainId))

    override fun detail(vararg params: String) = get<Transaction>(String.format(detailEndpoint, params[0], params[1]))

}