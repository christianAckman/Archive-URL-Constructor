

public class ArchiveMain {

	public static void main(String[] args) {
		
		Collect call = new Collect();
		
		String[] words = new String[4];
		words[0] = "one";
		words[1] = "nice";
		words[2] = "long";
		words[3] = "example";
		
		String[] URL = call.constructURL(words);	// URL needs: Page number
		
		call.collectData(URL);

		
		

		
	}

}
