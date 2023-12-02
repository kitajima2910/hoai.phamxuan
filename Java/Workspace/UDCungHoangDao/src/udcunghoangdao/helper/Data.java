/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udcunghoangdao.helper;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kitajima2910
 */
public class Data {

    private static Map<Integer, String> zodiac = new HashMap<Integer, String>() {
        {
            put(1, "Bạch Dương ~ (21/03 - 19/04)");
            put(2, "Kim Ngưu ~ (20/04 - 20/05)");
            put(3, "Song Tử ~ (21/05 - 21/06)");
            put(4, "Cự Giải ~ (22/06 - 22/07)");
            put(5, "Sư Tử ~ (23/07 - 22/08)");
            put(6, "Xử Nữ ~ (23/08 - 22/09)");
            put(7, "Thiên Bình ~ (23/09 - 23/10)");
            put(8, "Thiên Yết ~ (24/10 - 22/11)");
            put(9, "Nhân Mã ~ (23/11 - 21/12)");
            put(10, "Ma Kết ~ (22/12 - 19/01)");
            put(11, "Bảo Bình ~ (20/01 - 18/02)");
            put(12, "Song Ngư ~ (19/02 - 20/03)");
        }
    };

    public static String getZodiac(int key) {
        return zodiac.get(key);
    }

}
