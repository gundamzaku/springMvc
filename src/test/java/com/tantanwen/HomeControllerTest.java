package com.tantanwen;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tantanwen.data.SpitterRepository;
import com.tantanwen.data.Spittle;
import com.tantanwen.data.SpittleRepository;
import com.tantanwen.web.HomeController;
import com.tantanwen.web.SpitterController;
import com.tantanwen.web.SpittleController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
/**
 * Created by dan on 2017/6/22.
 */
/*
this is use junit to test
 */
/*
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();
        assertEquals("home",controller.home());
    }
}*/

public class HomeControllerTest{
    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();

        MockMvc mockMvc =  MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }

    /*
    @Test
    public void shouldShowRecentSpitles() throws Exception{
        //创建20个对象
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);

        when(mockRepository.findSpittles(Long.MAX_VALUE,20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")
        ).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittlesOne"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
    }
    */
    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle("Spittle "+i,new Date()));
        }
        return spittles;
    }

    //@Test
    public void shouldShowPagedSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);

        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900,50)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")
        ).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=238900&count=50"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
        //hasItem：
        //assertThat(iterableObject, hasItem (element));
        //表明被测的迭代对象iterableObject含有元素element项则测试通过

    }

    @Test
    public void testSpittle() throws Exception{
        Spittle spittle = new Spittle("hello",new Date());
        List<Spittle> expectedspittle = new ArrayList<Spittle>();
        expectedspittle.add(spittle);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(1)).thenReturn(expectedspittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//        整个过程：
//        1、mockMvc.perform执行一个请求；
//        2、MockMvcRequestBuilders.get("/user/1")构造一个请求
//        3、ResultActions.andExpect添加执行完成后的断言
//        4、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
//        5、ResultActions.andReturn表示执行完成后返回相应的结果。
        //ResultMatcher用来匹配执行完请求后的结果验证，其就一个match(MvcResult result)断言方法，如果匹配失败将抛出相应的异常
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/1"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))//得到模型验证器；
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList",hasItems(expectedspittle.toArray())));
    }

    /*
    @Test
    public void shouldShowRegistration() throws Exception{
        SpitterController controller = new SpitterController(SpitterRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }*/
}