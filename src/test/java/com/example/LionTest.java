package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensInvokeFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(5);
        Assert.assertEquals(5, lion.getKittens());
    }

    @Test
    public void getFoodInvokeFelineGetFoodWithParam() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

}
