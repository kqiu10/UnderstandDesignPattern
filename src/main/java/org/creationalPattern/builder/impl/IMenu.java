package org.creationalPattern.builder.impl;

import org.creationalPattern.builder.impl.matter.IMatter;

public interface IMenu {

    IMenu appendCeiling(IMatter matter);

    IMenu appendCoat(IMatter matter);

    IMenu appendFloor(IMatter matter);

    String getInfo();
}
