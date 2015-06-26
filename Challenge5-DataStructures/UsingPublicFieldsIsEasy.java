//UIUC CS125 FALL 2012 MP. File: UsingPublicFieldsIsEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2012-10-12T13:24:10-0500.281837000

/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 *
 *@author lzhou8
 */

public class UsingPublicFieldsIsEasy {

	public static SimplePublicTriple analyze(SimplePublicPair in) {
		SimplePublicTriple  user = new SimplePublicTriple ();
		int M=0;
		user.x=Math.min(in.a, in.b);
		user.y=Math.max(in.a,in.b);
		M=in.a * in.b;
		user.description=""+in.a+"*"+in.b+"="+ M;	
		return user;
	}
}
