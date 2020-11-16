package com.ssscl.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;
import scala.Int;
import scala.Tuple2;

import java.util.List;

public class MapReduceRDDTextFile {
    public static void main(String[] args) {
//        final SparkSession sparkSession = SparkSession.builder()
//                .appName("MapReduceTextFileContents")
//                .getOrCreate();

        final SparkConf conf = new SparkConf().setAppName("My Java Spark RDD").setMaster("local");
        final JavaSparkContext jsc = new JavaSparkContext(conf);

        final JavaRDD<String> textFileRdd = jsc.textFile("Names.txt");
        final JavaRDD<Integer> textFileMapRdd = textFileRdd.map(s -> s.length()).persist(StorageLevel.MEMORY_ONLY());

        final int totalLength = textFileMapRdd
                .reduce(
                        (a,b) -> {
                            System.out.println("a: " + a + ", b: " + b);
                            return a+b;
                        });
        System.out.println("totalLength of Names: " + totalLength);

        final int maxLength = textFileMapRdd.reduce((a,b) -> a>b?a:b);
        System.out.println("maxLength of Names: " + maxLength);

        final String maxName = textFileRdd.map(s -> s).reduce((a, b) -> a.length()>b.length()?a:b);
        System.out.println("maxLength Name: " + maxName);

        JavaPairRDD<String, Integer> namePairs = textFileRdd.mapToPair( s -> new Tuple2<>(s, 1));
        JavaPairRDD<String, Integer> nameCounts = namePairs.reduceByKey((a, b) -> a+b);
        List<Tuple2<String,Integer>> lists = nameCounts.collect();
        System.out.println("namePairs: " + lists);

        System.out.println("Total no of words: " + nameCounts.reduce((a,b) -> new Tuple2(a, a._2+b._2))._2);

        jsc.close();
    }
}
