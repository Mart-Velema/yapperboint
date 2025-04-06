package com.nhlstenden.style;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StyleTest
{
    Style style1;
    Style style2;

    @BeforeEach
    void setUp() throws IOException, FontFormatException
    {
        StyleBuilder styleBuilder = new StyleDirector().makeHeading3(new StyleBuilder());
        this.style1 = styleBuilder.build();
        this.style2 = styleBuilder.build();
    }

    @Test
    void equals_SameObject_ShouldReturnTrue()
    {
        assertTrue(this.style1.equals(this.style1));
    }

    @Test
    void equals_DifferentObject_ShouldReturnFalse()
    {
        assertFalse(this.style1.equals(new String("Not thes ame")));
    }

    @Test
    void equals_SameTypeDifferentIndentation_ShouldReturnFalse()
    {
        this.style2.setIndentation(0);

        assertFalse(this.style1.equals(this.style2));
    }

    @Test
    void equals_SameTypeDifferentColor_ShouldReturnFalse()
    {
        this.style2.setColor(Color.GREEN);

        assertFalse(this.style1.equals(this.style2));
    }

    @Test
    void equals_SameTypeDifferentFont_ShouldReturnFalse()
    {
        this.style2.setFont(Font.getFont("Helvetica"));

        assertFalse(this.style1.equals(this.style2));
    }

    @Test
    void equals_SameTypeDifferentProperties_ShouldReturnTrue()
    {
        assertTrue(this.style1.equals(this.style2));
    }
}