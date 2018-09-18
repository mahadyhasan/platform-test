package co.wrisk.platformtest

import co.wrisk.platformservice.contracts.BundleContract
import co.wrisk.platformservice.contracts.NamedItemContract
import co.wrisk.platformservice.contracts.SectionContract
import java.math.BigDecimal

class SectionContractBuilder {

    var name: String = ""
    var sumInsured: BigDecimal = BigDecimal.ZERO
    private var bundleContract: BundleContract? = null
    private val namedItemContracts = mutableListOf<NamedItemContract>()

    fun bundleContract(block: BundleContractBuilder.() -> Unit) {
        bundleContract = BundleContractBuilder().apply(block).build()
    }

    fun namedItemContracts(block: NAMEDITEMCONTRACTS.() -> Unit) {
        namedItemContracts.addAll(NAMEDITEMCONTRACTS().apply(block))
    }

    fun build(): SectionContract = SectionContract(name, sumInsured, bundleContract, namedItemContracts)

}

fun sectionContract(block: SectionContractBuilder.() -> Unit): SectionContract = SectionContractBuilder().apply(block).build()


class BundleContractBuilder {

    var sumInsured: BigDecimal = BigDecimal.ZERO
    var excess: BigDecimal = BigDecimal.ZERO

    fun build(): BundleContract = BundleContract(sumInsured, excess)

}

class NAMEDITEMCONTRACTS : ArrayList<NamedItemContract>() {
    fun namedItemContract(block: NamedItemContractBuilder.() -> Unit) {
        add(NamedItemContractBuilder().apply(block).build())
    }
}

class NamedItemContractBuilder {

    var name: String = ""
    var sumInsured: BigDecimal = BigDecimal.ZERO
    var excess: BigDecimal = BigDecimal.ZERO

    fun build(): NamedItemContract = NamedItemContract(name, sumInsured, excess)

}

