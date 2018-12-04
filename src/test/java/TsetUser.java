import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TsetUser {
	@Autowired
	UserService us;
	QueryUser query;
	//@Test
	public void testLogin(){
		QueryUser query = new QueryUser();
		query.setLoginname("caocao");
		query.setPassword("123321");
		try {
			TUser user = us.chkLogin(query);
			System.out.println(user.getRealname());
			for(TPermission per:user.getPermissions()){
				System.out.println(per.getPname());
			}
			System.out.println("————————————————————————————————整理后————————————————————————————————");
			for(TPermission per1:user.getMenu()){
				System.out.println(per1.getPname());
				for(TPermission per2 : per1.getChildren()){
					System.out.println("\t\t"+per2.getPname());
				}
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrMsg());
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	//测试
	//@Test
	/*public void testLogin2(){
		QueryUser query = new QueryUser();
		query.setLoginname("zhangfei");
		query.setPassword("123321");
		query.setIsenabled(1);
		try {
			TUser user = us.chkLogin(query);
			System.out.println(user.getRealname());
			for(TPermission per:user.getPermissions()){
				System.out.println(per.getPname());
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrMsg());
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}*/
	
	
	//批量删除测试
	//@Test
	public void deleteByIds(){
		int []ids={1,2,3};
		us.deleteByIds(ids);
	}
	
	//修改测试
	//@Test
	public void update(){
		TUser user = new TUser();	
		user.setId(4009);
		
		user.setPassword("123321");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setEmail("sanguo@qq.com");
		TDep dept = new TDep();
		dept.setId(5);
		user.setDept(dept);
		user.setRealname("吕小布");
		user.setCreator(1);
		user.setUpdator(1);
		user.setUpdatime(new Date());
		user.setPicurl("1");
		user.setIsenabled(2);
		try {
			us.update(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrMsg());
		}catch(Exception e1){
			e1.printStackTrace();
		}	
	}
	
	//不使用xml实现的根据条件查询的方法
	//@Test
	public void queryByCon(){
		QueryUser query = new QueryUser();
		query.setLoginname("zhangfei");
		query.setPassword("123321");
		us.queryByCon(query);
	}
	
	
	public void insert(){
		TUser user = new TUser();	
		user.setLoginname("sunshangxiang");
		user.setPassword("123321");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setEmail("sanguo@qq.com");
		TDep dept = new TDep();
		dept.setId(5);
		user.setDept(dept);
		user.setRealname("孙尚香");
		user.setCreator(1);
		user.setUpdator(1);
		user.setPicurl("1");
		try {
			us.insert(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrMsg());
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}

	//根据主键查询
	//@Test
	public void queryById(){
		us.queryById(4001);
	}
	
	//删除一条
	//@Test
	public void delete() throws AppException {
		us.delete(4001);
	}
	
	//查分页
	//@Test
	public void queryByPage() {
		QueryUser query = new QueryUser();
		System.out.println("当前总页数："+us.queryCount(query));
		for(TUser user :us.queryByPage(query, 2) ){
			System.out.println(user.getRealname());
		}
	}
	
	//查询总数
	//@Test
	public void queryCount() {
		System.out.println(us.queryCount(query));
	}
	
}
