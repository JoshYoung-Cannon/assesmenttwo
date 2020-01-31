package main;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String result = input.substring(0, 1);
		// System.out.println("declared as " + result);
		for (int i = 0; i < 2; i++) {
			result = result.concat(input.substring(0, 1));
		}
		// System.out.println("1st char " + result);
		for (int i = 1; i < input.length(); i++) {
			for (int j = 0; j < 3; j++) {
				result = result.concat(input.substring(i, i + 1));
			}
			// System.out.println(i + "th char " + result);
		}

		return result;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		boolean oneBert = false, twoBert = false;
		String currentB, b2b, result = "";
		int b1 = 0, b2 = 0, j = 0;
		;
		String[] temp;
		for (int i = 0; i < input.length() - 3; i++) {
			currentB = input.toLowerCase().substring(i, i + 4);
			// System.out.println("looking at: " + currentB);
			if (currentB.compareTo("bert") == 0) {
				if (oneBert == false) {
					oneBert = true;
					b1 = i + 4; // save t index
				} else if (oneBert == true) {
					twoBert = true;
					b2 = i; // save b index for substring
				}
			}
		}
		// System.out.println("oneBert: " + oneBert + " twoBert: " + twoBert);
		if (twoBert == true) {
			b2b = input.substring(b1, b2);
			// System.out.println("b2b = " + b2b);
			temp = new String[b2b.length()];
			for (int i = b2b.length() - 1; i >= 0; i--) {
				// System.out.println(i + ": concat " + b2b.substring(i, i + 1));

				temp[j] = b2b.substring(i, i + 1);
				j++;
			}
			for (int i = 0; i < temp.length; i++) {
				// System.out.println("reverse " + temp[i]);
				result = result.concat(temp[i]);
			}
		}
		// System.out.println("result = " + result);
		return result;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int temp, com1, com2;
		nums.add(a);
		nums.add(b);
		nums.add(c);
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 3; j++) {
				if (nums.get(i) > nums.get(j)) {
					temp = nums.get(j);
					nums.remove(j);
					nums.add(i, temp);
				}
			}
		}
		com1 = nums.get(1) - nums.get(0);
		// System.out.println(com1);
		com2 = nums.get(2) - nums.get(1);
		// System.out.println(com2);
		if (com1 == com2) {
			return true;
		}
		return false;
	}

	// Given a string and an int n, return a string that removes n letters from the
	// 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input
	// is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		return "";
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		String dev;
		if (input.length() >= 3) {
			dev = input.toLowerCase().substring(input.length() - 3);
//			System.out.println(dev);
//			System.out.println(dev.compareTo("dev"));
			if (dev.compareTo("dev") == 0) {
				return true;
			}
		}
		return false;
	}

	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		char[] chars = new char[input.length()];
		int blockMax = 0, blockCurrent = 0;
		char lastChar;
		if (input.isEmpty() == false) {
			chars = input.toCharArray();
			lastChar = chars[0];
			for (int i = 1; i < chars.length; i++) {
				// System.out.println(lastChar + " =? " + chars[i]);
				if (lastChar == chars[i]) {
					blockCurrent++;
				} else {
					if (blockCurrent > blockMax) {
						blockMax = blockCurrent;
						blockCurrent = 0;
					}
				}
				lastChar = chars[i];
			}

		}
		return blockMax;
	}

	// given a string - return the number of times "am" appears in the String
	// ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by
	// other letters
	//
	// amISearch("Am I in Amsterdam") → 1
	// amISearch("I am in Amsterdam am I?") → 2
	// amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		int amCount = 0;
		String am;

		for (int i = 0; i < arg1.length() - 2; i++) {
			if (i == 0) {
				am = arg1.toLowerCase().substring(i, i + 3);
				if (am.compareTo("am ") == 0) {
					amCount++;
				}
			} else if (i == arg1.length() - 3) {
				am = arg1.toLowerCase().substring(i, i + 3);
				if (am.compareTo(" am") == 0) {
					amCount++;
				}
			} else {
				am = arg1.toLowerCase().substring(i - 1, i + 3);
				if (am.compareTo(" am ") == 0) {
					amCount++;
				}
			}
		}

		return amCount;

	}

	// given a number
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3 and 5return "fizzbuzz"
	//
	// fizzBuzz(3) → "fizz"
	// fizzBuzz(10) → "buzz"
	// fizzBuzz(15) → "fizzbuzz"

	public String fizzBuzz(int arg1) {
		if ((arg1 % 3 == 0) && (arg1 % 5 == 0)) {
			return "fizzbuzz";
		} else if (arg1 % 3 == 0) {
			return "fizz";
		} else if (arg1 % 5 == 0) {
			return "buzz";
		}
		return null;
	}

	// Given a string split the string into the individual numbers present
	// then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	// largest("55 72 86") → 14
	// largest("15 72 80 164") → 11
	// largest("555 72 86 45 10") → 15

	public int largest(String arg1) {
		ArrayList<String> sNums = new ArrayList<String>();
		ArrayList<Integer> nNums = new ArrayList<Integer>();
		int nTemp = 0, lastSpace = 0, sortTemp;
		String sTemp;
		char c2i;
		for (int i = 0; i < arg1.length(); i++) {
			if (arg1.substring(i, i + 1).compareTo(" ") == 0) {
				sTemp = arg1.substring(lastSpace, i);
				sNums.add(sTemp);
				lastSpace = i + 1;
			}
		}
		sTemp = arg1.substring(lastSpace, arg1.length());
		sNums.add(sTemp);

		for (int i = 0; i < sNums.size(); i++) {
			for (int j = 0; j < sNums.get(i).length(); j++) {
				c2i = sNums.get(i).charAt(j);
				switch (c2i) {
				case '0':
					nTemp += 0;
					break;
				case '1':
					nTemp += 1;
					break;
				case '2':
					nTemp += 2;
					break;
				case '3':
					nTemp += 3;
					break;
				case '4':
					nTemp += 4;
					break;
				case '5':
					nTemp += 5;
					break;
				case '6':
					nTemp += 6;
					break;
				case '7':
					nTemp += 7;
					break;
				case '8':
					nTemp += 8;
					break;
				case '9':
					nTemp += 9;
					break;
				}
			}
			nNums.add(nTemp);
			nTemp = 0;
		}
			for (int i = 0; i < nNums.size() - 1; i++) {
				for (int j = 1; j < nNums.size(); j++) {
					if (nNums.get(i) > nNums.get(j)) {
						sortTemp = nNums.get(j);
						nNums.remove(j);
						nNums.add(i, sortTemp);
					}
				}
			}
		return nNums.get(nNums.size() - 1);
	}

}
