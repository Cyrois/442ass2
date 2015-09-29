import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;



public class PROBLEM3 {
	
	public static void main(String[] args) {

		Random randomGen = new Random();
		Integer x = randomGen.nextInt(Integer.MAX_VALUE),
				y = randomGen.nextInt(Integer.MAX_VALUE);
		
		Checksum firstSum = new CRC32();
		Checksum secondSum = new CRC32();
		
		long firstSumValue = 0; 
		long secondSumValue = 1; 
		
		while((firstSumValue  != secondSumValue) || (x.equals(y))) {
			x = randomGen.nextInt(Integer.MAX_VALUE);
			y = randomGen.nextInt(Integer.MAX_VALUE);
			
			byte firstBytes[] = Integer.toString(x).getBytes();
			byte secondBytes[] = Integer.toString(y).getBytes();
			
			firstSum.update(firstBytes, 0, firstBytes.length);
			secondSum.update(secondBytes, 0, secondBytes.length);
			
			firstSumValue = firstSum.getValue(); 
			secondSumValue = secondSum.getValue();  
			
			firstSum.reset();
			secondSum.reset();
		}
		
		System.out.print("first string: " + x + "\n");
		System.out.print("first string checksum : " + firstSumValue + "\n");
		System.out.print("second string: " + y + "\n");
		System.out.print("second string checksum : " + secondSumValue + "\n");
		System.out.print("DONE");
    }
}