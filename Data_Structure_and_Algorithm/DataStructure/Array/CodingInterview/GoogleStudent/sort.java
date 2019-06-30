// sort (Google Student, CodingBat)
// Return an array that contains the sorted values from the input array 
// with duplicates removed.
// ex. 
// sort([]) → []
// sort([1]) → [1]
// sort([1, 1]) → [1]


// Solution 1.
// Author: kei (All Correct)
// Date  : December 31, 2018
public int[] sort(int[] a) {
  if (a.length == 0) {
    return a;
  }

  Arrays.sort(a);

  ArrayList<Integer> list = new ArrayList<>();
  list.add(a[0]);
  int i = 1;
  while (i < a.length) {
    if (a[i] != a[i - 1]) {
      list.add(a[i]); 
    }

    i++;
  }

  // Convert ArrayList<Integer> to int array. 
  int[] res = new int[list.size()];
  for (int j = 0; j < list.size(); j++) {
    res[j] = list.get(j);
  }
  
  return res;
}


// Solution 2. 
// Author: kei (All Correct)
// Date  : December 15, 2018
public int[] sort(int[] a) {
  if (a.length == 0) {
    return a;
  }

  Arrays.sort(a);
  LinkedHashSet<Integer> bLHSet = new LinkedHashSet<>();

  for (int e : a) {
    bLHSet.add(e);
  }

  int[] b = new int[bLHSet.size()];
  int i = 0;
  for (Iterator<Integer> iter = bLHSet.iterator(); iter.hasNext();) {
    b[i] = (int) iter.next();
    i++;
  }

  return b;
}























