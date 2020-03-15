/**WriteToFile.java
 * utils
 * 写入文件的工具类
 * @author liar
 * 2019年8月14日 下午5:30:27
 * @version 1.0
 */
package utils;

import java.io.*;
import java.util.ArrayList;

public class WriteToFile {

	public WriteToFile() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean writeArrayListToFile(String filePath,ArrayList<String> tempArrayList) throws FileNotFoundException{//成功返回true，失败返回false
		
		File file = new File(filePath);
		 //写入信息到文件

        PrintWriter out = new PrintWriter(file);
        
        
		
		return false;
	}
	
}
