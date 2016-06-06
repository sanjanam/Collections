
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class FileBucket {
	private HashMap<Integer,ArrayList<File>> bucket=new HashMap<Integer,ArrayList<File>>();
	ArrayList<File> input=new ArrayList<File>();
	ArrayList<File> input0=new ArrayList<File>();
	ArrayList<File> input1=new ArrayList<File>();
	ArrayList<File> input2=new ArrayList<File>();
	ArrayList<File> input3=new ArrayList<File>();
	ArrayList<File> input4=new ArrayList<File>();
	ArrayList<File> input5=new ArrayList<File>();
	ArrayList<File> input6=new ArrayList<File>();
	ArrayList<File> input7=new ArrayList<File>();
	ArrayList<File> input8=new ArrayList<File>();
	ArrayList<File> input9=new ArrayList<File>();
	int[] count=new int[10];

	FileBucket(File directory_name) throws  NotDirectoryException{
	String str=null;
	System.out.println("enter file name");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try {
		str = br.readLine();
	} catch (IOException e) {
		e.printStackTrace();
		}
	File inp_file = new File(str);	
	boolean isDirectory = inp_file.isDirectory();
	System.out.println("Checking if argument is directory");
	if (!isDirectory) {
		System.out.println("Not a directory !");
		System.exit(0);

	} else {
		System.out.println("Is a directory");
		for (final File fileEntry : inp_file.listFiles()) {
			if (!fileEntry.isDirectory()) {
				input.add(fileEntry);
			}
		}
		createBucket();
		populateBucket();
	}

	
}
private void createBucket(){
	bucket.put(1024,null);
    bucket.put(2048,null);
    bucket.put(3072,null);
    bucket.put(4096,null);
    bucket.put(5120,null);
    bucket.put(6144,null);
    bucket.put(7168,null);
    bucket.put(8192,null);
    bucket.put(9216,null);
	bucket.put(10240,null);
}
private void populateBucket() {
	int file_capacity;
	
	for (int i = 0; i < input.size(); i++) {
		file_capacity = (int) input.get(i).length();
		if (file_capacity < 1024) {
			input0.add(input.get(i));
			bucket.replace(1024, input0);
			++count[0];
		} else if (file_capacity > 1024 && file_capacity < 2048) {
			input1.add(input.get(i));
			bucket.replace(2048, input1);
			count[1]++;
		} else if (file_capacity > 2048 && file_capacity < 3072) {
			input2.add(input.get(i));
			bucket.replace(3072, input2);
			count[2]++;
		} else if (file_capacity > 3072 && file_capacity < 4096) {
			input3.add(input.get(i));
			bucket.replace(4096, input3);
			count[3]++;
		} else if (file_capacity > 4096 && file_capacity < 5120) {
			input4.add(input.get(i));
			bucket.replace(5120, input4);
			count[4]++;
		} else if (file_capacity > 5120 && file_capacity < 6144) {
			input5.add(input.get(i));
			bucket.replace(6144, input5);
			count[5]++;
		} else if (file_capacity > 6144 && file_capacity < 7168) {
			input6.add(input.get(i));
			bucket.replace(7168, input6);
			count[6]++;
		} else if (file_capacity > 7168 && file_capacity < 8192) {
			input7.add(input.get(i));
			bucket.replace(8192, input7);
			count[7]++;
		} else if (file_capacity > 8192 && file_capacity < 9216) {
			input8.add(input.get(i));
			bucket.replace(9216, input8);
			count[8]++;
		} else if (file_capacity > 10240) {
			input9.add(input.get(i));
			bucket.replace(10240, input9);
			++count[9];
		}

	}

	
}

public void displayBuckets(){
	Set<Integer> keys=bucket.keySet();
	int index=0;
	for(Integer ky:keys){
		if(count[index]!=0)
	System.out.println("Bucket of  " + ky + "  No Of Files  " + (count[index]));
	index++;
	}
	
}

public void displayBucket(int bucketValue){
	Scanner scan=new Scanner(System.in);	 
	System.out.println("enter bucket value");
	int b_value=scan.nextInt();
	scan.close();
	Set<Integer> keys=bucket.keySet();
	int index=0;
	for(Integer ky:keys){
		if(ky==b_value)
			System.out.println("bucket of   " +b_value+ " No of File  "+ (count[index])+"   contains   " + bucket.get(ky));
		index++;
		}
		 
	}

}

