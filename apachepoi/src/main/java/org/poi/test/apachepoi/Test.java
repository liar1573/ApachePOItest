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

import org.poi.test.apachepoi.TechnologyRequire;

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
		String filePath = "E:/网站项目相关/批量插入功能实现/技术需求批量导入模板.xlsx";
		
		List<List<String>> showList;
		
		showList = ExcelUtil.readXlsx(filePath);
		
		for (List<String> list : showList) {
			for (String string : list) {
				System.out.print(string + "    ");				
			}
			System.out.println();
		}
		
//		ArrayList<TechnologyRequire> technologyRequiresList = new ArrayList<TechnologyRequire>();
//		
//		showList = ExcelUtil.readXlsx(filePath);
//		
//		for (List<String> list : showList) {
//				TechnologyRequire techRequrire = new TechnologyRequire();
//			
//				techRequrire.setUserId(Integer.parseInt(list.get(0).substring(0, list.get(0).indexOf("."))));//第0位为userid
//				techRequrire.setRequireName(list.get(1));
//				techRequrire.setInvestPrice(Double.parseDouble(list.get(2)));
//				techRequrire.setIndustrySituation(list.get(3));
//				techRequrire.setArea(list.get(4));
//				techRequrire.setDeadline(new Date(list.get(5)));
//				techRequrire.setKeyword(list.get(6));
//				techRequrire.setContent(list.get(7));
//				techRequrire.setGmtCreate(new Date());
//				techRequrire.setGmtModified(new Date());
//				techRequrire.setRequireState("waiting");
//				
//				technologyRequiresList.add(techRequrire);
//					
//			
//		}
		
//		for (TechnologyRequire technologyRequire : technologyRequiresList) {
//			System.out.println(technologyRequire);
//		}
		
		
		
	}

}
