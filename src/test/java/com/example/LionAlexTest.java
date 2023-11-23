package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Mock
    Feline feline;

    @Test
    public void getFriendsTest() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        List<String> expectedListOfFriends = List.of("Зебра Марти", "Бегемот Глория", "Жираф Мельман");
        List<String> actualListOfFriends = lionAlex.getFriends();
        for (String expectedListOfFriend : expectedListOfFriends) {
            Assert.assertTrue("Ожидаемого друга нет в списке друзей Алекса", actualListOfFriends.contains(expectedListOfFriend));
        }
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        Assert.assertEquals("Нью-Йоркский зоопарк", new LionAlex(feline).getPlaceOfLiving());
    }

    @Test
    public void getKittensTest() throws Exception {
        Assert.assertEquals("Кол-во котят не совпадает", 0, new LionAlex(feline).getKittens());
    }
}
