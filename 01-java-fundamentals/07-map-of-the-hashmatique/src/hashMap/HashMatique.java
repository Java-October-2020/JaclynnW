package hashMap;
import java.util.HashMap;
import java.util.Set;

public class HashMatique {
	public static void main(String[] args) {
		HashMap<String, String> trackList = new HashMap<String, String>();
		trackList.put("Mother Lover", "I'm a mother lover, you're a mother lover..");
		trackList.put("Boats and Hoes", "Boats 'n' hoes, boats 'n' hoes, I gotta have me more boats 'n' hoes...");
		trackList.put("I'm On A Boat", "I'm on a boat! I'm on a boat! Everybody look at me 'cause I'm sailing on a boat");
		trackList.put("Baby Shart", "Baby shart poo poo poo poo poo poo..");
		
//		System.out.println(trackList.get("Mother Lover"));
//		System.out.println(trackList.values());
		
		Set<String> keys = trackList.keySet();
		for(String key: keys) {
			System.out.println(key);
			System.out.println(trackList.get(key));
		}
	}
	
}
