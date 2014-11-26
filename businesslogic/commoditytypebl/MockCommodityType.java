package commoditytypebl;
import java.util.ArrayList;
import vo.CommodityTypeVO;
import vo.CommodityVO;
import enumType.ResultMessage;
public class MockCommodityType extends CommodityType{
	private ArrayList<CommodityTypeVO> list=new ArrayList<CommodityTypeVO>();
	@Override
	public ResultMessage addType(CommodityTypeVO vo) {
		for(int i=0;i<=list.size()-1;i++){
			if(vo.getName().equals(list.get(i).getName())){
				return ResultMessage.Failure;
			}
		}
		if(new Integer(vo.getId().substring(0,1)).intValue()>5){
			return ResultMessage.Failure;
		}
		list.add(vo);
		return ResultMessage.Success;
	}
	@Override
	public ResultMessage deleteType(CommodityTypeVO vo) {
		for(int i=0;i<=list.size()-1;i++){
			if(vo.getId().equals(list.get(i).getId())){
				list.remove(i);
			}
		}
		return ResultMessage.Success;
	}
	@Override
	public ResultMessage updateType(CommodityTypeVO vo) {
		for(int i=0;i<=list.size()-1;i++){
			if(vo.getId().equals(list.get(i))){
				vo.update(vo.makeCommodityType());
			}
		}
		return ResultMessage.Success;
	}
	@Override
	public CommodityTypeVO findInID(String id) {
		for(int i=0;i<=list.size()-1;i++){
			if(id.equals(list.get(i))){
				return list.get(i);
			}
		}
		return null;
	}
	@Override
	public ArrayList<CommodityTypeVO> findInKeyword(String key) {
		return null;
	}
	@Override
	public ArrayList<CommodityTypeVO> getAllSubType(CommodityTypeVO vo) {
		ArrayList<CommodityTypeVO> output=new ArrayList<CommodityTypeVO>();
		for(int i=0;i<=list.size()-1;i++){
			for(int j=0;j<=vo.getChild().size()-1;j++){
				if(vo.getChild().get(j).equals(list.get(i).getId())){
					output.add(list.get(i));
				}
			}
		}
		return output;
	}
	@Override
	public ArrayList<CommodityVO> getAllCommodity(CommodityTypeVO vo) {
		return null;
	}

}
