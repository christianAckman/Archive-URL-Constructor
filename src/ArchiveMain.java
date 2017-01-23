

public class ArchiveMain {

	public static void main(String[] args) {
		
		Collect call = new Collect();
		
		String[] words = new String[6];
		words[0] = "two";
		words[1] = "pages";
		words[2] = "one";
		words[3] = "four";
		words[4] = "three";
		words[5] = "five";
		
		String[] URL = call.constructURL(words);	// URL needs: Page number
		
		call.collectData(URL);

		
		

		
	}

}
