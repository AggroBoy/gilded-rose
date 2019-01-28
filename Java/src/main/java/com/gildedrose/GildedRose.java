package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(int times) {
        for (int i = 0; i < times; i++) {
            updateQuality();
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            new ItemUpdater(item).updateQuality();
        }
    }

}