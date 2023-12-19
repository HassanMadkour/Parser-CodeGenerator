package rules;

import main.Token;

public class IF {

    public static void ifStatment() {
        if (Token.getNextToken()[0] == "(") {
            if(){
                if(Token.getNextToken()[0] == ")"){
                    switch (Token.getNextToken()[0] ) {
                        case "{":{
                        Statment.statment(Token.getNextToken());
                        if (Token.getNextToken()[0] == "}") {
                                        System.out.println("NO ERROR");

                        }
                    }
                            
                            break;
                    
                        default:
                            break;
                    }
                }else{
            System.err.println("Error Syntax");
        }
            }else{
            System.err.println("Error Syntax");
        }
        } else {
            System.err.println("Error Syntax");
        }
    }
}
