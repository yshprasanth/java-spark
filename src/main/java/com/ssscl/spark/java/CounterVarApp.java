package com.ssscl.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CounterVarApp {

    public static void main(String[] args) {
        final SparkConf sparkConf = new SparkConf().setAppName("Counter App").setMaster("local");
        final JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        int counter = 0;
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        JavaRDD<Integer> listRdd = javaSparkContext.parallelize(data);
        listRdd.foreach(System.out::println);

        System.out.println("counter: " + counter);
    }
}
