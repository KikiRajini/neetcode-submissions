class TimeMap {
    private record DataEntry(int timestamp, String value){}
    Map<String, List<DataEntry>> keyStore ;
   
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       keyStore.computeIfAbsent(key, k ->new ArrayList<>()).add(new DataEntry(timestamp,value));

    }

//// BAD: Creates a new ArrayList every time this line runs, even though "users" already exists
//map.putIfAbsent("users", new ArrayList<>()); 
//returns prev value, not the new arraylist..may give null if it was emtpy prev

// GOOD: The lambda () -> new ArrayList<>() only executes if "users" is absent
//map.computeIfAbsent("users", k -> new ArrayList<>());
//returns prev value if it exists or new cmputed value if not - so can chain add etcc safely to it.
    
    public String get(String key, int timestamp) {
       if(!keyStore.containsKey(key)){return "";}
       String res ="";
       List<DataEntry> entries = keyStore.get(key);
       int left =0; int right = entries.size()-1;
       while(left<=right){
        int mid = left + (right-left)/2;
        String val =entries.get(mid).value();
        if(entries.get(mid).timestamp()<=timestamp){
            res = val;
            left = mid+1;
        }else{
            right = mid-1;
        }
       }

       return res;

    }
}
