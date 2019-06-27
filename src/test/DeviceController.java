

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceExample;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/6/26 16:38
 * @Description TODO
 */
@ContextConfiguration(locations = "classpath:application.xml")
@Controller
@RequestMapping("device")
public class DeviceController {

  /*  @Autowired
    DeviceService deviceService;


    @Test
    @RequestMapping("/deviceList")
    @ResponseBody
    public void addDevice(){
        Device device = deviceService.queryDeviceById("001");
        System.out.println("device = " + device);

    }*/
}
