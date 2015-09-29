import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class PROBLEM2 {
	public static String key[][] = {
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
			{"", "", "", "", ""},
	};
	public static double totalQuadScore;
	public static String missingLetter = "J";
	public static double TEMP = 20;
	public static double STEP = 0.2;
	
    public static void main(String[] args) throws IOException {
    	String encryptedString = "UPURUHNTHZHZXBTMMVZEQUIXAUCYZXKZZQUKXBHNBZLUUPRGQUAQENEQYHBMABFQQHEQVPDZZXAQENEQCQMLFHDRVGQXFHAOXUUKVGQHEOVNTWOHOYZBLMFOEODLXEILPVCEDNURKFMHTCNDUZZKTAKIZXHOOYOVBQYGMHQUHBHTXMQVUKKSCXUCBMXZVEOFUKAQENEQBPZLEOVNTWAQENEQQXNSHFEUMEYZBEGRXBOVMLFVPBFOQHEQMHQGZBBZUZZKHQTOYOHOMHWDHFOIUPFHGUZLUQOHAZDLHOVGDYRGOVHCXQDLKEVUVHGNZKOCCQMLRHMXRYIXXILNCZDWZLHMEZMHUCBMVMUGMHTPXLMXDZMHVMAQENEQYXVUOYMXMHQWHCXMQFEHUPTOUPRYFMFHDROYMVZBNQHFMLTPLMFOQHEQONKILIQHEQUCCYMHXMQVUKNGQCAZUGMHWDHFOIMLYDGQFMBZQXXZLAHFHZMXGUHOMHQWHCXMBQWPLHVHFMTZGUHOMXFGEAZXDOQUOYZBHQHOZTCUXZDWNTVCAIAQENEQYMMVZBIAQUGDXBTCVMOYMVHMPXXBMXUQOYMLFPQHEQBMVMCKABYQGNKSFMVUVHLMURMHOYMLAQENEQKDQXVHUZQXNSFMFHDROYOVEOVNTWVMAQRDEIZXPBLNEWXIUPVMKZQCMXOVOYIAUCBZUPOYHMPXXEVMUKVMPXOYHZYMMXOYMBQTGDAELMYZZXPVCEDLHOHCAZXQVUOYIAUCBZYMOVYGEOGYDOCQBZUGQHBEUMMVZEQUBEDLTQDWYHCYOYHETMBEGDAQENEQUCCYMLVSXCLWUPFHQCMXOVOYIAUCBZOVOYIAUCBZHCAZXQVUOYIAUCBZYXRUQHOVVHTMQYCTVHURMHWTZABEVHUGMHYQGNKPQHEQKMOYEQUWLZVLVIVMURMLCFIAFHQUKPQHEQOYHBBMVMNDEXXIOHNQMLVPUWHQVMZHQXMLFVTQHRMHZNHOQXUGMHKSQTLPQHEQBPZLTQLRMLCXUKAQENEQYMMXOYHBEOXPFUPBVOXEDLQUZXOYHEVQVUVHZQGYOHLZFEXMZHQXMLFZURMHWDHFOIKZDWQFZCFHQUUPRYYULZUZMBQXOYQVTWOHEOABOYZBYQGNQXNSYUAQNXLDOYHEDYOYEAHVCUNZHMQVTWBPZLONEHFUSUHOMKPBOYMVIAQHEQHFBQWGZFYOOYMVHAURMHBQXUUCTIZKCTCKAILNFMDRCXUCNTVOFLKDPBOUBEFMTIMBQXVHNZHVHYEAHEFOQHEQYMSUZLURMHHLYGFZABHFOHZHOYMXMHVIUFPBOYHTTZOYMBMVZBHFFHDRMLQXBVQEMLOVHCRNHFEOONZBFHQUMHHTTZVUOHEOABXBMXEXXIOHQXKSMVMLVGQUOHTIEZAQENEQMEKYVQMLKDQYQXLNRQZBCQDWEFZXHOBQYGMHVMYPZHOYMLTZHMPXZEBDBZLZURMHUCDRVOFLKSHFZUNHKXZXQTIXPBOUBETQDTYOMHOHWLQYYMOVHFCXNIBEUREOLULNEWXIUPVMBVAZOFZXMEHRHTDLMVYGQXXPDLPBTCGRMEKYAUCYUPGYCEUZMVZEQUIAQHEQOYHVCXZBCTXBZXXIOYBXQVLZABXMABVMABUMBEGNCTOYHZUHXTMXBAMVMHQVUPVRMHVOXIYPVKBVZXXIOYBXQVGDCENGQUMLQFZXNXHTKDSUHOUHNTIBZLLZDRAQENEQFMTZRUQAQHEQEZUQFOQHEQBPZLMHQWHCXMMLYDGQFMBZUPGUHUHTWLQYOYHZOYMXBMXUFIQHEQCTAQNTBZZLHYQVTWUCCYZXDOAQENEQLZABGRZXUPVUOYIAMFOLZWVOLQHAVGQUEOFEDRVMPXEXAUCYOYOVMHQWHCXMEOLDHOBQYDDQVMAIXZURZXUPRGQUAQENEQYHBMABFQQHEQUCCYZXXBHNBZXSUOMHMFYDGQFMBZUPOHIOQHHAXQXUUFMHCULSZLBDYGQTEHBPVMYDADCQBZUGAYBXBVZXXIKPQHEQQVMXVUOYHBOYIVHTURCEUQVLVCMFTCGRNDHVMHKMEPGNQXUGMHYHADCZDRCQVYEXKEVUOUVQXVKEVUOUQXUZMVAOILFKDRYGNHAZLADYHZZBCEUZMVZEQUZVZFFDMLPGHOYMOVBQYGMHXCYGQUIAQHHAVLCKGYCENGQUAQENEQUCCYMLFZDLZKXBFKIVVGQHEOVNTWOHMHQWHCXMUPOUHTHNYGABMHQVUPVKEXKEVUOUVQXVKEVUOUTQLQQHEQUHLYUQKRNXNKIXUIQVTWQXLZBMVMWVHTTZOTASWHDTFDZBBPZLMHQWHCXMUPRYZXZLURMHQVYGQTEHKDKLHVEORYMHRNMBMVIXHFFUIAQHEQBMMHQVGDUQBNYMHFBEDLOYZBBAMXNSQVABBPDLIKDLMVIXXCYMOVYGEOFOQHEQQXKFXDZBBPKBZXTQDLHOYPOYZBBEVMOIKFNGMXBDYGQTEHBPKBZXMHQWHCXMAQENEQXBDLMLVPVPMLYGATMVOYMVNDZB";
    	SortedMap<String, Integer> letterCount = convertToMap(encryptedString);
    	
    	BufferedReader quadgramFile = new BufferedReader(new FileReader("english_quadgrams.txt"));
    	SortedMap<String, Double> quadgramScores = quadgramToMap(quadgramFile);
    	
    	System.out.print(encryptedString + '\n');
        System.out.print(letterCount + "\n");
        
//        System.out.print(findSixes(encryptedString) + "s\n");
//        System.out.print(findFives(encryptedString) + "\n");
//        System.out.print(findQuadruplets(encryptedString) + "\n");
//        System.out.print(findTriplets(encryptedString) + "\n");
//        System.out.print(findDoubles(encryptedString) + "\n");
        
//        print(findSixes(encryptedString));
//        printTriplets(findDoubles(encryptedString));
//        printTriplets(findTriplets(encryptedString));
//        printTriplets(letterCount);
//        printHistogram(letterCount);
        
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String decodedString;
        double childScore = 0, 
        	parentScore = 0,
        	scoreDiff = 0,
        	prob = 0,
        	bestScore = (-1)*Double.MAX_VALUE;
        String parentKeyString = "UNDLXTRGFVOQPCAHMZIEYWSKB",
        	childKeyString = "",
        	bestKey = "";
        
        parentKeyString = fillKeyString(parentKeyString);
        //generate score with random key and store the score
        populatePlayfair(parentKeyString);
        decodedString = decode(encryptedString);
        parentScore = findEnglishScore(decodedString, quadgramScores);
        for (double T = TEMP; T >= 0; T-=STEP) {
        	for (int count = 50000; count>0; count--) {
        		childKeyString = randomSwap(parentKeyString);
        		populatePlayfair(childKeyString);
        		decodedString = decode(encryptedString);
        		childScore = findEnglishScore(decodedString, quadgramScores);
        		scoreDiff = childScore - parentScore;
        		//decide if the child should be kept or not
        		if(scoreDiff >= 0){
        			parentKeyString = childKeyString;
        			parentScore = childScore;
        		}else if(T>0){
        			prob = Math.exp(scoreDiff/T);
        			if(prob > Math.random()){
        				parentScore = childScore;
        				parentKeyString = childKeyString;
        			}
        		}
        		if(parentScore > bestScore) {
        			bestScore = parentScore;
        			bestKey = parentKeyString;
        			System.out.print(bestKey + "\n");
        			System.out.print("BestScore: " + bestScore + "\n");
        			System.out.print(decodedString + "\n");
        		}
        	}
        	System.out.print("T value: " + T);
        }
        System.out.print(bestKey + "\n");
        populatePlayfair(bestKey);
		decodedString = decode(encryptedString);
        System.out.print(decodedString);
    }
    
    private static String randomSwap(String startingKeyString) {
    	char[] stringChars = startingKeyString.toCharArray();
    	
		int firstLetterToSwap = (int) ((Math.random()*100) % 25),
			secondLetterToSwap = 0;
		
		do{
			secondLetterToSwap = (int) ((Math.random()*100) % 25);
		}while (firstLetterToSwap == secondLetterToSwap);
		
		char temp = stringChars[firstLetterToSwap];
		stringChars[firstLetterToSwap] = stringChars[secondLetterToSwap];
		stringChars[secondLetterToSwap] = temp;
		
		String result2 = new String(stringChars);
		
//		System.out.print(startingKeyString+"\n");
//		System.out.print(result2+"\n");
		return result2;
	}

	private static double findEnglishScore(String decodedString, SortedMap<String, Double> quadgramScores) {
		String quadgram;
		double quadgramScore = 0;
		for (int i = 0, len = decodedString.length(); i < len-4; i++) {
			quadgram = decodedString.substring(i,i+4);
			if(quadgram.equals("MXMA")) {
				quadgram += 10;
				continue;
			}
			if(quadgram.equals("OMXM")) {
				quadgram += 10;
				continue;
			}
			if(!quadgramScores.containsKey(quadgram)) {
				quadgram += (-1)*Double.MAX_VALUE;
				continue;
			}
			quadgramScore += quadgramScores.get(quadgram);
    	}
    	return quadgramScore;
	}

	private static SortedMap<String, Double> quadgramToMap(BufferedReader quadgramFile) throws IOException {
		// TODO Auto-generated method stub
    	String quad= null, quadgram = null;
    	Double totalScore = 0.0, score; 
    	SortedMap<String, Double> quadgramScore = new TreeMap<String, Double>();
    	while ((quadgram = quadgramFile.readLine()) != null) {
    		quad = quadgram.substring(0,4);
    		score = Double.parseDouble(quadgram.substring(5,quadgram.length()));
    		totalScore += score;
    		quadgramScore.put(quad, score);
        }
    	quadgramScore = findProbabilityOfQuad(quadgramScore, totalScore);
		return quadgramScore;
	}

	private static SortedMap<String, Double> findProbabilityOfQuad(SortedMap<String, Double> quadgramScore, Double totalScore) {
		Set<Entry<String, Double>> quadgrams = quadgramScore.entrySet();
		SortedMap<String, Double> newQuadgramScore = new TreeMap<String, Double>();
		Double probability;
		String quadKey;
		
		for(Map.Entry<String, Double> quad : quadgrams) {
			quadKey = quad.getKey();
			probability = quad.getValue()/totalScore;
			probability = Math.log(probability);
			newQuadgramScore.put(quadKey, probability);
		}
		return newQuadgramScore;
	}

	public static void populatePlayfair(String keyString) {
    	int x =0, k=0;
    	if(keyString.length() < 25) {
    		keyString = fillKeyString(keyString);
    	}
    	for (int i = 0, len = keyString.length(); i < len; i++) {
    		if(k == 4){
    			key[x][k] = String.valueOf(keyString.charAt(i));
    			k = 0;
    			x++;
    		}else {
    			key[x][k] = String.valueOf(keyString.charAt(i));
    			k++;
    		}
    	}
    }
    
    private static String fillKeyString(String keyString) {
    	int keyStringLength = keyString.length();
    	for (int i = keyStringLength; i < 25; i++) {
    		for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) {
    			String letter = String.valueOf(alphabet);
    			if(!keyString.contains(letter)) {
    				if(letter.equals(missingLetter)){
        				continue;
        			}
    				keyString = keyString.concat(letter);
    				break;
    			}
    		}
    	}
    	return keyString;
	}

    
    public static String decode(String encryptedString) {
    	ArrayList<String> diagraph = convertToDiagraph(encryptedString);
//    	System.out.print(diagraph);
    	
    	StringBuilder decodedString = new StringBuilder();
    	for(String pair : diagraph) {
    		String decodedPair = isVertical(pair, key);
    		
    		if(decodedPair != null) {
    			decodedString.append(decodedPair);
    		}else if(isHorizontal(pair, key) != null) {
    			decodedString.append(isHorizontal(pair, key));
    		}else{
    			decodedString.append(isDiagonal(pair, key));	
    		}
    	}
//    	System.out.print(decodedString);
//    	System.out.print('\n');
    	return decodedString.toString();
    }
    
    public static ArrayList<String> convertToDiagraph(String encryptedString) {
    	ArrayList<String> diagraph = new ArrayList<String>();
    	for (int i = 0, len = encryptedString.length()-1; i < len; i+=2) {
    		diagraph.add(encryptedString.substring(i, i+2));
    	}
		return diagraph;
    }
    
    public static String isDiagonal(String search, String key[][]) {
    	String firstChar = String.valueOf(search.charAt(0));
    	String secondChar = String.valueOf(search.charAt(1));
    	int xInt1 = 0, yInt1 =0, xInt2 =0, yInt2 =0;
    	
    	for(int j=0; j<5; j++) {
    		for( int k=0; k<5; k++) {
    			if (key[j][k].equals(firstChar)){
    				yInt1 = k;
    				xInt1 = j;
    				break;
    			}
    		}
    	}
    	for(int j=0; j<5; j++) {
    		for( int k=0; k<5; k++) {
    			if (key[j][k].equals(secondChar)){
    				yInt2 = k;
    				xInt2 = j;
    				break;
    			}
    		}
    	}
    	StringBuilder tempString = new StringBuilder();
    	tempString.append(key[xInt1][yInt2]);
    	tempString.append(key[xInt2][yInt1]);
    	
    	return tempString.toString();
    } 
    
    public static String isVertical(String search, String key[][]) {
    	String firstChar = String.valueOf(search.charAt(0));
    	String secondChar = String.valueOf(search.charAt(1));
    	int xInt1 = 0, yInt1 =0, xInt2 =0;
    	
    	for(int j=0; j<5; j++) {
    		for( int k=0; k<5; k++) {
    			if (key[j][k].equals(firstChar)){
    				yInt1 = k;
    				xInt1 = j;
    				break;
    			}
    		}
    	}
    	for( int k=0; k<5; k++) {
    		if (key[k][yInt1].equals(secondChar)){
    			xInt2 = k;
    			break;
    		}
    	}
    	if(xInt2 ==0 ){
    		return null;
    	}
    	StringBuilder tempString = new StringBuilder();
    	tempString.append(key[(xInt1+4)%5][yInt1]);
    	tempString.append(key[(xInt2+4)%5][yInt1]);
    	
    	return tempString.toString();
    }
    
    public static String isHorizontal(String search, String key[][]) {
    	String firstChar = String.valueOf(search.charAt(0));
    	String secondChar = String.valueOf(search.charAt(1));
    	int xInt1 = 0, yInt1 =0, yInt2 =0;
    	
    	for(int j=0; j<5; j++) {
    		for( int k=0; k<5; k++) {
    			if (key[j][k].equals(firstChar)){
    				yInt1 = k;
    				xInt1 = j;
    				break;
    			}
    		}
    	}
    	for( int k=0; k<5; k++) {
    		if (key[xInt1][k].equals(secondChar)){
    			yInt2 = k;
    			break;
    		}
    	}
    	if(yInt2 ==0 ){
    		return null;
    	}
    	StringBuilder tempString = new StringBuilder();
    	tempString.append(key[xInt1][(yInt1+4)%5]);
    	tempString.append(key[xInt1][(yInt2+4)%5]);
    	
    	return tempString.toString();
    }
    
    public static void print (SortedMap<String, Integer> tripletMap) {
		for (Entry<String, Integer> entry : tripletMap.entrySet()) {
			String key = (entry.getKey());
			int tripleCount = entry.getValue();
			System.out.print(key + "	" + tripleCount + '\n');
		}
    }
    
    public static SortedMap<String, Integer> findSixes(String encryptedString) {
    	SortedMap<String, Integer> tripletMap = new TreeMap<String, Integer>();
    	
    	for (int i = 0, len = encryptedString.length(); i < len-6; i++) {
    		String triplet = encryptedString.substring(i, i+6);
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
    
    public static SortedMap<String, Integer> findFives(String encryptedString) {
    	SortedMap<String, Integer> tripletMap = new TreeMap<String, Integer>();
    	
    	for (int i = 0, len = encryptedString.length(); i < len-5; i++) {
    		String triplet = encryptedString.substring(i, i+5);
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
}