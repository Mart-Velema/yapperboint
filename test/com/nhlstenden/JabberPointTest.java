package com.nhlstenden;

import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JabberPointTest
{
    @Test
    void main_ValidFileName_ShouldLoadFile()
    {
        JabberPoint.main(new String[] {"404.xml"});

        assertEquals("ERROR", Presentation.getInstance().getPresentationTitle());
    }

    @Test
    void main_NoFileName_ShouldLoadDemo()
    {
        JabberPoint.main(new String[] {});

        assertEquals("Demo presentation", Presentation.getInstance().getPresentationTitle());
    }
}