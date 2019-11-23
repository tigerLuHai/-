/* order status */
var webProjRoot = "/"
var webProjPort = 5577
//var webProjRoot = "/"
var CarStaus = new Object();
CarStaus.LINEOFF = "100";
CarStaus.LINEOFF_MSG = "车企扫码下线";
CarStaus.IN1 = "200";
CarStaus.IN1_MSG = "车企扫码入库";
CarStaus.OUT1 = "300";
CarStaus.OUT1_MSG = "车企扫码出库";
CarStaus.IN2 = "400";
CarStaus.IN2_MSG = "经销商扫码入库";
CarStaus.OUT2 = "500";
CarStaus.OUT2_MSG = "销售扫码出库";
CarStaus.OWNERBIND = "600";
CarStaus.OWNERBIND_MSG = "车主绑定";
CarStaus.REPAIRE = "700";
CarStaus.REPAIRE_MSG = "维修";
/* order type*/
var ISEnum = new Object();
ISEnum.YES = "200";
ISEnum.YES_MSG = "是";
ISEnum.NO = "300";
ISEnum.NO_MSG = "否";
/* Model name */
var ModelEnum = new Object();
ModelEnum.REGIST_PROJ = "101";
ModelEnum.REGIST_PROJ_MSG = "进入项目";
ModelEnum.LOGOUT_PROJ = "102";
ModelEnum.LOGOUT_PROJ_MSG = "退出项目";
ModelEnum.MERGE_PROJ = "206";
ModelEnum.MERGE_PROJ_MSG = "项目合并";
ModelEnum.RELATION_PROJ = "207";
ModelEnum.RELATION_PROJ_MSG = "项目关联";
ModelEnum.MULTI_PROJ = "209";
ModelEnum.MULTI_PROJ_MSG = "项目多方管理";
ModelEnum.MULTI_PROJ_EDIT = "211";
ModelEnum.MULTI_PROJ_EDIT_MSG = "项目多方编辑";
ModelEnum.GROUP_PROJ = "212";
ModelEnum.GROUP_PROJ_MSG = " 项目分组";
var AuthModelEnum = new Object();
AuthModelEnum.ALL = "100";
AuthModelEnum.ALL_MSG = "所有权限";
AuthModelEnum.READ = "200";
AuthModelEnum.READ_MSG = "读权限";
AuthModelEnum.WRITH = "300";
AuthModelEnum.WRITH_MSG = "写权限";
AuthModelEnum.NO = "400";
AuthModelEnum.NO_MSG = "无权限";
var ISInContryEnum = new Object();
ISInContryEnum.INNER = "101";
ISInContryEnum.INNER_MSG = "境内";
ISInContryEnum.OUTTER = "102";
ISInContryEnum.OUTTER_MSG = "境外";