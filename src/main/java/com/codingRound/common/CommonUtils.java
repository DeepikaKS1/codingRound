package com.codingRound.common;

import com.sun.javafx.PlatformUtil;

public class CommonUtils {
	   public void setDriverPath() {
	        if (PlatformUtil.isMac()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver");
	            return;
	        }
	        if (PlatformUtil.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	            return;
	        }
	        if (PlatformUtil.isLinux()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
	            return;
	        }
	    }
	   
	    public void waitFor(int durationInMilliSeconds) {
	    	 try {
	             Thread.sleep(durationInMilliSeconds);
	         } catch (InterruptedException e) {
	             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	         }
			
		}
}
