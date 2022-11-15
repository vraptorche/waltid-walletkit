package id.walt.webwallet.backend.clients.metaco.services

import com.metaco.harmonize.HarmonizeContext
import id.walt.webwallet.backend.clients.metaco.models.balance.Balance

class BalanceService(
    override val context: HarmonizeContext
) : BaseService<Balance, Balance>(context) {
    private val endpoint = "/v1/domains/%s/accounts/%s/balances"

    override fun list(domainId: String): Balance = throw IllegalArgumentException("Function not available")

    override fun detail(vararg params: String) = get<Balance>(String.format(endpoint, params[0], params[1]))

}