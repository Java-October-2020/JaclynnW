package tryAndCatch;
import java.util.ArrayList;

public class TryAndCatch {

	public static void main(String[] args) {
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add("32");
		myList.add("Hello World");
		myList.add(12);
		myList.add("Adios");
		
		for(int i = 0; i< myList.size(); i++) {
			try {
				Integer castedValue = (Integer) myList.get(i);
				}
			catch(ClassCastException e) {
					System.out.println(e.getClass());
				}
		}

	}

}
