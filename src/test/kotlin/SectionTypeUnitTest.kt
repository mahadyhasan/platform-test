import co.wrisk.platformtest.model.SectionType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class SectionTypeUnitTest {

    companion object {
        private val ONE_HUNDRED = BigDecimal(100)
        private val TWO_HUNDRED = BigDecimal(200)
        private val THREE_HUNDRED = BigDecimal(300)
        private val FOUR_HUNDRED = BigDecimal(400)
        private val FIVE_HUNDRED = BigDecimal(500)
    }

    @Test
    fun givenGeneralSectionType_whenExcessOptions_thenReturnCorrectExcessOptions() {
        val excessOptionsList = SectionType.GENERAL.excessOptions
        assertTrue(excessOptionsList is List<BigDecimal>)
        assertEquals(3, excessOptionsList.size)
        assertIterableEquals(listOf(TWO_HUNDRED, THREE_HUNDRED, FOUR_HUNDRED), excessOptionsList)
    }

    @Test
    fun givenGeneralSectionType_whenMultiplier_thenReturnCorrectMultiplier() {
        assertEquals(BigDecimal(0.1), SectionType.GENERAL.multiplier)
    }

    @Test
    fun givenElectronicSectionType_whenExcessOptions_thenReturnCorrectExcessOptions() {
        val excessOptionsList = SectionType.ELECTRONIC.excessOptions
        assertEquals(5, excessOptionsList.size)
        assertIterableEquals(listOf(ONE_HUNDRED, TWO_HUNDRED, THREE_HUNDRED, FOUR_HUNDRED, FIVE_HUNDRED), excessOptionsList)
    }

    @Test
    fun givenElectronicSectionType_whenMultiplier_thenReturnCorrectMultiplier() {
        assertEquals(BigDecimal(2), SectionType.ELECTRONIC.multiplier)
    }

    @Test
    fun givenJewelrySectionType_whenExcessOptions_thenReturnCorrectExcessOptions() {
        val excessOptionsList = SectionType.JEWELRY.excessOptions
        assertEquals(3, excessOptionsList.size)
        assertIterableEquals(listOf(ONE_HUNDRED, TWO_HUNDRED, THREE_HUNDRED), excessOptionsList)
    }

    @Test
    fun givenJewelrySectionType_whenMultiplier_thenReturnCorrectMultiplier() {
        assertEquals(BigDecimal(1), SectionType.JEWELRY.multiplier)
    }

    @Test
    fun givenBicycleSectionType_whenExcessOptions_thenReturnCorrectExcessOptions() {
        val excessOptionsList = SectionType.BICYCLE.excessOptions
        assertEquals(3, excessOptionsList.size)
        assertIterableEquals(listOf(THREE_HUNDRED, FOUR_HUNDRED, FIVE_HUNDRED), excessOptionsList)
    }

    @Test
    fun givenBicyleSectionType_whenMultiplier_thenReturnCorrectMultiplier() {
        assertEquals(BigDecimal(0.8), SectionType.BICYCLE.multiplier)
    }


}