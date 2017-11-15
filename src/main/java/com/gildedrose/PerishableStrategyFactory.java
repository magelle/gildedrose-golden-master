package com.gildedrose;

public class PerishableStrategyFactory {

    public PerishableItem getPerishableItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return new EternalItem(item);
        if (item.name.equals("Aged Brie"))
            return new MaturedItem(item);
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            return new FixedEndDateItem(item);

        return new DefaultPerishable(item);
    }

}
