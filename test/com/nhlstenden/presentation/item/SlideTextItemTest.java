package com.nhlstenden.presentation.item;

import com.nhlstenden.style.Style;
import com.nhlstenden.style.StyleBuilder;
import com.nhlstenden.style.StyleDirector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SlideTextItemTest
{
    SlideTextItem slideTextItem;

    @BeforeEach
    void setUp() throws IOException, FontFormatException
    {
        slideTextItem = new SlideTextItem("Test", new StyleBuilder().build());
    }

    @Test
    void getJLabel_heading3_getsCorrectJLabel() throws IOException, FontFormatException
    {
        StyleDirector styleDirector = new StyleDirector();
        Style style = styleDirector.makeHeading3(new StyleBuilder()).build();

        slideTextItem.setStyle(style);
        JLabel jLabel = slideTextItem.getJLabel();

        Font font = Font
                .createFont(Font.TRUETYPE_FONT, new File("./Monocraft.ttf"))
                .deriveFont(Font.PLAIN, 12);

        assertEquals("Test", jLabel.getText());
        assertEquals(font, jLabel.getFont());
        assertEquals(Color.BLACK, jLabel.getForeground());
        assertEquals(new Insets(0, 100, 0, 0), jLabel.getBorder().getBorderInsets(jLabel));
    }

    @Test
    void getJLabel_customStyling_getsCorrectJLabel() throws IOException, FontFormatException
    {
        Style style = new StyleBuilder().color(Color.PINK).font("Helvetica").indent(2).fontSize(30).build();

        slideTextItem.setStyle(style);
        slideTextItem.setText("Hallo");
        JLabel jLabel = slideTextItem.getJLabel();

        Font font = new Font("Helvetica", Font.PLAIN, 30);

        assertEquals("Hallo", jLabel.getText());
        assertEquals(font, jLabel.getFont());
        assertEquals(Color.PINK, jLabel.getForeground());
        assertEquals(new Insets(0, 2 * 10, 0, 0), jLabel.getBorder().getBorderInsets(jLabel));
    }
}