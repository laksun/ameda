package com.yla.external.service;

public class Thesaurus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String[] getSynonyms(String wordInput) {
	    String[] resultArray = {};
	    if (wordInput.equals("")) {
	        return resultArray;
	    }
	    try {
	        URL url = new URL("http://www.thesaurus.com/browse/" + wordInput);
	        URLConnection yc = url.openConnection();
	        String foundWords;
	        try (BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()))) {
	            String inputLine;
	            foundWords = "";
	            boolean foundListStart = false;
	            while ((inputLine = in.readLine()) != null) {
	                String iLine = inputLine.trim();
	                if (iLine.equals("<div class=\"relevancy-list\">")) {
	                    foundListStart = true;
	                }
	                if (foundListStart) {
	                    if (iLine.equals("</div>")) {
	                        foundListStart = false;
	                        break;
	                    }
	                    if (iLine.startsWith("<li><a href=")) {
	                        String[] codeLines = iLine.split(" ");
	                        int index = codeLines[1].lastIndexOf('/');
	                        String word = codeLines[1].substring(index + 1, codeLines[1].length());
	                        word = word.replace("%27", "'").replace("%20", " ").replace("\"", "");
	                        if (foundWords.equals("")) {
	                            foundWords += word;
	                        } else {
	                            foundWords += "," + word;
	                        }
	                    }
	                }
	            }
	        }
	        // Convert built comma delimited string to String Array
	        if (!foundWords.equals("")) {
	            resultArray = foundWords.split(",");
	        }
	    } catch (MalformedURLException ex) {
	        // Do what you want with exception
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        // Do what you want with exception
	        ex.printStackTrace();
	    }
	    return resultArray;
	}

}
