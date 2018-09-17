package co.wrisk.platformtest.model

import java.math.BigDecimal

interface IExcessOption {
    fun getAvailableExcessOptions(): List<BigDecimal>
    fun getMultiplier(): BigDecimal
}