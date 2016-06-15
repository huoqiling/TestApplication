package com.example.testing.myapplication.module.random;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * auther: baiiu
 * time: 16/6/15 15 23:18
 * description:
 */
public class RandomColorGenerator {

    private static Random random;
    private static List<Integer> colors;

    static {
        random = new Random();
        colors = new ArrayList<>();

        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.BLACK);

    }

    public static int getRandomColor() {
        return colors.get(random.nextInt(colors.size()));
    }

}
