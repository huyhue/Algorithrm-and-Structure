package Assignment1;
import java.util.Scanner;
public class Validation {
    Scanner sc = new Scanner(System.in);
    public double checkInputDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Must be >= 0");
                System.err.println("Please enter again: ");
            }
        }
    }

    public int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please input number in range [" + min + "-" + max + "]");
            }
        }
    }

    public double checkLimitDouble(double max, String message) {
        while (true) {
            try {
                System.out.print(message);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please enter number >= " + max);
            }
        }
    }

    public String checkInputString() {
        String text;
        while (true) {
            text = sc.nextLine();
            if (text.isEmpty()) {
                System.err.println("String not empty");
                System.err.println("Pls enter again");
            } else {
                return text;
            }
        }
    }

    public int checkchoice(String message) {
        int a = 0;
        while (true) {
            try {
                System.out.print(message);
                a = Integer.parseInt(sc.nextLine());
                if (a >= 1 && a <= 34) {
                    break;
                } else {
                    System.out.println("Re-input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            } catch (NullPointerException e) {
                System.out.println("Please don't input space!");
            }
        }
        return a;
    }

    public double checkDouble(String message) {
        double a = 0;
        while (true) {
            try {
                System.out.print(message);
                a = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            } catch (NullPointerException e) {
                System.out.println("Please don't input space!");
            } catch (ArithmeticException e) {
                System.out.println("Please don't division for 0!");
            }
        }
        return a;
    }

    public int checkPositiveInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please enter number > 0");
            }
        }
    }

    public String checkString(String message) {
        String text;
        while (true) {
            try {
                System.out.print(message);
                text = sc.nextLine();
                if (text.trim().equals("") || text == null) {
                    System.out.println("Please input");
                } else {
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("Please don't input space!");
            }
        }
        return text;
    }
}
