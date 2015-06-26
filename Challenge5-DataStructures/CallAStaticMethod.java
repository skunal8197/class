//UIUC CS125 FALL 2012 MP. File: CallAStaticMethod.java, CS125 Project: Challenge5-DataStructures, Version: 2012-10-12T13:24:10-0500.281837000
/**
 * Prints out only lines that contain an email address Each printed line is
 * justified to right by prepending the text with '.' characters The minimum
 * width of the line including padding is 40 characters. See the test case for
 * example input and expected output.
 * @author lzhou8
 */
class CallAStaticMethod {

	public static void main(String[] args) {

		while (!TextIO.eof()) {
			String s="";
			String line = TextIO.getln();
			if (ExampleClassMethods.isEmailAddress(line)==true){
				s=ExampleClassMethods.createPadding('.', 40-line.length());
				s=s+line;
				TextIO.putln(s);}
			
			
			// Use ExampleClassMethods
			// 'isEmailAddress' and 'createPadding' to complete this method
			
		}

	}
}
