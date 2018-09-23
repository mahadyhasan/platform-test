package co.wrisk.platformtest.model

import java.math.BigDecimal

class Calculation(
        var wriskScore: Int = 0,
        var selectedBundles: List<SectionType>? = emptyList(),
        var selectedNamedItems: List<NamedItem>? = emptyList()) {

    val priceMatrix = HashMap<SectionType, List<Result>>()




    fun calculatePrice() {


    }


}

data class Result(val value: BigDecimal, val excessOption: BigDecimal, val result: BigDecimal)

