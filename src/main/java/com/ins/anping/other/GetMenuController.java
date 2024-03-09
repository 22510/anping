//package com.ins.anping.controller.other;
//
//
//import com.ins.anping.utils.GetMenuTools;
//import com.ins.anping.utils.JwtToken;
//import com.sun.xml.internal.bind.v2.TODO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.*;
//
//
//// TODO: 不理解这里是在干什么...
//
///**
// * 执行ng命令，建立相应的模块和组件
// *
// * @author cmx
// *
// */
//@RestController
//@EnableAutoConfiguration
//@RequestMapping(value = "/api", produces = "application/json; charset=utf-8")
//public class GetMenuController {
//
//	@Autowired
//	JwtToken jwtToken;
//
//	/**
//	 * 取出指定key，指定field下的 value，将value返回
//	 * @param request
//	 * @param response
//	 * @param map      // key, field为指定的
//	 * @return
//	 */
//	@RequestMapping(value = "/busi/getmenus", method = RequestMethod.POST)
//	public Object getMenus(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> map) {
////		String projName = request.getAttribute("prj").toString();
////		String dbname = cmxConf.cdDatabase.getOne("select database()");
////		logger.info("当前database:" + dbname);
////		cmxConf.cdDatabase.execute("use " + dbname);
////		if(!projName.equals(dbname)) {
////			logger.info("当前项目：" + projName + " 不同与当前database:" + dbname);
////		}
//		// 获取当前项目信息
//	//	Map<String, String> projMap = cmxConf.redisHashTools.getProj();
////		String info = cmxConf.redisHashTools.getProj().get("proj");
////		Map<String, String> projMap = CmxJson.getMap(info);
////		projMap.put("database", cmxConf.cdDatabase.getOne("select database()"));
////		logger.info(projMap);
////		logger.info(x.get("name"));
////		// {"name":"oilfield21","desc":"油田措施效果评价系统22221","projs":[{"name":"xxyy","desc":"xxyy宿舍管理项目"} ....
////		@SuppressWarnings("unchecked")
////		Map<String, Object> projMap = (Map<String, Object>) JSON.parse(x.get("name"));
////		String runStr = cmxConf.redisHashTools.hget("sysconfig", "运行项");
////		List<Map<String, Object>> runlm = CmxJson.getLmo(runStr);
//
//		// 获取所有项目信息，用于切换项目
//		List<Map<String, Object>> projlm = cmxConf.redisHashTools.getProjs();
//		String key = map.get("key").toString();
//		String field = map.get("field").toString();
//		String s = cmxConf.redisHashTools.hget(key, field);
//		List<Map<String, Object>> root = CmxJson.getLmo(s);
//		String roleId = request.getAttribute("rid").toString();
//	    if(roleId.equals("9999")) {
//			List<Map<String, Object>> menus = GetMenuTools.genNewMenus(root, null, null, null);
//			//	List<Map<String, Object>> menus = getMenu(request.getAttribute("rid").toString(), request.getAttribute("rol").toString(), root);
//			//	logger.info(s);
//			return getRetMap(request, menus, projMap, projlm, runlm);
//	    }else {
//		// 根据模块分配中的角色，获取模块名列表，用于过滤菜单树中的结点
//		String sql = moduleSqlCfg + "'" + roleId + "'";  //    ShenHeLiuCheng  mokuaifenpei
//		logger.info(sql);
//		List<List<Object>> lls = cmxConf.cdDatabase.getListList(sql);
//		Map<String, Integer> filterMap = new HashMap<String, Integer>();
//		for(List<Object> ls : lls) {
//			for(String mName : ls.get(0).toString().split(",")) {
//				filterMap.put(mName, filterMap.containsKey(mName)? filterMap.get(mName)+1: 1);
//			}
//		}
//
//		// 根据审核流程中的角色，获取业务名称对应的审核列表，用于增加菜单树中的结点
//		sql = auditSqlCfg + "'" + request.getAttribute("rol").toString() + "' order by YeWuMingCheng";   //shenHeLiuCheng
//		logger.info(sql);
//		lls = cmxConf.cdDatabase.getListList(sql);
//
//		Map<String, List<String>> addMap = new HashMap<String, List<String>>();
//		Map<String, List<String>> viewMap = new HashMap<String, List<String>>();
//
//		if(lls!=null && lls.size()>0) {
//			List<String> ls = new ArrayList<String>();
//			List<String> viewls = new ArrayList<String>();
//
//			String busiName = lls.get(0).get(1).toString();
//			for(List<Object> ls1 : lls) {  // 在多行记录遍历
//				if(ls1.get(0)!=null && ls1.get(0).toString().trim().length()>0) {ls.add(ls1.get(0).toString());} // 审核名称
//				if(ls1.get(2)!=null && ls1.get(2).toString().trim().length()>0) {viewls.add(ls1.get(2).toString());} // 审核查询名称
//			}
//			addMap.put(busiName, ls);
//			viewMap.put(busiName, viewls);
//		}
//		logger.info("需要增加的菜单名：" + addMap);
//		logger.info("需要增加的审核查询菜单名：" + viewMap);
//		List<Map<String, Object>> menus = GetMenuTools.genNewMenus(root, filterMap, addMap, viewMap);
//		//	List<Map<String, Object>> menus = getMenu(request.getAttribute("rid").toString(), request.getAttribute("rol").toString(), root);
//		//	logger.info(s);
//		return getRetMap(request, menus, projMap, projlm, runlm);
//	    }
//	}
//
//	private Map<String, Object> getRetMap(HttpServletRequest request, Object obj, Map<String, String> projMap, List<Map<String, Object>> projlm, List<Map<String, Object>> runlm) {
//		Map<String, Object> retMap = new LinkedHashMap<String, Object>();
//		retMap.put("msg", "ok");
//		retMap.put("code", 0);
//		retMap.put("user", request.getAttribute("usr"));
//		retMap.put("role", request.getAttribute("rol"));
//		retMap.put("data", obj);
//		retMap.put("proj", projMap);   // 当前项目信息
////		retMap.put("projs", projlm);
//		retMap.put("runs", runlm);
//		return retMap;
//	}
//
//	// ============================ 获取菜单（根据角色过滤） =========================
//	@SuppressWarnings({ "unchecked", "unused" })
//	private List<Map<String, Object>> getMenu(String rid, String roleName, List<Map<String, Object>> root) {
//        // 以下为模块分配中，得到的模块列表（根据角色）
//        List<String> mkList = new ArrayList<String>();
//        // 从模块分配中，找出所有菜单的集合
//        String sql = moduleSqlCfg + rid;
//        logger.info(sql);
//        List<List<Object>> llo = cmxConf.cdDatabase.getListList(sql);
//        for(List<Object> lo : llo) {
//       // 	System.out.println("lo=" + lo);
//        	mkList.addAll(java.util.Arrays.asList(lo.get(0).toString().split(",")));
//        }
//        logger.info("模块分配库中：" + mkList);
//
//        // 从审核流程，审核流程明细表中，获取附加的菜单
//        sql = auditFlowSqlCfg;
//        logger.info(sql);
//        llo = cmxConf.cdDatabase.getListList(sql);
//
//        List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
//		for(Object mainMenuInfo : root) {
//        	List<Map<String, String>> lmChild = getChildMenu(mainMenuInfo, mkList, llo, roleName);
//        	if(lmChild.size()==0) {continue;}
//        	Map<String, Object> map = new LinkedHashMap<String, Object>();
//        	Object mainMenu = ((Map<String, Object>) mainMenuInfo).get("menu");
//        	map.put("text", ((Map<String, Object>) mainMenuInfo).get("menu"));
//        	map.put("image", cmxConf.redisHashTools.hget("字典信息", mainMenu.toString()) + ".png");
//        	map.put("children", lmChild);
//        	lm.add(map);
//        }
//    	return lm;
//    }
//
//	/**
//	 *  根据主菜单，在配置中取出其所有孩子, 然后根据 某角色对应的模块列表，形成此角色的主菜单对应子菜单 llo 为附加的菜单（根据审核流程）
//	 * @param mainMenuInfo  一个主菜单的信息
//	 * @param mkList  模块分配找到的列表
//	 * @param llo 为附加的菜单（根据审核流程）
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	private List<Map<String, String>> getChildMenu(Object mainMenuInfo, List<String> mkList, List<List<Object>> llo, String roleName) {
//		List<Map<String, String>> lmChild = new ArrayList<Map<String, String>>();
//		for(String zhSubMenu : (List<String>)((Map<String, Object>) mainMenuInfo).get("children")) {
//			if(!mkList.contains(zhSubMenu)) {continue;}
//			Map<String, String> mapChild = new LinkedHashMap<String, String>();
//			mapChild.put("text", zhSubMenu);
//			mapChild.put("state", "open");
//			mapChild.put("type",getContentType(zhSubMenu));  //????????
//			mapChild.put("color", "red");
//			if("masterslave".equals(mapChild.get("type"))) {
//				String slaveInfo = cmxConf.redisHashTools.hget("配置信息", zhSubMenu + ".从表信息");
//				String table2 = cmxConf.redisHashTools.hget("字典信息", slaveInfo);
//				mapChild.put("table2", table2);
//				mapChild.put("hztable2", slaveInfo);
//			}
//			mapChild.put("link",  cmxConf.redisHashTools.hget("字典信息", zhSubMenu));
//			mapChild.put("image", cmxConf.redisHashTools.hget("字典信息",zhSubMenu) + ".png");
//			lmChild.add(mapChild);
//			 // 遍历审核附加的菜单
//			for(List<Object> lo: llo) {
//				if(lo.get(2).toString().trim().equals(zhSubMenu)) {    // 表名匹配上了
//					String idStr = lo.get(0).toString().trim();
//					String moduleName = lo.get(1).toString().trim();
//					String sql = auditDetailSqlCfg + "'" + moduleName + "'";
//					logger.info(sql);
//			        List<List<Object>> myllo = cmxConf.cdDatabase.getListList(sql);
//			        int i=0;
//			        for(List<Object> x : myllo) {
//			       // 	System.out.println("lo=" + lo);
//			       // 	mkList.addAll(java.util.Arrays.asList(lo.get(0).toString().split(",")));
//			        	String selfType = (x.get(4)!=null && x.get(4).toString().trim().length()>0)? x.get(4).toString().trim(): "全部";
//			        	if(x.get(1)!=null && x.get(1).toString().trim().equals(roleName)) {
//			        		addAuditMap(lmChild, idStr, zhSubMenu, i, x, selfType);
//			        	}
//			        	i++;
//			        }
//				}
//			}
//		}
//		return lmChild;
//	}
//
//	private void addAuditMap(List<Map<String, String>> lmChild, String idStr, String zhSubMenu, int index, List<Object> lo, String selfType) {
//		Map<String, String> addAuditMap = new LinkedHashMap<String, String>();
//		// 如果模块别名为空，则在汉字表名基础上，增加审核二字
//		String hzMenu = lo.get(2)==null || lo.get(2).toString().trim().length()<1 || lo.get(2).toString().trim().toUpperCase().equals("NULL")? (zhSubMenu + ("个人提交".equals(selfType)? "提交": "审核")): lo.get(2).toString().trim();
//		// 审核业务查询
//		Boolean viewFlag = lo.get(3)!=null && lo.get(3).toString().trim().length()>0 && lo.get(3).toString().trim().equals("是");
//		addAuditMap.put("text", hzMenu);
//		addAuditMap.put("id", idStr);
//		addAuditMap.put("flowno", index+"");
//		addAuditMap.put("state", "open");
//		addAuditMap.put("type", "auditflow");  //审核流程
//		addAuditMap.put("selftype", selfType);
//		addAuditMap.put("color", "green");
//		addAuditMap.put("link",  cmxConf.redisHashTools.hget("字典信息", zhSubMenu));
//		addAuditMap.put("image", cmxConf.redisHashTools.hget("字典信息",zhSubMenu) + ".png");
//		logger.info("in add audit: mapChild=" + addAuditMap);
//		lmChild.add(addAuditMap);
//		if(viewFlag) {
//			Map<String, String> viewAuditMap = new LinkedHashMap<String, String>();
//			// 如果模块别名为空，则在汉字表名基础上，增加审核二字
//			// String hzMenu = lo.get(4)==null || lo.get(4).toString().trim().length()<1 || lo.get(4).toString().trim().toUpperCase().equals("NULL")? (zhSubMenu + (index==0? "提交": "审核")): lo.get(4).toString().trim();
//			// 审核业务查询
//			viewAuditMap.put("text", zhSubMenu + ("个人提交".equals(selfType)? "查看": "查询"));
//			viewAuditMap.put("id", idStr);
//			viewAuditMap.put("flowno", index+"");
//			viewAuditMap.put("state", "open");
//			viewAuditMap.put("type", "auditview");  //审核流程查看
//			viewAuditMap.put("selftype", selfType);
//			viewAuditMap.put("color", "green");
//			viewAuditMap.put("link",  cmxConf.redisHashTools.hget("字典信息", zhSubMenu));
//			viewAuditMap.put("image", cmxConf.redisHashTools.hget("字典信息",zhSubMenu) + ".png");
//			logger.info("in add audit: viewAuditMap=" + viewAuditMap);
//			lmChild.add(viewAuditMap);
//		}
//	}
//
//	private String getContentType(String zhSubMenu) {
//		String contentType = "table";
//		String beginOper = cmxConf.redisHashTools.hget("配置信息", zhSubMenu + ".初始操作");
//		String slaveInfo = cmxConf.redisHashTools.hget("配置信息", zhSubMenu + ".从表信息");
//		if(!"not_exists".equals(slaveInfo)) {
//			contentType="masterslave";
//		}else {
//			if("柱状图".equals(beginOper) || "bar".equals(beginOper)) {
//				contentType = "bar";
//			}
//			if("饼状图".equals(beginOper) || "pan".equals(beginOper)) {
//				contentType = "pan";
//			}
//		}
//		System.out.println("菜单：" + zhSubMenu + " beginOper=" + beginOper + " slaveInfo=" + slaveInfo );
//		return contentType;
//	}
//
////	jwtkey=msg value=Token正常!
////			jwtkey=rds value=2
////			jwtkey=uid value=1063
////			jwtkey=code value=0
////			jwtkey=usr value=zhangz
////			jwtkey=prj value=cmxjinx
////			jwtkey=rid value=7
////			jwtkey=rol value=财务部经理
//	// 如果能走到这个controller，说明过滤器判断成功
//	@RequestMapping(value = "/busi/menus", method = RequestMethod.GET)
//	public Object getMenus(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Map<String, Object> map = new LinkedHashMap<String, Object>();
//		Object userName = request.getAttribute("usr");
//	//	String roleName = request.getAttribute("rol").toString();
//
//		if(userName==null || userName.toString().trim().length()==0) {
//			map.put("code", "-99");
//			map.put("msg", "用户名不能为空，请重新登录!");
//	    	logger.info("获取菜单：" + map.get("msg"));
//			return map;
//		}
//		logger.info("开始取菜单信息：" + userName + " -- " + request.getAttribute("rol"));
//    	map.put("username", userName);
//    	map.put("role", request.getAttribute("rol").toString());
//		// TODO
//    //	map.put("sysmenu", getMenu(request.getAttribute("rds").toString(), request.getAttribute("prj").toString(), request.getAttribute("rid").toString(), request.getAttribute("rol").toString()));
//    	logger.info("菜单：" + map);
//		logger.info("取菜单信息结束：" + request.getAttribute("usr") + "\n");
//		return map;
//	}
//}
