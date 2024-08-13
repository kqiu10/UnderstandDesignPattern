package org.structuralPattern.facade.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.structuralPattern.facade.impl.languageLibrary.CodecFactory;
import org.structuralPattern.facade.impl.languageLibrary.ICodec;
import org.structuralPattern.facade.impl.languageLibrary.PythonCodec;
import org.structuralPattern.facade.impl.languageLibrary.RubyCodec;

public class LanguageConversionFacade {
    private static final Logger log = LogManager.getLogger();
    public String convertLanguage(String fileName, String format) {
        InputFile file = new InputFile(fileName);
        ICodec fromCodec = CodecFactory.extract(file);
        ICodec toCodec;
        if (format.equals("python")) {
            toCodec = new PythonCodec();
        } else {
            toCodec = new RubyCodec();
        }
        final String newFileName = fileName.substring(0, fileName.indexOf(".") + 1) + toCodec.getCode();
        log.info("convertLanguage method gets triggerred, fromCodec, {}, toCodec, {}, newFileName, {}", fromCodec.getCode(),
                toCodec.getCode(), newFileName);
        return newFileName;

    }
}
