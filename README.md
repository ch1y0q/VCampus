# VCampus

## 成员

董若菁（组长，@meteoseeker）

黄启越（@qwerty250）

肖凯杰（@x200012）

于跃（@Touhanabi）

荣逸鹏（@49666440）

杨飞（@opcoast）

## 功能特性
### 多语言支持
以下代码读取默认locale，查找对应语言的资源。
```java
        locale = Locale.getDefault();
        res = Utf8ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
```
以下代码指定使用美国英语显示。
```java
        locale = Locale.US;
        res = Utf8ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
```
其中，`Utf8ResourceBundle`是为了解决Java 9 之前properties编码问题而编写的辅助类。