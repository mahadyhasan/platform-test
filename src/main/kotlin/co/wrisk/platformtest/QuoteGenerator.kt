package co.wrisk.platformtest

import co.wrisk.platformtest.handler.CalculateQuoteHandler
import co.wrisk.platformtest.model.NamedItem
import co.wrisk.platformtest.model.QuoteRequest
import co.wrisk.platformtest.model.SectionType
import co.wrisk.platformtest.response.Quote
import java.math.BigDecimal

class QuoteGenerator {

    val calculateQuoteHandler = CalculateQuoteHandler()

    fun calculateQuote(quoteRequest: QuoteRequest): Quote {
          return calculateQuoteHandler.handle(quoteRequest)
    }


}

fun main(args: Array<String>) {

    val quoteRequest = QuoteRequest.Builder()
            .customerName("Ricky Sanchez")
            .wriskScore(200)
            .bundleSelected(listOf(SectionType.GENERAL))
            .namedItemSelected(listOf(
                    NamedItem("Portal Gun", SectionType.ELECTRONIC, BigDecimal.valueOf(2000)
                    )))
            .build()
}

