package co.wrisk.platformtest

import java.math.BigDecimal

fun main(args: Array<String>) {

    val sectionContract = sectionContract {
        name = "Rick Sanchez"
        sumInsured
        bundleContract {
            sumInsured = BigDecimal.valueOf(2500)
            excess = BigDecimal.valueOf(200)
        }
        namedItemContracts {
            namedItemContract {
                name = "Portal Gun"
                sumInsured = BigDecimal.valueOf(2000)
                excess = BigDecimal.valueOf(300)
            }
        }

    }



    println(sectionContract)
}