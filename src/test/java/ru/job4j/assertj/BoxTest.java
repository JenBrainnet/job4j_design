package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void whenWhatsThisAndBoxHas8VerticesThenCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name)
                .isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .isNotEqualTo("UNKNOWN")
                .isEqualTo("Cube");
    }

    @Test
    void whenWhatsThisAndBoxHas1VertexThenUnknown() {
        Box box = new Box(1, 2);
        String name = box.whatsThis();
        assertThat(name)
                .isNotNull()
                .isNotBlank()
                .doesNotContain("Sph")
                .containsIgnoringCase("unknown")
                .isEqualTo("Unknown object");
    }

    @Test
    void whenGetNumberOfVerticesAndBoxIsUnknownThenMinusOne() {
        Box box = new Box(1, 2);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices)
                .isNotZero()
                .isNegative()
                .isGreaterThan(-2)
                .isEqualTo(-1);
    }

    @Test
    void whenGetNumberOfVerticesAndBoxIsSphereThenZero() {
        Box box = new Box(0, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices)
                .isNotNegative()
                .isNotPositive()
                .isZero();
    }

    @Test
    void whenIsExistAndBoxIsValidThenTrue() {
        Box box = new Box(4, 6);
        boolean exist = box.isExists();
        assertThat(exist).isTrue();
    }

    @Test
    void whenIsExistAndBoxHasNegativeEdgeThenFalse() {
        Box box = new Box(4, -6);
        boolean exist = box.isExists();
        assertThat(exist).isFalse();
    }

    @Test
    void whenGetAreaAndBoxIsSphereThenCorrectValue() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area)
                .isNotZero()
                .isPositive()
                .isCloseTo(1256.63d, Percentage.withPercentage(1d))
                .isEqualTo(1256.63d, withPrecision(0.01d));
    }

    @Test
    void whenGetAreaAndBoxIsUnknownThenZero() {
        Box box = new Box(7, 10);
        double area = box.getArea();
        assertThat(area)
                .isGreaterThan(-0.1d)
                .isLessThan(0.1d)
                .isCloseTo(0.0d, withPrecision(0.0001d))
                .isZero();
    }

}