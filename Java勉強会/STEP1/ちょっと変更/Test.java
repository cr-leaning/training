public class Test {

  public String inputStr = "入力は";
  public static final String END_STR = "です。";
  
  public static void main(String[] args) {
    Test test = new Test();
    String res = test.testMethod(args[0], args[1]);
    System.out.println("一回目 " + res);
    System.out.println("二回目 " + test.testMethod2(args[0], args[1]));
  }
  
  private String testMethod(String para1, String para2) {
    String str = new String();
    str = inputStr + para1 + "+" + para2 + END_STR;
    return str;
  }
  
  private String testMethod2(String para1, String para2) {
    inputStr = "先頭を変更したら";
    return inputStr + para1 + "+" + para2 + END_STR;
  }
}
