package utils;

import java.util.Scanner;

public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    /*
     * Hàm trả về một số nguyên được nhập từ người dùng
     */
    public static int getInteger(String inpMsg){
        System.out.println(inpMsg);
        while(true){
            try{
                return Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /*
     * Hàm trả về một số thực được nhập từ người dùng
     */
    public static double getDouble(String inpMsg){
        System.out.println(inpMsg);
        while(true){
            try{
                return Double.parseDouble(sc.nextLine());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /*
     * Hàm ép người dùng nhập vào một chuỗi không rỗng và giống với định dạng
     */
    public static String getString(String inpMSg, String pattern){
        while(true){
            try{
                System.out.println(inpMSg);
                String str = sc.nextLine();
                if(str.isEmpty()){
                    throw new Exception("This field is required!\n");
                } else if (!str.matches(pattern)) {
                    throw new Exception("Invalid input!\n");
                }
                return str;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /*
     * Hàm cho người dùng nhập vào một chuỗi không rỗng
     */
    public static String getString(String inpMsg){
        System.out.println(inpMsg);
        while(true){
            try{
                String str = sc.nextLine();
                if(str.isEmpty()){
                    throw new Exception("This field is required!");
                }
                return str;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
