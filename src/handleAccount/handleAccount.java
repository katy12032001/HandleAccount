package handleAccount;

import java.io.*;
import jxl.*;

public class handleAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try{
			
            
            Workbook workbook = Workbook.getWorkbook(new File("test.xls"));
            
            Sheet sheet = workbook.getSheet(0);
            int i = 0;
            Cell c00 = null;
            int r = 0;
            System.out.println("There are "+ sheet.getRows()+" accounts to be resumed");
            for(r = 1; r < sheet.getRows(); r++){
            	 System.out.println(r);
                c00 = sheet.getCell(0, r);
                String strc00 = c00.getContents();
                
                //String s = "cmd net user "+ strc00 +"/time:all /domain";
                String s = "net user "+ strc00 +" /time:all /domain";
	            Process p = Runtime.getRuntime().exec(s);
	            System.out.println(s);
	            //p.waitFor();
	            BufferedReader reader=new BufferedReader(
	            	new InputStreamReader(p.getInputStream())
	            );
	            String line;
	            while((line = reader.readLine()) != null){
	               System.out.println(line);
	            }
                
            }

        }
        catch(IOException e1) {
        	e1.printStackTrace();
        }
        catch(Exception e3){
        	e3.printStackTrace();
        }

        System.out.println("Done");
    }
           

}
