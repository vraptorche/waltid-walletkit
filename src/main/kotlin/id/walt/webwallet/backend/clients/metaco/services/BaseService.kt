package id.walt.webwallet.backend.clients.metaco.services

import com.beust.klaxon.Klaxon
import com.metaco.harmonize.HarmonizeContext
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking

abstract class BaseService<K,T>(
    open val context: HarmonizeContext
) {

    protected val baseUrl = "https://api.juggh.1hhmpq.m3t4c0.services"
    private val bearerTokenStorage = mutableListOf<BearerTokens>()
    protected val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(Auth) {
            bearer {
                loadTokens {
                    fetchAuthToken()
                }
                refreshTokens {
                    fetchAuthToken()
                }
            }
        }
    }
    private val authService = AuthService()

    protected inline fun <reified T> get(
        endpoint: String,
        body: Map<String, String> = emptyMap()
    ) = runBlocking {
        val response = client.get("$baseUrl$endpoint"){
            contentType(ContentType.Application.Json)
            setBody(body)
        }.bodyAsText()
        Klaxon().parse<T>(response)!!
    }

    abstract fun list(domainId: String): T
    abstract fun detail(vararg params: String): K

    private fun fetchAuthToken(): BearerTokens {
        authService.authorize().run {
            bearerTokenStorage.add(BearerTokens(this.accessToken, this.accessToken))
        }
        return bearerTokenStorage.last()
    }
}