import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TarticleBean;
import com.zs.pms.po.TchannelBean;
import com.zs.pms.service.TarticleService;
import com.zs.pms.vo.QueryTarticle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestTarticle {
	@Autowired
	TarticleService ts;
	@Autowired
	QueryTarticle query;
	
	
	//批量删除测试
	//@Test
	public void deleteByIds(){
		int []ids={1,2,3};
		ts.deleteByIds(ids);
	}
	
	//修改测试
	//@Test
	public void update(){
		TarticleBean tartbean = new TarticleBean();	
		tartbean.setId(1);
		
		tartbean.setTitle("标题");
		tartbean.setAcontent("123123");
		tartbean.setAuthor("ewq12");
		TchannelBean tchannel = new TchannelBean();
		tchannel.setId(2);
		tartbean.setChannel(tchannel);
		tartbean.setIsremod(2);
		tartbean.setIshot(2);
		tartbean.setCreator(1);
		tartbean.setCreatime(new Date());
		tartbean.setUpdator(2);
		tartbean.setUpdatime(new Date());
		try {
			ts.update(tartbean);
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
		QueryTarticle query = new QueryTarticle();
		query.setId(1);
		query.setTitle("qweqwe");
		ts.queryByCon(query);
	}
	
	@Test
	public void insert(){
		TarticleBean tartbean = new TarticleBean();	
		tartbean.setId(1);
		
		tartbean.setTitle("标题");
		tartbean.setAcontent("123123");
		tartbean.setAuthor("ewq12");
		TchannelBean tchannel = new TchannelBean();
		tchannel.setId(2);
		tartbean.setChannel(tchannel);
		tartbean.setIsremod(2);
		tartbean.setIshot(2);
		tartbean.setCreator(1);
		tartbean.setCreatime(new Date());
		tartbean.setUpdator(2);
		tartbean.setUpdatime(new Date());
		try {
			ts.insert(tartbean);
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
		ts.queryById(1);
	}
	
	//删除一条
	//@Test
	public void delete() throws AppException {
		ts.delete(1);
	}
	
	//查分页
	//@Test
	public void queryByPage() {
		QueryTarticle query = new QueryTarticle();
		System.out.println("当前总页数："+ts.queryCount(query));
		for(TarticleBean tart :ts.queryByPage(query, 2) ){
			System.out.println(tart.getTitle());
		}
	}
	
	//查询总数
	//@Test
	public void queryCount() {
		ts.queryCount(query);
	}
}
