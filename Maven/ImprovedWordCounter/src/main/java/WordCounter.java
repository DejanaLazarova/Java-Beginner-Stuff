
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import org.apache.commons.lang3.StringUtils;

public class WordCounter {

	public static void main(String[] args) {

		FileReader file;
		Hashtable<String, Integer> htab = new Hashtable<String, Integer>();
		try {
			file = new FileReader("doc.txt");
			BufferedReader buff = new BufferedReader(file);
			String line;
			try {
				
				while ((line = buff.readLine()) != null) {
					System.out.println(line);
					String[] words = line.split(" ");

					for (int i = 0; i < words.length; i++) {
						
						String WordKey = StringUtils.lowerCase(words[i]);
						if (htab.containsKey(WordKey)) {
							int currCount = htab.get(WordKey);
							currCount++;
							htab.put(WordKey, currCount);
						} else {
							htab.put(WordKey, 1);
						}
					}
				}
				System.out.println(htab);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}