package id.walt.webwallet.backend.clients.metaco.routers

import id.walt.webwallet.backend.clients.metaco.controllers.AccountController
import io.javalin.apibuilder.ApiBuilder
import io.javalin.plugin.openapi.dsl.documented

object AccountRouter: Router {
    override fun routes() {
        ApiBuilder.path("accounts") {
            ApiBuilder.get("balance/{accountId}", documented(AccountController.balanceDoc(), AccountController::balance))
        }
    }
}