import com.nowcoder.WendaApplication;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dell--pc on 2017/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WendaApplication.class)
public class test {
    @Autowired
    UserDAO userDAO;
    @Test
    public void test(){
        User user=userDAO.selectById(2);
        System.out.println(user.getName());
    }
}
