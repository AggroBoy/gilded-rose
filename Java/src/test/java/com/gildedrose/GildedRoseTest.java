package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testSulfuras() {
        Item[] items = new Item[] {
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

}
