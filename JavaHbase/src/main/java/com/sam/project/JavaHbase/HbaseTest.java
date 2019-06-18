package com.sam.project.JavaHbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class HbaseTest {

	static Configuration conf;
	static Connection conn;

	public static void main(String[] args) {
		init();
	}

	public static void init() {
		conf = HBaseConfiguration.create();
		// conf.set("hbase.master", "192.168.1.114:16010");
		// conf.set("hbase.zookeeper.quorum", "hadoop,hadoop1,hadoop2");

		conf = HBaseConfiguration.create();
//		conf.set("hbase.zookeeper.property.clientPort", "2181");
//		conf.set("hbase.zookeeper.quorum", "192.168.1.114");
//		conf.set("hbase.master", "192.168.1.114:16010");
		conf.set("hbase.zookeeper.quorum", "192.168.16.251");

		try {
			conn = ConnectionFactory.createConnection(conf);
			System.out.println(conn);
			// 创建表
			createTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createTable() throws IOException {

		HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
		HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("people"));
		HColumnDescriptor htd_info = new HColumnDescriptor("info");
		htd.addFamily(htd_info);
		htd.addFamily(new HColumnDescriptor("data"));
		htd_info.setMaxVersions(3);

		admin.createTable(htd);
		admin.close();
		System.out.println("success!");
	}
}