package com.ssscl.spark.java;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

public class SimpleApp {

    public static void main(String[] args) {
        final String nameFile = "Names.txt";
        final SparkSession session = SparkSession.builder()
                                        .appName("Names Reader")
                                        .getOrCreate();
        final Dataset<String> namesDataSet = session.read().textFile(nameFile).cache();

        long numAs = namesDataSet
                        .filter((FilterFunction<String>) s -> s.contains("a"))
                        .count();
        long numBs = namesDataSet
                        .filter((FilterFunction<String>) s -> s.contains("b"))
                        .count();

        System.out.println("Number of a's: " + numAs + ", Number of b's: " + numBs);

        session.stop();
    }
}
