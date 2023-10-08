### idea中build时候中文乱码报错
1. Help -> Edit Custom VM Options 
2. 文件末尾追加：-Dfile.encoding=UTF-8
### lombok引入依赖
1. gradle 引入依赖
    ```groovy
    //lombok
    compileOnly 'org.projectlombok:lombok'//仅编译时使用，不参与打包
    annotationProcessor 'org.projectlombok:lombok'//注释处理器，如使用@Slf4j注解时
    //一般上面2个够了，下面这2个是用于JUnit单元测试时使用的，如果你使用单元测试，那么下面2个一定要加上
    testCompileOnly 'org.projectlombok:lombok'//仅测试编译时使用，不参与打包
    testAnnotationProcessor 'org.projectlombok:lombok'//仅测试时使用注释处理器，不参与打包
    ```
### 待看博客
1. https://blog.csdn.net/weixin_43333483/article/details/128067914