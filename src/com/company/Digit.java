package com.company;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Digit {

    public ArrayList<String> PossibleAmbiguousSolutions = new ArrayList<>();

    private String w0 = " _ ";
    private String w1 = "   ";
    private String w2 = "  |";
    private String w3 = "| |";
    private String w4 = "|_|";
    private String w5 = " _|";
    private String w6 = "|_ ";
    private String w7 = " _|";


    //Convert input to account number as char array
    public char[] convertStringToAccountNumberCharArray(String[] Input) {
        char[] Result = this.convertStringToAccountNumber(Input).toCharArray();
        return Result;
    }

    //Convert input to account number as int array
    public int convertStringToAccountNumberInt(String[] Input) {
        int Result;
        String AccountNumber= this.convertStringToAccountNumber(Input);
        Result = Integer.parseInt(AccountNumber);
        return Result;
    }

    //Convert input to account Number as String
    public String convertStringToAccountNumber(String[] Input) {
        String Result = "";
        for(int i = 0; i < 9;i++){
            Result += this.convertStringToNumber(Input,i);
        }
        return Result;
    }

    //Convert input to number by id. ID range 0-8
    public String convertStringToNumber(String[] Input, int Digit_Place) {
        String Result;

        String[] Output = {Input[0].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
                Input[1].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
                Input[2].substring(Digit_Place * 3, (Digit_Place * 3) + 3)};

        Result = this.convert(Output);
        return Result;
    }

    public String convert(String[] digit) {
        boolean Done = false;
        String DigitErr = "?";
        String Result = DigitErr;

        if (digit.length != 3) {
            return Result;
        }

        if (digit[0].equals(w1)) {
            if (digit[1].equals(w2)) {
                if (digit[2].equals(w2)) {
                    Result = "1";
                } else Result = DigitErr;
            } else if (digit[1].equals(w4)) {
                if (digit[2].equals(w2)) {
                    Result = "4";
                } else Result = DigitErr;
            }
        } else {
            if (digit[1].equals(w2)) {
                if (digit[2].equals(w2)) {
                    Result = "7";
                } else Result = DigitErr;
            } else if (digit[1].equals(w3)) {
                if (digit[2].equals(w4)) {
                    Result = "0";
                } else Result = DigitErr;
            } else if (digit[1].equals(w4)) {
                if (digit[2].equals(w4)) {
                    Result = "8";
                } else if (digit[2].equals(w5)) {
                    Result = "9";
                } else Result = DigitErr;
            } else if (digit[1].equals(w5)) {
                if (digit[2].equals(w5)) {
                    Result = "3";
                } else if (digit[2].equals(w6)) {
                    Result = "2";
                } else Result = DigitErr;
            } else if (digit[1].equals(w6)) {
                if (digit[2].equals(w5)) {
                    Result = "5";
                } else if (digit[2].equals(w4)) {
                    Result = "6";
                } else Result = DigitErr;
            }
        }
        return Result;
    }

    //Convert input to number by id. ID range 0-8
    public void solveAmbiguous(String[] Input, int Digit_Place) {
        Set<String> SetOfgetPossibleAmbiguousSolutions = new HashSet<String>();

        String[] Output = {Input[0].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
                Input[1].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
                Input[2].substring(Digit_Place * 3, (Digit_Place * 3) + 3)};

        testingStrokesHorisontal(SetOfgetPossibleAmbiguousSolutions, Output);

        testingStrokesVertical(SetOfgetPossibleAmbiguousSolutions, Output);

        //combined solution to be developed / reset after each try!
        cos2( SetOfgetPossibleAmbiguousSolutions, Output);

        this.PossibleAmbiguousSolutions.addAll(SetOfgetPossibleAmbiguousSolutions);

    }

    private void cos2( Set<String> setOfgetPossibleAmbiguousSolutions, String[] imput) {
        String[] tempNumber = new String[]{imput[0], imput[1], imput[2]};

        char[] temp;
        String Result;

        for (int i = 0; i < imput.length; i++) {
            temp = imput[i].toCharArray();
            if(temp[1] == ' '){
                imput[i] = imput[i].replace(' ','_');
                for (int j = 0; j < 2; j += 2) {
                    if(temp[j] == ' '){
                        temp[j] = '|';
                    }
                    imput[i] = String.valueOf(temp);
                    Result = this.convert(imput);
                    if (!Result.contains("?")) {
                        setOfgetPossibleAmbiguousSolutions.add(Result);
                    }
                    imput[i] = imput[i].replace(' ','_');
                }
                imput[i] = tempNumber[i];
            }
        }
    }

    private void testingStrokesVertical(Set<String> setOfgetPossibleAmbiguousSolutions, String[] imput) {
        String[] tempNumber = new String[]{imput[0], imput[1], imput[2]};

        char[] temp;
        String Result;

        for (int i = 1; i < imput.length; i++) {
            temp = imput[i].toCharArray();
            for (int j = 0; j < 2; j += 2) {
                if(temp[j] == ' '){
                    temp[j] = '|';
                }
                imput[i] = String.valueOf(temp);
                Result = this.convert(imput);
                if (!Result.contains("?")) {
                    setOfgetPossibleAmbiguousSolutions.add(Result);
                }
                imput[i] = tempNumber[i];
            }
        }
    }

    private void testingStrokesHorisontal(Set<String> setOfgetPossibleAmbiguousSolutions, String[] imput) {
        String[] temp = new String[]{imput[0], imput[1], imput[2]};
        String Result;
        for (int i = 0; i < imput.length; i++) {
            imput[i] = imput[i].replace(' ','_');
            Result = this.convert(imput);
            if (!Result.contains("?")) {
                setOfgetPossibleAmbiguousSolutions.add(Result);
            }
            imput[i] = temp[i];
        }
    }

}