package loginui;
import javax.swing.*;
import java.awt.event.*;
import mainui.Mainui;

/*
 * ��½����
 */
public class Loginui {
	
	JFrame frame;
	JPanel panel;
	JComboBox<String> box;//��½���
	
	Registerui register=new Registerui();
	FindPasswordui find=new FindPasswordui();
	Mainui mainui=new Mainui();
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("��ӭ��½������ϵͳ");
		
		JLabel labelWork=new JLabel("ְ��",JLabel.RIGHT);
		box=new JComboBox<String>();
		box.setEditable(true);
		box.addItem("������Ա");
		box.addItem("������Ա");
		box.addItem("������Ա");
		box.addItem("������Ա");
		box.addItem("�ܾ���");
		JLabel labelName=new JLabel("�û���",JLabel.RIGHT);
		JLabel labelPassword=new JLabel("����",JLabel.RIGHT);
		JTextField fieldName=new JTextField();
		JTextField fieldPassword=new JTextField();
		JButton buttonSure=new JButton("��½");
		buttonSure.addActionListener(new loginListener());
		JButton buttonRegister=new JButton("ע��");
		buttonRegister.addActionListener(new registerListener());
		JButton buttonFind=new JButton("��������");
		buttonFind.addActionListener(new findListener());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		panel.setLayout(null);
		
		labelWork.setBounds(350,250,50,25);
		box.setBounds(410,250,150,25);
		labelName.setBounds(350,300,50,25);
		fieldName.setBounds(410,300,150,25);
		labelPassword.setBounds(350,350,50,25);
		fieldPassword.setBounds(410,350,150,25);
		buttonSure.setBounds(450,400,65,25);
		buttonRegister.setBounds(600,300,90,25);
		buttonFind.setBounds(600,350,90,25);
		
		panel.add(labelWork);
		panel.add(box);
		panel.add(labelName);
		panel.add(labelPassword);
		panel.add(fieldPassword);
		panel.add(fieldName);
		panel.add(buttonFind);
		panel.add(buttonRegister);
		panel.add(buttonSure);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class loginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String work=(String) box.getSelectedItem();
			mainui.Jump(work);
			frame.dispose();
		}
	}
	
	class registerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			register.go();
		}
	}
	
	class findListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			find.go();
		}
	}
	
	public static void main(String args[]){
		Loginui l=new Loginui();
		l.go();
	}
}
