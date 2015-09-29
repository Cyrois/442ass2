import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class PROBLEM4 {
	
	public static void main(String[] args) {
		//question 3
		Random randomGen = new Random();
		String firstString = "F126A6B25737F666ED81A8C360135CCC";
		long y = 0;
		
		Checksum firstSum = new CRC32();
		Checksum secondSum = new CRC32();
		
		long firstSumValue = 0; 
		long secondSumValue = 1; 
		
		while((firstSumValue  != secondSumValue) || (firstString.equals(Long.toString(y)))) {
			y = randomGen.nextLong();
			
			byte firstBytes[] = firstString.getBytes();
			byte secondBytes[] = Long.toString(y).getBytes();
			
			firstSum.update(firstBytes, 0, firstBytes.length);
			secondSum.update(secondBytes, 0, secondBytes.length);
			
			firstSumValue = firstSum.getValue(); 
			secondSumValue = secondSum.getValue();  
			
			firstSum.reset();
			secondSum.reset();
		}
		
		System.out.print("first string: " + firstString + "\n");
		System.out.print("first string checksum : " + firstSumValue + "\n");
		System.out.print("second string: " + y + "\n");
		System.out.print("second string checksum : " + secondSumValue + "\n");
		System.out.print("DONE");
    }
}