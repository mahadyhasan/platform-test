package co.wrisk.platformtest

import co.wrisk.platformservice.contracts.BundleContract
import co.wrisk.platformservice.contracts.NamedItemContract
import co.wrisk.platformservice.contracts.SectionContract
import co.wrisk.platformtest.model.SectionType
import java.math.BigDecimal

fun main(args: Array<String>) {

    val bundleContract = BundleContract(
            BigDecimal.valueOf(2500),
            BigDecimal.valueOf(200)
    )

    val namedItemContract1 = NamedItemContract("Portal Gun",
            BigDecimal.valueOf(2000),
            BigDecimal.valueOf(300)
    )


    val listOfNamedItemContract = listOf(namedItemContract1)

    val sectionContract = SectionContract(SectionType.ELECTRONIC.name, BigDecimal.ZERO, bundleContract, listOfNamedItemContract)


}