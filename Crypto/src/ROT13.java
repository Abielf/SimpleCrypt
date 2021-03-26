import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    String lowerAlphabet="abcdefghijklmnopqrstuvwxyz";
    String higherC1;
    String higherC2;
    String code1;
    String code2;



    ROT13(Character cs, Character cf) {
        code1=rotate(lowerAlphabet,cs);
        code2=rotate(lowerAlphabet,cf);
        higherC1=code1.toUpperCase();
        higherC2=code2.toUpperCase();
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return encrypt(text);
    }

    public String encrypt(String text) {
        String temp ="";
        for(int i=0; i<text.length();i++){
            if (Character.isUpperCase(text.charAt(i))){
            temp=temp.concat(Character.toString(higherC2.charAt(higherC1.indexOf(text.charAt(i)))));
            }else if(Character.isLowerCase(text.charAt(i))) {temp=temp.concat(Character.toString(code2.charAt(code1.indexOf(text.charAt(i)))));
            }else temp=temp.concat(Character.toString(text.charAt(i)));
        }
        return temp;
    }

    public String decrypt(String text) {
        String temp ="";
        for(int i=0; i<text.length();i++){
            if (Character.isUpperCase(text.charAt(i))){
                temp=temp.concat(Character.toString(higherC1.charAt(higherC2.indexOf(text.charAt(i)))));
            }else if(Character.isLowerCase(text.charAt(i))) {temp=temp.concat(Character.toString(code1.charAt(code2.indexOf(text.charAt(i)))));
            }else temp=temp.concat(Character.toString(text.charAt(i)));
        }
        return temp;
    }

    public static String rotate(String s, Character c) {
        return s.substring(s.indexOf(c))+s.substring(0,s.indexOf(c));
    }

}
