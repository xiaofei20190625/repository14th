import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-spring.xml")
public class PerisonTest {
    @Autowired
    DepartmentService departmentService;
    @Test
    public void mytest1() {
        List<Department> departments = departmentService.selectAllDepartment();
        System.out.println(departments);
    }
}
