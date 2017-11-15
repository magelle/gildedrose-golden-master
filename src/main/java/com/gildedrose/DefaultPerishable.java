package com.gildedrose;

public class DefaultPerishable extends PerishableItem {

    public DefaultPerishable(Item item) {
        super(item);
    }

    @Override
    public void aged() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
