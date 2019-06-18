package com.sam.project.JavaHbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class App { 
	public static void main(String[] args) {  
        String createTableName = "sys_user";  
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "192.168.16.251");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        System.out.println("conf:"+conf);
        try {  
            HBaseAdmin hBaseAdmin = new HBaseAdmin(conf);  
            HTableDescriptor tableDescriptor = new HTableDescriptor(createTableName);  
            tableDescriptor.addFamily(new HColumnDescriptor("column1"));  
            tableDescriptor.addFamily(new HColumnDescriptor("column2"));  
            tableDescriptor.addFamily(new HColumnDescriptor("column3"));  
            hBaseAdmin.createTable(tableDescriptor);  
            hBaseAdmin.close();  
        } catch (MasterNotRunningException e) {  
            e.printStackTrace();  
        } catch (ZooKeeperConnectionException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println("end create table ......");  
    }  

}
