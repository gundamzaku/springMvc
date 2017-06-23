package com.tantanwen;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tantanwen.data.Spittle;
import com.tantanwen.data.SpittleRepository;
import com.tantanwen.web.HomeController;
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

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle("Spittle "+i,new Date()));
        }
        return spittles;
    }
}