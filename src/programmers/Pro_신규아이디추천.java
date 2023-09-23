package programmers;

public class Pro_신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < new_id.length(); i++){
            char tmp = new_id.charAt(i);
            if((tmp >= 'a' && tmp <= 'z') || (tmp >= '0' && tmp <= '9') ||
                    tmp == '-' || tmp == '_' || tmp == '.'){
                sb.append(tmp);
            }
        }
        new_id = sb.toString();

        // 3단계
        while(new_id.contains("..")){
            new_id = new_id.replace("..",".");
        }

        // 4단계
        if(new_id.length()>0){
            if(new_id.charAt(0) == '.'){
                new_id = new_id.substring(1,new_id.length());
            }
        }

        if(new_id.length()>0){
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }

        // 5단계
        if(new_id.equals("")){
            new_id = "a";
        }

        // 6단계
        if(new_id.length()>15){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }

        // 7단계
        if(new_id.length()<=2){
            char last = new_id.charAt(new_id.length()-1);
            while(new_id.length()<=2){
                new_id+=String.valueOf(last);
            }
        }
        System.out.println(new_id);
        return new_id;
    }
}
