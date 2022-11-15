package id.walt.webwallet.backend.clients.metaco.routers

import io.javalin.apibuilder.ApiBuilder

object MetacoRouter: Router {
    override fun routes() {
        ApiBuilder.path("metaco") {
            AccountRouter.routes()
        }
    }
}