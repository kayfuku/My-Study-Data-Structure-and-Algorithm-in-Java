// We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.
// Author: CodingBat + kei
// Date  : October 14, 2016

public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    // aSmile: true, bSmile: true --> true
    // aSmile: false, bSmile: false --> true
    // If the boolean value is same, then return true. 
    return aSmile == bSmile;

}



// We have a loud talking parrot. The "hour" parameter is the current hour time in the range 0..23. We are in trouble if the parrot is talking and the hour is before 7 or after 20. Return true if we are in trouble.
// parrotTrouble(true, 6) → true
// parrotTrouble(true, 7) → false
// parrotTrouble(false, 6) → false
// Author: CodingBat + kei
// Date  : October 14, 2016

public boolean parrotTrouble(boolean talking, int hour) {
  return talking && (hour < 7 || hour > 20);
}
    


























