package com.nhlstenden.presentation.item;

import com.nhlstenden.style.Style;

import javax.swing.*;

public class SlideTextItem implements SlideItem
{
    private String text;
    private Style style;

    public SlideTextItem(String text, Style style)
    {
        this.text = text;
        this.style = style;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Style getStyle()
    {
        return style;
    }

    public void setStyle(Style style)
    {
        this.style = style;
    }

    @Override
    public JLabel getJLabel()
    {
        JLabel jLabel = new JLabel(this.text);
        jLabel.setHorizontalTextPosition(this.getStyle().indentation);
        jLabel.setFont(this.getStyle().font);

        return jLabel;
    }
}