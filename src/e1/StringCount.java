package e1;

public class StringCount {
        public static int countWords(String text) {
            int count = 0;
            if (text == null || text.isEmpty()) {
                return 0;
            }
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != ' ' && (i == 0 || text.charAt(i-1) == ' ')) {
                    count++;
                }
            }
            return count;
        }

        public static int countChar(String text, char c) {
            int count = 0;
            if (text == null || text.isEmpty()) {
                return 0;
            }
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == c) {
                    count ++;
                }
            }
            return count;
        }

        public static int countCharIgnoringCase(String text, char c) {
            int count = 0;
            char lowerC = Character.toLowerCase(c);
            char upperC = Character.toUpperCase(c);
            if (text == null || text.isEmpty()) {
                return 0;
            }
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == upperC || text.charAt(i) == lowerC) {
                    count ++;
                }
            }
            return count;
        }

        public static boolean isPasswordSafe(String password) {
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;

            if (password.length() < 8) {
                return false;
            }
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    hasUpperCase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowerCase = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (c == '?' || c == '@' || c == '#' || c == '$' || c == '.' || c == ',') { //caracter especial
                    hasSpecialChar = true;
                }
            }
            return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
        }
}
