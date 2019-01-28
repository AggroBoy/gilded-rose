package com.gildedrose;

public class ItemUpdater {
    Item item;

    public ItemUpdater(Item newItem) {
        this.item = newItem;
    }

    public void updateQuality() {

        // Special case for Sulfuras; do nothing
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        item.sellIn = item.sellIn - 1;

        if (item.name.equals("Aged Brie")) {
            updateAgedBrieQuality();

        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateEtcPassQuality();

        } else if (item.name.startsWith("Conjured ")) {
            updateConjuredItemQuality();

        } else {
            updateNormalItemQuality();
        }
    }

    private void updateConjuredItemQuality() {
        updateNormalItemQuality();
        updateNormalItemQuality();
    }

    private void updateAgedBrieQuality() {
        increaseItemQuality();
        if (item.sellIn < 0) {
            increaseItemQuality();
        }
    }

    private void updateEtcPassQuality() {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            increaseItemQuality();

            if (item.sellIn < 10) {
                increaseItemQuality();
            }

            if (item.sellIn < 5) {
                increaseItemQuality();
            }
        }
    }

    private void updateNormalItemQuality() {
        decreaseItemQuality();
        if (item.sellIn < 0) {
            decreaseItemQuality();
        }
    }

    private void increaseItemQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseItemQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

}
