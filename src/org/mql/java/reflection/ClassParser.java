package org.mql.java.reflection;

import java.lang.annotation.Annotation;
import java.lang.module.ModuleDescriptor.Modifier;
import java.lang.module.ModuleDescriptor.Modifier.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

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
		
		getProjectName();
		System.out.println("Nous somme dans le package");
		getpackage();
		getClassName();
		getDaughtersClasses();
		getConstructeurs();
		getMethods();
		getInterfaces();
		getAnnotations();
		
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
    
    public void getClassName() {
    
    	System.out.println("la classe : "+ classe.getName());
    }
  //l'obtention de la classe mére d'une classe
    public Class<?> getClassesParentes() {
    	return classe.getSuperclass();
    }
    
    
    public void getFields() {
    	 fieldCount = 0;
      	Field[] field = classe.getFields();
      	System.out.println("Les attributs de cette classe:");
      	for (Field f : field) {
      		 
              System.out.print(f.getName() + " ");
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
     	Method[] method = classe.getMethods();
     	System.out.println("Les méthodes de cette classe:");
     	for (Method met : method) {
     		 
             System.out.print(met.getName() + " ");
             System.out.println(" ");
             methodCount++;
     }
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
    	Constructor[] constructors = classe.getConstructors();
    	System.out.println("Les constructeurs de cette classe:");
    	for (Constructor con : constructors) {
    		 
            System.out.print(con.getName() + " ");
            System.out.println(" ");
            consCount++;
    }
 
    	System.out.println("il existe " + consCount + " Constructeurs");
        
    	
    	
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
