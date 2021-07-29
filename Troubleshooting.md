# Troubleshooting

Some problems we encountered.

## GUI
### JTable不显示表头
解决方法：把JTable 放进JScrollPane中，JScrollPane设置bounds，JTable不设置。

### WebLaf 安装
在安装 [Weblaf](https://github.com/mgarin/weblaf) 时报错。

同样是JDK 9的模块平台的原因。

解决方法： 在JVM启动选项中添加：
```java
--add-opens java.base/java.util=ALL-UNNAMED
--add-opens java.base/java.text=ALL-UNNAMED
--add-opens java.base/java.lang.reflect=ALL-UNNAMED
--add-opens java.base/java.net=ALL-UNNAMED
--add-opens java.base/java.lang=ALL-UNNAMED
--add-opens java.base/jdk.internal.loader=ALL-UNNAMED
--add-opens java.desktop/javax.swing=ALL-UNNAMED
--add-opens java.desktop/javax.swing.text=ALL-UNNAMED
--add-opens java.desktop/java.awt.font=ALL-UNNAMED
--add-opens java.desktop/java.awt.geom=ALL-UNNAMED
--add-opens java.desktop/java.awt=ALL-UNNAMED
--add-opens java.desktop/java.beans=ALL-UNNAMED
--add-opens java.desktop/javax.swing.table=ALL-UNNAMED
--add-opens java.desktop/com.sun.awt=ALL-UNNAMED
--add-opens java.desktop/sun.awt=ALL-UNNAMED
--add-opens java.desktop/sun.swing=ALL-UNNAMED
--add-opens java.desktop/sun.font=ALL-UNNAMED
--add-opens java.desktop/javax.swing.plaf.basic=ALL-UNNAMED
--add-opens java.desktop/javax.swing.plaf.synth=ALL-UNNAMED
--add-opens java.desktop/com.sun.java.swing.plaf.windows=ALL-UNNAMED
--add-opens java.desktop/com.sun.java.swing.plaf.gtk=ALL-UNNAMED
--add-opens java.desktop/com.apple.laf=ALL-UNNAMED
```

在添加后运行，控制台输出警告：
```java
WARNING: package com.sun.java.swing.plaf.gtk not in java.desktop
WARNING: package com.apple.laf not in java.desktop
WARNING: package com.sun.awt not in java.desktop
```
这是因为上述JVM启动选项是为跨平台运行考虑的，一些包在Windows环境并不存在。无视警告即可。

参考：https://github.com/mgarin/weblaf#java-9

## Reflection
点击登录按钮报错：`Unable to make field private boolean java.net.Socket.closed accessible: module java.base does not "opens java.net" to unnamed module @13969fbe`

完整错误内容：
```
Exception in thread "AWT-EventQueue-0" java.lang.reflect.InaccessibleObjectException: Unable to make field private boolean java.net.Socket.closed accessible: module java.base does not "opens java.net" to unnamed module @3a19b6cd
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:357)
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)
	at java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:177)
	at java.base/java.lang.reflect.Field.setAccessible(Field.java:171)
	at com.alibaba.fastjson.util.TypeUtils.setAccessible(TypeUtils.java:2517)
	at com.alibaba.fastjson.util.FieldInfo.<init>(FieldInfo.java:196)
	at com.alibaba.fastjson.util.FieldInfo.<init>(FieldInfo.java:115)
	at com.alibaba.fastjson.util.TypeUtils.computeGetters(TypeUtils.java:2191)
	at com.alibaba.fastjson.util.TypeUtils.buildBeanInfo(TypeUtils.java:1826)
	at com.alibaba.fastjson.serializer.SerializeConfig.createJavaBeanSerializer(SerializeConfig.java:113)
	at com.alibaba.fastjson.serializer.SerializeConfig.getObjectWriter(SerializeConfig.java:821)
	at com.alibaba.fastjson.serializer.SerializeConfig.getObjectWriter(SerializeConfig.java:440)
	at com.alibaba.fastjson.serializer.JSONSerializer.getObjectWriter(JSONSerializer.java:448)
	at com.alibaba.fastjson.serializer.ASMSerializer_2_ConnectionToServer.write(Unknown Source)
	at com.alibaba.fastjson.serializer.ASMSerializer_1_Request.write(Unknown Source)
	at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
	at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
	at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
	at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
	at com.vcampus.net.Request.send(Request.java:38)
	at com.vcampus.client.Verifier.verifyStudent(Verifier.java:17)
	at com.vcampus.client.LoginUI.login(LoginUI.java:50)
	at com.vcampus.client.LoginUI$5.actionPerformed(LoginUI.java:192)
	at java.desktop/javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:1972)
	at java.desktop/javax.swing.AbstractButton$Handler.actionPerformed(AbstractButton.java:2313)
	at java.desktop/javax.swing.DefaultButtonModel.fireActionPerformed(DefaultButtonModel.java:405)
	at java.desktop/javax.swing.DefaultButtonModel.setPressed(DefaultButtonModel.java:262)
	at java.desktop/javax.swing.plaf.basic.BasicButtonListener.mouseReleased(BasicButtonListener.java:279)
	at java.desktop/java.awt.Component.processMouseEvent(Component.java:6617)
	at java.desktop/javax.swing.JComponent.processMouseEvent(JComponent.java:3342)
	at java.desktop/java.awt.Component.processEvent(Component.java:6382)
	at java.desktop/java.awt.Container.processEvent(Container.java:2264)
	at java.desktop/java.awt.Component.dispatchEventImpl(Component.java:4993)
	at java.desktop/java.awt.Container.dispatchEventImpl(Container.java:2322)
	at java.desktop/java.awt.Component.dispatchEvent(Component.java:4825)
	at java.desktop/java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:4934)
	at java.desktop/java.awt.LightweightDispatcher.processMouseEvent(Container.java:4563)
	at java.desktop/java.awt.LightweightDispatcher.dispatchEvent(Container.java:4504)
	at java.desktop/java.awt.Container.dispatchEventImpl(Container.java:2308)
	at java.desktop/java.awt.Window.dispatchEventImpl(Window.java:2773)
	at java.desktop/java.awt.Component.dispatchEvent(Component.java:4825)
	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:772)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:715)
	at java.base/java.security.AccessController.doPrivileged(AccessController.java:391)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:95)
	at java.desktop/java.awt.EventQueue$5.run(EventQueue.java:745)
	at java.desktop/java.awt.EventQueue$5.run(EventQueue.java:743)
	at java.base/java.security.AccessController.doPrivileged(AccessController.java:391)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:742)
	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)
```

`fastjson`包通过反射机制生成`connectionToServer`成员变量的`soket`成员变量的JSON String时出错。

解决方法：经调查，发现由于JDK9以后引入了Module Platform，需要在JVM启动选项中添加`--add-opens java.base/java.net=ALL-UNNAMED`。

参考： https://stackoverflow.com/questions/41265266/how-to-solve-inaccessibleobjectexception-unable-to-make-member-accessible-m

## Database
### MyBatis未能确定变量类型
商店无法列出商品。但管理员仍可以添加。说明`listGoodsByCategory`接口出错。
抛出异常：`org.apache.ibatis.exceptions.PersistenceException`
报错：
```java
org.apache.ibatis.exceptions.PersistenceException:
        ### Error querying database.  Cause: org.apache.ibatis.executor.result.ResultMapException: Error attempting to get column 'category' from result set.  Cause: java.sql.SQLDataException: Cannot determine value type from string '日用'
        ### The error may exist in resources/mapper/goodsMapper.xml
        ### The error may involve com.vcampus.dao.IGoodsMapper.listGoodsByCategory
        ### The error occurred while handling results
        ### SQL: SELECT * FROM goods WHERE `category` = ?
        ### Cause: org.apache.ibatis.executor.result.ResultMapException: Error attempting to get column 'category' from result set.  Cause: java.sql.SQLDataException: Cannot determine value type from string '日用'
        at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
        at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:150)
        at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:141)
        at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:144)
        at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:77)
        at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:58)
        at jdk.proxy1/jdk.proxy1.$Proxy5.listGoodsByCategory(Unknown Source)
        at com.vcampus.server.shop.ShopServer.listGoodsByType(ShopServer.java:68)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:78)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:567)
        at com.vcampus.server.messageQueue.RequestHandler.run(RequestHandler.java:67)
        Caused by: org.apache.ibatis.executor.result.ResultMapException: Error attempting to get column 'category' from result set.  Cause: java.sql.SQLDataException: Cannot determine value type from string '日用'
        at org.apache.ibatis.type.BaseTypeHandler.getResult(BaseTypeHandler.java:83)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.createUsingConstructor(DefaultResultSetHandler.java:672)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.createByConstructorSignature(DefaultResultSetHandler.java:655)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.createResultObject(DefaultResultSetHandler.java:618)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.createResultObject(DefaultResultSetHandler.java:591)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.getRowValue(DefaultResultSetHandler.java:397)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.handleRowValuesForSimpleResultMap(DefaultResultSetHandler.java:354)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.handleRowValues(DefaultResultSetHandler.java:328)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.handleResultSet(DefaultResultSetHandler.java:301)
        at org.apache.ibatis.executor.resultset.DefaultResultSetHandler.handleResultSets(DefaultResultSetHandler.java:194)
        at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:65)
        at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
        at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
        at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
        at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
        at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
        at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
        at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
        ... 11 more
        Caused by: java.sql.SQLDataException: Cannot determine value type from string '日用'
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:114)
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:89)
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:63)
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:73)
        at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:96)
        at com.mysql.cj.jdbc.result.ResultSetImpl.getObject(ResultSetImpl.java:1422)
        at com.mysql.cj.jdbc.result.ResultSetImpl.getInt(ResultSetImpl.java:822)
        at com.mysql.cj.jdbc.result.ResultSetImpl.getInt(ResultSetImpl.java:843)
        at com.mchange.v2.c3p0.impl.NewProxyResultSet.getInt(NewProxyResultSet.java:451)
        at org.apache.ibatis.type.IntegerTypeHandler.getNullableResult(IntegerTypeHandler.java:37)
        at org.apache.ibatis.type.IntegerTypeHandler.getNullableResult(IntegerTypeHandler.java:26)
        at org.apache.ibatis.type.BaseTypeHandler.getResult(BaseTypeHandler.java:81)
        ... 28 more
        Caused by: com.mysql.cj.exceptions.DataConversionException: Cannot determine value type from string '日用'
        at com.mysql.cj.result.AbstractNumericValueFactory.createFromBytes(AbstractNumericValueFactory.java:66)
        at com.mysql.cj.protocol.a.MysqlTextValueDecoder.decodeByteArray(MysqlTextValueDecoder.java:143)
        at com.mysql.cj.protocol.result.AbstractResultsetRow.decodeAndCreateReturnValue(AbstractResultsetRow.java:135)
        at com.mysql.cj.protocol.result.AbstractResultsetRow.getValueFromBytes(AbstractResultsetRow.java:243)
        at com.mysql.cj.protocol.a.result.ByteArrayRow.getValue(ByteArrayRow.java:91)
        at com.mysql.cj.jdbc.result.ResultSetImpl.getObject(ResultSetImpl.java:1316)
        ... 34 more
```

检查git commits记录，发现是在给`Goods`类编写构造函数后发生的，构造函数和数据库存储顺序不一致。修改构造函数参数顺序即可。

### 无法保存中文字符到数据库中
可以读取数据库中含有中文字符的数据，却无法保存，保存的中文字符全成了“?”。
解决方法：首先确保数据库使用的编码支持中文（我们采用的是UTF8）。在此基础上，最关键的一步是，连接数据库的URL后面添加参数`useUnicode=true&characterEncoding=UTF-8`。
参考资料：https://blog.csdn.net/randompeople/article/details/79439859

### MyBatis 未正确映射Java对象和数据库字段
这是一个示例语句。
```sql
CREATE DATABASE IF NOT EXISTS vCampus;
USE vCampus;
CREATE TABLE IF NOT EXISTS students(
    name varchar(10),
    password varchar(100),
    cardNumber varchar(20),
    studentNumber varchar(20),
    balance decimal(10,2),
    school varchar(20),
    gender varchar(5),
    email varchar(50),
    phoneNumber varchar(20)
);
INSERT INTO students(name,password,cardNumber,studentNumber,balance)
VALUES("yfdl","123","213191111","09019000",0);
```
在`com.vampus.client.Verifier`的方法`public static Student checkStudent(String cardNumber, String password)`中加入调试语句`System.out.println(toJSONString(new Student(cardNumber, password)));`，输出结果为`{"cardNumber":"213191111","name":"","password":"123","school":""}`，可见正常读取了登陆界面填入的卡号和密码并创建了`Student`实例。

但在`com.vampus.server.Verifier`中，如果加入如下测试语句
```java
System.out.println(toJSONString(student));
Student getStudent = studentMapper.getStudentDetailByCardNumber(student.getCardNumber());
System.out.println(toJSONString(getStudent));
System.out.println(studentMapper.verifyStudent(getStudent));
```
输出的结果是
```json
{"cardNumber":"213191111","name":"","school":""}
{"cardNumber":"213191111","name":"yfdl","school":"计算机科学与工程学院"}
false
```

初步判断应该与MyBatis Mapper有关。参考 https://mybatis.org/mybatis-3/sqlmap-xml.html#Result_Maps ，了解其自动映射机制，转而寻找`Student`类的问题。

```java
public void setPassword(String Password) {
    this.password = password;
}
```
第一行误将`password`写为`Password`...

## Misc
### 重命名
IntelliJ IDEA很智能，但是，在使用Refactor功能重命名类名的时候一定要先用全局文本搜索（在我这的快捷键是Ctrl+Shift+F）查找包名是否出现在字符串里。尤其是本项目，不少后端API是通过字符串的方式获得的。