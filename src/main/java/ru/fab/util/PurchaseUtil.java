package ru.fab.util;

import ru.fab.model.Goods;
import ru.fab.model.Purchase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by r22fab21051979 on 29.01.2018.
 */
public class PurchaseUtil {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /*public static List<Purchase> purchaseList = Arrays.asList(
            new Purchase(1, UserUtil.get(0), GoodsUtil.get(0), LocalDateTime.now(), 64, 2),
            new Purchase(1, UserUtil.get(0), GoodsUtil.get(2), LocalDateTime.now(), 180, 1),
            new Purchase(1, UserUtil.get(1), GoodsUtil.get(3), LocalDateTime.now(), 360, 1)
    );*/

//    public static List<Purchase> getAll(){
//        return purchaseList;
//    }
//
//    public static String toString(LocalDateTime localDateTime){
//        return localDateTime == null ? "" : localDateTime.format(DATE_TIME_FORMATTER);
//    }

}
