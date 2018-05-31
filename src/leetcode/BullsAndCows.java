package leetcode;

public class BullsAndCows {

	public static void main(String[] args) {
		
		System.out.println(getHint("1122","1222"));
		
		
	}
    public static String getHint(String secret, String guess) {
        
    	String hint="";
    	int [] secretHash = new int[10];
    	int [] guessHash = new int[10];
    	int bulls=0;
    	int cows=0;
    	for(int i=0;i<guess.length();i++){
    		char guessDigit = guess.charAt(i);
    		char secretDigit = secret.charAt(i);
    		
    		if(secretDigit==guessDigit){
    			bulls++;
    		}
    		else{
    			secretHash[secretDigit-'0']++;
    			guessHash[guessDigit-'0']++;
    		}

    	}
    	
    	for(int i=0;i<10;i++){
    		if(guessHash[i]>0 && secretHash[i]>0){
    			cows+=Math.min(guessHash[i], secretHash[i]);
    		}
    	}
    	hint=hint+String.valueOf(bulls)+"A";
    	hint=hint+String.valueOf(cows)+"B";
    	return hint;
    }

}
