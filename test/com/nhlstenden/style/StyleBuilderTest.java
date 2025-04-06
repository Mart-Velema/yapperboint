package com.nhlstenden.style;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StyleBuilderTest
{
    StyleBuilder styleBuilder;

    @BeforeEach
    void setUp()
    {
        this.styleBuilder = new StyleBuilder();
    }

    @Test
    void build_DefaultFont_ShouldReturnDefaultFont() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.font("MC"));

        Style style = this.styleBuilder.build();

        assertEquals("Monocraft", style.getFont().getName());
    }

    @Test
    void build_HelveticaFont_ShouldReturnHelveticaFont() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.font("Helvetica"));

        Style style = this.styleBuilder.build();

        assertEquals("Helvetica", style.getFont().getName());
    }

    @Test
    void color_BlackColour_ShouldReturnBlackStyle() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.color(Color.BLACK));

        Style style = this.styleBuilder.build();

        assertEquals(Color.BLACK, style.getColor());
    }

    @Test
    void color_WhiteColour_ShouldReturnWhiteStyle() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.color(Color.WHITE));

        Style style = this.styleBuilder.build();

        assertEquals(Color.WHITE, style.getColor());
    }

    @Test
    void color_NullColour_ShouldReturnWhiteStyle() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.color(Color.WHITE));
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.color(null));

        Style style = this.styleBuilder.build();

        assertEquals(Color.WHITE, style.getColor());
    }

    @Test
    void fontSize_ValidIntegerTen_ShouldReturnTen() throws IOException, FontFormatException
    {
        String number = "10";

        assertInstanceOf(StyleBuilder.class, this.styleBuilder.fontSize(number));

        Style style = this.styleBuilder.build();

        assertEquals(10, style.getFont().getSize());
    }

    @Test
    void fontSize_ValidIntegerTwenty_ShouldReturnTwenty() throws IOException, FontFormatException
    {
        String number = "20";

        assertInstanceOf(StyleBuilder.class, this.styleBuilder.fontSize(number));

        Style style = this.styleBuilder.build();

        assertEquals(20, style.getFont().getSize());
    }

    @Test
    void fontSize_InvalidInteger_ShouldReturnTwelve() throws IOException, FontFormatException
    {
        String number = "IEEE 754";

        assertInstanceOf(StyleBuilder.class, this.styleBuilder.fontSize(number));

        Style style = this.styleBuilder.build();

        assertEquals(12, style.getFont().getSize());
    }

    @Test
    void fontSize_Null_ShouldReturnTwelve() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.fontSize(null));

        Style style = this.styleBuilder.build();

        assertEquals(12, style.getFont().getSize());
    }

    @Test
    void fontSize_NormalIntegerTen_ShouldReturnTen() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.fontSize(10));

        Style style = this.styleBuilder.build();

        assertEquals(10, style.getFont().getSize());
    }

    @Test
    void fontSize_NormalIntegerTwenty_ShouldReturnTwenty() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.fontSize(20));

        Style style = this.styleBuilder.build();

        assertEquals(20, style.getFont().getSize());
    }

    @Test
    void font_ValidFont_ShouldReturnHelvetica() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.font("Helvetica"));

        Style style = this.styleBuilder.build();

        assertEquals("Helvetica", style.getFont().getName());
    }

    @Test
    void font_ValidFont_ShouldReturnComicSans() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.font("Comic Sans"));

        Style style = this.styleBuilder.build();

        assertEquals("Comic Sans", style.getFont().getName());
    }

    @Test
    void font_NullFont_ShouldReturnMonocraft() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.font(null));

        Style style = this.styleBuilder.build();

        assertEquals("Monocraft", style.getFont().getName());
    }

    @Test
    void indent_ValidIntegerTen_ShouldReturnTen() throws IOException, FontFormatException
    {
        String indent = "10";

        assertInstanceOf(StyleBuilder.class, this.styleBuilder.indent(indent));

        Style style = this.styleBuilder.build();

        assertEquals(10, style.getIndentation());
    }

    @Test
    void indent_ValidIntegerTwenty_ShouldReturnTwentyt() throws IOException, FontFormatException
    {
        String indent = "20";

        assertInstanceOf(StyleBuilder.class, this.styleBuilder.indent(indent));

        Style style = this.styleBuilder.build();

        assertEquals(20, style.getIndentation());
    }

    @Test
    void indent_Null_ShouldReturnZero() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.indent(null));

        Style style = this.styleBuilder.build();

        assertEquals(0, style.getIndentation());
    }

    @Test
    void indent_InvalidInteger_ShouldReturnZero() throws IOException, FontFormatException
    {
        String indent = "IEEE 754";

        assertInstanceOf(StyleBuilder.class, this.styleBuilder.indent(indent));

        Style style = this.styleBuilder.build();

        assertEquals(0, style.getIndentation());
    }

    @Test
    void indent_IntegerTen_ShouldReturnTen() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.indent(10));

        Style style = this.styleBuilder.build();

        assertEquals(10, style.getIndentation());
    }

    @Test
    void indent_IntegerTwenty_ShouldReturnTwenty() throws IOException, FontFormatException
    {
        assertInstanceOf(StyleBuilder.class, this.styleBuilder.indent(20));

        Style style = this.styleBuilder.build();

        assertEquals(20, style.getIndentation());
    }
}