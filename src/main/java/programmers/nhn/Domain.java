package programmers.nhn;

public class Domain {
    public int solution(String[] emails){
        int answer = 0;
        for (int i=0; i< emails.length; i++){
            String[] split = emails[i].split("@");

            if (split.length == 2){
                System.out.println(split[0]);
                System.out.println(split[1]);

                if (validName(split[0]) && validDomain(split[1]))
                    answer++;
            }
        }

        return answer;
    }

    public static boolean validName(String name){

        for (int i=0; i<name.length(); i++){
            if (Character.isUpperCase(name.charAt(i))
                    || (!Character.isLetter(name.charAt(i))
                    && !String.valueOf(name.charAt(i)).equals(".")))
                return false;
        }

        return true;
    }

    public static boolean validDomain(String domain){

        String[] split = domain.split("\\.");

        if (split.length != 2 || split[0].length() < 1)
            return false;

        for (int i=0; i<split[0].length(); i++){
            if (Character.isUpperCase(domain.charAt(i)))
                return false;
        }

        if (!split[1].equals("com") && !split[1].equals("net") && !split[1].equals("org"))
            return false;

        return true;
    }
}
