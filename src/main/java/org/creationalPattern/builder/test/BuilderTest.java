package org.creationalPattern.builder.test;

import org.creationalPattern.builder.impl.Builder;
import org.junit.jupiter.api.Test;

public class BuilderTest {
    @Test
    public void returnInfo_with_different_decoration_package() {
        final Builder builder = new Builder();
        builder.levelOne(100.0).getInfo();
        builder.levelTwo(100.0).getInfo();
        builder.levelThree(100.0).getInfo();

    }
}
