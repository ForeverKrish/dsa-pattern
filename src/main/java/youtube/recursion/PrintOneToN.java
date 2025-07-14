package youtube.recursion;

public class PrintOneToN {
    public static void main(String[] km){
        print(5);
        System.out.println();
        print(0);
        System.out.println();
        print(1000);

    }

    private static void print(int length){
        //Base criteria
        if(length>0){
            if(length == 1){
                System.out.print(1);
                return;
            }

            //call print with length-1
            print(length-1); //Hypothesis

            System.out.print(" "+length); //Induction
        }
    }
}
