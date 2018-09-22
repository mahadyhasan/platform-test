package co.wrisk.platformtest.model

import java.math.BigDecimal

sealed class SectionType(val label: String) {

    abstract val excessOptions: List<BigDecimal>

    abstract val multiplier: BigDecimal

    object GENERAL : SectionType("General") {

        override val multiplier: BigDecimal = BigDecimal(0.1)

        override val excessOptions: List<BigDecimal> =
                listOf(BigDecimal(200), BigDecimal(300), BigDecimal(400))
    }

    object ELECTRONIC : SectionType("Electronic") {

        override val multiplier: BigDecimal = BigDecimal(2)

        override val excessOptions: List<BigDecimal> =
                listOf(BigDecimal(100), BigDecimal(200), BigDecimal(300), BigDecimal(400), BigDecimal(500))
    }

    object JEWELRY : SectionType("Jewelry") {

        override val multiplier: BigDecimal = BigDecimal(1)

        override val excessOptions: List<BigDecimal> = listOf(BigDecimal(100), BigDecimal(200), BigDecimal(300))
    }

    object BICYCLE : SectionType("Bicycle") {

        override val multiplier: BigDecimal = BigDecimal(0.8)

        override val excessOptions: List<BigDecimal> = listOf(BigDecimal(300), BigDecimal(400), BigDecimal(500))
    }


}