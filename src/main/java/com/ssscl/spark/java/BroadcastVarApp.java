package com.ssscl.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;

import java.util.Arrays;

public class BroadcastVarApp {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("BroadcastVarApp").setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        Broadcast<int[]> broadcastVar = javaSparkContext.broadcast(new int[]{1, 2, 3});
        Arrays.stream(broadcastVar.value()).forEach(System.out::println);
    }
}
