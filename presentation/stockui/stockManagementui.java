package stockui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import stockbl.StockController;
import stockcheckbl.StockCheckController;
import vo.GiftBillVO;
import vo.OverflowBillVO;
import vo.StockCheckListVO;
import vo.UnderflowBillVO;
import vo.GiftBillVO.GiftBillItemVO;
import enumType.ResultMessage;

class stockManagementui extends JPanel{
	private JPanel stock=new JPanel();
	private JPanel bills=new JPanel();
	private JButton jbtCheck=new JButton("库存查看");
	private JButton jbtSnapshot=new JButton("库存快照");
	private JButton jbtPresent=new JButton("库存赠送");
	private JButton jbtOverflow=new JButton("库存报溢");
	private JButton jbtLoss=new JButton("库存报损");
	private JButton jbtWarming=new JButton("库存报警");
	
	//insFrame:
	JFrame checkFrame=new JFrame();
	JPanel totalPanel=new JPanel(new BorderLayout());
	String[] columnName={"序号","仓库名"};
	Object[][] rowData={{"0001","hehe"},{"0002","haha"}};
	DefaultTableModel tableModel=new DefaultTableModel(rowData,columnName);
	JTable checkTable=new JTable(tableModel);
	JScrollPane stockListPane=new JScrollPane(checkTable); 
	JLabel startTime=new JLabel("开始时间");
	JTextField startTimeField=new JTextField(20);
	JLabel endTime=new JLabel("结束时间");
	JTextField endTimeField=new JTextField(20);
	JPanel time1=new JPanel(new BorderLayout());
	JPanel time2=new JPanel(new BorderLayout());
	JPanel operation=new JPanel(new GridLayout(1,2));
	JButton jbtAssure=new JButton("确认");
	JButton jbtCancel=new JButton("取消");
	JPanel rightPanel=new JPanel();
	JLabel stockListTitle=new JLabel("仓库列表");
	JPanel time=new JPanel(new GridLayout(2,1));
	JPanel leftPanel=new JPanel(new BorderLayout());
	
	JFrame voFrame;
	
	//shotFrame:
	JFrame shotFrame=new JFrame();
	JButton jbtSelect=new JButton("确定");
	JButton jbtNotSelect=new JButton("取消");
	String[] columnName1={"序号","仓库名"};
	String[][] rowData1={{"0001","hehe"},{"0002","haha"}};
	DefaultTableModel tableModel1=new DefaultTableModel(rowData1,columnName1);
	JTable shotTable=new JTable(tableModel1);
	JScrollPane shotListPane=new JScrollPane(shotTable);
	JLabel shotListTitle=new JLabel("仓库列表");
	JPanel biao=new JPanel(new BorderLayout());
	JPanel butt=new JPanel();
	
	//oneStockInfoFrame:
	JFrame oneStockInfoFrame=new JFrame();
	JPanel systemPanel=new JPanel(new BorderLayout());
	JPanel topInfoPanel=new JPanel();
	JPanel middlePanel=new JPanel(new BorderLayout());
	JLabel info1=new JLabel("仓库名  迪");
	JLabel info2=new JLabel("盘点时间  刁");
	JButton jbtPath=new JButton("选择路径");
	JButton jbtPathCancel=new JButton("取消");
	String[] goodsColumn={"编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
	Object[][] goodsRowData={{"00001","淫迪","1号",1,4,4,4,4,4}};
	DefaultTableModel goodsTableModel=new DefaultTableModel(goodsRowData,goodsColumn);
	JTable goodsTable=new JTable(goodsTableModel);
	JScrollPane goodsListPane=new JScrollPane(goodsTable);
	JPanel butto=new JPanel();
	
	//presentFrame:
	JFrame presentFrame=new JFrame();
	JButton jbtPresentSelect=new JButton("确定");
	JButton jbtPresentNotSelect=new JButton("取消");
	String[] presentColumnName1={"序号","仓库名"};
	String[][] presentRowData1={{"0001","hehe"},{"0002","haha"}};
	DefaultTableModel presentTableModel=new DefaultTableModel(presentRowData1,presentColumnName1);
	JTable presentTable=new JTable(presentTableModel);
	JScrollPane presentListPane=new JScrollPane(presentTable);
	JLabel presentListTitle=new JLabel("仓库列表");
	JPanel presentBiao=new JPanel(new BorderLayout());
	JPanel presentButt=new JPanel();
	JSplitPane presentSplit;
	
	//present_subFrame:
	JFrame subPresentFrame=new JFrame();
	String[] presentColumn={"编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
	Object[][] presentRowData={{"00001","淫迪","1号",1,4,4,4,4,4}};
	DefaultTableModel presentListTableModel=new DefaultTableModel(presentRowData,presentColumn);
	JTable presentListTable=new JTable(presentListTableModel);
	JScrollPane presentJScrollPane=new JScrollPane(presentListTable);
	JButton jbtPresentSelected=new JButton("赠送");
	JButton jbtPresentNotSelected=new JButton("取消");
	JPanel rightPresentPanel=new JPanel(new BorderLayout());
	JPanel rightTopPresentPanel=new JPanel(new BorderLayout());
	JPanel rightBottomPresentPanel=new JPanel(new BorderLayout());
	JPanel rightTotalPanel=new JPanel(new BorderLayout());
	JPanel presentButtons=new JPanel();
	JPanel subPresentPanel=new JPanel(new FlowLayout());
	JLabel number=new JLabel("数量");
	JTextField numberField=new JTextField();
	JLabel tip=new JLabel("备注");
	JTextArea tipArea=new JTextArea(5,20);
	
	//overFlowFrame:
	JFrame overFlowFrame=new JFrame();
	String[] overColumn={"仓库名","编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
	Object[][] overRowData={{"1A231","00001","淫迪","1号",1,4,4,4,4,4}};
	DefaultTableModel overTableModel=new DefaultTableModel(overRowData,overColumn);
	JTable overTable=new JTable(overTableModel);
	JScrollPane overJScrollPane=new JScrollPane(overTable);
	JSplitPane overSplit;
	JLabel stockName=new JLabel("仓库名称");
	JLabel goodsName=new JLabel("商品名称");
	JLabel goodsID=new JLabel("商品编号");
	JTextField stockNameField=new JTextField();
	JTextField goodsNameField=new JTextField();
	JTextField goodsIDField=new JTextField();
	JButton overSearch=new JButton("搜索");
	JButton overAssure=new JButton("确定");
	JButton overCancel=new JButton("取消");
	JPanel inputOnePanel=new JPanel(new BorderLayout());
	JPanel inputTwoPanel=new JPanel(new BorderLayout());
	JPanel inputThreePanel=new JPanel(new BorderLayout());
	JPanel overButtons=new JPanel();
	JPanel overRightPanel=new JPanel(new GridLayout(3,1));
	JPanel overRight=new JPanel(new BorderLayout());
	
	//overListFrame:
	JFrame overListFrame=new JFrame();
	JLabel overListTitle=new JLabel("库存报溢单",SwingConstants.CENTER);
	JLabel overStockName=new JLabel("仓库名",SwingConstants.RIGHT);
	JLabel overGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
	JLabel overGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
	JLabel overGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
	JLabel overSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
	JLabel overActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
	JLabel overTip=new JLabel("备注",SwingConstants.RIGHT);
	JTextField overStockNameField=new JTextField();
	JTextField overGoodsIDField=new JTextField();
	JTextField overGoodsNameField=new JTextField();
	JTextField overGoodsTypeField=new JTextField();
	JTextField overSystemNumField=new JTextField();
	JTextField overActualNumField=new JTextField();
	JTextArea  overTipArea       =new JTextArea();
	JButton overOutput=new JButton("生成");
	JButton overNotOutput=new JButton("取消");
	JPanel overListPanel=new JPanel(new GridLayout(6,2) );
	JPanel overOutputPanel=new JPanel();
	JPanel overListPanelPlus=new JPanel(new BorderLayout());
	JPanel overTipPanel=new JPanel(new GridLayout(1,2));
	JPanel overTipPlusPanel=new JPanel(new GridLayout(2,1));
	
	//lossFrame:
			JFrame lossFrame=new JFrame();
			String[] lossColumn={"仓库名","编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
			Object[][] lossRowData={{"1A231","00001","淫迪","1号",1,4,4,4,4,4}};
			DefaultTableModel lossTableModel=new DefaultTableModel(lossRowData,lossColumn);
			JTable lossTable=new JTable(lossTableModel);
			JScrollPane lossJScrollPane=new JScrollPane(lossTable);
			JSplitPane lossSplit;
			JLabel stockLossName=new JLabel("仓库名称");
			JLabel goodsLossName=new JLabel("商品名称");
			JLabel goodsLossID=new JLabel("商品编号");
			JTextField stockLossNameField=new JTextField();
			JTextField goodsLossNameField=new JTextField();
			JTextField goodsLossIDField=new JTextField();
			JButton lossSearch=new JButton("搜索");
			JButton lossAssure=new JButton("确定");
			JButton lossCancel=new JButton("取消");
			JPanel lossinputOnePanel=new JPanel(new BorderLayout());
			JPanel lossinputTwoPanel=new JPanel(new BorderLayout());
			JPanel lossinputThreePanel=new JPanel(new BorderLayout());
			JPanel lossButtons=new JPanel();
			JPanel lossRightPanel=new JPanel(new GridLayout(3,1));
			JPanel lossRight=new JPanel(new BorderLayout());
			
			//lossListFrame:
			JFrame lossListFrame=new JFrame();
			JLabel lossListTitle=new JLabel("库存报损单",SwingConstants.CENTER);
			JLabel lossStockName=new JLabel("仓库名",SwingConstants.RIGHT);
			JLabel lossGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
			JLabel lossGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
			JLabel lossGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
			JLabel lossSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
			JLabel lossActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
			JLabel lossTip=new JLabel("备注",SwingConstants.RIGHT);
			JTextField lossStockNameField=new JTextField();
			JTextField lossGoodsIDField=new JTextField();
			JTextField lossGoodsNameField=new JTextField();
			JTextField lossGoodsTypeField=new JTextField();
			JTextField lossSystemNumField=new JTextField();
			JTextField lossActualNumField=new JTextField();
			JTextArea  lossTipArea       =new JTextArea();
			JButton lossOutput=new JButton("生成");
			JButton lossNotOutput=new JButton("取消");
			JPanel lossListPanel=new JPanel(new GridLayout(6,2) );
			JPanel lossOutputPanel=new JPanel();
			JPanel lossListPanelPlus=new JPanel(new BorderLayout());
			JPanel lossTipPanel=new JPanel(new GridLayout(1,2));
			JPanel lossTipPlusPanel=new JPanel(new GridLayout(2,1));
		
		//warmingFrame:
			JFrame warmingFrame=new JFrame();
			String[] warmingListColumn={"仓库名","编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
			Object[][] warmingRowData={{"1A231","00001","淫迪","1号",1,4,4,4,4,4}};
			DefaultTableModel warmingTableModel=new DefaultTableModel(warmingRowData,warmingListColumn);
			JTable warmingTable=new JTable(warmingTableModel);
			JScrollPane warmingScrollPane=new JScrollPane(warmingTable);
			JLabel warmingTitle=new JLabel("库存报警单列表");
			JButton jbtSubmit=new JButton("提交");
			JButton jbtNotSubmit=new JButton("取消");
			JPanel warmingButtons=new JPanel();
			JPanel warmingTotal=new JPanel(new BorderLayout());
			
			
	public stockManagementui()
	{
		stockListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(new GridLayout(10,1));
		stock.add(jbtCheck);
		stock.add(jbtSnapshot);
		bills.add(jbtPresent);
		bills.add(jbtOverflow);
		bills.add(jbtLoss);
		bills.add(jbtWarming);
		stock.setBorder(new TitledBorder("库存查看"));
		bills.setBorder(new TitledBorder("单据制定"));
		add(stock);
		add(bills);
		
		jbtCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				startTime.setHorizontalAlignment(SwingConstants.RIGHT);
				endTime.setHorizontalAlignment(SwingConstants.RIGHT);
				time1.add(startTime,BorderLayout.WEST);
				time1.add(startTimeField,BorderLayout.CENTER);
				time2.add(endTime,BorderLayout.WEST);
				time2.add(endTimeField,BorderLayout.CENTER);
				time.add(time1);
				time.add(time2);
				operation.add(jbtAssure);
				operation.add(jbtCancel);
				rightPanel.add(time);
				rightPanel.add(operation);;
				leftPanel.add(stockListTitle,BorderLayout.NORTH);
				leftPanel.add(stockListPane,BorderLayout.CENTER);
				totalPanel.add(leftPanel,BorderLayout.CENTER);
				totalPanel.add(rightPanel,BorderLayout.SOUTH);
				checkFrame.add(totalPanel);
				checkFrame.pack();
				checkFrame.setLocationRelativeTo(null);
				checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				checkFrame.setTitle("库存查看");
				checkFrame.setVisible(true);
		//未实现		
				jbtAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
					//	String start=startTimeField.getText();
					//	String end=endTimeField.getText();
						String storehouse=(String)tableModel.getValueAt(checkTable.getSelectedRow(),1);
						StockCheckController stock=new StockCheckController();
						GregorianCalendar start=new GregorianCalendar();
						GregorianCalendar end=new GregorianCalendar();
						String[] startInfo=startTimeField.getText().split("/"); 
						String[] endInfo=endTimeField.getText().split("/");
						start.set(Integer.parseInt(startInfo[0]), Integer.parseInt(startInfo[1]),Integer.parseInt(startInfo[2]));
						end.set(Integer.parseInt(endInfo[0]),Integer.parseInt(endInfo[1]),Integer.parseInt(endInfo[2]));
						StockCheckListVO vo=stock.check(storehouse,start, end);
						String[] columnvo={"开始时间","结束时间","入库数量","出库数量","入库金额","出库金额","进货数量","销售数量","进货金额","销售金额","总数量"};
						String[][] rowDatavo={{vo.getStart(),vo.getEnd(),String.valueOf(vo.getInNumber()),String.valueOf(vo.getOutNumber()),String.valueOf(vo.getInMoney()),String.valueOf(vo.getOutMoney()),String.valueOf(vo.getPurchaseNumber()),String.valueOf(vo.getSalesNumber()),String.valueOf(vo.getPurchaseMoney()),String.valueOf(vo.getSalesMoney()),String.valueOf(vo.getTotalNumber())}};
						DefaultTableModel voTableModel=new DefaultTableModel(rowDatavo,columnvo);
						JTable voTable=new JTable(voTableModel);
						JScrollPane voJS=new JScrollPane(voTable);
						voFrame=new JFrame();
						JPanel voPanel=new JPanel(new BorderLayout());
						JPanel voButtons=new JPanel();
						JButton voButton=new JButton("确定");
						voButtons.add(voButton);
						voPanel.add(voJS,BorderLayout.CENTER);
						voPanel.add(voButtons,BorderLayout.SOUTH);
						voFrame.add(voPanel);
						voFrame.pack();
						voFrame.setLocationRelativeTo(null);
						voFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						voFrame.setTitle("库存查看");
						voFrame.setVisible(true);
						voButton.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								voFrame.dispose();
							}
						});
					}
				});
				
				jbtCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						checkFrame.dispose();
					}
				});
				
			}
		});
		
		jbtSnapshot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shotListTitle.setHorizontalAlignment(SwingConstants.CENTER);
				biao.add(shotListTitle,BorderLayout.NORTH);
				biao.add(shotListPane,BorderLayout.CENTER);
				
				butt.add(jbtSelect);
				butt.add(jbtNotSelect);
				biao.add(butt,BorderLayout.SOUTH);
				shotFrame.add(biao);
				shotFrame.pack();
				shotFrame.setLocationRelativeTo(null);
				shotFrame.setTitle("库存快照");
				shotFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				shotFrame.setVisible(true);
		//未实现选择仓库		
				jbtSelect.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						topInfoPanel.add(info1);
						topInfoPanel.add(info2);
						middlePanel.add(topInfoPanel,BorderLayout.NORTH);
						middlePanel.add(goodsListPane,BorderLayout.CENTER);
						systemPanel.add(middlePanel,BorderLayout.CENTER);
						butto.add(jbtPath);
						butto.add(jbtPathCancel);
						systemPanel.add(butto,BorderLayout.SOUTH);
						oneStockInfoFrame.add(systemPanel);
						oneStockInfoFrame.pack();
						oneStockInfoFrame.setLocationRelativeTo(null);
						oneStockInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						oneStockInfoFrame.setTitle("库存信息");
						oneStockInfoFrame.setVisible(true);
						
		//未实现excel导出	
						jbtPath.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
							}
						});
						jbtPathCancel.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								oneStockInfoFrame.dispose();
							}
						});
					}
				});
				jbtNotSelect.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
					    shotFrame.dispose();
					}
				});
			}
		});
		
		jbtPresent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				presentFrame=new JFrame();
				jbtPresentSelect=new JButton("确定");
				jbtPresentNotSelect=new JButton("取消");
				presentTableModel=new DefaultTableModel(presentRowData1,presentColumnName1);
				presentTable=new JTable(presentTableModel);
				presentListPane=new JScrollPane(presentTable);
				presentListTitle=new JLabel("仓库列表");
				presentBiao=new JPanel(new BorderLayout());
				presentButt=new JPanel();
				
				
				presentListTitle.setHorizontalAlignment(SwingConstants.CENTER);
                presentBiao.add(presentListTitle,BorderLayout.NORTH);
				presentBiao.add(presentListPane,BorderLayout.CENTER);
				
				presentButt.add(jbtPresentSelect);
				presentButt.add(jbtPresentNotSelect);
				presentBiao.add(presentButt,BorderLayout.SOUTH);
				presentFrame.add(presentBiao);
				presentFrame.pack();
				presentFrame.setLocationRelativeTo(null);
				presentFrame.setTitle("库存赠送");
				presentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				presentFrame.setVisible(true);
				
				jbtPresentSelect.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						subPresentFrame=new JFrame();
						String[] presentColumn={"编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
						Object[][] presentRowData={{"00001","淫迪","1号",1,4,4,4,4,4}};
						presentListTableModel=new DefaultTableModel(presentRowData,presentColumn);
						presentListTable=new JTable(presentListTableModel);
						presentJScrollPane=new JScrollPane(presentListTable);
					    jbtPresentSelected=new JButton("赠送");
						jbtPresentNotSelected=new JButton("取消");
						rightPresentPanel=new JPanel(new BorderLayout());
						rightTopPresentPanel=new JPanel(new BorderLayout());
						rightBottomPresentPanel=new JPanel(new BorderLayout());
						rightTotalPanel=new JPanel(new BorderLayout());
						presentButtons=new JPanel();
						subPresentPanel=new JPanel(new FlowLayout());
						number=new JLabel("数量");
						numberField=new JTextField();
						tip=new JLabel("备注");
						tipArea=new JTextArea(5,20);
						
						rightTopPresentPanel.add(number,BorderLayout.WEST);
						rightTopPresentPanel.add(numberField,BorderLayout.CENTER);
						rightBottomPresentPanel.add(tip,BorderLayout.WEST);
						rightBottomPresentPanel.add(tipArea,BorderLayout.CENTER);
						rightPresentPanel.add(rightTopPresentPanel,BorderLayout.NORTH);
						rightPresentPanel.add(rightBottomPresentPanel,BorderLayout.CENTER);
						presentButtons.add(jbtPresentSelected);
						presentButtons.add(jbtPresentNotSelected);
						
						
						rightTotalPanel.add(rightPresentPanel,BorderLayout.CENTER);
						rightTotalPanel.add(presentButtons,BorderLayout.SOUTH);
						presentSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,presentJScrollPane,rightTotalPanel);
						subPresentPanel.add(presentSplit);
						subPresentFrame.add(subPresentPanel);
						subPresentFrame.pack();
						subPresentFrame.setLocationRelativeTo(null);
						subPresentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						subPresentFrame.setTitle("赠送选择");
						subPresentFrame.setVisible(true);
				//未修改系统数据！！！！！！！！！！！！！！！！！！！！！！		
						jbtPresentSelected.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								if(presentListTable.getSelectedRow()==-1)
									JOptionPane.showMessageDialog(null, "未选择赠送商品");
								else
								{
								
								StockController stock=new StockController();
								ArrayList<GiftBillVO.GiftBillItemVO> list=new ArrayList<GiftBillVO.GiftBillItemVO>();
								GiftBillVO vo=new GiftBillVO("GiftBill", "迪", (String)presentTableModel.getValueAt(presentTable.getSelectedRow(),1), "di",list);
								
								GiftBillVO.GiftBillItemVO item=vo.new GiftBillItemVO((String)presentListTableModel.getValueAt(presentListTable.getSelectedRow(),1),(String)presentListTableModel.getValueAt(presentListTable.getSelectedRow(), 2),Integer.parseInt(numberField.getText()));
								list.add(item);
								vo.setList(list);
								ResultMessage result=stock.send(vo);
								if(result==ResultMessage.Success)
								{
								JOptionPane.showMessageDialog(null, "赠送成功");
								subPresentFrame.dispose();
								}
								else
								{
								JOptionPane.showMessageDialog(null, "赠送失败");
								subPresentFrame.dispose();
								}
								}
							}
						});
						jbtPresentNotSelected.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								subPresentFrame.dispose();
							}
						});
					}
				});
				jbtPresentNotSelect.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						presentFrame.dispose();
					}
				});
			}
		});
		
		jbtOverflow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				overFlowFrame=new JFrame();
				overTableModel=new DefaultTableModel(overRowData,overColumn);
				overTable=new JTable(overTableModel);
				overJScrollPane=new JScrollPane(overTable);
				stockName=new JLabel("仓库名称");
				goodsName=new JLabel("商品名称");
				goodsID=new JLabel("商品编号");
				stockNameField=new JTextField();
				goodsNameField=new JTextField();
				goodsIDField=new JTextField();
				overSearch=new JButton("搜索");
				overAssure=new JButton("确定");
				overCancel=new JButton("取消");
				inputOnePanel=new JPanel(new BorderLayout());
				inputTwoPanel=new JPanel(new BorderLayout());
		        inputThreePanel=new JPanel(new BorderLayout());
				overButtons=new JPanel();
				overRightPanel=new JPanel(new GridLayout(3,1));
				overRight=new JPanel(new BorderLayout());
				
				inputOnePanel.add(stockName,BorderLayout.WEST);
				inputOnePanel.add(stockNameField,BorderLayout.CENTER);
				inputTwoPanel.add(goodsName,BorderLayout.WEST);
				inputTwoPanel.add(goodsNameField,BorderLayout.CENTER);
				inputThreePanel.add(goodsID,BorderLayout.WEST);
				inputThreePanel.add(goodsIDField,BorderLayout.CENTER);
				overButtons.add(overSearch);
				overButtons.add(overAssure);
				overButtons.add(overCancel);
				overRightPanel.add(inputOnePanel);
				overRightPanel.add(inputTwoPanel);
				overRightPanel.add(inputThreePanel);
				overRight.add(overRightPanel,BorderLayout.CENTER);
				overRight.add(overButtons,BorderLayout.SOUTH);
				overSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,overJScrollPane,overRight);
				overFlowFrame.add(overSplit);
				
				overFlowFrame.pack();
				overFlowFrame.setLocationRelativeTo(null);
				overFlowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				overFlowFrame.setTitle("库存报溢");
				overFlowFrame.setVisible(true);
				//未实现
				overSearch.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
					    JOptionPane.showMessageDialog(null, "功能未实现");	
					}
				});
				
				overAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						overListFrame=new JFrame();
						overListTitle=new JLabel("库存报溢单",SwingConstants.CENTER);
						overStockName=new JLabel("仓库名",SwingConstants.RIGHT);
						overGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
						overGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
						overGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
						overSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
						overActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
						overTip=new JLabel("备注",SwingConstants.RIGHT);
						overStockNameField=new JTextField();
						overGoodsIDField=new JTextField();
						overGoodsNameField=new JTextField();
						overGoodsTypeField=new JTextField();
						overSystemNumField=new JTextField();
						overActualNumField=new JTextField();
						overTipArea       =new JTextArea();
						overOutput=new JButton("生成");
						overNotOutput=new JButton("取消");
						overListPanel=new JPanel(new GridLayout(6,2) );
						overOutputPanel=new JPanel();
					    overListPanelPlus=new JPanel(new BorderLayout());
						overTipPanel=new JPanel(new GridLayout(1,2));
					    overTipPlusPanel=new JPanel(new GridLayout(2,1));
						
						overListTitle.setSize(overSystemNum.getSize());
						overStockName.setSize(overSystemNum.getSize());
						overGoodsID.setSize(overSystemNum.getSize());
						overGoodsName.setSize(overSystemNum.getSize());
						overGoodsType.setSize(overSystemNum.getSize());
						overSystemNum.setSize(overSystemNum.getSize());
						overActualNum.setSize(overSystemNum.getSize());
						overTip.setSize(overSystemNum.getSize());
						overListPanel.add(overStockName);
						overListPanel.add(overStockNameField);
						overListPanel.add(overGoodsID);
						overListPanel.add(overGoodsIDField);
						overListPanel.add(overGoodsName);
						overListPanel.add(overGoodsNameField);
						overListPanel.add(overGoodsType);
						overListPanel.add(overGoodsTypeField);
						overListPanel.add(overSystemNum);
						overListPanel.add(overSystemNumField);
						overListPanel.add(overActualNum);
						overListPanel.add(overActualNumField);
						overTipPanel.add(overTip);
						overTipPanel.add(overTipArea);
						overTipPlusPanel.add(overListPanel);
						overTipPlusPanel.add(overTipPanel);
						overListPanelPlus.add(overListTitle,BorderLayout.NORTH);
						overListPanelPlus.add(overTipPlusPanel,BorderLayout.CENTER);
						overListPanelPlus.setBorder(new LineBorder(Color.BLACK,2));
						overOutputPanel.add(overListPanelPlus);
						overOutputPanel.add(overOutput);
						overOutputPanel.add(overNotOutput);
						overListFrame.add(overOutputPanel);
						overListFrame.setLocationRelativeTo(null);
						overListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						overListFrame.setTitle("制定库存报溢单");
						overListFrame.pack();
						overListFrame.setVisible(true);
						
						overOutput.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								StockController stock=new StockController();
								OverflowBillVO vo=new OverflowBillVO("XXX",overStockNameField.getText(),overGoodsNameField.getText(), overGoodsTypeField.getText(),Integer.parseInt(overSystemNumField.getText()),Integer.parseInt(overActualNumField.getText()));
								ResultMessage result=stock.send(vo);
								if(result==ResultMessage.Success)
								{
								JOptionPane.showMessageDialog(null, "单据生成成功");
								overListFrame.dispose();
								}
								else
								{
								JOptionPane.showMessageDialog(null, "单据生成失败");
								
								}
							}
						
							
						});
						overNotOutput.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								overListFrame.dispose();
							}
						});
					}
				});
				overCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						overFlowFrame.dispose();
					}
				});
			}
		});
		
		jbtLoss.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lossFrame=new JFrame();
				lossTableModel=new DefaultTableModel(lossRowData,lossColumn);
				lossTable=new JTable(lossTableModel);
				lossJScrollPane=new JScrollPane(lossTable);
				stockLossName=new JLabel("仓库名称");
				goodsLossName=new JLabel("商品名称");
				goodsLossID=new JLabel("商品编号");
				stockLossNameField=new JTextField();
				goodsLossNameField=new JTextField();
				goodsLossIDField=new JTextField();
				lossSearch=new JButton("搜索");
				lossAssure=new JButton("确定");
				lossCancel=new JButton("取消");
				lossinputOnePanel=new JPanel(new BorderLayout());
				lossinputTwoPanel=new JPanel(new BorderLayout());
				lossinputThreePanel=new JPanel(new BorderLayout());
				lossButtons=new JPanel();
				lossRightPanel=new JPanel(new GridLayout(3,1));
				lossRight=new JPanel(new BorderLayout());
				
				lossinputOnePanel.add(stockLossName,BorderLayout.WEST);
				lossinputOnePanel.add(stockLossNameField,BorderLayout.CENTER);
				lossinputTwoPanel.add(goodsLossName,BorderLayout.WEST);
				lossinputTwoPanel.add(goodsLossNameField,BorderLayout.CENTER);
				lossinputThreePanel.add(goodsLossID,BorderLayout.WEST);
				lossinputThreePanel.add(goodsLossIDField,BorderLayout.CENTER);
				lossButtons.add(lossSearch);
				lossButtons.add(lossAssure);
				lossButtons.add(lossCancel);
				lossRightPanel.add(lossinputOnePanel);
				lossRightPanel.add(lossinputTwoPanel);
				lossRightPanel.add(lossinputThreePanel);
				lossRight.add(lossRightPanel,BorderLayout.CENTER);
				lossRight.add(lossButtons,BorderLayout.SOUTH);
				lossSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,lossJScrollPane,lossRight);
				lossFrame.add(lossSplit);
				
				lossFrame.pack();
				lossFrame.setLocationRelativeTo(null);
				lossFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				lossFrame.setTitle("库存报损");
				lossFrame.setVisible(true);
				//未实现
				overSearch.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						
					    JOptionPane.showMessageDialog(null, "功能未实现");	
					}
				});
				
				lossAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						lossListFrame=new JFrame();
						lossListTitle=new JLabel("库存报损单",SwingConstants.CENTER);
				        lossStockName=new JLabel("仓库名",SwingConstants.RIGHT);
						lossGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
						lossGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
						lossGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
						lossSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
						lossActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
					    lossTip=new JLabel("备注",SwingConstants.RIGHT);
						lossStockNameField=new JTextField();
						lossGoodsIDField=new JTextField();
						lossGoodsNameField=new JTextField();
						lossGoodsTypeField=new JTextField();
						lossSystemNumField=new JTextField();
						lossActualNumField=new JTextField();
						lossTipArea       =new JTextArea();
						lossOutput=new JButton("生成");
					    lossNotOutput=new JButton("取消");
						lossListPanel=new JPanel(new GridLayout(6,2) );
						lossOutputPanel=new JPanel();
						lossListPanelPlus=new JPanel(new BorderLayout());
						lossTipPanel=new JPanel(new GridLayout(1,2));
						lossTipPlusPanel=new JPanel(new GridLayout(2,1));
						
						lossListTitle.setSize(lossSystemNum.getSize());
					    lossStockName.setSize(lossSystemNum.getSize());
						lossGoodsID.setSize(lossSystemNum.getSize());
						lossGoodsName.setSize(lossSystemNum.getSize());
						lossGoodsType.setSize(lossSystemNum.getSize());
						lossSystemNum.setSize(lossSystemNum.getSize());
					    lossActualNum.setSize(lossSystemNum.getSize());
						lossTip.setSize(lossSystemNum.getSize());
						lossListPanel.add(lossStockName);
						lossListPanel.add(lossStockNameField);
						lossListPanel.add(lossGoodsID);
						lossListPanel.add(lossGoodsIDField);
						lossListPanel.add(lossGoodsName);
						lossListPanel.add(lossGoodsNameField);
						lossListPanel.add(lossGoodsType);
						lossListPanel.add(lossGoodsTypeField);
						lossListPanel.add(lossSystemNum);
						lossListPanel.add(lossSystemNumField);
						lossListPanel.add(lossActualNum);
						lossListPanel.add(lossActualNumField);
						lossTipPanel.add(lossTip);
						lossTipPanel.add(lossTipArea);
						lossTipPlusPanel.add(lossListPanel);
						lossTipPlusPanel.add(lossTipPanel);
						lossListPanelPlus.add(lossListTitle,BorderLayout.NORTH);
						lossListPanelPlus.add(lossTipPlusPanel,BorderLayout.CENTER);
						lossListPanelPlus.setBorder(new LineBorder(Color.BLACK,2));
						lossOutputPanel.add(lossListPanelPlus);
						lossOutputPanel.add(lossOutput);
						lossOutputPanel.add(lossNotOutput);
						lossListFrame.add(lossOutputPanel);
						lossListFrame.setLocationRelativeTo(null);
						lossListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						lossListFrame.setTitle("制定库存报损单");
						lossListFrame.pack();
						lossListFrame.setVisible(true);
						
						lossOutput.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								StockController stock=new StockController();
								UnderflowBillVO vo=new UnderflowBillVO("XXX",lossStockNameField.getText(),lossGoodsNameField.getText(), lossGoodsTypeField.getText(),Integer.parseInt(lossSystemNumField.getText()),Integer.parseInt(lossActualNumField.getText()));
								ResultMessage result=stock.send(vo);
								if(result==ResultMessage.Success)
								{
								JOptionPane.showMessageDialog(null, "单据生成成功");
								lossListFrame.dispose();
								}
								else
								{
								JOptionPane.showMessageDialog(null, "单据生成失败");
								
								}
							}
						});
						lossNotOutput.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								lossListFrame.dispose();
							}
						});
					}
				});
				lossCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						lossFrame.dispose();
					}
				});
			}
		});
		
		jbtWarming.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				warmingFrame=new JFrame();
				warmingTableModel=new DefaultTableModel(warmingRowData,warmingListColumn);
				warmingTable=new JTable(warmingTableModel);
			    warmingScrollPane=new JScrollPane(warmingTable);
				warmingTitle=new JLabel("库存报警单列表");
				jbtSubmit=new JButton("提交");
				jbtNotSubmit=new JButton("取消");
				warmingButtons=new JPanel();
				warmingTotal=new JPanel(new BorderLayout());
				
				warmingButtons.add(jbtSubmit);
				warmingButtons.add(jbtNotSubmit);
				warmingTotal.add(warmingTitle,BorderLayout.NORTH);
				warmingTotal.add(warmingScrollPane,BorderLayout.CENTER);
				warmingTotal.add(warmingButtons,BorderLayout.SOUTH);
				warmingFrame.add(warmingTotal);
				warmingFrame.pack();
				warmingFrame.setLocationRelativeTo(null);
				warmingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				warmingFrame.setTitle("库存报警");
				warmingFrame.setVisible(true);
				
				jbtSubmit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(warmingTable.getSelectedRow()>=0)
						{
							StockController stock=new StockController();
							OverflowBillVO vo=new OverflowBillVO("XXX",overStockNameField.getText(),overGoodsNameField.getText(), overGoodsTypeField.getText(),Integer.parseInt(overSystemNumField.getText()),Integer.parseInt(overActualNumField.getText()));
							ResultMessage result=stock.send(vo);
							if(result==ResultMessage.Success)
							{
							warmingTableModel.removeRow(warmingTable.getSelectedRow());
							JOptionPane.showMessageDialog(null, "提交成功");
							overListFrame.dispose();
							}
							else
							{
							JOptionPane.showMessageDialog(null, "提交失败");
							
							}
							
						}
						else
							JOptionPane.showMessageDialog(null, "未选择目标");
					}
				});
				jbtNotSubmit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						warmingFrame.dispose();
					}
				});
			}
		});
	}
	
	
	
	
	
	
}



