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
        Font font;

        if (this.fontName.equals("MC"))
        {
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new File("./resources/fonts/Monocraft.ttf"));
            font = baseFont.deriveFont(Font.PLAIN, this.fontSize);
        }
        else
        {
            font = new Font(this.fontName, Font.PLAIN, this.fontSize);
        }

        return new Style(font, this.color, this.indent);
    }

    public StyleBuilder color(Color color)
    {
        if (color != null)
        {
            this.color = color;
        }

        return this;
    }

    public StyleBuilder fontSize(String size)
    {
        if (size != null && size.matches("-?\\d+"))
        {
            this.fontSize = Integer.parseInt(size);
        }

        return this;
    }

    public StyleBuilder fontSize(int size)
    {
        this.fontSize = size;

        return this;
    }

    public StyleBuilder font(String fontName)
    {
        if (fontName != null)
        {
            this.fontName = fontName;
        }

        return this;
    }

    public StyleBuilder indent(String indent)
    {
        if (indent != null && indent.matches("[0-9]+"))
        {
            this.indent = Integer.parseInt(indent);
        }

        return this;
    }

    public StyleBuilder indent(int indent)
    {
        this.indent = indent;

        return this;
    }
}
