package confirmui;
import javax.swing.*;

/*
 * �����ɹ���ʾ����
 */
public class Confirmui implements Runnable{
	
	JFrame frame=new JFrame();
	JLabel label=new JLabel();
	
	public Confirmui(){
		
	}
	
	public Confirmui(String result){
		frame.setSize(400,200);
		frame.setLocation(550,250);
		
		label.setText(result);
		
		frame.setLayout(null);
		
		label.setBounds(100,70,200,25);
		
		frame.getContentPane().add(label);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(10000);
			frame.dispose();
		}catch(InterruptedException e){
			
		}
	}

}
