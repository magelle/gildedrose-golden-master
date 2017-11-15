package com.gildedrose;

public abstract class PerishableItem {

    protected Item item;

    public PerishableItem(Item item) {
        this.item = item;
    }

    public abstract void aged();

}
