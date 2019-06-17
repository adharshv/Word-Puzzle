
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class WordPuzzle {

    public static void main(String args[]) throws Exception
    {
        long startTime = System.nanoTime();
        MyHashTable H = new MyHashTable();
        Scanner sc1 = new Scanner(System.in);


        System.out.println("Enter the pathname of dictionary (eg:C:\\\\Users\\\\adharsh\\\\Desktop\\\\dictionary.txt): ");
        String path = sc1.nextLine();
        File file = new File(path);//reading in the text file
        Scanner sc = new Scanner(file);
        String entry;
        int maxLength=0;

        String prefix="";

        System.out.println("Do you want to use the enhanced algorithm? (y or n)");
        String answer= sc1.nextLine();

        //inserting all the words in dictionary to the hash table
        while (sc.hasNextLine())
        {
            entry = sc.nextLine();
            if (entry.length() > maxLength)
            {
                maxLength = entry.length();
            }
            if(answer.equals("y"))
            {
                prefix="";
                //inserting all prefixes into the hash table
                for (int i = 0; i < (entry.length()); i++)
                {
                    prefix += entry.charAt(i);
                    //System.out.println(prefix);
                    H.insert(prefix + '@');//appending all prefixes with '@' sign
                    //System.out.println(H.size());
                }
            }
            H.insert(entry);
        }

        System.out.println("Enter the number of rows and columns of the word puzzle with spaces in b/w: ");
        String input1=sc1.nextLine();
        String[] array1 = input1.split("\\s+");//reading numbers with spaces in between
        int lst1[]= new int[array1.length];//integer array containing the entered elements of tree
        for(int i=0; i<array1.length; i++)
        {
            lst1[i]=Integer.parseInt(array1[i]);
        }

        Random rand = new Random();

        int rows = lst1[0];
        int columns = lst1[1];
        char puzzle[][] = new char[rows][columns];
        int start[]= new int[2];
        String word,word1,word2,word3,word4,word5,word6,word7,word8;
        //creating random 2D array of alphabets
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                puzzle[i][j] = (char)('a' + rand.nextInt(26) + 0); //loading random char b/w a & z into the 2D array puzzle
            }
        }

        System.out.println("The word puzzle is: ");
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("");
        long estimatedTime1 = System.nanoTime() - startTime;



            System.out.println("The solutions using normal algorithm are: ");


            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    start[0] = i;
                    start[1] = j;
                    word1 = ""+puzzle[i][j];
                    if (H.contains(word1)) {
                        System.out.println(word1 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + 1) + "," + (j + 1) + ")");
                    }
                    word2 = ""+puzzle[i][j];
                    word3 = ""+puzzle[i][j];
                    word4 = ""+puzzle[i][j];
                    word5 = ""+puzzle[i][j];
                    word6 = ""+puzzle[i][j];
                    word7 = ""+puzzle[i][j];
                    word8 = ""+puzzle[i][j];


                    for (int k = 1; k < maxLength; k++) {
                        //checking all 8 orientations
                        if ((i + k) < rows) {

                            word1 += puzzle[i + k][j];

                            if (H.contains(word1)) {
                                System.out.println(word1 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + k + 1) + "," + (j + 1) + ")");
                            }
                        }
                        if ((i - k) >= 0) {
                            word2 += puzzle[i - k][j];
                            if (H.contains(word2)) {
                                System.out.println(word2 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i - k + 1) + "," + (j + 1) + ")");
                            }
                        }
                        if ((j + k) < columns) {
                            word3 += puzzle[i][j + k];
                            if (H.contains(word3)) {
                                System.out.println(word3 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + 1) + "," + (j + k + 1) + ")");
                            }
                        }

                        if ((j - k) >= 0) {
                            word4 += puzzle[i][j - k];
                            if (H.contains(word4)) {
                                System.out.println(word4 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + 1) + "," + (j - k + 1) + ")");
                            }
                        }
                        if ((i + k) < rows && (j + k) < columns) {
                            word5 += puzzle[i + k][j + k];
                            if (H.contains(word5)) {
                                System.out.println(word5 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + k + 1) + "," + (j + k + 1) + ")");
                            }
                        }
                        if ((i + k) < rows && (j - k) >= 0) {
                            word6 += puzzle[i + k][j - k];
                            if (H.contains(word6)) {
                                System.out.println(word6 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + k + 1) + "," + (j - k + 1) + ")");
                            }
                        }
                        if ((i - k) >= 0 && (j + k) < columns) {
                            word7 += puzzle[i - k][j + k];
                            if (H.contains(word7)) {
                                System.out.println(word7 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i - k + 1) + "," + (j + k + 1) + ")");
                            }
                        }
                        if ((i - k) >= 0 && (j - k) >= 0) {
                            word8 += puzzle[i - k][j - k];
                            if (H.contains(word8)) {
                                System.out.println(word8 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i - k + 1) + "," + (j - k + 1) + ")");
                            }
                        }
                    }
                }
            }

        long estimatedTime2 = System.nanoTime() - startTime;
        double seconds2 = (double)estimatedTime2 / 1_000_000_000.0;
        System.out.println("\nThe time taken for normal algorithm is: "+seconds2+" seconds");

        if (answer.equals("y")) {
            System.out.println("");
            System.out.println("The solutions using enhanced algorithm are: ");

            for(int i=0; i< rows; i++)
            {
                for(int j=0; j<columns; j++)
                {
                    start[0]=i;
                    start[1]=j;
                    word1=""+puzzle[i][j];
                    if(H.contains(word1))
                    {
                        System.out.println(word1 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + 1) + "," + (j + 1) + ")");
                    }
                    word2=""+puzzle[i][j];
                    word3=""+puzzle[i][j];
                    word4=""+puzzle[i][j];
                    word5=""+puzzle[i][j];
                    word6=""+puzzle[i][j];
                    word7=""+puzzle[i][j];
                    word8=""+puzzle[i][j];


                    for(int k=1; k< maxLength; k++) {
                        //checking all 8 orientations
                        if (H.contains(word1 + "@")) {
                            if ((i + k) < rows)
                            {
                                word1 += puzzle[i + k][j];
                                if (H.contains(word1))
                                {
                                    System.out.println(word1 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + k + 1) + "," + (j + 1) + ")");
                                }
                            }
                        }
                        if (H.contains(word2 + "@"))
                        {
                            if ((i - k) >= 0) {
                                word2 += puzzle[i - k][j];
                                if (H.contains(word2)) {
                                    System.out.println(word2 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i - k + 1) + "," + (j + 1) + ")");
                                }
                            }
                        }

                        if (H.contains(word3 + "@"))
                            {
                                if ((j + k) < columns)
                                {
                                    word3 += puzzle[i][j + k];
                                    if (H.contains(word3))
                                    {
                                        System.out.println(word3 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + 1) + "," + (j + k + 1) + ")");
                                    }
                                }
                            }

                            if (H.contains(word4 + "@"))
                            {
                                if ((j - k) >= 0)
                                {
                                    word4 += puzzle[i][j - k];
                                    if (H.contains(word4))
                                    {
                                        System.out.println(word4 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + 1) + "," + (j - k + 1) + ")");
                                    }
                                }
                            }
                            if (H.contains(word5 + "@"))
                            {
                                if((i+k)<rows && (j+k)<columns)
                                {
                                    word5+=puzzle[i+k][j+k];
                                    if(H.contains(word5))
                                    {
                                        System.out.println(word5+" goes from ("+(start[0]+1)+","+(start[1]+1)+") to ("+(i+k+1)+","+(j+k+1)+")");
                                    }
                                }
                            }
                            if (H.contains(word6 + "@"))
                            {
                                if ((i + k) < rows && (j - k) >= 0)
                                {
                                    word6 += puzzle[i + k][j - k];
                                    if (H.contains(word6))
                                    {
                                        System.out.println(word6 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i + k + 1) + "," + (j - k + 1) + ")");
                                    }
                                }
                            }
                        if (H.contains(word7 + "@"))
                        {
                            if ((i - k) >= 0 && (j + k) < columns)
                            {
                                word7 += puzzle[i - k][j + k];
                                if (H.contains(word7)) {
                                    System.out.println(word7 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i - k + 1) + "," + (j + k + 1) + ")");
                                }
                            }
                        }
                        if (H.contains(word8 + "@"))
                        {
                            if ((i - k) >= 0 && (j - k) >= 0)
                            {
                                word8 += puzzle[i - k][j - k];
                                if (H.contains(word8)) {
                                    System.out.println(word8 + " goes from (" + (start[0] + 1) + "," + (start[1] + 1) + ") to (" + (i - k + 1) + "," + (j - k + 1) + ")");
                                }
                            }
                        }



                    }
                }
            }
            long estimatedTime3 = System.nanoTime() - startTime;
            long estimatedTime4=estimatedTime3-(estimatedTime2-estimatedTime1);
            double seconds3 = (double)estimatedTime4 / 1_000_000_000.0;

            System.out.println("\nThe time taken for enhanced algorithm is: "+seconds3+" seconds");

        }



    }
}
