# tantanwen
java spring的代码  
  
## 名词说明  
*import static（静态导入）*  
```
是JDK1.5中的新特性，
一般我们导入一个类都用 import com.....ClassName;
而静态导入是这样：import static com.....ClassName.*;
这里多了个static，还有就是类名ClassName后面多了个 .* ，
意思是导入这个类里的静态方法。当然，也可以只导入某个静态方法，只要把 .* 换成静态方法名就行了。
然后在这个类中，就可以直接用方法名调用静态方法，而不必用ClassName.方法名的方式来调用。
```  
  
*mockito*  
```
官网地址
http://site.mockito.org/
```  
  
*@Autowired*
```
Spring 2.5 引入了 @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 
通过 @Autowired的使用来消除 set ，get方法。
```
