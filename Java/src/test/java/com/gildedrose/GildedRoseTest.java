package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    private void assertItemEquals(Item item, int sellIn, int quality) {
        assertEquals(quality, item.quality);
        assertEquals(sellIn, item.sellIn);
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Sulfuras, Hand of Ragnaros", 10, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertItemEquals(items[0], 0, 80);
        assertItemEquals(items[1], -1, 80);
        assertItemEquals(items[2], 10, 80);
    }

    @Test
    public void testNormalItem() {
        Item[] items = new Item[]{
                new Item("Happy Fun Rock", 10, 20),
                new Item("Heavy Leather Ball", 1, 5),
                new Item("Voodoo Skull", 0, 10),
                new Item("Paper Zeppelin Kit", 3, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertItemEquals(items[0], 9, 19);
        assertItemEquals(items[1], 0, 4);
        assertItemEquals(items[2], -1, 8);
        assertItemEquals(items[3], 2, 0);

        app.updateQuality();
        assertItemEquals(items[0], 8, 18);
        assertItemEquals(items[1], -1, 2);
        assertItemEquals(items[2], -2, 6);
        assertItemEquals(items[3], 1, 0);
    }

    @Test
    public void testBrie() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 10),
                new Item("Aged Brie", 2, 49)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertItemEquals(items[0], 1, 11);
        assertItemEquals(items[1], 1, 50);


        app.updateQuality();
        assertItemEquals(items[0], 0, 12);
        assertItemEquals(items[1], 0, 50);

        app.updateQuality();
        assertItemEquals(items[0], -1, 14);
        assertItemEquals(items[1], -1, 50);
    }

    @Test
    public void testChieftains() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 50)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertItemEquals(items[0], 11, 11);
        assertItemEquals(items[1], 11, 50);

        app.updateQuality();
        assertItemEquals(items[0], 10, 12);
        assertItemEquals(items[1], 10, 50);

        app.updateQuality();
        assertItemEquals(items[0], 9, 14);
        assertItemEquals(items[1], 9, 50);

        app.updateQuality(5);
        assertItemEquals(items[0], 4, 25);
        assertItemEquals(items[1], 4, 50);

        app.updateQuality();
        assertItemEquals(items[0], 3, 28);
        assertItemEquals(items[1], 3, 50);

        app.updateQuality(3);
        assertItemEquals(items[0], 0, 37);
        assertItemEquals(items[1], 0, 50);

        app.updateQuality();
        assertItemEquals(items[0], -1, 0);
        assertItemEquals(items[1], -1, 0);
    }

    @Test
    public void testConjured() {
        Item[] items = new Item[]{
                new Item("Conjured Mana Cake", 1, 10),
                new Item("Conjured Mana Strudel", 10, 50)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertItemEquals(items[0], 0, 8);
        assertItemEquals(items[1], 9, 48);

        app.updateQuality();
        assertItemEquals(items[0], -1, 4);
        assertItemEquals(items[1], 8, 46);

        app.updateQuality();
        assertItemEquals(items[0], -2, 0);
        assertItemEquals(items[1], 7, 44);

        app.updateQuality();
        assertItemEquals(items[0], -3, 0);
        assertItemEquals(items[1], 6, 42);
    }
}
