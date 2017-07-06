package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpireJobTask {
	 /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ExpireJobTask.class);
 
    /**
     * 涓氬姟閫昏緫澶勭悊
     */
    public void doBiz() {
    	System.out.println("---------任务正在执行-----------");
    }
}
