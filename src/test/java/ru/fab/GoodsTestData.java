package ru.fab;

import ru.fab.model.Goods;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class GoodsTestData {
    public static final int GOOD_CAT_ID = 3;
    public static final int GOOD_TOY_ID = 1;

    public static final Goods GOODS_TOY = new Goods(1,"Toy", "China toy", 100, 5);
    public static final Goods GOODS_ROSE = new Goods(2,"Flower", "Red rouse", 50, 150);
    public static final Goods GOODS_CAT = new Goods(3,"Cat", "catty", 1500, 1);
    public static final Goods GOODS_WATER = new Goods(4,"Water", "artesian water 5 liters", 60, 15);




    public static void assertMatch(Goods actual, Goods expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "price");
    }

    public static void assertMatch(Iterable<Goods> actual, Goods... expected) {
        assertMatch(actual, Arrays.asList(expected));

    }
    public static void assertMatch(Iterable<Goods> actual, Iterable<Goods> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("price").isEqualTo(expected);
    }

}
