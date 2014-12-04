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
	public ResultMessage addModel(CommodityModelVO vo) {
		return commodity.addModel(vo);
	}
	public ResultMessage deleteModel(CommodityModelVO vo) {
		return commodity.deleteModel(vo);
	}
	public ResultMessage updateModel(String beforeName, CommodityModelVO vo) {
		return commodity.updateModel(beforeName,vo);
	}
	public CommodityVO findCommodityInID(String id) {
		return commodity.findCommodityInID(id);
	}
	public ArrayList<CommodityVO> findCommodityInKeyword(String key) {
		return commodity.findCommodityInKeyword(key);
	}
	public CommodityModelVO getModel(CommodityVO vo, String model) {
		return commodity.getModel(vo, model);
	}
}