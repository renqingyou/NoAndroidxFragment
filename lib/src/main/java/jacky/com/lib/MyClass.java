package jacky.com.lib;

import com.sun.org.apache.bcel.internal.classfile.Synthetic;

public class MyClass {
    public static void main(String... args){
        String a = null+"";
        System.out.print(a.equals("null"));
    }
}
