package com.gildedrose;

public class ItemUpdater {
    public static final int ETC_DOUBLE_QUALITY_THRESHOLD = 10;
    public static final int ETC_TREBLE_QUALITY_THRESHOLD = 5;

    public static final int ITEM_MIN_QUALITY = 0;
    public static final int ITEM_MAX_QUALITY = 50;
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

        // Ideally I'd have subclassed Item to include an updateQuality method appropriate to each type, but
        // Goblins ruin everything.
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

            if (item.sellIn < ETC_DOUBLE_QUALITY_THRESHOLD) {
                increaseItemQuality();
            }

            if (item.sellIn < ETC_TREBLE_QUALITY_THRESHOLD) {
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
        if (item.quality < ITEM_MAX_QUALITY) {
            item.quality++;
        }
    }

    private void decreaseItemQuality() {
        if (item.quality > ITEM_MIN_QUALITY) {
            item.quality--;
        }
    }
}
