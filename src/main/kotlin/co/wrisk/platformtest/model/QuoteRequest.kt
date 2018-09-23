package co.wrisk.platformtest.model

class QuoteRequest(
        val customerName: String,
        val wriskScore: Int,
        val bundleSelected: List<SectionType>?,
        val namedItemSelected: List<NamedItem>?
) {
    data class Builder(
            var customerName: String = "",
            var wriskScore: Int = 0,
            var bundleSelected: List<SectionType>? = null,
            var namedItemSelected: List<NamedItem>? = null) {


        fun customerName(customerName: String) = apply { this.customerName = customerName }

        fun wriskScore(wriskScore: Int) = apply { this.wriskScore = wriskScore }

        fun bundleSelected(bundleSelected: List<SectionType>?) = apply { this.bundleSelected = bundleSelected }

        fun namedItemSelected(namedItemSelected: List<NamedItem>?) = apply { this.namedItemSelected = namedItemSelected }

        fun build() = QuoteRequest(customerName, wriskScore, bundleSelected, namedItemSelected)

    }
}

