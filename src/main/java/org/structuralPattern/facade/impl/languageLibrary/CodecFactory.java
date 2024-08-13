package org.structuralPattern.facade.impl.languageLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.structuralPattern.facade.impl.InputFile;

public class CodecFactory {
    private static final Logger log = LogManager.getLogger();
    public static ICodec extract(InputFile file) {
        log.info("extract file, fileName, {}, fileType, {}", file.getName(), file.getCodecType());
        String type = file.getCodecType();
        if (type.equals("python")) {
            return new PythonCodec();
        } else if (type.equals("ruby")) {
            return new RubyCodec();
        } else {
            throw new UnsupportedOperationException("File type is unsupported");
        }

    }
}