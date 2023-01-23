package org.mql.java.enums;

public enum Modificateurs {
	PUBLIC(1, "+"),
	PUBLIC_STATIC(9, "+ {static}"),
	PUBLIC_ABSTRACT(1025, "+ {abstract}"),
	PUBLIC_FINAL_STATIC(25, ""),
	
	PACKAGE(0, "~"),
	PACKAGE_STATIC(8, "~ {static}"),
	PACKAGE_ABSTRACT(1024, "~ {abstract}"),
	PACKAGE_FINAL_STATIC(24, ""),
	
	PRIVATE(2, "-"),
	PRIVATE_STATIC(10, "- {static}"),
	PRIVATE_FINAL_STATIC(26, ""),
	
	PROTECTED(4, "#"),
	PROTECTED_STATIC(12, "{static}"),
	PROTECTED_ABSTRACT(1028, "# {abstract}"),
	PROTECTED_FINAL_STATIC(28, ""),
	

	;
	
	public String type;
	
	public int modif;
	
	
	private Modificateurs(int modif, String type) {
		this.modif = modif;
		this.type = type;
	}
	
	
	public static String valueOf(int modif){
		for(Modificateurs element : Modificateurs.values()){
			if(element.modif == modif){
				return element.type;
			}
		}
		return "";
	}
}
