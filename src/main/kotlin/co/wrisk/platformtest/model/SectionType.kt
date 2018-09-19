package co.wrisk.platformtest.model

import java.math.BigDecimal

sealed class SectionType(val label: String) {

    abstract val excessOptions: List<BigDecimal>

    abstract val multiplier: BigDecimal

    object GENERAL : SectionType("General") {
        override val multiplier: BigDecimal = BigDecimal.valueOf(0.1)

        override val excessOptions: List<BigDecimal> =
                listOf<BigDecimal>(
                        BigDecimal.valueOf(200),
                        BigDecimal.valueOf(300),
                        BigDecimal.valueOf(400))
    }

    object ELECTRONIC : SectionType("Electronic") {
        override val multiplier: BigDecimal = BigDecimal.valueOf(2)

        override val excessOptions: List<BigDecimal> =
                listOf<BigDecimal>(
                        BigDecimal.valueOf(100),
                        BigDecimal.valueOf(200),
                        BigDecimal.valueOf(300),
                        BigDecimal.valueOf(400),
                        BigDecimal.valueOf(500))
    }

    object JEWELRY : SectionType("Jewelry") {
        override val multiplier: BigDecimal = BigDecimal.valueOf(1)

        override val excessOptions: List<BigDecimal> =
                listOf<BigDecimal>(
                        BigDecimal.valueOf(100),
                        BigDecimal.valueOf(200),
                        BigDecimal.valueOf(300))
    }

    object BICYCLE : SectionType("Bicycle") {
        override val multiplier: BigDecimal = BigDecimal.valueOf(0.8)

        override val excessOptions: List<BigDecimal> =
                listOf<BigDecimal>(
                        BigDecimal.valueOf(300),
                        BigDecimal.valueOf(400),
                        BigDecimal.valueOf(500))
    }


}