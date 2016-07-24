package dynamicDataSource;

import com.test.dynamicDataSource.dao.UserDao;
import com.test.dynamicDataSource.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jd on 2016/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class Test1 {
    @Autowired
    private UserDao userDao;

    @Test
    public void testInsertUser(){
//        for (int i = 0; i < 10; i++){
            User user = new User();
            user.setName("guo" + 11121);
            user.setRemark("remark" + 1);
            this.userDao.insert(user);
//        }

    }

    @Test
    public void testSelectUser(){
        User selParam = new User();
        selParam.setName("guo11121");
        List<User> user = this.userDao.select(selParam);
        System.out.println("******************" + user.size());
    }
}
