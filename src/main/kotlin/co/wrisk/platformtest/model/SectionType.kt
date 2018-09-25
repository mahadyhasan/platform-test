package co.wrisk.platformtest.model

import java.math.BigDecimal

abstract class BundleOptionType : SectionType(), IBundleOption

sealed class SectionType {
    abstract val excessOptions: List<BigDecimal>
    abstract val multiplier: BigDecimal

    object GENERAL : BundleOptionType() {
        override fun listOfValueOptions() = listOf(BigDecimal(2000), BigDecimal(5000), BigDecimal(10000), BigDecimal(15000))
        override val multiplier: BigDecimal = BigDecimal.valueOf(0.1)
        override val excessOptions: List<BigDecimal> = listOf(BigDecimal(200), BigDecimal(300), BigDecimal(400))
    }

    object ELECTRONIC : SectionType() {
        override val multiplier: BigDecimal = BigDecimal.valueOf(2.0)
        override val excessOptions: List<BigDecimal> = listOf(BigDecimal(100), BigDecimal(200), BigDecimal(300), BigDecimal(400), BigDecimal(500))
    }

    object JEWELRY : BundleOptionType() {
        override fun listOfValueOptions() = listOf(BigDecimal(1000), BigDecimal(2000), BigDecimal(3000), BigDecimal(4000), BigDecimal(5000))
        override val multiplier: BigDecimal = BigDecimal.valueOf(1.0)
        override val excessOptions: List<BigDecimal> = listOf(BigDecimal(100), BigDecimal(200), BigDecimal(300))
    }

    object BICYCLE : SectionType() {
        override val multiplier: BigDecimal = BigDecimal.valueOf(0.8)
        override val excessOptions: List<BigDecimal> = listOf(BigDecimal(300), BigDecimal(400), BigDecimal(500))
    }
}






