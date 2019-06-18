package com.agent.javaAgent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.ClassFileTransformer;

/**
 * @ClassName: PerfMonAgent 
 * @Description: Agent入口
 * @author mqx 
 * @date 2017年7月17日 下午4:19:32
 */
public class PerfMonAgent {
    static private Instrumentation inst = null;
    /**
     * This method is called before the application’s main-method is called,
     * when this agent is specified to the Java VM.
     **/
    public static void premain(String agentArgs, Instrumentation _inst) {
        System.out.println("PerfMonAgent.premain() was called.");
        // Initialize the static variables we use to track information.
        inst = _inst;
        // Set up the class-file transformer.
        ClassFileTransformer trans = new PerfMonXformer();
        System.out.println("Adding a PerfMonXformer instance to the JVM.");
        inst.addTransformer(trans);
    }
}