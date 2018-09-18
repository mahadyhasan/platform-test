package co.wrisk.platformtest

import java.math.BigDecimal

open class Section(val excessOptions: List<BigDecimal>, val multiplier: BigDecimal)

class General(excessOptions: List<BigDecimal>, multiplier: BigDecimal) : Section(excessOptions, multiplier)

class Electronic(excessOptions: List<BigDecimal>, multiplier: BigDecimal) : Section(excessOptions, multiplier)

class Jewelry(excessOptions: List<BigDecimal>, multiplier: BigDecimal) : Section(excessOptions, multiplier)

class Bicycle(excessOptions: List<BigDecimal>, multiplier: BigDecimal) : Section(excessOptions, multiplier)




