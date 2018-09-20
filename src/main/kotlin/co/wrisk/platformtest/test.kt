package co.wrisk.platformtest

import java.math.BigDecimal

data class Result(val value: BigDecimal, val rate: BigDecimal, val result: BigDecimal)

sealed class Membership {

    abstract val interestRates: List<BigDecimal>
    abstract val valueOptions: List<BigDecimal>

    fun calcCombinations() = this.valueOptions.map { vo ->
        this.interestRates.map {
            Result(vo, it, vo * it)
        }
    }

    object SILVER : Membership() {
        override val interestRates = listOf(BigDecimal("0.13"), BigDecimal("0.24"), BigDecimal("0.3"))

        override val valueOptions = listOf(BigDecimal(10), BigDecimal(50), BigDecimal(40))
    }

    object GOLD : Membership() {

        override val interestRates = listOf(BigDecimal("0.12"), BigDecimal("0.2"), BigDecimal("0.3"))

        override val valueOptions = listOf(BigDecimal(10), BigDecimal(20), BigDecimal(30))
    }
}

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        //println(Membership.GOLD.calcCombinations())
       // println(Membership.SILVER.calcCombinations())

        val membershipToCombinations = setOf(Membership.GOLD, Membership.SILVER).associateBy({
            it
        }, {
            it.calcCombinations()
        })

        //println(membershipToCombinations[Membership.SILVER])
        println(membershipToCombinations[Membership.GOLD])
    }
}