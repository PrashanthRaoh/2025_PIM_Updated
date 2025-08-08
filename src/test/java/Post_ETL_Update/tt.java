package Post_ETL_Update;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import common_functions.NotepadManager;

public class tt {

	public static void main(String[] args) throws IOException {

		String PRE_ETL_Filename = "/Pre_ETL_Artifacts/AutoApproveattributes.txt";
		
		List<String> attributelist = Arrays.asList("X Plant Material Status Description (Global)",
	            "X Plant Material Status Code (Global)","Weight - Product Only (lbs)","Weight - Product Only (kg)","X Plant Material Status Description (Global)",
	            "X Plant Material Status Code (Global)","Weight - Product Only (lbs)", "Weight - Product Only (kg)","UPC Number","Sellable Material ID",
	            "Market Part Number", "ECCN","Book Description (ZB11)","Application Type Description");
		
		for (int i = 0; i < attributelist.size(); i++) {
//			System.out.println(attributelist.get(i) + ": - " + NotepadManager.getValuesByKey(PRE_ETL_Filename, attributelist.get(i)));
			String fieldLabel =attributelist.get(i);
			 List<String> preETL_fieldvalue = NotepadManager.getValuesByKey(PRE_ETL_Filename, fieldLabel);
			
			System.out.println(fieldLabel +" = " + preETL_fieldvalue.get(0));
		}

//		System.out.println("--------------- ");
//		List<String> searchFields = Arrays.asList("Selling UOM Description", "Selling UOM Code",
//				"Proprietary Indicator", "Munitions Indicator");
//		for (int i = 0; i < searchFields.size(); i++) {
//			System.out.println(attributelist.get(i) + ": - " + NotepadManager.getValuesByKey(PRE_ETL_Filename, searchFields.get(i)));
//		}
	}

}
