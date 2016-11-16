# MVPHelper-master
A plugin can help you to create google samples MVP classes
#说明
本插件是用于生成谷歌架构蓝图基础MVP中Model和Presenter文件的。
使用本插件可以提高一些生产效率，不必再手写Model和Presenter，只需要创建xxxContract文件，再通过Generate即可。

对基类BaseView、BaseModel、BasePresenter进行封装，如果需要生成别的模板内容可以修改本项目代码重新生成符合您要求的插件。
PS:
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
![image](https://github.com/caipizi/MVPHelper-master/blob/master/img/logo.jpg)
