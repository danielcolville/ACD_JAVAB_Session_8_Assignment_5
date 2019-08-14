package session8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintToFileThread extends Thread{
	String msg;
	volatile File f=new File("messagelogs.txt");
	public PrintToFileThread(String msg) {
		this.msg=msg;
	}
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(f,true));
			System.out.println("Printing message to log file:\n"+msg);
			br.write(msg);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
