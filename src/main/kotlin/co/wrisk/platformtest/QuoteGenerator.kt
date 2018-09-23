package co.wrisk.platformtest

import co.wrisk.platformtest.model.Calculation
import co.wrisk.platformtest.model.NamedItem
import co.wrisk.platformtest.model.QuoteRequest
import co.wrisk.platformtest.model.SectionType
import co.wrisk.platformtest.response.Quote
import java.math.BigDecimal

class QuoteGenerator {


    fun calculateQuote(quoteRequest: QuoteRequest): Quote? {

        val calculation = Calculation(quoteRequest.wriskScore, quoteRequest.bundleSelected, quoteRequest.namedItemSelected)

        calculation.calculatePrice()

        return resultFromCalculation(calculation)


    }

    fun resultFromCalculation(calculation: Calculation): Quote? {
        return null
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

