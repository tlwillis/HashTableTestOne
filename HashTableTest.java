package hashtabletest;

import java.util.Arrays;

public class HashTableTest {
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;
    
    
    public static void main(String[] args) {
        
        System.out.println("Test");
        
        HashTableTest theFunct = new HashTableTest(30);
        String[]elementsToAdd = {"2", "4", "7"};
        //theFunct.hashFunctionOne(elementsToAdd, theFunct.theArray);
        //theFunct.displayTheStack();
        
        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
        
        theFunct.hashFunctionTwo(elementsToAdd2, theFunct.theArray);
        theFunct.displayTheStack();
        
        theFunct.findKey("660");

    }
    
    
    public void hashFunctionOne(String[] stringsForArray, String[] theArray){
        
        for(int i = 0; i < stringsForArray.length; i++){
            
            String newElementValue = stringsForArray[i];
            theArray[Integer.parseInt(newElementValue)] = newElementValue;
        }    
    }
    
    
    public void hashFunctionTwo(String[] stringsForArray, String[] theArray){
        
        for(int i = 0; i < stringsForArray.length; i++){
            
            String newElementValue = stringsForArray[i];
            int arrayIndex = Integer.parseInt(newElementValue) % 29;
            System.out.println("Mod index = " + arrayIndex + " for value " + newElementValue);
            
            while(theArray[arrayIndex] != "no"){
                
                ++arrayIndex;
                System.out.println("Collision occurred try " + arrayIndex);
                arrayIndex %= arraySize;
            }
            
            theArray[arrayIndex] = newElementValue;
        }
    }
    
    public String findKey(String key){
        
        int arrayIndexHash = Integer.parseInt(key) % 29;
        
        while(theArray[arrayIndexHash] != "no"){
            System.out.println(key + " was found in index " + arrayIndexHash);
            
            return theArray[arrayIndexHash];
        }
        
        arrayIndexHash++;
        
        arrayIndexHash %= arraySize;
        
        return "null";
    }

    
    
    HashTableTest(int size){
        
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "no");
    }
    
    public void displayTheStack() {

		int increment = 0;

		for (int m = 0; m < 3; m++) {

			increment += 10;

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				System.out.format("| %3s " + " ", n);

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				if (theArray[n].equals("-1"))
					System.out.print("|      ");

				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

		}

	}
}
