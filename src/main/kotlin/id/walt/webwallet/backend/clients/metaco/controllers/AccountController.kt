package id.walt.webwallet.backend.clients.metaco.controllers

import com.metaco.harmonize.HarmonizeContext
import id.walt.webwallet.backend.clients.metaco.WaltIdSandboxSigner
import id.walt.webwallet.backend.clients.metaco.dto.Balance
import id.walt.webwallet.backend.clients.metaco.dto.ValueWithChange
import id.walt.webwallet.backend.clients.metaco.services.AccountService
import id.walt.webwallet.backend.clients.metaco.services.BalanceService
import id.walt.webwallet.backend.clients.metaco.services.TickerService
import io.javalin.http.Context
import io.javalin.plugin.openapi.dsl.document

object AccountController {
    private val signer = WaltIdSandboxSigner()
    private val harmonizeCtx = HarmonizeContext.load(signer, "src/main/resources/harmonize.json");
    private val balanceService = BalanceService(harmonizeCtx)
    private val accountService = AccountService(harmonizeCtx)
    private val tickerService = TickerService(harmonizeCtx)
    //TODO: store it globally on login or smth.
    private const val domainId = "domain-id"
    private const val unknownValue = "unknown"

    fun balance(ctx: Context) {
        val accountId = ctx.pathParam("accountId")
        val balance = balanceService.detail(domainId, accountId).items?.map {
            Balance(
                balance = it.totalAmount,
                value = it.totalAmount,//TODO: calculate from current price
                ticker = tickerService.detail(domainId, it.tickerId).symbol?: unknownValue,
                price = ValueWithChange(unknownValue, unknownValue)
            )
        }?: emptyList()
        ctx.json(balance)
    }

    fun balanceDoc() = document().operation {
        it.summary("Returns the account balance").operationId("balance").addTagsItem("Account Management")
    }.json<List<Balance>>("200") { it.description("The account balance") }

//    fun balanceDoc() =
//        document().operation {
//            it.summary("Returns the account balance").operationId("balance")
//                .addTagsItem("Account Management")
//        }.body<Account> {
//            it.description("Account to be onboarded.")
//        }.json<Boolean>("200") { it.description("The list of available tokens to be claimed.") }


}