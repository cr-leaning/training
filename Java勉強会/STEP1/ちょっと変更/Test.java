public class Test {

  public String inputStr = "���͂�";
  public static final String END_STR = "�ł��B";
  
  public static void main(String[] args) {
    Test test = new Test();
    String res = test.testMethod(args[0], args[1]);
    System.out.println("���� " + res);
    System.out.println("���� " + test.testMethod2(args[0], args[1]));
  }
  
  private String testMethod(String para1, String para2) {
    String str = new String();
    str = inputStr + para1 + "+" + para2 + END_STR;
    return str;
  }
  
  private String testMethod2(String para1, String para2) {
    inputStr = "�擪��ύX������";
    return inputStr + para1 + "+" + para2 + END_STR;
  }
}
