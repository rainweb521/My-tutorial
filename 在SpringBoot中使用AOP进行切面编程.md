

# 在SpringBoot中使用AOP进行切面编程

## 什么是AOP

AOP是OOP的延续，是Aspect Oriented Programming的缩写，意思是面向切面编程。可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。

我们现在做的一些非业务，如：日志、事务、安全等都会写在业务代码中，但这些代码往往是重复的，会给程序的维护带来不便，AOP就实现了把这些业务需求与系统需求分开来做。这种解决的方式也称代理机制。



**通知（Advice）类型：**

- **前置通知（Before advice）：**在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行。ApplicationContext中在<aop:aspect>里面使用<aop:before>元素进行声明。例如，TestAspect中的doBefore方法。
- **后置通知（After advice）：**当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。ApplicationContext中在<aop:aspect>里面使用<aop:after>元素进行声明。例如，ServiceAspect中的returnAfter方法，所以Teser中调用UserService.delete抛出异常时，returnAfter方法仍然执行。
- **返回后通知（After return advice）：**在某连接点正常完成后执行的通知，不包括抛出异常的情况。ApplicationContext中在<aop:aspect>里面使用<after-returning>元素进行声明。
- **环绕通知（Around advice）：**包围一个连接点的通知，类似Web中Servlet规范中的Filter的doFilter方法。可以在方法的调用前后完成自定义的行为，也可以选择不执行。ApplicationContext中在<aop:aspect>里面使用<aop:around>元素进行声明。例如，ServiceAspect中的around方法。
- **抛出异常后通知（After throwing advice）：**在方法抛出异常退出时执行的通知。ApplicationContext中在<aop:aspect>里面使用<aop:after-throwing>元素进行声明。例如，ServiceAspect中的returnThrow方法。

参考资料

<https://my.oschina.net/sniperLi/blog/491854>

<https://www.google.com/search?q=spring+aop%E7%9A%84%E4%BD%BF%E7%94%A8&oq=aop%E7%9A%84%E4%BD%BF%E7%94%A8&aqs=chrome.2.69i57j0l3.11653j0j1&sourceid=chrome&ie=UTF-8>

