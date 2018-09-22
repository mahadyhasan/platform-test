import co.wrisk.platformtest.QuoteGenerator
import co.wrisk.platformtest.model.NamedItem
import co.wrisk.platformtest.model.QuoteRequest
import co.wrisk.platformtest.model.SectionType
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class QuoteGeneratorTest {

    private val quoteGenerator = QuoteGenerator()

    @Test
    fun whenGivenQuoteRequest_thenProduceQuote() {
        //given
        val quoteRequest = QuoteRequest.Builder()
                .customerName("Ricky Sanchez")
                .wriskScore(200)
                .bundleSelected(listOf(SectionType.GENERAL))
                .namedItemSelected(listOf(
                        NamedItem("Portal Gun", SectionType.ELECTRONIC, BigDecimal.valueOf(2000)
                        )))
                .build()

        val quote = quoteGenerator.calculateQuote(quoteRequest)

        assertNotNull(quote)


    }

}