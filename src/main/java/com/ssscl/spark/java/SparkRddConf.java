package com.ssscl.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkRddConf {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("My Spark Conf").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
