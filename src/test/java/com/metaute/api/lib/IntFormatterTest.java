package com.metaute.api.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntFormatterTest {

    @Test
    public void convertsOne() {
        IntFormatter converter = new IntFormatter();
        String transformed = converter.format(1);
        assertEquals("one", transformed);
    }

    @Test
    public void convertsTwo() {
        IntFormatter converter = new IntFormatter();
        String transformed = converter.format(2);
        assertEquals("two", transformed);
    }
}
