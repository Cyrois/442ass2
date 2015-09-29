import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;


public class PROBLEM1 {
	
    public static void main(String[] args) {
    	String encryptedString = "NZAMZIQISUXZZHBNKTUHQZBKMPZBNKTAINIKNKTNKTIKQBZBKMTHEOFZTBAINXKHIBUKOOAFQFZBAINMRETZBUKOOAAINKTXZHOEBQUARQIBTHEOZITBNKTTXZHZCZHZUKOOAABXABDZZIBAQNUKOOAOAIPPKEISXKDDQTBFHZBZITNKTXEINHZNBKMOEBQUARUHAUVZHBXANDZZIFERRZNNKTOKBTKMTXZODKHZTXZOAHVNARZKITXZOCXQUXNQNIKTUKIGZPOEUXTKOKBTKMTXZXKDDQTBUKOOADETTXZPARRASHZZNTXZPCZHZOAHGZRRKEBUHAUVZHBNKTTXZPUKITAQIZNQIBTHEOZITBUKOOABOARRUKOOADETKMFZHMZUTOAVZAINZIUXAITQISTKIZBNKTQINZZNUKOOAQIKIZUKHIZHBKOZKMTXZPKEISTKKVBAINDHAINPDEUVBUKOOABEFFKBQISEIURZDQRDKTKXAGZMQIQBXZNNKTBQIUZXZXANFRAQIRPBAQNARRTXATCABIZUZBBAHPNKTUKOOAIKCSKTEFAIQOFHKOFTEKHUXZBTHAUKOOAAINDZSAIAOZHHPNAIUZTEIZ";
    	SortedMap<String, Integer> letterCount = convertToMap(encryptedString);
    	
    	System.out.print(encryptedString + '\n');
        System.out.print(letterCount + "\n");
        
//        System.out.print(findQuadruplets(encryptedString) + "\n");
//        System.out.print(findTriplets(encryptedString) + "\n");
//        System.out.print(findDoubles(encryptedString) + "\n");
//        printTriplets(findQuadruplets(encryptedString));
//        printTriplets(findDoubles(encryptedString));
//        printTriplets(findTriplets(encryptedString));
//        printHistogram(letterCount);
        System.out.print(decryptString(encryptedString));
    }
    
    public static void printTriplets (SortedMap<String, Integer> tripletMap) {
		for (Entry<String, Integer> entry : tripletMap.entrySet()) {
			String key = (entry.getKey());
			int tripleCount = entry.getValue();
			System.out.print(key + "	" + tripleCount + '\n');
		}
    }
    
    public static SortedMap<String, Integer> findQuadruplets(String encryptedString) {
    	SortedMap<String, Integer> tripletMap = new TreeMap<String, Integer>();
    	
    	for (int i = 0, len = encryptedString.length(); i < len-4; i++) {
    		String triplet = encryptedString.substring(i, i+4);
    		if (tripletMap.get(triplet) == null) {
    			tripletMap.put(triplet, 1);
    		} else {
    			int count = tripletMap.get(triplet);
    			count++;
    			tripletMap.put(triplet, count);
    		}
    	}
    	return tripletMap;
    }
    
    public static SortedMap<String, Integer> findTriplets(String encryptedString) {
    	SortedMap<String, Integer> tripletMap = new TreeMap<String, Integer>();
    	
    	for (int i = 0, len = encryptedString.length(); i < len-3; i++) {
    		String triplet = encryptedString.substring(i, i+3);
    		if (tripletMap.get(triplet) == null) {
    			tripletMap.put(triplet, 1);
    		} else {
    			int count = tripletMap.get(triplet);
    			count++;
    			tripletMap.put(triplet, count);
    		}
    	}
    	return tripletMap;
    }
    
    public static SortedMap<String, Integer> findDoubles(String encryptedString) {
    	SortedMap<String, Integer> doubleMap = new TreeMap<String, Integer>();
    	
    	for (int i = 0, len = encryptedString.length(); i < len-2; i++) {
    		String triplet = encryptedString.substring(i, i+2);
    		if (doubleMap.get(triplet) == null) {
    			doubleMap.put(triplet, 1);
    		} else {
    			int count = doubleMap.get(triplet);
    			count++;
    			doubleMap.put(triplet, count);
    		}
    	}
    	return doubleMap;
    }
    
	public static String decryptString(String encryptedString) {
    	SortedMap<String, String> letterMapping = new TreeMap<String, String>();
    	letterMapping.put("A", "a");
    	letterMapping.put("B", "s");
    	letterMapping.put("C", "w");
    	letterMapping.put("D", "b");
    	letterMapping.put("E", "u");
    	letterMapping.put("F", "p");
    	letterMapping.put("G", "v");
    	letterMapping.put("H", "r");
    	letterMapping.put("I", "n");
    	letterMapping.put("J", "J");
    	letterMapping.put("K", "o");
    	letterMapping.put("L", "L");
    	letterMapping.put("M", "f");
    	letterMapping.put("N", "d");
    	letterMapping.put("O", "m");
    	letterMapping.put("P", "y");
    	letterMapping.put("Q", "i");
    	letterMapping.put("R", "l");
    	letterMapping.put("S", "g");
    	letterMapping.put("T", "t");
    	letterMapping.put("U", "c");
    	letterMapping.put("V", "k");
    	letterMapping.put("W", "W");
    	letterMapping.put("X", "h");
    	letterMapping.put("Y", "Y");
    	letterMapping.put("Z", "e");
    	
    	StringBuilder decryptedString = new StringBuilder();
    	decryptedString.append(letterMapping.get(String.valueOf(encryptedString.charAt(0))));
    	for (int i = 1, len = encryptedString.length(); i < len; i++) {
    	    String letter = String.valueOf(encryptedString.charAt(i));
    	    decryptedString.append(letterMapping.get(letter));
    	}
    	return decryptedString.toString();
    }
    
    public static SortedMap<String, Integer> convertToMap(String encryptedString) {
    	SortedMap<String, Integer> letterCount = new TreeMap<String, Integer>();
        for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) {
        	int count=0;
        	for (int i = 0, len = encryptedString.length(); i < len; i++) {
        	    if (encryptedString.charAt(i) == alphabet){
        	        count++;
        	    }
        	}
            letterCount.put(String.valueOf(alphabet), count);
        }
        return letterCount;
    }
    
    public static void printHistogram(SortedMap<String, Integer> letterCount) {
    	for(Map.Entry<String, Integer> entry: letterCount.entrySet()) {
    		String letter = entry.getKey();
    		Integer count = entry.getValue();
    		System.out.print(letter + ": ");
    		for(int i=0; i < count; i++) {
    			System.out.print("X");
    		}
    		System.out.print("\n");
    	}
    }
}