package co.wrisk.platformtest.model

import java.math.BigDecimal

interface IBundleOption {
    fun listOfValueOptions(): List<BigDecimal>
}