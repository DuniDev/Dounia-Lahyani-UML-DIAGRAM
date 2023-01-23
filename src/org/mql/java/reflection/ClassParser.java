package org.mql.java.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class ClassParser {
    
	private String className;
    private Class<?> classe;
    private int consCount;
    private int methodCount;
	private int interfacesCount;
	private int fieldCount;
    
    
   

	
	public ClassParser(String className) {
		this.className = className;
		try {
			classe= Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------------");
		getClassName();
		System.out.println("--------------------------------------");
		getFields();
		System.out.println("--------------------------------------");
		getConstructeurs();
		getMethods();
		System.out.println("--------------------------------------");
		
		
	}
    
	
    public ClassParser(Class<?> classe) {
		this.classe = classe;
		
		
	}
    public void getProjectName() {
    	String classPath = System.getProperty("java.class.path"); 
		System.out.println("Projet : " + classPath);
    }
    public void getpackage() {
    System.out.println(classe.getPackageName());
    }
    
    public String getClassName() {
    	  System.out.println(this.classe.getSimpleName());
          return this.classe.getSimpleName();
    	
    }
    
    
  //l'obtention de la classe mére d'une classe
    public Class<?> getClassesParentes() {
    	return classe.getSuperclass();
    }
    
    
    public void getFields() {
    	 fieldCount = 0;
      	Field[] field = classe.getDeclaredFields();
      	
      	for (Field f : field) {
            int m = f.getModifiers();
     		
     		String s = Modifier.toString(m);
		        
     		  if (!s.contains("public")) {
					s="-";
		        } else if (s.contains("public")) {
						s="+";
					}
					
              System.out.print(s+" "+f.getName() +":"+f.getType().getSimpleName());
              System.out.println(" ");
            
             fieldCount++;
             }
	}
    
   
    
    public int getFieldCount() {
		return fieldCount;
	}

	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
	}
	
    
    //l'obtention des methodes d'une classe
    private void getMethods() {
    	 methodCount = 0;
     	Method[] method = classe.getDeclaredMethods();
     	
     	
     	for (Method met : method) {
     	
     		int m = met.getModifiers();
     		
     		String s = Modifier.toString(m);
		        
     		  if (!s.contains("public")) {
					s="-";
		        } else if (s.contains("public")) {
						s="+";
					}
     		 
	             System.out.print(s+" "+met.getName() + "():"+met.getReturnType().getSimpleName());
	             System.out.println(" ");
                 }
	             methodCount++;
		        }
     	
     		
     
    
    
    public int getMethodCount() {
		return methodCount;
	}

	public void setMethodCount(int methodCount) {
		this.methodCount = methodCount;
	}
    
    
    //l'obtention des classe filles d'une classe
    public Class<?>[] getDaughtersClasses(){	
		return classe.getDeclaredClasses();
	}
    
    
    //l'obtention des interfaces d'une classe
    public void getInterfaces() { 
    	 interfacesCount = 0;
    	 Class<?>[] classeInterfaces = classe.getInterfaces();
      	System.out.println("Les Interfaces de cette classe:");
      	for (Class<?> i : classeInterfaces) {
      		  
              System.out.print(i.getName() + " ");
              System.out.println(" ");
              interfacesCount++;
              }
      	System.out.println("Il existe "+interfacesCount + " interfaces");
    }
      	public int getInterfacesCount() {
    		return interfacesCount;
    	}

    	public void setInterfacesCount(int interfacesCount) {
    		this.interfacesCount = interfacesCount;
    	}

   public void getAnnotations() {
	   int AnnotationsCount=0;
	   Annotation[] annotation = classe.getAnnotations();
   	System.out.println("Les annotations de cette classe:");
   	for (Annotation ann : annotation) {
   		 
           System.out.print(ann);
           System.out.println(" ");
           AnnotationsCount++;
   }
   	if (AnnotationsCount>1) {
   	System.out.println("il existe " + AnnotationsCount + " annotations");
   	}else {
   		System.out.println("il existe une seule annotation");
   	}
   	
   }
   //l'obtention des constructeurs d'une classe
    public void getConstructeurs() { 
        consCount = 0;
    	Constructor[] constructors = classe.getDeclaredConstructors();
    	
    	for (Constructor con : constructors) {
            System.out.print("+ "+con.getName()+ "()");
            System.out.println(" ");
            consCount++;
    	}
    	
      }
    
    
    public int getConsCount() {
		return consCount;
	}

	public void setConsCount(int consCount) {
		this.consCount = consCount;
	}

	public static void main(String[] args) {
    	new ClassParser("org.mql.java.models.Person");
	}

}
