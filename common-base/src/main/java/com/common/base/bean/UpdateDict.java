package com.common.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonggege on 2017/7/20.
 */

public class UpdateDict implements Serializable, Parcelable {
    private static final long serialVersionUID = 1L;
    /**
     * has_update : 1
     * dict_version : 10000
     * dict : {"industry":[{"id":1,"dict_text":"冶金","children":[{"id":14,"dict_type":"sub_industry","dict_text":"电解锰","children":[]},{"id":20,"dict_type":"sub_industry","dict_text":"电解锌","children":[]},{"id":21,"dict_type":"sub_industry","dict_text":"电解铅","children":[]},{"id":22,"dict_type":"sub_industry","dict_text":"电解铜","children":[]},{"id":23,"dict_type":"sub_industry","dict_text":"稀有金属冶炼","children":[]},{"id":24,"dict_type":"sub_industry","dict_text":"钢铁工业","children":[]}]},{"id":2,"dict_text":"石油化工","children":[{"id":25,"dict_type":"sub_industry","dict_text":"石油炼化","children":[]},{"id":26,"dict_type":"sub_industry","dict_text":"油气田","children":[]},{"id":27,"dict_type":"sub_industry","dict_text":"石化","children":[]},{"id":28,"dict_type":"sub_industry","dict_text":"油气设备","children":[]},{"id":29,"dict_type":"sub_industry","dict_text":"油气输送管道","children":[]},{"id":30,"dict_type":"sub_industry","dict_text":"海洋油田","children":[]}]},{"id":3,"dict_text":"化工","children":[{"id":31,"dict_type":"sub_industry","dict_text":"氯碱化工","children":[]},{"id":124,"dict_type":"sub_industry","dict_text":"硫酸化工","children":[]},{"id":125,"dict_type":"sub_industry","dict_text":"硝酸化工","children":[]},{"id":126,"dict_type":"sub_industry","dict_text":"磷化工","children":[]},{"id":127,"dict_type":"sub_industry","dict_text":"氟化工","children":[]},{"id":128,"dict_type":"sub_industry","dict_text":"钛白","children":[]},{"id":129,"dict_type":"sub_industry","dict_text":"农药","children":[]},{"id":130,"dict_type":"sub_industry","dict_text":"有机树脂化工","children":[]},{"id":131,"dict_type":"sub_industry","dict_text":"塑料化工","children":[]},{"id":132,"dict_type":"sub_industry","dict_text":"橡胶化工","children":[]},{"id":133,"dict_type":"sub_industry","dict_text":"无机盐化工","children":[]},{"id":134,"dict_type":"sub_industry","dict_text":"皮革化工","children":[]},{"id":135,"dict_type":"sub_industry","dict_text":"医药化工","children":[]},{"id":136,"dict_type":"sub_industry","dict_text":"化肥","children":[]},{"id":137,"dict_type":"sub_industry","dict_text":"环保化工","children":[]},{"id":138,"dict_type":"sub_industry","dict_text":"煤化工","children":[]},{"id":139,"dict_type":"sub_industry","dict_text":"日用化工","children":[]},{"id":140,"dict_type":"sub_industry","dict_text":"印染化工","children":[]},{"id":141,"dict_type":"sub_industry","dict_text":"化学助剂","children":[]}]},{"id":4,"dict_text":"建材建筑","children":[{"id":142,"dict_type":"sub_industry","dict_text":"建材水泥","children":[]},{"id":143,"dict_type":"sub_industry","dict_text":"建材玻璃","children":[]},{"id":144,"dict_type":"sub_industry","dict_text":"钢结构建筑","children":[]},{"id":145,"dict_type":"sub_industry","dict_text":"房地产","children":[]},{"id":146,"dict_type":"sub_industry","dict_text":"公用设施","children":[]}]},{"id":5,"dict_text":"电力","children":[{"id":147,"dict_type":"sub_industry","dict_text":"火电","children":[]},{"id":148,"dict_type":"sub_industry","dict_text":"水电","children":[]},{"id":149,"dict_type":"sub_industry","dict_text":"风电","children":[]},{"id":150,"dict_type":"sub_industry","dict_text":"核电","children":[]},{"id":151,"dict_type":"sub_industry","dict_text":"输变电","children":[]},{"id":152,"dict_type":"sub_industry","dict_text":"新能源","children":[]}]},{"id":6,"dict_text":"海洋工程","children":[{"id":153,"dict_type":"sub_industry","dict_text":"海岸工程","children":[]},{"id":154,"dict_type":"sub_industry","dict_text":"海港工程","children":[]},{"id":155,"dict_type":"sub_industry","dict_text":"围海工程","children":[]}]},{"id":7,"dict_text":"交通","children":[{"id":156,"dict_type":"sub_industry","dict_text":"公路","children":[]},{"id":157,"dict_type":"sub_industry","dict_text":"铁路","children":[]},{"id":158,"dict_type":"sub_industry","dict_text":"机场","children":[]},{"id":159,"dict_type":"sub_industry","dict_text":"航运","children":[]},{"id":160,"dict_type":"sub_industry","dict_text":"地铁","children":[]},{"id":161,"dict_type":"sub_industry","dict_text":"桥梁","children":[]},{"id":162,"dict_type":"sub_industry","dict_text":"隧道","children":[]}]},{"id":8,"dict_text":"矿山","children":[{"id":163,"dict_type":"sub_industry","dict_text":"煤炭","children":[]},{"id":164,"dict_type":"sub_industry","dict_text":"铁矿","children":[]},{"id":165,"dict_type":"sub_industry","dict_text":"锰矿","children":[]},{"id":166,"dict_type":"sub_industry","dict_text":"铜矿","children":[]},{"id":167,"dict_type":"sub_industry","dict_text":"铅锌矿","children":[]},{"id":168,"dict_type":"sub_industry","dict_text":"稀有金属矿","children":[]},{"id":169,"dict_type":"sub_industry","dict_text":"磷矿","children":[]}]},{"id":9,"dict_text":"船舶","children":[{"id":170,"dict_type":"sub_industry","dict_text":"船舶制造","children":[]},{"id":171,"dict_type":"sub_industry","dict_text":"船舶维修","children":[]}]},{"id":10,"dict_text":"市政工程","children":[{"id":172,"dict_type":"sub_industry","dict_text":"污水处理","children":[]},{"id":173,"dict_type":"sub_industry","dict_text":"供排水设施","children":[]},{"id":174,"dict_type":"sub_industry","dict_text":"热力供暖","children":[]},{"id":175,"dict_type":"sub_industry","dict_text":"燃气工程","children":[]},{"id":176,"dict_type":"sub_industry","dict_text":"通讯工程","children":[]}]},{"id":11,"dict_text":"轻工","children":[{"id":177,"dict_type":"sub_industry","dict_text":"食品饮料","children":[]},{"id":178,"dict_type":"sub_industry","dict_text":"纺织","children":[]},{"id":179,"dict_type":"sub_industry","dict_text":"油脂","children":[]},{"id":180,"dict_type":"sub_industry","dict_text":"造纸","children":[]}]},{"id":12,"dict_text":"水利工程","children":[{"id":181,"dict_type":"sub_industry","dict_text":"水库","children":[]},{"id":182,"dict_type":"sub_industry","dict_text":"水坝","children":[]},{"id":183,"dict_type":"sub_industry","dict_text":"航道港口","children":[]},{"id":184,"dict_type":"sub_industry","dict_text":"防洪工程","children":[]},{"id":185,"dict_type":"sub_industry","dict_text":"农田水利","children":[]}]},{"id":13,"dict_text":"装备制造","children":[{"id":186,"dict_type":"sub_industry","dict_text":"汽车","children":[]},{"id":187,"dict_type":"sub_industry","dict_text":"火车","children":[]},{"id":188,"dict_type":"sub_industry","dict_text":"通用机械制造","children":[]}]}],"worker_skill":[{"id":32,"dict_text":"表面处理","children":[{"id":38,"dict_type":"worker_sub_skill","dict_text":"打磨工","children":[]},{"id":39,"dict_type":"worker_sub_skill","dict_text":"喷砂除锈工","children":[]},{"id":40,"dict_type":"worker_sub_skill","dict_text":"喷砂设备维护工","children":[]},{"id":41,"dict_type":"worker_sub_skill","dict_text":"电工","children":[]},{"id":42,"dict_type":"worker_sub_skill","dict_text":"普工","children":[]}]},{"id":33,"dict_text":"保冷","children":[{"id":43,"dict_type":"worker_sub_skill","dict_text":"下料工","children":[]},{"id":44,"dict_type":"worker_sub_skill","dict_text":"保冷包扎工","children":[]},{"id":308,"dict_type":"worker_sub_skill","dict_text":"保冷外护工","children":[]},{"id":309,"dict_type":"worker_sub_skill","dict_text":"人工聚氨酯发泡工","children":[]},{"id":310,"dict_type":"worker_sub_skill","dict_text":"机喷聚氨酯发泡工","children":[]},{"id":311,"dict_type":"worker_sub_skill","dict_text":"保冷装模工","children":[]},{"id":312,"dict_type":"worker_sub_skill","dict_text":"保冷设备维护工","children":[]}]},{"id":34,"dict_text":"内保温","children":[{"id":313,"dict_type":"worker_sub_skill","dict_text":"保温砖砌筑工","children":[]},{"id":314,"dict_type":"worker_sub_skill","dict_text":"保温料浇注工","children":[]},{"id":315,"dict_type":"worker_sub_skill","dict_text":"装模工","children":[]}]},{"id":35,"dict_text":"外保温","children":[{"id":316,"dict_type":"worker_sub_skill","dict_text":"下料工","children":[]},{"id":317,"dict_type":"worker_sub_skill","dict_text":"包棉工","children":[]},{"id":318,"dict_type":"worker_sub_skill","dict_text":"包毡工","children":[]},{"id":319,"dict_type":"worker_sub_skill","dict_text":"白铁工","children":[]},{"id":320,"dict_type":"worker_sub_skill","dict_text":"外护工","children":[]},{"id":321,"dict_type":"worker_sub_skill","dict_text":"包布工","children":[]},{"id":322,"dict_type":"worker_sub_skill","dict_text":"焊工","children":[]},{"id":323,"dict_type":"worker_sub_skill","dict_text":"架子工","children":[]},{"id":324,"dict_type":"worker_sub_skill","dict_text":"保温砂浆工","children":[]},{"id":325,"dict_type":"worker_sub_skill","dict_text":"保温板材安装工","children":[]}]},{"id":36,"dict_text":"玻璃钢衬里","children":[{"id":326,"dict_type":"worker_sub_skill","dict_text":"裁布工","children":[]},{"id":327,"dict_type":"worker_sub_skill","dict_text":"配料工","children":[]},{"id":328,"dict_type":"worker_sub_skill","dict_text":"衬贴工","children":[]}]},{"id":37,"dict_text":"耐蚀板衬里","children":[{"id":329,"dict_type":"worker_sub_skill","dict_text":"配料工","children":[]},{"id":330,"dict_type":"worker_sub_skill","dict_text":"板材衬里工","children":[]}]},{"id":298,"dict_text":"橡胶衬里","children":[{"id":331,"dict_type":"worker_sub_skill","dict_text":"裁料工","children":[]},{"id":332,"dict_type":"worker_sub_skill","dict_text":"衬胶工","children":[]},{"id":333,"dict_type":"worker_sub_skill","dict_text":"硫化工","children":[]}]},{"id":299,"dict_text":"塑料衬里","children":[{"id":334,"dict_type":"worker_sub_skill","dict_text":"裁料工","children":[]},{"id":335,"dict_type":"worker_sub_skill","dict_text":"衬贴工","children":[]},{"id":336,"dict_type":"worker_sub_skill","dict_text":"焊接工","children":[]}]},{"id":300,"dict_text":"涂料防腐","children":[{"id":337,"dict_type":"worker_sub_skill","dict_text":"配漆工","children":[]},{"id":338,"dict_type":"worker_sub_skill","dict_text":"腻子工","children":[]},{"id":339,"dict_type":"worker_sub_skill","dict_text":"工厂喷涂工","children":[]},{"id":340,"dict_type":"worker_sub_skill","dict_text":"空气喷涂工","children":[]},{"id":341,"dict_type":"worker_sub_skill","dict_text":"无气喷涂工","children":[]},{"id":342,"dict_type":"worker_sub_skill","dict_text":"刷漆工","children":[]},{"id":343,"dict_type":"worker_sub_skill","dict_text":"高空涂装工","children":[]}]},{"id":301,"dict_text":"热喷涂","children":[{"id":344,"dict_type":"worker_sub_skill","dict_text":"喷锌工","children":[]},{"id":345,"dict_type":"worker_sub_skill","dict_text":"喷铝工","children":[]},{"id":346,"dict_type":"worker_sub_skill","dict_text":"喷不锈钢工","children":[]},{"id":347,"dict_type":"worker_sub_skill","dict_text":"喷塑工","children":[]},{"id":348,"dict_type":"worker_sub_skill","dict_text":"搪铅工","children":[]}]},{"id":302,"dict_text":"清洗","children":[{"id":349,"dict_type":"worker_sub_skill","dict_text":"化学清洗工","children":[]},{"id":350,"dict_type":"worker_sub_skill","dict_text":"机械清洗工","children":[]},{"id":351,"dict_type":"worker_sub_skill","dict_text":"清洗设备维护工","children":[]}]},{"id":303,"dict_text":"耐蚀混凝土","children":[{"id":352,"dict_type":"worker_sub_skill","dict_text":"耐蚀混凝土配料工","children":[]},{"id":353,"dict_type":"worker_sub_skill","dict_text":"耐蚀混凝土浇注工","children":[]},{"id":354,"dict_type":"worker_sub_skill","dict_text":"装模工","children":[]}]},{"id":304,"dict_text":"防水","children":[{"id":355,"dict_type":"worker_sub_skill","dict_text":"防水涂料涂抹工","children":[]},{"id":356,"dict_type":"worker_sub_skill","dict_text":"防水卷材铺贴工","children":[]},{"id":357,"dict_type":"worker_sub_skill","dict_text":"防水砂浆涂抹工","children":[]},{"id":358,"dict_type":"worker_sub_skill","dict_text":"聚脲喷涂工","children":[]},{"id":359,"dict_type":"worker_sub_skill","dict_text":"聚脲设备工","children":[]}]},{"id":305,"dict_text":"耐蚀地坪","children":[{"id":360,"dict_type":"worker_sub_skill","dict_text":"耐蚀地坪配料工","children":[]},{"id":361,"dict_type":"worker_sub_skill","dict_text":"耐蚀地坪刮涂工","children":[]},{"id":362,"dict_type":"worker_sub_skill","dict_text":"聚脲地坪喷涂工","children":[]}]},{"id":306,"dict_text":"阴极保护","children":[{"id":363,"dict_type":"worker_sub_skill","dict_text":"阴极保护安装工","children":[]}]},{"id":307,"dict_text":"其他","children":[{"id":364,"dict_type":"worker_sub_skill","dict_text":"施工员","children":[]},{"id":365,"dict_type":"worker_sub_skill","dict_text":"安全员","children":[]},{"id":366,"dict_type":"worker_sub_skill","dict_text":"质检员","children":[]},{"id":367,"dict_type":"worker_sub_skill","dict_text":"材料员","children":[]},{"id":368,"dict_type":"worker_sub_skill","dict_text":"资料员","children":[]},{"id":369,"dict_type":"worker_sub_skill","dict_text":"机械员","children":[]}]}],"team_skill":[{"id":45,"dict_text":"保温保冷","children":[{"id":51,"dict_type":"team_sub_skill","dict_text":"包棉","children":[]},{"id":52,"dict_type":"team_sub_skill","dict_text":"保温浇注","children":[]},{"id":53,"dict_type":"team_sub_skill","dict_text":"保温衬里","children":[]},{"id":54,"dict_type":"team_sub_skill","dict_text":"聚氨酯发泡","children":[]},{"id":55,"dict_type":"team_sub_skill","dict_text":"架子工","children":[]},{"id":56,"dict_type":"team_sub_skill","dict_text":"外护","children":[]}]},{"id":46,"dict_text":"防腐","children":[{"id":57,"dict_type":"team_sub_skill","dict_text":"喷砂","children":[]},{"id":370,"dict_type":"team_sub_skill","dict_text":"化学除锈","children":[]},{"id":371,"dict_type":"team_sub_skill","dict_text":"机械除锈","children":[]},{"id":372,"dict_type":"team_sub_skill","dict_text":"涂装","children":[]},{"id":373,"dict_type":"team_sub_skill","dict_text":"玻璃钢","children":[]},{"id":374,"dict_type":"team_sub_skill","dict_text":"砖板","children":[]},{"id":375,"dict_type":"team_sub_skill","dict_text":"橡胶","children":[]},{"id":376,"dict_type":"team_sub_skill","dict_text":"塑料","children":[]},{"id":377,"dict_type":"team_sub_skill","dict_text":"电化学","children":[]},{"id":378,"dict_type":"team_sub_skill","dict_text":"防腐地坪","children":[]},{"id":379,"dict_type":"team_sub_skill","dict_text":"金属喷涂","children":[]},{"id":380,"dict_type":"team_sub_skill","dict_text":"非金属喷涂","children":[]},{"id":381,"dict_type":"team_sub_skill","dict_text":"机械清洗","children":[]},{"id":382,"dict_type":"team_sub_skill","dict_text":"化学清洗","children":[]},{"id":383,"dict_type":"team_sub_skill","dict_text":"高空","children":[]},{"id":384,"dict_type":"team_sub_skill","dict_text":"耐能混凝土","children":[]}]},{"id":47,"dict_text":"防水","children":[{"id":385,"dict_type":"team_sub_skill","dict_text":"防水","children":[]}]}],"device_type":[{"id":120,"dict_text":"表面处理","children":[{"id":121,"dict_type":"device_sub_type","dict_text":"空压机","children":[]},{"id":263,"dict_type":"device_sub_type","dict_text":"喷砂机","children":[]},{"id":264,"dict_type":"device_sub_type","dict_text":"抛丸机","children":[]},{"id":265,"dict_type":"device_sub_type","dict_text":"角向抛光机","children":[]}]},{"id":266,"dict_text":"防腐衬里","children":[{"id":267,"dict_type":"device_sub_type","dict_text":"电火花检测仪","children":[]},{"id":268,"dict_type":"device_sub_type","dict_text":"邵氏硬度计","children":[]},{"id":269,"dict_type":"device_sub_type","dict_text":"切割机","children":[]},{"id":270,"dict_type":"device_sub_type","dict_text":"塑料焊接机","children":[]}]},{"id":271,"dict_text":"绝热","children":[{"id":272,"dict_type":"device_sub_type","dict_text":"剪板机","children":[]},{"id":273,"dict_type":"device_sub_type","dict_text":"压边机","children":[]},{"id":274,"dict_type":"device_sub_type","dict_text":"滚圆机","children":[]},{"id":275,"dict_type":"device_sub_type","dict_text":"咬边机","children":[]},{"id":276,"dict_type":"device_sub_type","dict_text":"聚氨酯喷涂机","children":[]},{"id":277,"dict_type":"device_sub_type","dict_text":"手电钻","children":[]},{"id":278,"dict_type":"device_sub_type","dict_text":"起线机","children":[]}]},{"id":279,"dict_text":"涂装","children":[{"id":280,"dict_type":"device_sub_type","dict_text":"喷涂机","children":[]},{"id":281,"dict_type":"device_sub_type","dict_text":"干（湿）膜测厚仪","children":[]},{"id":282,"dict_type":"device_sub_type","dict_text":"漆膜划格器","children":[]},{"id":283,"dict_type":"device_sub_type","dict_text":"粘度计","children":[]},{"id":284,"dict_type":"device_sub_type","dict_text":"聚脲喷涂机","children":[]}]},{"id":285,"dict_text":"清洗","children":[{"id":286,"dict_type":"device_sub_type","dict_text":"高压清洗机","children":[]}]},{"id":287,"dict_text":"常用设备","children":[{"id":288,"dict_type":"device_sub_type","dict_text":"电焊机","children":[]},{"id":289,"dict_type":"device_sub_type","dict_text":"风机","children":[]}]}],"cert_fee":[{"id":209,"dict_text":"1-2万元","children":[]},{"id":210,"dict_text":"2-3万元","children":[]},{"id":211,"dict_text":"3-4万元","children":[]},{"id":212,"dict_text":"4-5万元","children":[]},{"id":213,"dict_text":"5-10万元","children":[]}],"cert_type":[{"id":214,"dict_text":"二级建造师","children":[{"id":217,"dict_type":"cert_sub_type","dict_text":"建筑工程","children":[]},{"id":218,"dict_type":"cert_sub_type","dict_text":"机电安装","children":[]},{"id":219,"dict_type":"cert_sub_type","dict_text":"市政工程","children":[]},{"id":220,"dict_type":"cert_sub_type","dict_text":"水利水电工程","children":[]},{"id":221,"dict_type":"cert_sub_type","dict_text":"公路工程","children":[]},{"id":222,"dict_type":"cert_sub_type","dict_text":"矿业工程","children":[]}]},{"id":215,"dict_text":"九大员","children":[{"id":223,"dict_type":"cert_sub_type","dict_text":"施工员(土建和安装)","children":[]},{"id":224,"dict_type":"cert_sub_type","dict_text":"质量员","children":[]},{"id":225,"dict_type":"cert_sub_type","dict_text":"安全员","children":[]},{"id":226,"dict_type":"cert_sub_type","dict_text":"材料员","children":[]},{"id":227,"dict_type":"cert_sub_type","dict_text":"预算员","children":[]},{"id":228,"dict_type":"cert_sub_type","dict_text":"机械员","children":[]},{"id":229,"dict_type":"cert_sub_type","dict_text":"资料员","children":[]},{"id":230,"dict_type":"cert_sub_type","dict_text":"标准员","children":[]}]},{"id":216,"dict_text":"技术工人","children":[{"id":231,"dict_type":"cert_sub_type","dict_text":"电工","children":[]},{"id":232,"dict_type":"cert_sub_type","dict_text":"焊工","children":[]},{"id":233,"dict_type":"cert_sub_type","dict_text":"架子工","children":[]},{"id":234,"dict_type":"cert_sub_type","dict_text":"防水工","children":[]},{"id":235,"dict_type":"cert_sub_type","dict_text":"油漆工","children":[]},{"id":236,"dict_type":"cert_sub_type","dict_text":"抹灰工","children":[]},{"id":237,"dict_type":"cert_sub_type","dict_text":"设备安装工","children":[]},{"id":238,"dict_type":"cert_sub_type","dict_text":"管道工","children":[]},{"id":239,"dict_type":"cert_sub_type","dict_text":"通风工","children":[]},{"id":240,"dict_type":"cert_sub_type","dict_text":"水暖工","children":[]},{"id":241,"dict_type":"cert_sub_type","dict_text":"砌筑工","children":[]}]}],"expert_skill":[{"id":257,"dict_text":"涂料涂装","children":[]},{"id":407,"dict_text":"橡胶衬里","children":[]},{"id":408,"dict_text":"耐酸砖板衬里","children":[]},{"id":409,"dict_text":"玻璃钢衬里","children":[]},{"id":410,"dict_text":"塑胶衬里","children":[]},{"id":411,"dict_text":"金属喷涂","children":[]},{"id":412,"dict_text":"非金属喷涂","children":[]},{"id":413,"dict_text":"电化学保护","children":[]},{"id":414,"dict_text":"清洗","children":[]},{"id":415,"dict_text":"绝热","children":[]},{"id":416,"dict_text":"防水","children":[]},{"id":417,"dict_text":"地坪防腐","children":[]}],"edu":[{"id":258,"dict_text":"小学","children":[]},{"id":259,"dict_text":"初中","children":[]},{"id":418,"dict_text":"中职/高中","children":[]},{"id":419,"dict_text":"专科/本科","children":[]},{"id":420,"dict_text":"硕士研究生","children":[]},{"id":421,"dict_text":"博士研究生","children":[]}],"labour_cert":[{"id":422,"dict_text":"电工","children":[]},{"id":423,"dict_text":"焊工","children":[]},{"id":424,"dict_text":"架子工","children":[]},{"id":425,"dict_text":"防水工","children":[]},{"id":426,"dict_text":"油漆工","children":[]},{"id":427,"dict_text":"抹灰工","children":[]},{"id":428,"dict_text":"设备安装工","children":[]},{"id":429,"dict_text":"管道工","children":[]},{"id":430,"dict_text":"通风工","children":[]},{"id":431,"dict_text":"水暖工","children":[]},{"id":432,"dict_text":"砌筑工等","children":[]}],"req_type":[{"id":433,"dict_text":"电话咨询","children":[]},{"id":434,"dict_text":"工艺方案撰写","children":[]},{"id":435,"dict_text":"招投标方案撰写","children":[]},{"id":436,"dict_text":"现场服务","children":[]}],"device_quality":[{"id":437,"dict_text":"全新","children":[]},{"id":438,"dict_text":"九成新","children":[]},{"id":439,"dict_text":"八成新","children":[]},{"id":440,"dict_text":"七成新","children":[]},{"id":441,"dict_text":"六成新","children":[]}],"sort_worker":[{"id":442,"dict_text":"默认排序","children":[]},{"id":443,"dict_text":"工人报价","children":[]},{"id":444,"dict_text":"工人工龄","children":[]}],"sort_team":[{"id":445,"dict_text":"默认排序","children":[]},{"id":446,"dict_text":"班组报价","children":[]},{"id":447,"dict_text":"班组人数","children":[]}],"sort_worker_employ":[{"id":448,"dict_text":"默认排序","children":[]},{"id":449,"dict_text":"工人报价","children":[]},{"id":450,"dict_text":"工人工龄","children":[]}],"sort_team_employ":[{"id":451,"dict_text":"默认排序","children":[]},{"id":452,"dict_text":"班组报价","children":[]},{"id":453,"dict_text":"班组人数","children":[]}]}
     */

    private int has_update;
    private int dict_version;
    private DictBean dict;

    protected UpdateDict(Parcel in) {
        has_update = in.readInt();
        dict_version = in.readInt();
    }

    public static final Creator<UpdateDict> CREATOR = new Creator<UpdateDict>() {
        @Override
        public UpdateDict createFromParcel(Parcel in) {
            return new UpdateDict(in);
        }

        @Override
        public UpdateDict[] newArray(int size) {
            return new UpdateDict[size];
        }
    };

    public int getHas_update() {
        return has_update;
    }

    public void setHas_update(int has_update) {
        this.has_update = has_update;
    }

    public int getDict_version() {
        return dict_version;
    }

    public void setDict_version(int dict_version) {
        this.dict_version = dict_version;
    }

    public DictBean getDict() {
        return dict;
    }

    public void setDict(DictBean dict) {
        this.dict = dict;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(has_update);
        dest.writeInt(dict_version);
    }

    public static class DictBean {
        private List<IndustryBean> industry;
        private List<WorkerSkillBean> worker_skill;
        private List<TeamSkillBean> team_skill;
        private List<DeviceTypeBean> device_type;
        private List<CertFeeBean> cert_fee;
        private List<CertTypeBean> cert_type;
        private List<ExpertSkillBean> expert_skill;
        private List<EduBean> edu;
        private List<LabourCertBean> labour_cert;
        private List<ReqTypeBean> req_type;
        private List<DeviceQualityBean> device_quality;
        private List<SortWorkerBean> sort_worker;
        private List<SortTeamBean> sort_team;
        private List<SortWorkerEmployBean> sort_worker_employ;
        private List<SortTeamEmployBean> sort_team_employ;

        public List<IndustryBean> getIndustry() {
            return industry;
        }

        public void setIndustry(List<IndustryBean> industry) {
            this.industry = industry;
        }

        public List<WorkerSkillBean> getWorker_skill() {
            return worker_skill;
        }

        public void setWorker_skill(List<WorkerSkillBean> worker_skill) {
            this.worker_skill = worker_skill;
        }

        public List<TeamSkillBean> getTeam_skill() {
            return team_skill;
        }

        public void setTeam_skill(List<TeamSkillBean> team_skill) {
            this.team_skill = team_skill;
        }

        public List<DeviceTypeBean> getDevice_type() {
            return device_type;
        }

        public void setDevice_type(List<DeviceTypeBean> device_type) {
            this.device_type = device_type;
        }

        public List<CertFeeBean> getCert_fee() {
            return cert_fee;
        }

        public void setCert_fee(List<CertFeeBean> cert_fee) {
            this.cert_fee = cert_fee;
        }

        public List<CertTypeBean> getCert_type() {
            return cert_type;
        }

        public void setCert_type(List<CertTypeBean> cert_type) {
            this.cert_type = cert_type;
        }

        public List<ExpertSkillBean> getExpert_skill() {
            return expert_skill;
        }

        public void setExpert_skill(List<ExpertSkillBean> expert_skill) {
            this.expert_skill = expert_skill;
        }

        public List<EduBean> getEdu() {
            return edu;
        }

        public void setEdu(List<EduBean> edu) {
            this.edu = edu;
        }

        public List<LabourCertBean> getLabour_cert() {
            return labour_cert;
        }

        public void setLabour_cert(List<LabourCertBean> labour_cert) {
            this.labour_cert = labour_cert;
        }

        public List<ReqTypeBean> getReq_type() {
            return req_type;
        }

        public void setReq_type(List<ReqTypeBean> req_type) {
            this.req_type = req_type;
        }

        public List<DeviceQualityBean> getDevice_quality() {
            return device_quality;
        }

        public void setDevice_quality(List<DeviceQualityBean> device_quality) {
            this.device_quality = device_quality;
        }

        public List<SortWorkerBean> getSort_worker() {
            return sort_worker;
        }

        public void setSort_worker(List<SortWorkerBean> sort_worker) {
            this.sort_worker = sort_worker;
        }

        public List<SortTeamBean> getSort_team() {
            return sort_team;
        }

        public void setSort_team(List<SortTeamBean> sort_team) {
            this.sort_team = sort_team;
        }

        public List<SortWorkerEmployBean> getSort_worker_employ() {
            return sort_worker_employ;
        }

        public void setSort_worker_employ(List<SortWorkerEmployBean> sort_worker_employ) {
            this.sort_worker_employ = sort_worker_employ;
        }

        public List<SortTeamEmployBean> getSort_team_employ() {
            return sort_team_employ;
        }

        public void setSort_team_employ(List<SortTeamEmployBean> sort_team_employ) {
            this.sort_team_employ = sort_team_employ;
        }

        public static class IndustryBean {
            /**
             * id : 1
             * dict_text : 冶金
             * children : [{"id":14,"dict_type":"sub_industry","dict_text":"电解锰","children":[]},{"id":20,"dict_type":"sub_industry","dict_text":"电解锌","children":[]},{"id":21,"dict_type":"sub_industry","dict_text":"电解铅","children":[]},{"id":22,"dict_type":"sub_industry","dict_text":"电解铜","children":[]},{"id":23,"dict_type":"sub_industry","dict_text":"稀有金属冶炼","children":[]},{"id":24,"dict_type":"sub_industry","dict_text":"钢铁工业","children":[]}]
             */

            private int id;
            private String dict_text;
            private List<ChildrenBean> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * id : 14
                 * dict_type : sub_industry
                 * dict_text : 电解锰
                 * children : []
                 */

                private int id;
                private String dict_type;
                private String dict_text;
                private List<?> children;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDict_type() {
                    return dict_type;
                }

                public void setDict_type(String dict_type) {
                    this.dict_type = dict_type;
                }

                public String getDict_text() {
                    return dict_text;
                }

                public void setDict_text(String dict_text) {
                    this.dict_text = dict_text;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }

        public static class WorkerSkillBean {
            /**
             * id : 32
             * dict_text : 表面处理
             * children : [{"id":38,"dict_type":"worker_sub_skill","dict_text":"打磨工","children":[]},{"id":39,"dict_type":"worker_sub_skill","dict_text":"喷砂除锈工","children":[]},{"id":40,"dict_type":"worker_sub_skill","dict_text":"喷砂设备维护工","children":[]},{"id":41,"dict_type":"worker_sub_skill","dict_text":"电工","children":[]},{"id":42,"dict_type":"worker_sub_skill","dict_text":"普工","children":[]}]
             */

            private int id;
            private String dict_text;
            public List<ChildrenBeanX> children;
            public List<WorkerSkillBean> workerChildren = new ArrayList<WorkerSkillBean>();
            public WorkerSkillBean(String dict_text) {
                this.dict_text = dict_text;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<ChildrenBeanX> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanX> children) {
                this.children = children;
            }

            public static class ChildrenBeanX {
                /**
                 * id : 38
                 * dict_type : worker_sub_skill
                 * dict_text : 打磨工
                 * children : []
                 */

                private int id;
                private String dict_type;
                private String dict_text;
                private List<?> children;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDict_type() {
                    return dict_type;
                }

                public void setDict_type(String dict_type) {
                    this.dict_type = dict_type;
                }

                public String getDict_text() {
                    return dict_text;
                }

                public void setDict_text(String dict_text) {
                    this.dict_text = dict_text;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }

        public static class TeamSkillBean {
            /**
             * id : 45
             * dict_text : 保温保冷
             * children : [{"id":51,"dict_type":"team_sub_skill","dict_text":"包棉","children":[]},{"id":52,"dict_type":"team_sub_skill","dict_text":"保温浇注","children":[]},{"id":53,"dict_type":"team_sub_skill","dict_text":"保温衬里","children":[]},{"id":54,"dict_type":"team_sub_skill","dict_text":"聚氨酯发泡","children":[]},{"id":55,"dict_type":"team_sub_skill","dict_text":"架子工","children":[]},{"id":56,"dict_type":"team_sub_skill","dict_text":"外护","children":[]}]
             */

            private int id;
            private String dict_text;
            private List<ChildrenBeanXX> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<ChildrenBeanXX> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanXX> children) {
                this.children = children;
            }

            public static class ChildrenBeanXX {
                /**
                 * id : 51
                 * dict_type : team_sub_skill
                 * dict_text : 包棉
                 * children : []
                 */

                private int id;
                private String dict_type;
                private String dict_text;
                private List<?> children;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDict_type() {
                    return dict_type;
                }

                public void setDict_type(String dict_type) {
                    this.dict_type = dict_type;
                }

                public String getDict_text() {
                    return dict_text;
                }

                public void setDict_text(String dict_text) {
                    this.dict_text = dict_text;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }

        public static class DeviceTypeBean {
            /**
             * id : 120
             * dict_text : 表面处理
             * children : [{"id":121,"dict_type":"device_sub_type","dict_text":"空压机","children":[]},{"id":263,"dict_type":"device_sub_type","dict_text":"喷砂机","children":[]},{"id":264,"dict_type":"device_sub_type","dict_text":"抛丸机","children":[]},{"id":265,"dict_type":"device_sub_type","dict_text":"角向抛光机","children":[]}]
             */

            private int id;
            private String dict_text;
            private List<ChildrenBeanXXX> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<ChildrenBeanXXX> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanXXX> children) {
                this.children = children;
            }

            public static class ChildrenBeanXXX {
                /**
                 * id : 121
                 * dict_type : device_sub_type
                 * dict_text : 空压机
                 * children : []
                 */

                private int id;
                private String dict_type;
                private String dict_text;
                private List<?> children;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDict_type() {
                    return dict_type;
                }

                public void setDict_type(String dict_type) {
                    this.dict_type = dict_type;
                }

                public String getDict_text() {
                    return dict_text;
                }

                public void setDict_text(String dict_text) {
                    this.dict_text = dict_text;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }

        public static class CertFeeBean {
            /**
             * id : 209
             * dict_text : 1-2万元
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class CertTypeBean {
            /**
             * id : 214
             * dict_text : 二级建造师
             * children : [{"id":217,"dict_type":"cert_sub_type","dict_text":"建筑工程","children":[]},{"id":218,"dict_type":"cert_sub_type","dict_text":"机电安装","children":[]},{"id":219,"dict_type":"cert_sub_type","dict_text":"市政工程","children":[]},{"id":220,"dict_type":"cert_sub_type","dict_text":"水利水电工程","children":[]},{"id":221,"dict_type":"cert_sub_type","dict_text":"公路工程","children":[]},{"id":222,"dict_type":"cert_sub_type","dict_text":"矿业工程","children":[]}]
             */

            private int id;
            private String dict_text;
            private List<ChildrenBeanXXXX> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<ChildrenBeanXXXX> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanXXXX> children) {
                this.children = children;
            }

            public static class ChildrenBeanXXXX {
                /**
                 * id : 217
                 * dict_type : cert_sub_type
                 * dict_text : 建筑工程
                 * children : []
                 */

                private int id;
                private String dict_type;
                private String dict_text;
                private List<?> children;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDict_type() {
                    return dict_type;
                }

                public void setDict_type(String dict_type) {
                    this.dict_type = dict_type;
                }

                public String getDict_text() {
                    return dict_text;
                }

                public void setDict_text(String dict_text) {
                    this.dict_text = dict_text;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }

        public static class ExpertSkillBean {
            /**
             * id : 257
             * dict_text : 涂料涂装
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class EduBean {
            /**
             * id : 258
             * dict_text : 小学
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class LabourCertBean {
            /**
             * id : 422
             * dict_text : 电工
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class ReqTypeBean {
            /**
             * id : 433
             * dict_text : 电话咨询
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class DeviceQualityBean {
            /**
             * id : 437
             * dict_text : 全新
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class SortWorkerBean {
            /**
             * id : 442
             * dict_text : 默认排序
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class SortTeamBean {
            /**
             * id : 445
             * dict_text : 默认排序
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class SortWorkerEmployBean {
            /**
             * id : 448
             * dict_text : 默认排序
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }

        public static class SortTeamEmployBean {
            /**
             * id : 451
             * dict_text : 默认排序
             * children : []
             */

            private int id;
            private String dict_text;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDict_text() {
                return dict_text;
            }

            public void setDict_text(String dict_text) {
                this.dict_text = dict_text;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }
    }
}
