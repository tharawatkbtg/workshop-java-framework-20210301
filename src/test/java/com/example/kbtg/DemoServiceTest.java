package com.example.kbtg;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest {
    @Test
    @DisplayName("ในการทำงานต้อง random ได้ค่า 5")
    public void random_5(){
        DemoService demoService = new DemoService();
        demoService.setRandom(new Random5());
        String actualResult = demoService.generateData("Eark");
        assertEquals("Eark5",actualResult);
    }

    @Test
    @DisplayName("ในการทำงาน random <= 4")
    public void random_1to4(){
        DemoService demoService = new DemoService();
        demoService.setRandom(new Random1_4());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            //final String invalidEmail = "somkiat@";
            String actualResult = demoService.generateData("Eark");
        });
    }

    class Random5 extends Random {
        @Override
        public int nextInt(int bound) {
            return 5;
        }
    }

    class Random1_4 extends Random {
        @Override
        public int nextInt(int bound) {
            return 4;
        }
    }
}