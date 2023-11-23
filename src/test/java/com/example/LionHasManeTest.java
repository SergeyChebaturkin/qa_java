package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionHasManeTest {

    private final String sex;
    private final boolean hasMane;
    private Feline feline;

    public LionHasManeTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Не определился", false}
        };
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void checkSexTest() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals("Наличие гривы у льва не соответствует ожидаемому результату", hasMane, lion.doesHaveMane());
        } catch (NoSuchSexOfAnimalException expectedException) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", expectedException.getMessage());
        }
    }
}
