class Test2 {
  public static void main(String[] args) {
    ArrayList a = new ArrayList();
    String[] b;
    try {
      while (true) {
        a.add("hoge");
      }
    } catch (RuntimeException e) {
      System.out.println("hogehoge");
    } catch (Exception e2) {
      System.out.println("hogehogehoge");
    } 
    System.out.println("hogehogehogehogehoge");
  }     

}
