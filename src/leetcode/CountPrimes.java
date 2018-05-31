package leetcode;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(farBetterSolution(1000));

	}
    public static int primesLessThanN(int n) {
        if(n<=2){
            return 0;
        }
        int count=0;
    	// 0 means prime
        // 1 means not prime
        int [] prime = new int[n];
        for(int i=2;i<Math.sqrt(n);i++){// 36ms with sqrt and 61ms without sqrt
        	if(prime[i]==0){
        		for(int j=2;i*j<n;j++){
        			prime[i*j]=1;
        		}
        	}
        }
        for(int i=0;i<n;i++){
        	if(prime[i]==0){
        		count++;
        	}
        }
    	
    	return count;
    }
    public static int betterSolution(int n){
        if(n<3){
            return 0;
        }
        int count=0;
    	// 0 means prime
        // 1 means not prime
        int [] prime = new int[n];
        for(int i=2;i<Math.sqrt(n);i++){
        	if(prime[i]==0){
        		for(int j=3;i*j<n;j+=2){
        			prime[i*j]=1;
        		}
        	}
        }
        for(int i=0;i<n;i++){
        	if(prime[i]==0){
        		count++;
        	}
        }
    	
    	return count;
    	
    }
    
    public static int farBetterSolution(int n){
    	
    	if(n<3)
    		return 0;
    	int count = n/2;
    	
    	int [] prime = new int[n];
    	
    	prime[2]=1;
    	for(int i=3;i<n;i+=2){
    		//System.out.println(i);
    		prime[i]=1;
    	}
    	
    	for(int i=3;i<Math.sqrt(n);i+=2){
    		if(prime[i]==1){
    			/*for(int j=3;j*i<n;j+=2){
    				if(prime[i*j]==1){
    					prime[i*j]=0;
    					count--;
    				}
    			}*/ // runs with 23 ms
    			
    			for(int j=i*i;j<n;j=j+2*i){
    				if(prime[j]==1){
    					prime[j]=0;
    					count--;
    				}
    			}
    			
    		}
    	}
    	for(int i=1;i<n;i++){
    		if(prime[i]==1){
    			System.out.println(i);
    		}
    	}
    	return count;
    }
    
    
    
    public static int bestSolution(int n){
    	/**
         * if n = 2, the prime 2 is not less than n,
         * so there are no primes less than n
         */
        if (n < 3) return 0;
        
        /** 
         * Start with the assumption that half the numbers below n are
         * prime candidates, since we know that half of them are even,
         * and so _in general_ aren't prime.
         * 
         * An exception to this is 2, which is the only even prime.
         * But also 1 is an odd which isn't prime.
         * These two exceptions (a prime even and a for-sure not-prime odd)
         * cancel each other out for n > 2, so our assumption holds.
         *     			for(int j=3;j*i<n;j+=2){
    				if(prime[i*j]==1){
    					prime[i*j]=0;
    					count--;
    				}
    			}
         * We'll decrement count when we find an odd which isn't prime.
         *
         * If n = 3,  c = 1.
         * If n = 5,  c = 2.
         * If n = 10, c = 5.
         */
        int c = n / 2;
        
        /**
         * Java initializes boolean arrays to {false}.
         * In this method, we'll use truth to mark _composite_ numbers.
         * 
         * This is the opposite of most Sieve of Eratosthenes methods,
         * which use truth to mark _prime_ numbers.
         * 
         * We will _NOT_ mark evens as composite, even though they are.
         * This is because `c` is current after each `i` iteration below.
         */
        boolean[] s = new boolean[n];
        
        /**
         * Starting with an odd prime-candidate above 2, increment by two
         * to skip evens (which we know are not prime candidates).
         */
        for (int i = 3; i * i < n; i += 2) {
            if (s[i]) {
                // c has already been decremented for this composite odd
                continue;
            }
            
            /** 
             * For each prime i, iterate through the odd composites
             * we know we can form from i, and mark them as composite
             * if not already marked.
             * 
             * We know that i * i is composite.
             * We also know that i * i + i is composite, since they share
             * a common factor of i.
             * Thus, we also know that i * i + a*i is composite for all real a,
             * since they share a common factor of i.
             * 
             * Note, though, that i * i + i _must_ be composite for an
             * independent reason: it must be even.
             * (all i are odd, thus all i*i are odd,
             * thus all (odd + odd) are even).
             * 
             * Recall that, by initializing c to n/2, we already accounted for
             * all of the evens less than n being composite, and so marking
             * i * i + (odd)*i as composite is needless bookkeeping.
             * 
             * So, we can skip checking i * i + a*i for all odd a,
             * and just increment j by even multiples of i,
             * since all (odd + even) are odd.
             */
            for (int j = i * i; j < n; j += 2 * i) {
                if (!s[j]) {
                    c--;
                    s[j] = true;
                    }
                }
            }
        return c;
    }
    	
}