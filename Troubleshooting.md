# Troubleshooting

Some problems we encountered.

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

解决方法：添加JVM启动选项`--add-opens java.base/java.net=ALL-UNNAMED`。

参考： https://stackoverflow.com/questions/41265266/how-to-solve-inaccessibleobjectexception-unable-to-make-member-accessible-m

## Database
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