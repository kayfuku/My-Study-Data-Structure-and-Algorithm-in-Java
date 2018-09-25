// Demo of StringTokenizer. CS211S.

String string = "good:bad-nice,tall";
StringTokenizer stringTokenizer = new StringTokenizer(string, ":-,");
while (stringTokenizer.hasMoreElements()) 
{
	myPrintln(stringTokenizer.nextToken());
}
