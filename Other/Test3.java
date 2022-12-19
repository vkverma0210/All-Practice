import java.util.Collections;

// 1 -- 100
// prime number

// 25
// 5

// sun rises in east

public class Test3 {
    public static String solve(String str) {
        String[] word = str.split(" ");

        for (int i = 0; i < word.length; i++) {
            if (word[i].length() % 2 != 0) {
                StringBuilder temp = new StringBuilder(word[i]);
                word[i] = temp.reverse().toString();
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < word.length; i++) {
            sb.append(word[i] + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Sun rises in East";

        System.out.println(solve(str));
    }

}

// Employee Table Emp_no,
// Emp Name, Dept, Salary

// Manager Table Emp_no,
// Dept

// 2 abc 3000
// 1 bcd 2500
// 5 abc 2000

// Select Emp, Name, Dept, Salary from e1 Dept from e2 where Employee e1 =