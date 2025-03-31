package com.nhlstenden.presentation.item;

import com.nhlstenden.facade.RenderFacade;
import com.nhlstenden.style.Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
        jLabel.setBorder(new EmptyBorder(0, this.style.indentation * 10, 0, 0));
        jLabel.setFont(this.style.font);

        return jLabel;
    }
}