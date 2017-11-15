package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;
    private PerishableStrategyFactory perishableStrategyFactory;

    public GildedRose(Item[] items) {
        this.items = items;
        this.perishableStrategyFactory = new PerishableStrategyFactory();
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item ->
                perishableStrategyFactory.getPerishableItem(item).aged()
        );
    }
}