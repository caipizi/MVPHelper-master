# MVPHelper-master
A plugin can help you to create google samples MVP classes
#说明
使用本插件可以提高一些工作效率，不必再手写Model和Presenter，只需要创建xxxContract文件，再通过Generate即可。

对基类BaseView、BaseModel、BasePresenter已进行封装，如果需要生成别的模板内容可以修改本项目代码重新生成符合您要求的插件。
```java 
public class MainContract {


   public interface Model extends BaseModel {
   }

   public interface View extends BaseView {
   }

   public abstract class Presenter extends BasePresenter<Model,View> {
   }

}
```
**PS:**
![image](https://github.com/caipizi/MVPHelper-master/blob/master/img/logo.jpg)
####使用步骤：
**step1：下载MVPHelper-master.jar**

[MVPHelper-master.jar](https://github.com/caipizi/MVPHelper-master/blob/master/MVPHelper-master.jar)

**step2：通过本地文件安装插件File->Settings->Plugins**
![image](https://github.com/caipizi/MVPHelper-master/blob/master/img/step2.jpg)
**step3：重启后设置包名以及使用插件自动生成代码**
![image](https://github.com/caipizi/MVPHelper-master/blob/master/img/step3.jpg)
![image](https://github.com/caipizi/MVPHelper-master/blob/master/img/step4.jpg)
![image](https://github.com/caipizi/MVPHelper-master/blob/master/img/step5.jpg)
