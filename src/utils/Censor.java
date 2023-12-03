package utils;

import models.userDB.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Censor {
    static final Map<String, String> map = new HashMap<>();


    /*
    * Hàm checkGenderAndBirth nhận vào chuỗi
    * từ chuỗi đó tìm ra và trả về chuỗi giới tính(gender) và năm sinh(yob) tương ứng.
     */
    public static String checkGenderAndBirth(String str){
        StringBuilder info = new StringBuilder();
        switch (str.charAt(0)) {
            case '0' -> {
                info.append("Giới tính: Nam | ").append("19");
            }
            case '2' -> {
                info.append("Giới tính: Nam | ").append("20");
            }
            case '4' -> {
                info.append("Giới tính: Nam | ").append("21");
            }
            case '6' -> {
                info.append("Giới tính: Nam | ").append("22");
            }
            case '8' -> {
                info.append("Giới tính: Nam | ").append("23");
            }
            case '1' -> {
                info.append("Giới tính: Nữ | ").append("19");
            }
            case '3' -> {
                info.append("Giới tính: Nữ | ").append("20");
            }
            case '5' -> {
                info.append("Giới tính: Nữ | ").append("21");
            }
            case '7' -> {
                info.append("Giới tính: Nữ | ").append("22");
            }
            case '9' -> {
                info.append("Giới tính: Nữ | ").append("23");
            }
        }

        info.append(str.substring(1));
        return info.toString();
    }

    /*
    * Hàm khởi tạo giá trị của từng tỉnh thành
    */
    public static void initListProvinces(){
        map.put("001", "Hà Nội");
        map.put("002", "Hà Giang");
        map.put("004", "Cao Bằng");
        map.put("006", "Bắc Kan");
        map.put("008", "Tuyên Quang");
        map.put("010", "Lào Cai");
        map.put("011", "Điện Biên");
        map.put("012","Lai Châu");
        map.put("014", "Sơn La");
        map.put("015", "Yên Bái");
        map.put("017", "Hòa Bình");
        map.put("019", "Thái Nguyên");
        map.put("020", "Lạng Sơn");
        map.put("022", "Quảng Ninh");
        map.put("024", "Bắc Giang");
        map.put("025", "Phú Thọ");
        map.put("026", "Vĩnh Phúc");
        map.put("027", "Bắc Ninh");
        map.put("030", "Hải Dương");
        map.put("031", "Hải Phòng");
        map.put("033", "Hưng Yên");
        map.put("034", "Thái Bình");
        map.put("035", "Hà Nam");
        map.put("036", "Nam Định");
        map.put("037", "Ninh Bình");
        map.put("038", "Thanh Hóa");
        map.put("040", "Nghệ An");
        map.put("042", "Hà Tĩnh");
        map.put("044", "Quảng Bình");
        map.put("045", "Quảng Trị");
        map.put("046", "Thừa Thiên Huế");
        map.put("048", "Đà Nẵng");
        map.put("049", "Quảng Nam");
        map.put("051", "Quảng Ngãi");
        map.put("052", "Bình Định");
        map.put("054", "Phú Yên");
        map.put("056", "Khánh Hòa");
        map.put("058", "Ninh Thuận");
        map.put("060", "Bình Thuận");
        map.put("062", "Kon Tum");
        map.put("064", "Gia Lai");
        map.put("066", "Đắk Lắk");
        map.put("068", "Lâm Đồng");
        map.put("070", "Bình Phước");
        map.put("072", "Tây Ninh");
        map.put("074", "Bình Dương");
        map.put("075", "Đồng Nai");
        map.put("077", "Bà Rịa - Vũng Tàu");
        map.put("079", "Hồ Chí Minh");
        map.put("080", "Long An");
        map.put("082", "Tiền Giang");
        map.put("083", "Bến Tre");
        map.put("084", "Trà Vinh");
        map.put("086", "Vĩnh Long");
        map.put("087", "Đồng Tháp");
        map.put("089", "An Giang");
        map.put("091", "Kiên Giang");
        map.put("092", "Cần Thơ");
        map.put("093", "Hậu Giang");
        map.put("094", "Sóc Trăng");
        map.put("095", "Bạc Liêu");
        map.put("096", "Cà Mau");
    }

    /*
    * Hàm checkProvince nhận vào mã tỉnh, nếu có thì trả về tên của tỉnh đó
    * nếu không tìm thấy thì trả về thông báo không tìm thấy
    */
    public static String checkProvince(String num){
        return map.getOrDefault(num, "false");
    }

    /*
    * Hàm isNumeric nhận vào một chuỗi và kiểm tra xem có phải chuỗi số không
    * có thì trả về true không thì trả về false
    */
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) < 48 || str.charAt(i) > 57){
                return false;
            }
        }
        return true;
    }

    /*
    * Hàm isDup nhận vào chuỗi cần kiểm tra, mẫu để so sánh và một thông báo
    * nếu chuỗi cần kiểm tra giống với mẫu thì in ra màn hình một thông báo và
    * trả về true, nếu không thì trả về false
    */
    public static boolean isDup(String checkDup, String pattern, String msg){
        if(checkDup.equals(pattern)){
            System.out.println(msg);
            return true;
        }
        return false;
    }

    /*
     * Hàm isDup nhận vào chuỗi cần kiểm tra, mẫu để so sánh
     * nếu chuỗi cần kiểm tra giống với mẫu thì
     * trả về true, nếu không thì trả về false
     */
    public static boolean isDup(String checkDup, String pattern){
        if(checkDup.equals(pattern)){
            return true;
        }
        return false;
    }

    /*
     * Hàm isDup nhận vào chuỗi cần kiểm tra, list để so sánh
     * nếu chuỗi cần kiểm tra có trùng trong list thì
     * trả về true,  không thì trả về false
     */
    public static boolean isDup(String checkDup, List<Customer> listCheck){
        for(Customer customer : listCheck){
            if(checkDup.equals(customer.getCustomerId())){
                return true;
            }
        }
        return false;
    }

    /*
    *Hàm checkCCCD nhận vào chuỗi cccd do khách hàng nhập
    * kiểm tra đúng định dạng thì return true
    * sai thì return false
    */
    public static boolean checkCCCD(String id){
        if(!checkProvince(id.substring(0, 3)).equals("false")){
            return !checkGenderAndBirth(id.substring(3, 7)).isEmpty();
        }
        return false;
    }
}
