package co.wrisk.platformtest

import co.wrisk.platformtest.model.NamedItem
import co.wrisk.platformtest.model.SectionType
import java.math.BigDecimal

fun calculateQuote(wriskScore: Int, bundleSelected: List<SectionType>, namedItemSelected: List<NamedItem>): Quote {


    for (bundle in bundleSelected) {
        for (excess in bundle.excessOptions) {
            println(excess.multiply(BigDecimal.TEN))
        }
    }


    return Quote()
}

class Quote {

}

fun main(args: Array<String>) {

    val bundleSelected = listOf(SectionType.GENERAL)

    val namedItemSelected = listOf(
            NamedItem("Portal Gun", SectionType.ELECTRONIC, BigDecimal.valueOf(2000)))

    calculateQuote(200, bundleSelected, namedItemSelected)


}

