// Map and List.
// Author: CtCI + kei
// Date  : December 18, 2018


for (String s : strs) {
    String key = sortChars(s);

    // If it is new, then create a new list. 
    if (!map.containsKey(key)) {
        map.put(key, new ArrayList<String>());
    }
    // If it already exists in the map, then just get the list and 
    // add to it. No need to put else. 
    ArrayList<String> anagrams = map.get(key);
    anagrams.add(s);
}




