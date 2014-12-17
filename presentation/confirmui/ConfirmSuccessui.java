package confirmui;
import javax.swing.*;

/*
 * 操作成功提示界面
 */
public class ConfirmSuccessui implements Runnable{
	
	JFrame frame;
	JLabel label;
	
	public ConfirmSuccessui(){
		
	}
	
	public ConfirmSuccessui(String result){
		frame=new JFrame();
		frame.setSize(400,200);
		frame.setLocation(550,250);
		
		label=new JLabel(result);
		
		frame.setLayout(null);
		
		label.setBounds(100,70,200,25);
		
		frame.getContentPane().add(label);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(5000);
			frame.dispose();
		}catch(InterruptedException e){
			
		}
	}

}
