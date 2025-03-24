package com.nhlstenden.style;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StyleBuilder
{
    private Color color;
    private String fontName;
    private int fontSize;
    private int indent;

    public StyleBuilder()
    {
        this.color = Color.BLACK;
        this.fontSize = 12;
        this.fontName = "MC";
        this.indent = 0;
    }

    public Style build() throws IOException, FontFormatException
    {
        return new Style(this.fontName.equals("MC") ? Font.createFont(Font.TRUETYPE_FONT, new File("./Monocraft.ttf")) : new Font(this.fontName, Font.PLAIN, this.fontSize), this.color, this.fontSize);
    }

    public StyleBuilder color(Color color)
    {
        this.color = color;

        return this;
    }


    public StyleBuilder fontSize(int size)
    {
        this.fontSize = size;

        return this;
    }

    public StyleBuilder font(String fontName)
    {
        this.fontName = fontName;

        return this;
    }

    public StyleBuilder indent(int indent)
    {
        this.indent = indent;

        return this;
    }
}
