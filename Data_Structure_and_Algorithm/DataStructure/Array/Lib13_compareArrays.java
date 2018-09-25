/*
  Comparing arrays

*/

boolean arraysAreEqual = true;

if (score.length != newScore.length)
    arraysAreEqual = false;

for (int i = 0; arraysAreEqual && i < score.length; i++){
    if (score[i] != newScore[i])
        arraysAreEqual = false;
}
