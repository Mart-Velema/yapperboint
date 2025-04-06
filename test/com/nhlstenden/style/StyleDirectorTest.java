package com.nhlstenden.style;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StyleDirectorTest
{
    StyleDirector styleDirector;

    @BeforeEach
    void setUp()
    {
        this.styleDirector = new StyleDirector();
    }

    @Test
    void makeHeading1() throws IOException, FontFormatException
    {
        StyleBuilder styleBuilder = this.styleDirector.makeHeading1(new StyleBuilder());

        Style style = styleBuilder.build();

        assertEquals(Color.BLUE, style.getColor());
        assertEquals("Monocraft", style.getFont().getName());
        assertEquals(30, style.getFont().getSize());
        assertEquals(0, style.getIndentation());
    }

    @Test
    void makeHeading2() throws IOException, FontFormatException
    {
        StyleBuilder styleBuilder = this.styleDirector.makeHeading2(new StyleBuilder());

        Style style = styleBuilder.build();

        assertEquals(Color.CYAN, style.getColor());
        assertEquals("Monocraft", style.getFont().getName());
        assertEquals(25, style.getFont().getSize());
        assertEquals(5, style.getIndentation());
    }

    @Test
    void makeHeading3() throws IOException, FontFormatException
    {
        StyleBuilder styleBuilder = this.styleDirector.makeHeading3(new StyleBuilder());

        Style style = styleBuilder.build();

        assertEquals(Color.BLACK, style.getColor());
        assertEquals("Monocraft", style.getFont().getName());
        assertEquals(12, style.getFont().getSize());
        assertEquals(10, style.getIndentation());
    }

    @Test
    void makeHeading4() throws IOException, FontFormatException
    {
        StyleBuilder styleBuilder = this.styleDirector.makeHeading4(new StyleBuilder());

        Style style = styleBuilder.build();

        assertEquals(Color.GRAY, style.getColor());
        assertEquals("Monocraft", style.getFont().getName());
        assertEquals(10, style.getFont().getSize());
        assertEquals(15, style.getIndentation());
    }

    @Test
    void makeHeading5() throws IOException, FontFormatException
    {
        StyleBuilder styleBuilder = this.styleDirector.makeHeading5(new StyleBuilder());

        Style style = styleBuilder.build();

        assertEquals(Color.DARK_GRAY, style.getColor());
        assertEquals("Monocraft", style.getFont().getName());
        assertEquals(8, style.getFont().getSize());
        assertEquals(20, style.getIndentation());
    }
}