package commoditybl;

import java.util.ArrayList;

import vo.CommodityModelVO;
import vo.CommodityVO;
import enumType.ResultMessage;
import blservice.*;

public class CommodityController implements CommodityBLService{
	public Commodity commodity;
	public CommodityController(){
		commodity=new Commodity();
	}
	@Override
	public ResultMessage addCommodity(CommodityVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage deleteCommodity(CommodityVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage updateCommodity(CommodityVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage addModel(CommodityModelVO model) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage deleteModel(String commodityID, String modelName) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage updateModel(String beforeName, CommodityModelVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public CommodityVO findCommodityByID(String id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public CommodityVO findCommodityByName(String name) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<CommodityVO> findCommodityInKeyword(String key) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public CommodityModelVO getModel(String commodityID, String model) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<CommodityVO> getAllCommodity() {
		// TODO 自动生成的方法存根
		return null;
	}
}