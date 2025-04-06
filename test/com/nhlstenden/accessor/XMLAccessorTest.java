package com.nhlstenden.accessor;

import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.Slide;
import com.nhlstenden.presentation.item.SlideItem;
import com.nhlstenden.style.Style;
import com.nhlstenden.style.StyleBuilder;
import com.nhlstenden.style.StyleDirector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLAccessorTest
{

    XMLAccessor xmlAccessor;
    Presentation presentation;

    @BeforeEach
    void setUp()
    {
        xmlAccessor = new XMLAccessor();
        presentation = Presentation.getInstance();
        presentation.getSlides().clear();
    }

    @Test
    void loadFile_loadDemo_successfullyLoaded()
    {
        xmlAccessor.loadFile("./resources/presentations/demo.xml");

        assertEquals(3, presentation.getSlides().size());
    }

    @Test
    void loadFile_loadWrongFile_loadErrorPage()
    {
        xmlAccessor.loadFile("unknownFileName.xml");

        assertEquals("ERROR", presentation.getPresentationTitle());
    }

    @Test
    void loadFile_loadDemo_CorrectStyling() throws IOException, FontFormatException
    {
        xmlAccessor.loadFile("./resources/presentations/test.xml");
        List<Slide> slides = presentation.getSlides();

        StyleBuilder styleBuilder = new StyleBuilder();
        StyleDirector styleDirector = new StyleDirector();

        Style preset1 = styleDirector.makeHeading1(styleBuilder).build();
        Style preset2 = styleDirector.makeHeading2(styleBuilder).build();
        Style preset3 = styleDirector.makeHeading3(styleBuilder).build();
        Style preset4 = styleDirector.makeHeading4(styleBuilder).build();
        Style preset5 = styleDirector.makeHeading5(styleBuilder).build();

        Style custom = styleBuilder
                .font("Helvetica")
                .color(Color.GREEN)
                .fontSize(16)
                .indent(16)
                .build();

        Style customWithPreset = styleDirector
                .makeHeading2(styleBuilder)
                .font("MC")
                .color(Color.RED)
                .indent(16)
                .build();

        List<Style> expectedStyling = List.of(
                preset3,
                preset1,
                preset2,
                preset3,
                preset4,
                preset5,
                custom,
                customWithPreset
        );

        int i = 0;
        for (Slide slide: slides)
        {
            List<SlideItem> slideItems = slide.getTextItems();
            for (SlideItem slideItem: slideItems)
            {
                JLabel jLabel = slideItem.getJLabel();
                Font font = jLabel.getFont();
                Color color = jLabel.getForeground();
                int indentation = jLabel.getBorder().getBorderInsets(jLabel).left / 10;
                Style style = new Style(font, color, indentation);

                assertEquals(expectedStyling.get(i), style);

                i++;
            }
        }
    }
}