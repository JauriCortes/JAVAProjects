public class debug{
    public static void main(String args[]) {

        debug Debug = new debug();
        Debug.test();
    }

    public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           //System.out.println("index " + index);
           index = input.indexOf("abc",index+3);
           //System.out.println("index after updating " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcabcabcabca");
   }
}