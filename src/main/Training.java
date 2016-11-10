package main;

import java.io.*;
import java.util.*;

public class Training {
       
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*String filename = "somefile.txt";
		FileReader reader = new FileReader(filename);
		BufferedReader bufreader = new BufferedReader(reader);
		List<String> linesList = new ArrayList<String>();
		
		String inputLine;
		
		while((inputLine = bufreader.readLine()) != null){
			linesList.add(inputLine);
		}
		reader.close();
		*/
		String text = "Kepler measurements of starlight infer the spin rate of a star by picking up small changes in its brightness. These changes result from starspots which, like the more-familiar sunspots on our sun, form when magnetic field concentrations prevent the normal release of energy at a star’s surface. The affected regions become cooler than their surroundings and appear dark in comparison.";
		String[] lines = text.split("\\.");
		System.out.println("\nSplitted sentences of text: ");
		for(String s : lines){
			System.out.println(s);
		}
		
		Arrays.sort(lines, new Comparator<String>(){
			@Override
		    public int compare(String o1, String o2) {
		        return new Integer(o1.length()).compareTo(o2.length());
		   }
		});
		
		System.out.println("\nSorted sentences of text: ");
		for(String s : lines){
			System.out.println(s);
		}
		
	 	int [] dotsIndexes = new int[3];
		int [] linesLens = new int[3];
		for(int i = 0; i < text.length(); i++){
			if(text.contains(".")){
				for(int j = 0; j < dotsIndexes.length; j++){
					if(j == 0){
						dotsIndexes[j] = text.indexOf('.',j);
					}else{
						dotsIndexes[j] = text.indexOf('.',dotsIndexes[j-1]+1);
					}
				}
			}
		}
		//lengths of sentences
		linesLens[0] = dotsIndexes[0];
		linesLens[1] = dotsIndexes[1] - dotsIndexes[0];
		linesLens[2] = dotsIndexes[2] - dotsIndexes[1];
		System.out.println("Lengths of sentences: ");
		for(int n1 : linesLens){
			System.out.println(n1);
		}
		
		
		
		/*
		FileWriter writer = new FileWriter(filename);
		PrintWriter print = new PrintWriter(writer);
		for(String outputLine : linesList){
			print.println(outputLine);
		}
		print.flush();
		print.close();
		
		try{
			byte[] buffer = new byte[1000];
			FileInputStream inputStream = new FileInputStream(filename);
			int nRead = 0;
			while((nRead = inputStream.read(buffer)) != -1){
				System.out.println(new String(buffer));
			}
			inputStream.close();
		}catch(FileNotFoundException ex){
			System.out.println("Unable to open file '" + filename + "'");
		}
		catch(IOException ex){
			System.out.println("Error reading file '" + filename + "'");
		}
		
		String delimiters = ".?!";
		
		for(int i = 0; i < )
	}*/
	
	}
}


