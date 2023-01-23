package org.mql.java.reflection;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ProjectExplorer {
public String ProjectName;
public Vector<String> packages;
	public ProjectExplorer()  {
		
		System.out.println("Current project path");
		getProjectPath("p03-Annotation and reflection");
		System.out.println("\n"+"Current project packages");
		Set<String> files=new HashSet<>();
		listOfPackage("src/",files);
		 System.out.println(files+"\n");
		 
		 System.out.println("Current project imports");
		 getProjectImports("p03-Annotation and reflection");
	
		 	
	}
	public List<String> getProjectPath(String ProjectName) {
		File maindir = new File(System.getProperty("user.dir"));
		packages = new Vector<String>();
		if (maindir.exists() && maindir.isDirectory()) {
		File files[] = maindir.listFiles();
		for (File file : files) {
		packages.add(file.getName()
                .toString());
		}
		}
		System.out.println(packages);
		return packages;
	}
	public static void listOfPackage(String directoryName, Set<String> pack) {
        File directory = new File(directoryName);

       
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                String path=file.getPath();
                String packName=path.substring(path.indexOf("src")+4, path.lastIndexOf('\\'));
                pack.add(packName.replace('\\', '.'));
            } else if (file.isDirectory()) {

                listOfPackage(file.getAbsolutePath(), pack);
            }
        }
        
    }
	
	public List<String> getProjectImports(String ProjectName) {
	List<String> result = new LinkedList<String>();

	Package[] packages = Package.getPackages();
   
	for(Package pack : packages)
	{
		
	    result.add(pack.getName());
	   
	}
	 
	for (int i=0 ; i<= result.size()-2;i++) {
		System.out.println(i+1 +":" +result.get(i));
	}
	
	return result;
	}
	
	public static void main(String[] args) {
		

		new ProjectExplorer();
	}

}
