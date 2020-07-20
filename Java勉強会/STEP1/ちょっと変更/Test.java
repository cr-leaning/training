public class Test {

  public String inputStr = "“ü—Í‚Í";
  public static final String END_STR = "‚Å‚·B";
  
  public static void main(String[] args) {
    Test test = new Test();
    String res = test.testMethod(args[0], args[1]);
    System.out.println("ˆê‰ñ–Ú " + res);
    System.out.println("“ñ‰ñ–Ú " + test.testMethod2(args[0], args[1]));
  }
  
  private String testMethod(String para1, String para2) {
    String str = new String();
    str = inputStr + para1 + "+" + para2 + END_STR;
    return str;
  }
  
  private String testMethod2(String para1, String para2) {
    inputStr = "æ“ª‚ğ•ÏX‚µ‚½‚ç";
    return inputStr + para1 + "+" + para2 + END_STR;
  }
}
