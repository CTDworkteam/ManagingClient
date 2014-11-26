package commoditytypebl;
import java.util.ArrayList;

import vo.CommodityTypeVO;
import vo.CommodityVO;
import enumType.ResultMessage;
import blservice.*;
public class CommodityType implements CommodityTypeBLService{
	public String id;
	public String name;
	public CommodityList comlist;
	public SubTypeList childs;
	public CommodityType father;
	public boolean isRoot;
	public boolean isLeaf;
	@Override
	public ResultMessage addType(CommodityTypeVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage deleteType(CommodityTypeVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage updateType(CommodityTypeVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public CommodityTypeVO findInID(String id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<CommodityTypeVO> findInKeyword(String key) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<CommodityTypeVO> getAllSubType(CommodityTypeVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<CommodityVO> getAllCommodity(CommodityTypeVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}