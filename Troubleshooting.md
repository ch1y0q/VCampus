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