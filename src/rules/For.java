package rules;

import main.Token;

public class For {
    public static void forStatment() {
        if (Token.getNextToken()[0] == "(") {
            if (ExpressionParser.isValidExpression()// Decleration
            ) {if (
                //condtion
            ) {
                if(Token.getNextToken()[0] == ";"){
                    if(ExpressionParser.isValidExpression()){if (Token.getNextToken()[0] == ")") {
                        if (Token.getNextToken()[0] == "{") {
                            Statment.statment(Token.getNextToken());
                            if (Token.getNextToken()[0] == "}") {
                                
                            }else{
                                
                                                     System.err.println("Prehaps '}' non-exist");
                            }
                            
                        }else{
                                                     System.err.println("Prehaps '{' non-exist");

                        }
                    }else{
                         System.err.println("Prehaps ')' non-exist ");
                    }

                    }else{
                         System.err.println("error in expression ");
                    }
                }else{
                                System.err.println("; not exist");
                }
            }else{
                                System.err.println("error in for condtion ");

            }

            } else {
                System.err.println("error in expression ");

            }

        } else {
            System.err.println("Prehaps '(' non-exist ");
            return;
        }

    }
}
