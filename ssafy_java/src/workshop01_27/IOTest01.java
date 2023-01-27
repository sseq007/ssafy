package workshop01_27;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IOTest01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
//		FileInputStream fls = new FileInputStream("test.txt");
		FileOutputStream fos = new FileOutputStream("test.txt");
		
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		//osw.write("hello");
		//fos.write("hello".getBytes());
		
		BufferedWriter bw =new BufferedWriter(osw);
		bw.write("hello");
		
		BufferedWriter bw2= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test")));
		
		bw2.write(" ");
		bw2.close();
		
		FileOutputStream fos2 = new  FileOutputStream("test2.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		DataOutputStream dos=new DataOutputStream(bos);
		dos.writeInt(7);
		dos.writeFloat(4.1f);
		
		
		
		DataInputStream dis = new DataInputStream(new FileInputStream("test2.txt"));
		int res = dis.readInt();
		float res2 = dis.readFloat();
		System.out.println(res);
		System.out.println(res2);
	}
}
