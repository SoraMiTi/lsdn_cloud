# lsdn_cloud
SpringCloud微服务与Maven父子组件组合使用

使用maven组件的方式 实现父组件<子组件>的嵌套

cloud目录下都是公共服务层次的实例 比如 registry,gateway,txmanager
code目录下是实现代码层次的实例
parent目录下提供各个层次的公共资源，统一引用

cloud--registry 使用eureka作为注册中心
     --gateway 网关服务,访问数据接口时，通过gateway+服务名做到负载均衡
     --txmanager 事务管理器,数据库的操作是分服务进行部署,多个服务的事务需要统一调配,否则不具备一致性

code--dbservice  放置数据库操作的服务 当前拆分服务为增删改查四个服务，可以不拆分，基于jpa的底层操作，可自行添加mybatis/jdbc或者其他数据库操作
    --logicservice 放置实际业务处理层面的东西 比如同一业务需要调用多个db实例，都在这个服务中做操作
    --model  放置数据库表对应的entity,其中有lombok插件   （使用时以jar包的形式引用）
    --utils 放置所有公共工具类（使用时以jar包的形式引用）
    
parent--spring-boot-parent 提供一个服务端所需要的jar包,其他项目中直接引用即可（cloud目录下的项目不引用这个包）
      --dbservice-parent 提供数据库服务所需要的jar包,例如oracle链接包,jpa基础包
      --model-parent 提供作为entity所需要的基本jar包 
