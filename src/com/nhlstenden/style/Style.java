package com.nhlstenden.style;

import java.awt.*;

public class Style
{
    private Font font;
    private Color color;
    private int indentation;

    public Style(Font font, Color color, int indentation)
    {
        this.font = font;
        this.color = color;
        this.indentation = indentation;
    }

    public Font getFont()
    {
        return font;
    }

    public void setFont(Font font)
    {
        this.font = font;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getIndentation()
    {
        return indentation;
    }

    public void setIndentation(int indentation)
    {
        this.indentation = indentation;
    }
}
