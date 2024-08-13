package org.structuralPattern.facade.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.structuralPattern.facade.impl.LanguageConversionFacade;

public class FacadeTest {

    @Test
    public void test_Facade_return_expected_result() {
        final LanguageConversionFacade facade = new LanguageConversionFacade();
        assertEquals("youtubeVideo.python", facade.convertLanguage("youtubeVideo.ruby", "python"));
        assertEquals("tiktokVideo.ruby", facade.convertLanguage("tiktokVideo.python", "ruby"));
    }
}
