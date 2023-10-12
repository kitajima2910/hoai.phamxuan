package test1;


public class Test1 {

    static {
        System.loadLibrary("libtest_native_Cproject");
    }
    
    public Test1() {
        
    }
    
    // Keyword: native --> like abstract method --> there is no implementation
    public native double multiple(double a, double b);
    public static native void sayHi();
    public static native void sayHiToMe();
    public native String initLegal(String msg);
    
    
    public static void main(String[] args) {
        Test1.sayHi();
        Test1.sayHiToMe();
        System.out.println(new Test1().multiple(1.1, 2.2));
        System.out.println(new Test1().initLegal("Hello initLegal"));
    }
    
}
