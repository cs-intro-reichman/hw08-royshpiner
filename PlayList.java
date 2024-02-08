/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        if (size < maxSize){
            tracks[size]=track;
            size++;
            return true;
        }
        else{
            return false;
        }

   
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() {
        String str = "";
        for (int i=0;i<size;i++){
            str +=  "\n" +tracks[i] ;
           
                    
        }
        return str;
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() {
        if (size > 1){
            size --;
        }
    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        int totalInSeconds=0;
        for (int i=0;i<size;i++){
            totalInSeconds+=tracks[i].getDuration();
        }
        //// replace the following statement with your code
        return totalInSeconds;
    }

    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        String currentTitle;
        title = title.toLowerCase();
        for (int i=0;i<size;i++){
            currentTitle = tracks[i].getTitle();
            currentTitle = currentTitle.toLowerCase();
                if (currentTitle.equals(title)){
                return i;
            }
        }
        //// replace the following statement with your code
        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) {
        
        if (i<0 || i>size || maxSize<=size){
            return false;
        }
        if (size>i){
            for(int j=size ;j>i; j--){
                tracks[j] = tracks[j-1];
            }
            tracks [i] = track;
            size++;

        }
        else if (size == i){
            tracks[size]=track;
            size++;
        }
        //// replace the following statement with your code
        return true;
    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) {
        if (i>=0 && i<=size-1 && maxSize>=size){
            for (int j=i;j<size-1;j++){
                tracks[j]=tracks[j+1];

             }
             size--;          
    }

        
    }

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title) {
        int titleIndex = indexOf(title);
        remove(titleIndex);
        //// replace this comment with your code
    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() {
        for (int j=0;j<size-1;j++){
            tracks[j]=tracks[j+1];
         }
         size--;  
        
        //// replace this comment with your code
    }
    
    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) {
        int bothSize = size + other.getSize();
        int j=0;
        if (bothSize<=maxSize){
            for (int i = size; i<bothSize; i++){
                tracks[i] = other.tracks[j];
                j++;
            
            }
            size = bothSize;

        }
        //// replace this comment with your code
    }

    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) {
        int minDuration = tracks[start].getDuration();
        int miniIndex = start;
        int currentDuration;
        if (start>size-1 || start < 0){
            return -1;
        }
        for (int i = start+1 ; i<size ; i++){
            currentDuration = tracks[i].getDuration();
            if (currentDuration<minDuration){
                minDuration = currentDuration;
                miniIndex = i;
            }
        }

        return miniIndex;
    }

    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() {
        return tracks[minIndex(0)].getTitle();
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() {
        Track a;
        int currentMinIndex;
        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
        for (int i=0 ; i<size ; i++){
            currentMinIndex = minIndex(i);
            a = tracks[i];
            tracks[i] = tracks[currentMinIndex];
            tracks[currentMinIndex] = a;
        }

    }
}
