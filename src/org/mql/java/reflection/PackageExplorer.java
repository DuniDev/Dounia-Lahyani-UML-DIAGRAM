package org.mql.java.reflection;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.Vector;

public class PackageExplorer {

	public PackageExplorer() {
		getClassList("org.mql.java.reflection");
		
	}
	
	public String []getClassList(String packageName) {
		String classPath = System.getProperty("java.class.path"); 
		System.out.println("Current Project : " + classPath);
		System.out.println("");
		
		String packagepath  = packageName.replace(".", "/");
		System.out.println("Current package : "+packagepath);
		
		File dir = new File(classPath + "/" + packagepath);
		File f[] = dir.listFiles();
		Vector<String> v = new Vector<String>();
		for(int i = 0; i < f.length; i++) {
			if(f[i].isFile() && f[i].getName().endsWith(".class")) {
				 
			        int m = f.getClass().getModifiers();
			        String s = Modifier.toString(m);
			        
				String name = f[i].getName().replace(".class", "");
				if (s.contains("public")) {
					s="+";
					 if(s.contains("public")) {
						s="-";
					}
						
					
				}
				v.add( s +" "+name);
			}
		}
		String t[] = new String[v.size()];
		v.toArray(t);
		System.out.println("");
		System.out.println("Les classes du package : ");
		for (int i=0 ; i<= v.size()-1;i++) {
			System.out.println(i+1 +":" +v.get(i));
		}
		return t;
	}
	
	
	
	public static void main(String[] args) {
		new PackageExplorer();
	}
	
}
