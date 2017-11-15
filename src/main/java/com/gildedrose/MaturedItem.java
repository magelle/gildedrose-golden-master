package com.gildedrose;

public class MaturedItem extends PerishableItem {
    public MaturedItem(Item item) {
        super(item);
    }

    @Override
    public void aged() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
