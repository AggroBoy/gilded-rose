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
            updateQualityForItem(item);
        }
    }

    private void updateQualityForItem(Item item) {

        // Special case fot Sulfuras; do nothing
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        item.sellIn = item.sellIn - 1;

        if (item.name.equals("Aged Brie")) {
            updateAgedBrieQuality(item);

        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateEtcPassQuality(item);

        } else {
            updateNormalItemQuality(item);
        }
    }

    private void updateAgedBrieQuality(Item item) {
        increaseItemQuality(item);
        if (item.sellIn < 0) {
            increaseItemQuality(item);
        }
    }

    private void updateEtcPassQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            increaseItemQuality(item);

            if (item.sellIn < 10) {
                increaseItemQuality(item);
            }

            if (item.sellIn < 5) {
                increaseItemQuality(item);
            }
        }
    }

    private void updateNormalItemQuality(Item item) {
        decreaseItemQuality(item);
        if (item.sellIn < 0) {
            decreaseItemQuality(item);
        }
    }

    private void increaseItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}