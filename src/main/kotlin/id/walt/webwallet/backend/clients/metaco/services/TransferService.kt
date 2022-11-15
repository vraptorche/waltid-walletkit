package id.walt.webwallet.backend.clients.metaco.services

import com.metaco.harmonize.HarmonizeContext
import id.walt.webwallet.backend.clients.metaco.models.transfer.Transfer
import id.walt.webwallet.backend.clients.metaco.models.transfer.TransferList

class TransferService(
    context: HarmonizeContext
): BaseService<Transfer, TransferList>(context) {
    val listEndpoint = "/v1/domains/%s/transactions/transfers"//?transactionId=fe8da9e8-520a-497c-9001-0b26c8067d3b"
    val detailEndpoint = "/v1/domains/%s/transactions/transfers/%s"

    override fun list(domainId: String) = get<TransferList>(String.format(listEndpoint, domainId))

    override fun detail(vararg params: String) = get<Transfer>(String.format(detailEndpoint, params[0], params[1]))
}