package weblab;

class PlayList {

    private LibraryStack libraryStack;
    private LibraryQueue libraryQueue;

    /**
     * Constructor of the playlist, creates a playlist with the given songs.
     * @param songs - the songs that will be part of this playlist
     */
    public PlayList(String[] songs) {
        libraryStack = new LibraryStack();
        libraryQueue = new LibraryQueue();
        for (String s : songs) {
            libraryQueue.enqueueBack(s);
        }
    }

    /**
     * Starts playing the first song in the playlist, if no songs was playing yet.
     * @return the first song that will be played if no song was playing, otherwise null
     */
    public String playSong() {
        if (!libraryStack.isEmpty() || libraryQueue.isEmpty()) return null;
        String s = libraryQueue.first();
        libraryStack.push(s);
        return s;
    }

    /**
     * Switches to the next song in the playlist.
     * @return the next song in the playlist
     */
    public String nextSong() {
        String s = libraryQueue.dequeue();
        libraryStack.push(s);
        s = libraryQueue.first();
        return s;
    }

    /**
     * Switches back to the previous song in the playlist.
     * @return the previous song in the playlist
     */
    public String previousSong() {
        String s = libraryStack.pop();
        libraryQueue.enqueueFront(s);
        s = libraryQueue.first();
        return s;
    }
}
