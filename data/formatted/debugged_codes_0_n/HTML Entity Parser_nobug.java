```java
// Runtime: 4 ms (Top 70.19%) | Memory: 39.3 MB (Top 73.08%)
class Solution {
    public String entityParser(String text) {
        return text.replace("&quot;", "\"").replace("&apos;", "'").replace("&gt;", ">").replace("&lt;", "<").replace("&frasl;", "/").replace("&amp;", "&");
    }
}
```