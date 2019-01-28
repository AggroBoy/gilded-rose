package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testSulfuras() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Sulfuras, Hand of Ragnaros", 10, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, items[0].quality);
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[1].quality);
        assertEquals(-1, items[1].sellIn);
        assertEquals(80, items[2].quality);
        assertEquals(10, items[2].sellIn);
    }

    @Test
    public void testNormalItem() {
        Item[] items = new Item[]{
                new Item("Happy Fun Rock", 10, 20),
                new Item("Heavy Leather Ball", 1, 5),
                new Item("Voodoo Skull", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
        assertEquals(0, items[1].sellIn);
        assertEquals(4, items[1].quality);
        assertEquals(-1, items[2].sellIn);
        assertEquals(8, items[2].quality);

        app.updateQuality();
        assertEquals(8, items[0].sellIn);
        assertEquals(18, items[0].quality);
        assertEquals(-1, items[1].sellIn);
        assertEquals(2, items[1].quality);
        assertEquals(-2, items[2].sellIn);
        assertEquals(6, items[2].quality);
    }

    @Test
    public void testBrie() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 10)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(1, items[0].sellIn);
        assertEquals(11, items[0].quality);

        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(12, items[0].quality);

        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(14, items[0].quality);


    }

    @Test
    public void testChieftans() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(11, items[0].sellIn);
        assertEquals(11, items[0].quality);

        app.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(12, items[0].quality);

        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(14, items[0].quality);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(25, items[0].quality);

        app.updateQuality();
        assertEquals(3, items[0].sellIn);
        assertEquals(28, items[0].quality);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(37, items[0].quality);

        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }
}
