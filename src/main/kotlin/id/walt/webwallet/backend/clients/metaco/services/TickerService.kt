package id.walt.webwallet.backend.clients.metaco.services

import com.metaco.harmonize.HarmonizeContext
import id.walt.webwallet.backend.clients.metaco.models.ticker.Ticker
import id.walt.webwallet.backend.clients.metaco.models.ticker.TickerList

class TickerService(
    override val context: HarmonizeContext
) : BaseService<Ticker, TickerList>(context) {
    private val listEndpoint = "/v1/tickers"
    private val detailEndpoint = "/v1/tickers/%s"

    override fun list(domainId: String) = get<TickerList>(listEndpoint)

    override fun detail(vararg params: String) = get<Ticker>(String.format(detailEndpoint, params[0]))

}