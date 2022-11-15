package id.walt.webwallet.backend.clients.metaco.models.ticker

import kotlinx.serialization.Serializable

@Serializable
data class TickerList(
    val items: List<Ticker>
)