package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GildedRoseTest {

    private final static String[] itemTypes = new String[]{
            "+5 Dexterity Vest",
            "Aged Brie",
            "Elixir of the Mongoose",
            "Sulfuras, Hand of Ragnaros",
            "Backstage passes to a TAFKAL80ETC concert",
            "Conjured Mana Cake"
    };

    @Test
    public void compare_old_and_new() {
        Item[] itemsForNew = testCases().collect(toList()).toArray(new Item[]{});
        Item[] itemsForOld = testCases().collect(toList()).toArray(new Item[]{});

        new GildedRose(itemsForNew).updateQuality();
        new OldGildedRose(itemsForOld).updateQuality();

        for(int index = 0; index < itemsForNew.length; index++) {
            Item itemUpdatedNew = itemsForNew[index];
            Item itemUpdatedOld = itemsForOld[index];
            Assert.assertEquals(itemUpdatedNew.name, itemUpdatedOld.name);
            Assert.assertEquals(itemUpdatedNew.quality, itemUpdatedOld.quality);
            Assert.assertEquals(itemUpdatedNew.sellIn, itemUpdatedOld.sellIn);
        }
    }

    private Stream<Item> testCases() {
        return Arrays.stream(itemTypes)
                .flatMap(item -> initialSellIns()
                        .flatMap(sellIn -> initialQuality()
                                .map(quality -> new Item(item, sellIn, quality))));
    }

    private Stream<Integer> initialSellIns() {
        return IntStream
                .range(-50, 80)
                .boxed();
    }

    private Stream<Integer> initialQuality() {
        return IntStream
                .range(-50, 80)
                .boxed();
    }
}
