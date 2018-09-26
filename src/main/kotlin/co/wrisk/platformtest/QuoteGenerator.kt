package co.wrisk.platformtest

import co.wrisk.platformtest.model.*
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
                    bundleQuoteMap.put(bundle, calcBundleCombinations(wriskScore, bundle))
                }

        println(bundleQuoteMap)

    }


    private fun generateNamedItemQuote(wriskScore: Int, namedItemSelected: List<NamedItem>) {
        namedItemSelected.stream()
                .forEach { t: NamedItem? ->
                    namedItemQuoteMap.put(t!!.category, calcNamedItemCombinations(wriskScore, t))
                }

        println(namedItemQuoteMap)
    }

    private fun calcNamedItemCombinations(wriskScore: Int, t: NamedItem?): List<Quote> {
        val allQuoteCombinations = mutableListOf<Quote>()
        if (t != null) {
            t.category.excessOptions
                    .map { excessOption ->
                        allQuoteCombinations.add(Quote(wriskScore, t.value, excessOption, rate, t.category.multiplier))
                    }
        }

        return allQuoteCombinations
    }


    /**
     * Calculate the combinations of value/excess options
     * for a bundle type selected
     */
    private fun calcBundleCombinations(wriskScore: Int, bundle: BundleOptionType): List<Quote> {
        val allQuoteCombinations = mutableListOf<Quote>()
        bundle.listOfValueOptions()
                .map { value ->
                    bundle.excessOptions.map {
                        allQuoteCombinations.add(Quote(wriskScore, value, it, rate, bundle.multiplier).sum())
                    }
                }
        return allQuoteCombinations
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

