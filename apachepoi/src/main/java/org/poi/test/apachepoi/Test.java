/**  
 * @Title:  Test.java   
 * @Package org.poi.test.apachepoi   
 * @Description:    TODO  
 * @author: liar     
 * @date:   2019年5月3日 上午10:10:51   
 */  
package org.poi.test.apachepoi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.poi.test.apachepoi.Email;

import utils.ExcelUtil;



public class Test {

	/**     
	 * @Description: TODO 
	 * @param: @param args      
	 * @return: void      
	 * @throws   
	 * @author: liar 
	 * @date:   2019年5月3日 上午10:10:51
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ExcelUtil myExcelUtil = new ExcelUtil();
		String filePath = "D:/研一下/申请公众号/邀请函扫描版/邀请函-邮件信息整理/邀请函-邮件信息.xlsx";
		//百度了一下需要写绝对路径？？--->也不行
		//又看到一个说法，文件需要放在项目目录厦门
		
		
		List<List<String>> showList;
		
//		showList = ExcelUtil.readXlsx(filePath);
//		
//		for (List<String> list : showList) {
//			for (String string : list) {
//				System.out.print(string + "    ");				
//			}
//			System.out.println();
//		}
		
		
		ArrayList<Email> emailList = new ArrayList<Email>();
		
		showList = ExcelUtil.readXlsx(filePath);
		
		for (List<String> list : showList) {
				Email email = new Email();
			
//				email.setUserId(Integer.parseInt(list.get(0).substring(0, list.get(0).indexOf("."))));//第0位为userid
				email.setID(Integer.parseInt(list.get(0)));
				//ID是一定有的数据段
				
				email.setName(list.get(1));
				//名字基本上也没有空的
				
				if (null != list.get(2)) {//类型有认识空的
					email.setType(list.get(2));
				} else {
					email.setType("null");
				}
				
				
				if (null != list.get(3)) {//邮箱有认识空的
					email.setEmailAddr(list.get(3));
				} else {
					email.setEmailAddr("null");
				}
				
				

				
				emailList.add(email);
					
			
		}
		
//		for (Email email : emailList) {
//			System.out.println(email);
//		}
		
//		for (int i = 0; i < 100; i++) {
//			System.out.println(emailList.get(i));
//		}
		
		ArrayList<Integer> tempIDList = new ArrayList<Integer>();
		ArrayList<String> tempStringList = new ArrayList<String>();
		
		//循环3次，第一次找到没Type或者没EmailAddr的特殊用户
		//第2次找CCF+NC的，
		//第3次找单CCF的，
		//第4次找单NC的
		
		
		for (int i = 0; i < emailList.size(); i++) {
//			if(("" == emailList.get(i).getType()) || (("" == emailList.get(i).getEmailAddr()))){
			if(emailList.get(i).getType().equals("CCF+NC") && ("" != emailList.get(i).getEmailAddr())){	
				//偷个懒根据不同的判定条件多写几次
				tempIDList.add(emailList.get(i).getID());
				tempStringList.add(emailList.get(i).getEmailAddr());
//				tempStringList.add(emailList.get(i).getName());
			}
//			System.out.println(emailList.get(i));
		}
		
		for (String string : tempStringList) {
			System.out.print(string + ";");
		}
		
		System.out.println();
		
		for (Integer Id : tempIDList) {
			System.out.print(Id + ";");
		}
		
		
		
		
		
	}

}
