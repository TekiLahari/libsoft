public class IsNumeric{
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            System.out.println("false");
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }
    public static void main(String[] args){
        IsNumeric obj1234=new IsNumeric();
        boolean data1234=obj1234.isNumeric("123");
    }
}
