package co.wrisk.platformtest.model

open class Calculation(wriskScore: Int)

class BundleCalculation(wriskScore: Int, listOfSectionTypes: List<SectionType>) : Calculation(wriskScore)

class NamedItemCalculation(wriskScore: Int, listOfNamedItems: List<NamedItem>) : Calculation(wriskScore)