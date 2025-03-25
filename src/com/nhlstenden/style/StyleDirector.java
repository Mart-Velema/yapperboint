package com.nhlstenden.style;

import java.awt.*;

public class StyleDirector
{
    public StyleDirector()
    {

    }

    public StyleBuilder makeHeading1(StyleBuilder styleBuilder)
    {
        return styleBuilder.color(Color.BLUE).fontSize(30);
    }

    public StyleBuilder makeHeading2(StyleBuilder styleBuilder)
    {
        return styleBuilder.color(Color.CYAN).fontSize(25).indent(5);
    }

    public StyleBuilder makeHeading3(StyleBuilder styleBuilder)
    {
        return styleBuilder.color(Color.BLACK).fontSize(12).indent(10);
    }

    public StyleBuilder makeHeading4(StyleBuilder styleBuilder)
    {
        return styleBuilder.color(Color.GRAY).fontSize(10).indent(15);
    }

    public StyleBuilder makeHeading5(StyleBuilder styleBuilder)
    {
        return styleBuilder.color(Color.DARK_GRAY).fontSize(8).indent(20);
    }
}
