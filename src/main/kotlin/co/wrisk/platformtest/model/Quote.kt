package co.wrisk.platformtest.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Quote(
        val wriskScore: Int,
        val value: BigDecimal,
        val excess: BigDecimal,
        val rate: BigDecimal,
        val multiplier: BigDecimal
) {
    var totalPremium = BigDecimal.ZERO

    fun sum(): Quote {
        totalPremium = (BigDecimal(1000).divide(BigDecimal(wriskScore)))
                .multiply(value)
                .multiply(BigDecimal.ONE - (excess.divide(value, 0, RoundingMode.HALF_UP)))
                .multiply(rate)
                .multiply(multiplier)

        return this
    }

    override fun toString(): String {
        return "Quote(wriskScore=$wriskScore, " +
                "value=$value, " +
                "excess=$excess, " +
                "rate=$rate, " +
                "multiplier=$multiplier, " +
                "totalPremium=$totalPremium) "
    }


}