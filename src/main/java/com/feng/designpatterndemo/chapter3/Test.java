package com.feng.designpatterndemo.chapter3;

import com.feng.designpatterndemo.chapter3.component.Beverage;
import com.feng.designpatterndemo.chapter3.component.Espresso;
import com.feng.designpatterndemo.chapter3.component.HouseBlend;
import com.feng.designpatterndemo.chapter3.decorator.Mocha;
import com.feng.designpatterndemo.chapter3.decorator.Whip;
import com.feng.designpatterndemo.chapter3.javaio.LowerCaseInputStream;

import java.io.*;

/**
 * @Author fency
 * @Date 2025/5/20 13:58
 * @Version 1.0
 */

public class Test {

    public static void main(String[] args) throws IOException {
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        FileInputStream fileInputStream = new FileInputStream("d://test.txt");
        LowerCaseInputStream lowerCaseInputStream = new LowerCaseInputStream(fileInputStream);
        while (true) {
            int c = lowerCaseInputStream.read();
            if (c == -1) {
                break;
            }
            System.out.print((char) c);
        }
        lowerCaseInputStream.close();
        fileInputStream.close();
    }

}
