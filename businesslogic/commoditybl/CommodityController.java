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
	public ResultMessage addCommodity(CommodityVO vo) {
		return commodity.addCommodity(vo);
	}
	public ResultMessage deleteCommodity(CommodityVO vo) {
		return commodity.deleteCommodity(vo);
	}
	public ResultMessage updateCommodity(CommodityVO vo) {
		return commodity.updateCommodity(vo);
	}
	public ResultMessage addModel(CommodityModelVO model) {
		return commodity.addModel(model);
	}
	public ResultMessage deleteModel(String commodityID, String modelName) {
		return commodity.deleteModel(commodityID, modelName);
	}
	public ResultMessage updateModel(String beforeName, CommodityModelVO vo) {
		return commodity.updateModel(beforeName, vo);
	}
	public CommodityVO findCommodityByID(String id) {
		return commodity.findCommodityByID(id);
	}
	public CommodityVO findCommodityByName(String name) {
		return commodity.findCommodityByName(name);
	}
	public ArrayList<CommodityVO> findCommodityInKeyword(String key) {
		return commodity.findCommodityInKeyword(key);
	}
	public CommodityModelVO getModel(String commodityID, String model) {
		return commodity.getModel(commodityID, model);
	}
	public ArrayList<CommodityVO> getAllCommodity() {
		return commodity.getAllCommodity();
	}
	@Override
	public String getNewID(String typeID) {
		return commodity.getNewID(typeID);
	}
}
