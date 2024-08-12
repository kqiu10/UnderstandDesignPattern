package org.creationalPattern.builder.impl.configuration.ceiling;

import java.math.BigDecimal;

import org.creationalPattern.builder.impl.matter.IMatter;

/**
 * 吊顶
 * 品牌；装修公司自带
 * 型号：二级顶
 */
public class LevelTwoCeiling  implements IMatter {

    public String scene() {
        return "吊顶";
    }

    public String brand() {
        return "装修公司自带";
    }

    public String model() {
        return "二级顶";
    }

    public BigDecimal price() {
        return new BigDecimal(850);
    }

    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm，要是层高很高，也可增加每级的厚度";
    }
    
}