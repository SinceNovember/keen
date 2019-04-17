
import java.sql.Timestamp;

import org.junit.Test;
import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.service.ArticleService;
@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})
public class Test{
	@Resource
	private ArticleService articleService;

	@Test
	public void test(){
		System.out.println(articleService.listall().get(0).getArticleTitle());
	}
}
