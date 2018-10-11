import java.util.Calendar;
import java.util.GregorianCalendar;

public class Act3 {

	public static void main(String[] args) {
		
		//String = "dia/mes/any"
		System.out.println(zeller("2999999999999999999994/2/10000000"));
	}

	private static int zeller(String data) {
		
		int res=-1;
		
		int er;
    	
		int eri=0;
		int erl=0;
		
		String s="";
		String s2="";
		String s3="";
		
		Exception lo = null;
		
		GregorianCalendar calendar = new GregorianCalendar();
		
    	try {
		
			int[] dia_setmana = {5, 6, 0, 1, 2, 3, 4};

	      
	        String[] separa = data.split("/");
	        
	        s=separa[0];
	        s2=separa[1];
	        s3=separa[2];
	        
	        for(int i=0; i<3; i++) {
	  
	        	eri=i;
	        		
	        	if(separa[i].length()>9) {
	        		erl=1;
	        		
	        		for(int j=0; j<separa[i].length(); j++) {
	        			
	        			char c = separa[i].charAt(j);
	        			
	        			if(c!='1'&&c!='2'&&c!='0'&&c!='3'&&c!='4'&&c!='5'&&c!='6'&&c!='7'&&c!='8'&&c!='9') {
	        				erl=0;
	        			}
	        			
	        		}
	        		
	        		throw lo;
	        	}
	        	
	        		er = Integer.parseInt(separa[i]);
	        		
	        	
	        	
	        }
	        
	        int dia = Integer.parseInt(separa[0]);
	        int mes = Integer.parseInt(separa[1]);
	        int any = Integer.parseInt(separa[2]);

	        
	        
	        if (dia>0&&dia<32) {
	        	
				if (mes>0&&mes<13) {
					
					if (any>-1) {
						
						if(mes==2&&dia<29&&!calendar.isLeapYear(any)||mes==2&&dia<30&&calendar.isLeapYear(any)||mes==4&&dia<31||mes==6&&dia<31||mes==9&&dia<31||mes==11&&dia<31) {
							
							if (mes < 3) {
								mes += 12;
								any -= 1;
							}
							int k = any % 100;
							int j = any / 100;
							int day = ((dia + (((mes + 1) * 26) / 10) + k + (k / 4) + (j / 4)) + (5 * j)) % 7;
							
							res=dia_setmana[day];
							
						}else {
							System.out.println("Valor per dia= "+dia+" en el mes= "+mes+" i any= "+any+" no està permès");
						}
						
					}else {
						System.out.println("Valor per dia= "+dia+" en el mes= "+mes+" i any= "+any+" no està permès");
					}
					
				}else {
					System.out.println("Valor per dia= "+dia+" en el mes= "+mes+" i any= "+any+" no està permès");
				}
				
			}else {
				System.out.println("Valor per dia= "+dia+" en el mes= "+mes+" i any= "+any+" no està permès");
				
			}
	        
    	}catch(Exception e){
    		
    		String error="";
    		
    		switch(eri) {
    		case 0:
    			error="dia";
    			break;
    		case 1:
    			error="mes";
    			break;
    		case 2:
    			error="any";
    			break;
    		}
    		
    		if(erl==1) {
    			
    			System.out.println("Valor per dia= "+s+" en el mes= "+s2+" i any= "+s3+" no està permès");
    			
    		}else {
	    		
	    		System.out.println("Valor de "+error+" no es numèric");
	    		
    		}
    		
    	}
	        
	        return res;
	        
	}


}
