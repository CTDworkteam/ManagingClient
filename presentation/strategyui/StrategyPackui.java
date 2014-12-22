package strategyui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import vo.CombinationStrategyVO.CombinationItemVO;
import strategybl.StrategyController;
import confirmui.*;
import enumType.ResultMessage;

/*
 * �ƶ��ؼ۰�����
 */
public class StrategyPackui {
	
	public JPanel panel=new JPanel();
	
	JTextField fieldInitial;
	JTextField fieldLater;
	JTextField fieldCommodity;
	JTextField fieldModel;
	JTextField fieldNumber;
	
	ArrayList<CombinationItemVO> item=new ArrayList<CombinationItemVO>();
	
	public StrategyPackui(){
		JLabel labelInitial=new JLabel("ԭ��");
		fieldInitial=new JTextField();
		JLabel labelLater=new JLabel("�ּ�");
		fieldLater=new JTextField();
		JLabel labelCommodity=new JLabel("����",JLabel.RIGHT);
		fieldCommodity=new JTextField();
		JLabel labelModel=new JLabel("�ͺ�",JLabel.RIGHT);
		fieldModel=new JTextField();
		JLabel labelNumber=new JLabel("����",JLabel.RIGHT);
		fieldNumber=new JTextField();
		JButton buttonAdd=new JButton("����");//�����ؼ۰��е�һ����Ʒ
		JButton buttonConfirmItem=new JButton("ȷ��");//ȷ������ô��������е�һ���ؼ۰�
		
		panel.setLayout(null);
		labelInitial.setBounds(10,3,65,25);
		fieldInitial.setBounds(85,3,70,25);
		labelLater.setBounds(165,3,65,25);
		fieldLater.setBounds(240,3,70,25);
		labelCommodity.setBounds(3,38,80,25);
		fieldCommodity.setBounds(93,38,100,25);
		labelCommodity.setBounds(3,70,80,25);
		fieldCommodity.setBounds(93,70,100,25);
		labelNumber.setBounds(3,102,80,25);
		fieldNumber.setBounds(93,102,100,25);
		buttonAdd.setBounds(223,70,65,25);
		buttonConfirmItem.setBounds(223,165,65,25);
		
		panel.add(fieldInitial);
		panel.add(labelInitial);
		panel.add(labelLater);
		panel.add(fieldLater);
		panel.add(labelCommodity);
		panel.add(fieldCommodity);
		panel.add(labelModel);
		panel.add(fieldModel);
		panel.add(labelNumber);
		panel.add(fieldNumber);
		panel.add(buttonAdd);
		panel.add(buttonConfirmItem);
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(fieldCommodity.getText()!=null&&fieldModel.getText()!=null&&fieldNumber.getText()!=null){
				CombinationStrategyVO.CombinationItemVO vo=new CombinationStrategyVO().new CombinationItemVO();
				vo.setCommodity(fieldCommodity.getText());
				vo.setModel(fieldModel.getText());
				vo.setNumber(Integer.parseInt(fieldNumber.getText()));
				item.add(vo);
			}else{
				Runnable r=new Confirmui("��������д�ؼ۰�����Ʒ��Ϣ");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			StrategyController controller=new StrategyController();
			if(fieldInitial.getText()!=null&&fieldLater.getText()!=null&&item.get(0)!=null){
				CombinationStrategyVO vo=new CombinationStrategyVO();
				GregorianCalendar date=new GregorianCalendar();
				String id=controller.getNewCombinationStrategyID(date);
				vo.setId(id);
				vo.setInitialMoney(Double.parseDouble(fieldInitial.getText()));
				vo.setLaterMoney(Double.parseDouble(fieldLater.getText()));
				vo.setList(item);
				ResultMessage result=controller.setCombination(vo);
				if(result==ResultMessage.Failure){
					Runnable r=new Confirmui("δ�ܳɹ��ƶ��ؼ۰�����");
					Thread t=new Thread(r);
					t.start();
				}else{
					Runnable r=new Confirmui("�ؼ۰���ӳɹ�");
					Thread t=new Thread(r);
					t.start();
				}
			}else{
				Runnable r=new Confirmui("�������ؼ۰�������Ϣ");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
}
