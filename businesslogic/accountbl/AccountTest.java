package accountbl;
import vo.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enumType.ResultMessage;

public class AccountTest {
	private Account account = new Account();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd1(){
		AccountVO vo = new AccountVO(4,"工行账户",1000);
		ResultMessage result = account.add(vo);
		assertEquals(ResultMessage.Failure,result);
	}
	
	@Test
	public void testAdd2(){
		AccountVO vo = new AccountVO(4,"花旗账户",1000);
		ResultMessage result = account.add(vo);
		assertEquals(ResultMessage.Success,result);
	}
	
	@Test
	public void testDelete1(){
		AccountVO vo = new AccountVO(1,"工行账户",200000);
		ResultMessage result = account.delete(vo);
		assertEquals(ResultMessage.Success,result);
	}
	
	@Test
	public void testDelete2(){
		AccountVO vo = new AccountVO(5,"工行账户",200000);
		ResultMessage result = account.delete(vo);
		assertEquals(ResultMessage.Failure,result);
	}
	
	@Test
	public void testUpdate1(){
		AccountVO vo = new AccountVO(1,"呵呵哒账户",200000);
		ResultMessage result = account.update(vo);
		assertEquals(ResultMessage.Success,result);
	}
	
	@Test
	public void testUpdate2(){
		AccountVO vo = new AccountVO(5,"工行账户",200000);
		ResultMessage result = account.update(vo);
		assertEquals(ResultMessage.Failure,result);
	}
	
	@Test
	public void testGetNewAccountID(){
		long id = account.getNewAccountID();
		assertEquals(4,id);
	}
	
	@Test
	public void testFind(){
		AccountVO vo = account.find("工行账户");
		assertEquals(1,vo.getId());
		assertEquals(200000.0,vo.getMoney(),0.0);
	}
}
