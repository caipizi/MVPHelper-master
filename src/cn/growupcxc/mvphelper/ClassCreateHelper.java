package cn.growupcxc.mvphelper;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by cxianchun on 2016-11-15.
 */
public class ClassCreateHelper {
    static final int  PRESENTER = 1;
    static final int MODEl = 2;
    static final int BasePresenter = 3;
    static final int BaseModel = 4;
    static final int BaseView = 5;


    /**
     * 创建实现类
     * @param path
     * @param className
     * @param classFullName
     * @param mode
     * @throws IOException
     */
    public static void createClasses(String path, String className, String classFullName, int mode) throws IOException {
        String type = null;
        String dir = "";
        switch (mode){
            case PRESENTER:
                type = "PresenterImpl";
                dir = path+"presenter/";
                break;
            case MODEl:
                type = "ModelImpl";
                dir = path+"model/";
                break;
            case BaseModel:
                type = "BaseModel";
                dir = path+"base/";
                break;
            case BaseView:
                type = "BaseView";
                dir = path+"base/";
                break;
            case BasePresenter:
                type = "BasePresenter";
                dir = path+"base/";
                break;
        }
        String filePath =null;
        if(mode==PRESENTER||mode==MODEl) filePath = dir + className + type+".java";
        else filePath = dir + type+".java";
        File dirs = new File(dir);
        System.out.println("dirs = "+dir);
        File file = new File(filePath);
        if(!dirs.exists()){
            dirs.mkdir();
        }else{
            if(file.exists()){
                return;
            }
        }
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String packageName = getPackageName(dir);
        System.out.println("createClasses===>package="+packageName);
        writer.write("package "+ packageName+";");
        writer.newLine();
        if(mode==PRESENTER||mode==MODEl)
        if(getPackageName(path).endsWith("/contract"))
            writer.write("import "+ getPackageName(path)+"."+classFullName+";");
        else
            writer.write("import "+ getPackageName(path+"contract")+"."+classFullName+";");
        writer.newLine();
       /* if(mode == MODEl){
            writer.write("import android.support.v4.app.Fragment;");
            writer.newLine();
            writer.newLine();
        }*/

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        writer.write("/**\n* Created by cxianchunk on "+sdf.format(date)+"\n*/");
        writer.newLine();
        writer.newLine();
        switch (mode){
            case PRESENTER:
                writer.write("public class " + className + "PresenterImpl implements "+classFullName+".Presenter"+" {");
                break;
            case MODEl:
                writer.write("public class "+className+"ModelImpl implements "+classFullName+".Model {");
                break;
            case BaseModel:
                writer.write("public interface BaseModel {");
                break;
            case BaseView:
                writer.write("public interface BaseView {");
                break;
            case BasePresenter:
                writer.write("public abstract class BasePresenter<E,T> {");
                break;
        }
        writer.newLine();
        writer.newLine();
        writer.newLine();
        writer.write("}");

        writer.flush();
        writer.close();
    }

    public static String getPackageName(String path) {
        String[] strings = path.split("/");
        StringBuilder packageName = new StringBuilder();
        int index = 0;
        int length = strings.length;
        for(int i = 0;i<strings.length;i++){
            if(strings[i].equals("cn")||strings[i].equals("com")||strings[i].equals("org")){
                index = i;
                break;
            }

        }
        for(int j = index;j<length;j++){
            packageName.append(strings[j]+".");
        }
        String finalPackageName = packageName.toString();
        finalPackageName = finalPackageName.substring(0,finalPackageName.lastIndexOf("."));
        return finalPackageName;
    }

    public static String getCurrentPath(AnActionEvent e, String classFullName){

        VirtualFile currentFile = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());

        String path = currentFile.getPath().replace(classFullName+".java","");
        return path;
    }

    /**
     * 得到首字母大写的变量名称
     * @param variables
     * @return
     */
    private static String getFirstLowerVariables(String variables){
        String firstLetter = variables.substring(0,1);
        variables = variables.replaceFirst(firstLetter,firstLetter.toLowerCase());
        return variables;
    }

}
