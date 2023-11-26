package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionHasManePositiveTest {

    private final String sex;
    private final boolean hasMane;
    private Feline feline;

    public LionHasManePositiveTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void hasManePositiveTest() throws NoSuchSexOfAnimalException{
        Lion lion = new Lion(sex, feline);
            Assert.assertEquals("Наличие гривы у льва не соответствует ожидаемому результату", hasMane, lion.doesHaveMane());
        }
    }
