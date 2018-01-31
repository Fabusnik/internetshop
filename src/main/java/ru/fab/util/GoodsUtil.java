package ru.fab.util;

import ru.fab.model.Goods;

import java.util.Arrays;
import java.util.List;

/**
 * Created by r22fab21051979 on 29.01.2018.
 */
public class GoodsUtil {
    public static List<Goods> goodsList = Arrays.asList(
            new Goods(1, "Milk", "Milk 2.5%", 32, 50),
            new Goods(2, "Beer", "Carlsberg 4.5%", 64, 155),
            new Goods(3, "Better", "Burenka 72%", 180, 35),
            new Goods(4, "Toy", "Small pig", 360, 17),
            new Goods(5, "TV", "Samsung 40", 4520, 2)
    );

    public static List<Goods> getAll(){
        return goodsList;
    }

    public static Goods get(Integer id){
        return goodsList.get(id);
    }
}
