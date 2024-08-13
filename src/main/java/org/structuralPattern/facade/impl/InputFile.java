package org.structuralPattern.facade.impl;

public class InputFile {
    private String name;
    private String codecType;

    public InputFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCodecType() {
        return codecType;
    }

    public void setCodecType(final String codecType) {
        this.codecType = codecType;
    }
}
