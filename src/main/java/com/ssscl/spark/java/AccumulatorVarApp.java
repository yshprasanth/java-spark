package com.ssscl.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.LongAccumulator;

import java.util.Arrays;
import java.util.List;

public class AccumulatorVarApp {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("Accumulator Var App").setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        LongAccumulator longAccumulator = javaSparkContext.sc().longAccumulator();
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        javaSparkContext.parallelize(values).foreach(x -> longAccumulator.add(x));

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("longAccumulator value: " + longAccumulator.value());
    }
}
