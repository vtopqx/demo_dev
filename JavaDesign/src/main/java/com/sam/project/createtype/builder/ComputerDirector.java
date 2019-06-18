package com.sam.project.createtype.builder;

//导演者（Director）角色
public class ComputerDirector {
	 public Computer createComputer(Builder bud) {  
		 bud.createCpu();
		 bud.createBoard();
         return bud.buildComputer();  
    }  
}
