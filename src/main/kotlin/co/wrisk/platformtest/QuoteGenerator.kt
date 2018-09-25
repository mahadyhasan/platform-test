package co.wrisk.platformtest

import co.wrisk.platformtest.model.BundleOptionType
import co.wrisk.platformtest.model.NamedItem
import co.wrisk.platformtest.model.Quote
import co.wrisk.platformtest.model.QuoteRequest
import co.wrisk.platformtest.model.SectionType
import java.math.BigDecimal

class QuoteGenerator {

    companion object {
        private val rate = BigDecimal.valueOf(0.0015)
    }

    private val bundleQuoteMap: MutableMap<BundleOptionType, List<Quote>> = mutableMapOf()
    private val namedItemQuoteMap: MutableMap<SectionType, List<Quote>> = mutableMapOf()


    fun generateQuote(quoteRequest: QuoteRequest) {

        val wriskScore = quoteRequest.wriskScore
        val bundleSelected = quoteRequest.bundleSelected
        val namedItemSelected = quoteRequest.namedItemSelected

        if (bundleSelected.isEmpty()) {
            println("No Bundles Selected!!")
        }

        generateBundleQuote(wriskScore, bundleSelected)

        if (namedItemSelected.isEmpty()) {
            println("No Named Item Selected!!")
        }

        generateNamedItemQuote(wriskScore, namedItemSelected)


    }

    private fun generateBundleQuote(wriskScore: Int, bundleSelected: List<BundleOptionType>) {
        bundleSelected.stream()
                .forEach { bundle ->
                    bundleQuoteMap.put(bundle, calcCombinations(wriskScore, bundle))
                }

        println(bundleQuoteMap)

    }

    /**
     * Calculate the combinations of value/excess options
     * for each bundle types selected
     */
    private fun calcCombinations(wriskScore: Int, bundle: BundleOptionType): List<Quote> {
        val allQuoteCombinations = mutableListOf<Quote>()
        bundle.listOfValueOptions()
                .map { value ->
                    bundle.excessOptions.map {
                        allQuoteCombinations.add(Quote(wriskScore, value, it, rate, bundle.multiplier).sum())
                    }
                }
        return allQuoteCombinations
    }

    private fun generateNamedItemQuote(wriskScore: Int, namedItemSelected: List<NamedItem>) {
    }


}

fun main(args: Array<String>) {

    val quoteRequest = QuoteRequest.Builder()
            .customerName("Ricky Sanchez")
            .wriskScore(200)
            .bundleSelected(listOf(SectionType.GENERAL, SectionType.JEWELRY))
            .namedItemSelected(listOf(
                    NamedItem("Portal Gun", SectionType.ELECTRONIC, BigDecimal(2000)
                    )))
            .build()

    val quoteGenerator = QuoteGenerator()
    quoteGenerator.generateQuote(quoteRequest)

}

