package co.wrisk.platformtest.model

import java.math.BigDecimal

enum class SectionType : IExcessOption {


    GENERAL {

        override fun getMultiplier() = BigDecimal.valueOf(0.1)

        override fun getAvailableExcessOptions() =
                listOf<BigDecimal>(
                        BigDecimal.valueOf(200),
                        BigDecimal.valueOf(300),
                        BigDecimal.valueOf(400))
    },

    ELECTRONIC {

        override fun getMultiplier() = BigDecimal.valueOf(1.0)

        override fun getAvailableExcessOptions() =
                listOf<BigDecimal>(
                        BigDecimal.valueOf(100),
                        BigDecimal.valueOf(200),
                        BigDecimal.valueOf(300),
                        BigDecimal.valueOf(400),
                        BigDecimal.valueOf(500))
    },

    JEWELLERY {

        override fun getMultiplier() = BigDecimal.valueOf(2.0)

        override fun getAvailableExcessOptions() =
                listOf<BigDecimal>(
                        BigDecimal.valueOf(100),
                        BigDecimal.valueOf(200),
                        BigDecimal.valueOf(300))
    }


}

