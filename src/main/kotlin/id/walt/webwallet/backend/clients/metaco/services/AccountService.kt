package id.walt.webwallet.backend.clients.metaco.services

import com.metaco.harmonize.HarmonizeContext
import id.walt.webwallet.backend.clients.metaco.models.account.Account
import id.walt.webwallet.backend.clients.metaco.models.account.AccountList

class AccountService(
    override val context: HarmonizeContext
) : BaseService<Account, AccountList>(context) {
    private val listEndpoint = "/v1/domains/%s/accounts"
    private val detailEndpoint = "/v1/domains/%s/accounts/%s"

    override fun list(domainId: String) = get<AccountList>(String.format(listEndpoint, domainId))

    override fun detail(vararg params: String) = get<Account>(String.format(detailEndpoint, params[0], params[1]))

}