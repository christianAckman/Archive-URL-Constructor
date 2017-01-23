import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Collect {
	
	Document doc = null;
	Elements item = null;
	ArrayList<String> resultNames = null;
	
	
	
	public void collectData(String[] urlStrings){
		
		Boolean stop = false;
		
		resultNames = new ArrayList<String>();
		
		String URL = "";
		
		int pageNum = 1; // CounterVariable
		
		
		while(stop == false){
			
			URL = urlStrings[0] + pageNum;	// connect first half and pageNum
			
			for(int i = 1; i<urlStrings.length; i++){	// i = 1 to skip first half
				URL += urlStrings[i];
			}
			
			
			
			try{
			doc = Jsoup.connect(URL).get();		// Connect with site - get HTML - First page can take 2 minutes

			
				Elements element = doc.getElementsByClass("no-results");	// Check if page is empty!
				if(!element.isEmpty()){
					break;
				}

				Elements elements = doc.getElementsByClass("item-ia");
				
				for(Element ele : elements){
					resultNames.add(ele.attr("data-id"));
					System.out.println(ele.attr("data-id"));
				}
				pageNum++;
			}


			catch(Exception e){
				System.out.println("ouch, error");
			}
		}
		
	}
	
	public String[] constructURL(String[] searchWords){
		/*	FORMAT
		
		https://archive.org/details/texts?and[]=mediatype=texts&and[]=
		searchWord + searchWord
		&sort=
		&page=
		pageNum
		&scroll=1
		
		
		
	 	*/
		
		/*
		switch(sortType){
		case "none":
			sortType = "";
			break;
		case "downloads":
			sortType = "downloads";
			break;
		case "-downloads":
			sortType = "-downloads";
			break;
		case "title":
			sortType = "title";
			break;
		case "-title":
			sortType = "-title";
			break;
		case "datePublished":
			sortType = "datePublished";
			break;
		case "-datePublished":
			sortType = "-datePublished";
			break;
		case "dateArchived":
			sortType = "dateArchived";
			break;
		case "-dateArchived":
			sortType = "-dateArchived";
			break;
		case "dateReviewed":
			sortType = "dateReviewed";
			break;
		case "-dateReviewed":
			sortType = "-dateReviewed";
			break;
		case "reviewDate":
			sortType = "reviewDate";
			break;
		case "-reviewDate":
			sortType = "-reviewDate";
			break;
		case "creator":
			sortType = "creator";
			break;
		case "-creator":
			sortType = "-creator";
			break;
		}
		*/
		
		
		String urlSTART1 = "https://archive.org/details/texts?and[]=mediatype=texts&and[]=";
		String urlSEARCHWORDS2 = ""; // Holds search Words
		String urlMIDDLE3 = "&sort=&page=";
		String urlEND4 = "&scroll=1";
		
		if(searchWords.length == 1){
			urlSEARCHWORDS2 = searchWords[0];
		}
		else{
			for(String word : searchWords){	// Loop through search words
				urlSEARCHWORDS2 += word + "+";
			}	
			urlSEARCHWORDS2 = urlSEARCHWORDS2.substring(0, urlSEARCHWORDS2.length() - 1);	// Remove the last '+'
		}
		
		

		String[] urlStrings = new String[2];
		
		urlStrings[0] = urlSTART1 + urlSEARCHWORDS2 + urlMIDDLE3;
		urlStrings[1] = urlEND4;
		
		return urlStrings;
	}
	
	
}
