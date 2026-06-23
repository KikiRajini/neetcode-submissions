class TimeMap {
    private record DataEntry(int timestamp, String value){}
    Map<String, List<DataEntry>> keyStore ;
   
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        //lazy initialisation compared to putifabsent
        keyStore.computeIfAbsent(key,k -> new ArrayList<>()).add(new DataEntry(timestamp, value));

    }
    
    public String get(String key, int timestamp) {
        if(!keyStore.containsKey(key)){return "";}
        List<DataEntry> entries = keyStore.get(key);
        String res ="";
        int left =0; int right = entries.size() -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(entries.get(mid).timestamp()<=timestamp){
                res = entries.get(mid).value();
                left = mid+1;
            }else{
                right = mid-1;
            }
           
        }
         return res;
    }
}
