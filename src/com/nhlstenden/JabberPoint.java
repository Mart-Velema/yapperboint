package com.nhlstenden;

import com.nhlstenden.accessor.Accessor;
import com.nhlstenden.accessor.XMLAccessor;
import com.nhlstenden.facade.RenderFacade;
import com.nhlstenden.presentation.Presentation;

/**
 * com.nhlstenden.JabberPoint Main Programma
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint
{
    protected static final String IOERR = "IO Error: ";
    protected static final String JABERR = "Jabberpoint Error ";
    protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

    // Het Main Programma
    public static void main(String[] argv)
    {

        Presentation presentation = Presentation.getInstance();
        RenderFacade renderFacade = RenderFacade.getInstance();

        Accessor accessor = new XMLAccessor();
        if (argv.length == 0)
        { // een demo presentatie
            accessor.loadFile("demo.xml");
        }
        else
        {
            accessor.loadFile(argv[0]);
        }

        presentation.setCurrentSlideNumber(0);
        renderFacade.renderSlide(presentation.getCurrentSlide());
    }
}
