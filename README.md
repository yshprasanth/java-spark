### Java Spark Application
<hr>

A simple app to read text from a file and list the number of words that contain characters 'a' and 'b'.

1. Below are the required dependencies:
        ```xml
        <dependency>
            <groupId>org.apache.spark</groupId>
            <artifactId>spark-core_2.12</artifactId>
            <version>3.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.spark</groupId>
            <artifactId>spark-sql_2.12</artifactId>
            <version>3.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.spark</groupId>
            <artifactId>spark-streaming_2.12</artifactId>
            <version>3.0.1</version>
        </dependency>
        ```
    
2. Build the app

    - mvn package
    
3. Run the app using following command

    - <spark-install-path>/bin/spark-submit \
        --class "com.ssscl.spark.java.SimpleApp" \ 
        --master local[1] target/java-spark-1.0-SNAPSHOT.jar 

    


    
