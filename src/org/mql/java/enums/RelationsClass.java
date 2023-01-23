package org.mql.java.enums;

public enum RelationsClass {
	
			DEPENDENCY("..>"),

			ASSOCIATION("--"),

			AGGREGATION("--o"),

			COMPOSITION("--*"),

			GENERALIZATION("--|>"),

			REALIZATION("..|>"); 

			private String TypeR;

			private RelationsClass(String TypeR) {
				this.TypeR = TypeR;
			}

			
			public String getRelationType(){
				return this.TypeR;
			}
}
