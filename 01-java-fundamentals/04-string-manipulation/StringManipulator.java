public class StringManipulator {
    //
   public String trimAndConcat(String string1, String string2) {
       String string3=string1.trim() + string2.trim();
        return string3;
   }

    //can use the indexOf method
   public Integer getIndexOrNull(String str, char alpha){
	   if(str.indexOf(alpha) >= 0) {
		   return str.indexOf(alpha);
	   }else {return null;}
   }
 
//
   public Integer getIndexOrNull(String word1, String word2){
	   if(word1.indexOf(word2) >= 0) {
		   return word1.indexOf(word2);
	   }else {return null;}
   }
    public String concatSubstring(String strA, int ind1, int ind2, String strB) {
    	String strC = strA.substring(ind1, ind2) + strB;
    	return strC;
    }
}
