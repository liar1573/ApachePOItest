/**  
 * @Title:  ExcelUtil.java   
 * @Package utils   
 * @Description:    TODO  
 * @author: liar     
 * @date:   2019年5月3日 上午10:12:21   
 */  
package utils;

/**
 * @author liar
 *
 */
import java.io.*;
import java.util.*;


import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.*;


public class ExcelUtil {
	//有点纠结Util类里面的方法权限是什么？示例程序用的是private，小杰的Util都是Public static方法
	
	 /**
     * 
    * @Title: readXls 
    * @Description: 处理xls文件
    * @param @param path
    * @param @return
    * @param @throws Exception    设定文件 
    * @return List<List<String>>    返回类型 
    * @throws
    * 
    * 从代码不难发现其处理逻辑：
    * 1.先用InputStream获取excel文件的io流
    * 2.然后创建一个内存中的excel文件HSSFWorkbook类型对象，这个对象表示了整个excel文件。
    * 3.对这个excel文件的每页做循环处理
    * 4.对每页中每行做循环处理
    * 5.对每行中的每个单元格做处理，获取这个单元格的值
    * 6.把这行的结果添加到一个List数组中
    * 7.把每行的结果添加到最后的总结果中
    * 8.解析完以后就获取了一个List<List<String>>类型的对象了
    * 
     */
    public List<List<String>> readXls(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        // HSSFWorkbook 标识整个excel
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<List<String>> result = new ArrayList<List<String>>();
        int size = hssfWorkbook.getNumberOfSheets();
        // 循环每一页，并处理当前循环页
        for (int numSheet = 0; numSheet < size; numSheet++) {
            // HSSFSheet 标识某一页
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 处理当前页，循环读取每一行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                // HSSFRow表示行
            	//这里下标为什么是1开始的？0下标行是什么？？
            	//感觉下标0行八成对应着表格第一行的标题行，往往不是数据，所以就没有读取
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                int minColIx = hssfRow.getFirstCellNum();
                int maxColIx = hssfRow.getLastCellNum();
                List<String> rowList = new ArrayList<String>();
                // 遍历改行，获取处理每个cell元素
                for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                    // HSSFCell 表示单元格
                    HSSFCell cell = hssfRow.getCell(colIx);
                    if (cell == null) {
                        continue;
                    }
                    rowList.add(getStringVal(cell));
                }
                result.add(rowList);
            }
        }
        hssfWorkbook.close();
        return result;
    }
	
    
    /**
     * 
    * @Title: readXlsx 
    * @Description: 处理Xlsx文件
    * @param @param path
    * @param @return
    * @param @throws Exception    设定文件 
    * @return List<List<String>>    返回类型 
    * @throws
     */
    public static List<List<String>> readXlsx(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<List<String>> result = new ArrayList<List<String>>();
        int size = xssfWorkbook.getNumberOfSheets();
        // 循环每一页，并处理当前循环页
        for (int numSheet = 0;numSheet < size; numSheet++) {
        	XSSFSheet xssfSheet =  xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 处理当前页，循环读取每一行
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                int minColIx = xssfRow.getFirstCellNum();
                int maxColIx = xssfRow.getLastCellNum();
                List<String> rowList = new ArrayList<String>();
                for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                    XSSFCell cell = xssfRow.getCell(colIx);
                    if (cell == null) {
                        continue;
                    }
                    rowList.add(getStringVal(cell));
                }
                result.add(rowList);
            }
        }
        xssfWorkbook.close();
        return result;
    }
    
    /**
     * 改造poi默认的toString（）方法如下
    * @Title: getStringVal 
    * @Description: 1.对于不熟悉的类型，或者为空则返回""控制串
    *               2.如果是数字，则修改单元格类型为String，然后返回String，这样就保证数字不被格式化了
    *               3.19/5/3修改了字符串类型，增添了Date类型的对应获取
    * @param @param cell
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String getStringVal(HSSFCell cell) {
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_BOOLEAN:
            return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        case Cell.CELL_TYPE_FORMULA:
            return cell.getCellFormula();
//        case Cell.CELL_TYPE_NUMERIC:  原有的数字类型的操作
//            cell.setCellType(Cell.CELL_TYPE_STRING);
//            return cell.getStringCellValue();
        case Cell.CELL_TYPE_NUMERIC://现在按照网上的例子，把日期类型看成数字类型的子类操作试试
        	if (DateUtil.isCellDateFormatted(cell)) {
        		return cell.getDateCellValue().toString();
        	}else{
	            cell.setCellType(Cell.CELL_TYPE_STRING);
	            return cell.getStringCellValue();
        	}
        case Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();
        default:
            return "";
        }
    }
    
    /**
     * 
     * @Description: 之前只有参数为HSSFCell类型的不知道会不会不太好，加了个overload的XSSFCell类型 
     * @param: @param cell
     * @param: @return      
     * @return: String      
     * @throws   
     * @author: liar 
     * @date:   2019年5月3日 上午11:10:02
     */
    public static String getStringVal(XSSFCell cell){
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_BOOLEAN:
            return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        case Cell.CELL_TYPE_FORMULA:
            return cell.getCellFormula();
//        case Cell.CELL_TYPE_NUMERIC:  原有的数字类型的操作
//            cell.setCellType(Cell.CELL_TYPE_STRING);
//            return cell.getStringCellValue();
        case Cell.CELL_TYPE_NUMERIC://现在按照网上的例子，把日期类型看成数字类型的子类操作试试
        	if (DateUtil.isCellDateFormatted(cell)) {
        		return cell.getDateCellValue().toString();
        	}else{
	            cell.setCellType(Cell.CELL_TYPE_STRING);
	            return cell.getStringCellValue();
        	}
        case Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();
        default:
            return "";
        }
    }

	
}
