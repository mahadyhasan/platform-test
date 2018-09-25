package co.wrisk.platformtest.model

class QuoteRequest(
        val customerName: String,
        val wriskScore: Int,
        val bundleSelected: List<BundleOptionType>,
        val namedItemSelected: List<NamedItem>
) {
    data class Builder(
            var customerName: String = "",
            var wriskScore: Int = 1,
            var bundleSelected: List<BundleOptionType> = emptyList(),
            var namedItemSelected: List<NamedItem> = emptyList()) {


        fun customerName(customerName: String) = apply { this.customerName = customerName }

        fun wriskScore(wriskScore: Int) = apply { this.wriskScore = wriskScore }

        fun bundleSelected(bundleSelected: List<BundleOptionType>) = apply { this.bundleSelected = bundleSelected }

        fun namedItemSelected(namedItemSelected: List<NamedItem>) = apply { this.namedItemSelected = namedItemSelected }

        fun build() = QuoteRequest(customerName, wriskScore, bundleSelected, namedItemSelected)

    }
}

