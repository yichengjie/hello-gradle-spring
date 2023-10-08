#### 使用@WebMvcTest注解
1. 编写单元测试类
   ```java
   @WebMvcTest
   class HelloControllerWebMvcTest {
       private MockMvc mockMvc;
       @MockBean
       private HelloService helloService ;
       //
       @BeforeEach
       void setup(WebApplicationContext wac) {
           this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
       }
       @Test
       void index() throws Exception {
           given(this.helloService.hello("张三")).willReturn("hello, 张三") ;
           //
           MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello/index")
                   .accept(MediaType.APPLICATION_JSON)
                   .contentType(MediaType.APPLICATION_JSON);
           mockMvc.perform(requestBuilder)
                   .andExpect(status().isOk())
                   .andExpect(content().contentType("application/json"))
                   .andDo(print()) ;
       }
   }
   ```
#### 使用@SpringJUnitWebConfig注解
1. 编写配置类
   ```java
   @Configuration
   @EnableWebMvc
   @ComponentScan(basePackages = "com.yicj.study.controller")
   public class WebMvcConfig {
       @Bean
       public HelloService helloService(){
           return new HelloServiceImpl() ;
       }
   }
   ```
2. 编写单元测试
   ```java
   @SpringJUnitWebConfig(classes = WebMvcConfig.class)
   class HelloControllerWebConfigTest {
       MockMvc mockMvc;
       @BeforeEach
       void setup(WebApplicationContext wac) {
           this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
       }
       @Test
       void index() throws Exception {
           MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8081/hello/index")
                   .accept(MediaType.APPLICATION_JSON)
                   .contentType(MediaType.APPLICATION_JSON);
           mockMvc.perform(requestBuilder)
                   .andExpect(status().isOk())
                   .andExpect(content().contentType("application/json"))
                   .andDo(print()) ;
       }
   }
   ```
#### 使用standaloneSetup模式
1. 编写单元测试
   ```java
   class HelloControllerStandaloneTest {
       MockMvc mockMvc;
       // 这里不能使用MockBean
       HelloService helloService ;
       @BeforeEach
       void setup() {
           helloService = new HelloServiceImpl();
           this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController(helloService))
                   //.defaultRequest(MockMvcRequestBuilders.get("/hello/index").accept(MediaType.APPLICATION_JSON))
                   .alwaysExpect(status().isOk())
                   .alwaysExpect(content().contentType("application/json"))
                   .build();
       }
       @Test
       void index() throws Exception {
           //given(this.helloService.hello("张三")).willReturn("hello, 张三") ;
           MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello/index")
                   .accept(MediaType.APPLICATION_JSON)
                   .contentType(MediaType.APPLICATION_JSON);
           mockMvc.perform(requestBuilder)
                   .andExpect(status().isOk())
                   .andExpect(content().contentType("application/json"))
                   .andDo(print()) ;
       }
   }
   ```