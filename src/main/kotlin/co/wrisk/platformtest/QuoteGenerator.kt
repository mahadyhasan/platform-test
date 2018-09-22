package co.wrisk.platformtest

import co.wrisk.platformtest.model.BundleCalculation
import co.wrisk.platformtest.model.Calculation
import co.wrisk.platformtest.model.NamedItem
import co.wrisk.platformtest.model.NamedItemCalculation
import co.wrisk.platformtest.model.QuoteCalculator
import co.wrisk.platformtest.model.QuoteRequest
import co.wrisk.platformtest.model.SectionType
import co.wrisk.platformtest.response.Quote
import java.math.BigDecimal

class QuoteGenerator {

    private val quoteCalculator = QuoteCalculator()


    fun calculateQuote(quoteRequest: QuoteRequest): Quote? {

        val listOfCalculation = mutableListOf<Calculation>()

        val wriskScore = quoteRequest.wriskScore
        val bundleSelected = quoteRequest.bundleSelected
        val namedItemSelected = quoteRequest.namedItemSelected

        if (bundleSelected != null) {
            val bundleCalculation = quoteCalculator.calculatePrice(toBundleCalculation(wriskScore, bundleSelected))
            listOfCalculation.add(bundleCalculation)
        }

        if (namedItemSelected != null) {
            val namedItemCalculation = quoteCalculator.calculatePrice(toNamedItemCalculation(wriskScore, namedItemSelected))
            listOfCalculation.add(namedItemCalculation)
        }

        return resultFromCalculation(listOfCalculation)


    }

    fun toBundleCalculation(wriskScore: Int, listOfSectionTypes: List<SectionType>): Calculation {
        return BundleCalculation(wriskScore, listOfSectionTypes)
    }

    fun toNamedItemCalculation(wriskScore: Int, listOfNamedItems: List<NamedItem>): Calculation {
        return NamedItemCalculation(wriskScore, listOfNamedItems)
    }

    fun resultFromCalculation(listOfCalculations: MutableList<Calculation>): Quote? {
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

