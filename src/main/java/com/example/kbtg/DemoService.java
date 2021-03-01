package com.example.kbtg;

import java.util.Random;

import static java.lang.System.out;

public class DemoService {
    private Random random;
    public void setRandom(Random random) {
        this.random = random;
    }

    public String generateData(String name) {
        int number = random.nextInt(random.nextInt());
        if (number >= 5 && number <= 8){
            return name+number;
        }
        throw new RuntimeException("Invalid number with "+5);
    }

//    public static void main(String[] args) {
//        // Anonymous class + Override by methods
//        Random random = new Random(){
//            @Override
//            public int nextInt(int bound) {
//                return 5;
//            }
//        };
//        DemoService demoService = new DemoService();
//        demoService.setRandom(new Random5());
//        out.println(demoService.generateData("somkiat"));
//    }
}

//class Random5 extends Random {
//    @Override
//    public int nextInt(int bound) {
//        return 5;
//    }
//}
