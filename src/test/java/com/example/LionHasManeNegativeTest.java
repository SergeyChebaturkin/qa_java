package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class LionHasManeNegativeTest {

    @Mock
    Feline feline;

    @Test
    public void hasManeThrowsNoSuchSexOfAnimalException() {
        try {
        Lion lion = new Lion("Не определился", feline);
        Assert.fail("Expected NoSuchSexOfAnimalException");
        } catch (NoSuchSexOfAnimalException expectedException) {
            Assert.assertNotEquals("", expectedException.getMessage());
        }
    }
}
