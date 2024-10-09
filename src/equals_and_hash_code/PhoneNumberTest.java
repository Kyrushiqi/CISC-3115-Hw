package equals_and_hash_code;

// DO NOT MODIFY THIS FILE.

public class PhoneNumberTest {
    public static void main(String[] args) {
        System.out.println(new PhoneNumber("111-111-1111").equals(new PhoneNumber("111-111-1111"))); // expected: true
        System.out.println(new PhoneNumber("111-111-1111").equals(new PhoneNumber("222-111-1111"))); // expected: false
        System.out.println(new PhoneNumber("111-111-1111").equals(new PhoneNumber("111-222-1111"))); // expected: false
        System.out.println(new PhoneNumber("111-111-1111").equals(new PhoneNumber("111-111-2222"))); // expected: false

        // test using two references to a single object
        PhoneNumber phoneNumber = new PhoneNumber("111-111-1111");
        System.out.println(phoneNumber.equals(phoneNumber)); // expected: true

        System.out.println(phoneNumber.equals("123-456-7890")); // expected: false
        System.out.println(phoneNumber.equals(null)); // expected: false

        Object o1 = new PhoneNumber(1, 1, 1);
        Object o2 = new PhoneNumber(1, 1, 1);
        System.out.println(o1.equals(o2)); // expected: true

        System.out.println(new PhoneNumber(1, 1, 1).hashCode() == new PhoneNumber(1, 1, 1).hashCode()); // expected: true
    }
}

