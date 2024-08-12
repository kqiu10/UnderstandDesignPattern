package org.creationalPattern.builder.impl;

import org.creationalPattern.builder.impl.configuration.ceiling.LevelOneCeiling;
import org.creationalPattern.builder.impl.configuration.ceiling.LevelTwoCeiling;
import org.creationalPattern.builder.impl.configuration.coat.DuluxCoat;
import org.creationalPattern.builder.impl.configuration.coat.LiBangCoat;
import org.creationalPattern.builder.impl.configuration.floor.DerFloor;
import org.creationalPattern.builder.impl.configuration.floor.ShengXiangFloor;

public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new LiBangCoat())
                .appendFloor(new DerFloor());
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new LiBangCoat())
                .appendFloor(new DerFloor());
    }

}
