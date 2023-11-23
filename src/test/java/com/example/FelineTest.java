package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Это семейство кошачьих", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithParam10Returns10() {
        Feline feline = new Feline();
        Assert.assertEquals("Кол-во котят не равно ожидаемому значению", 10, feline.getKittens(10));
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWithParam1() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }
}
