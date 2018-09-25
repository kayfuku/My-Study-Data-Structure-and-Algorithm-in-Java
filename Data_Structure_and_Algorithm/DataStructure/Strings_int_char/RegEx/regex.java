// regex (By myself)

private static HashMap<String, String> javaProperties = new HashMap<>();

    
// ------------ getJavaProperty() --------------------------
// Get properties whose name start with "java.".
public static void getJavaProperty()
{
    Pattern pattern = Pattern.compile("^java\\.");
    Matcher matcher; 
    
    Properties properties = System.getProperties();
    Enumeration<Object> keysEnumeration = properties.keys();
    
    while (keysEnumeration.hasMoreElements())
    {
        String keyString = (String) keysEnumeration.nextElement();
        
        matcher = pattern.matcher(keyString);                  
        if (matcher.find())
        {
            String valueString = (String) properties.get(keyString);
            javaProperties.put(keyString, valueString);
        }
    }
}
