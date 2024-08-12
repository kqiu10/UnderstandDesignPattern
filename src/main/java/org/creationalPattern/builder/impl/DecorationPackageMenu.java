package org.creationalPattern.builder.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.creationalPattern.builder.impl.matter.IMatter;

public class DecorationPackageMenu implements IMenu {

    private static final Logger log = LogManager.getLogger(DecorationPackageMenu.class);

    private List<IMatter> matters = new ArrayList<>();
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal area;
    private String grade;

    public DecorationPackageMenu(final Double area, final String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    @Override
    public IMenu appendCeiling(final IMatter matter) {
        matters.add(matter);
        count(matter);
        return this;
    }

    @Override
    public IMenu appendCoat(final IMatter matter) {
        matters.add(matter);
        count(matter);
        return this;
    }

    @Override
    public IMenu appendFloor(final IMatter matter) {
        matters.add(matter);
        count(matter);
        return this;
    }

    @Override
    public String getInfo() {
        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "package list" + "\r\n" +
                "package level：" + grade + "\r\n" +
                "total price：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " yuan\r\n" +
                "area：" + area.doubleValue() + " square feet\r\n" +
                "matter list：\r\n");

        for (IMatter matter: matters) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、price per square feet：").append(matter.price()).append(" yuan。\n");
        }
        log.info(detail.toString());
        return detail.toString();
    }

    private void count(IMatter matter) {
        price =  price.add(area.multiply(matter.price()));
    }
}
