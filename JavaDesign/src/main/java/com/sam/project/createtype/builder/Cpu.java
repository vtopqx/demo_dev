package com.sam.project.createtype.builder;

/**
 * @ClassName: Cpu
 * @Description: CPU实体类
 * @author mqx
 * @date 2017年9月20日 下午3:27:20
 */
public class Cpu {
	private int id;
	private String name;

	public Cpu(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
