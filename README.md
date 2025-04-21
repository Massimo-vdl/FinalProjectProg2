# FinalProjectProg2
##Scenario : This idea behind my project is to create a playlist editor. It will allow users to interact with a Playlist (Queue<Audio>) which is a queue of type Audio.
There is a User class of which has two subclasses Owner which can import and export playlists from and to txt files, and there is the Listener subclass which can rate Playlists on a scale from 1 -10.
Then there is the Audio class which extends to Songs and Podcats, Playlist will have both these audio types in them.
##Functionalities : 
Firstly playlists will be able to be sorted by creator, type (Song or Podcast), and length.  Playlists will also be able to be searched by keyword which will check for a keyword match in both title and creator. 
Playlists also impliment the play() method which will print out the whole playlist as queued, Users will be able to add Audios to the queue even if they are not in the playlist, Playlists can also be shuffled which will play the Audio in a rondom order.
Audio also impliments Playable which will let you play single audios at a time runtime polymorphism is incorparated because Songs and Podcasts will print out different resaults when played.
TextIOs purpose is to import audios from an outside text file and arrange them into a playlist, as well as export existing playlists.
Comparable will be used to compare users while Comparator will be used to compare audios based on first runtime then artist then audio title

##Unit Testing: 
will be required for: OwnerTest (importAudio, exportPlaylist), ListenerTest (ratePlaylist, invalidRating), PlaylistTest (play, shuffle, sortByType, sortByCreator, sortByTime, searchByKeyword)

##For deliverable 2: 
User will have it's construstors hash code and too string, Owner will be largely empty as Playlist and Audio need to be fully implemented before doing the export and import, Listener will be fully implemented as it only contains 1 method (ratePlaylist),   Playble interface will be implemented in both playlist and audio, Song and Podcast will be fully implemented aswell as their comparator class(in Audio), along with Playlist being partially implemented with unfinished, sorting methods (sortByType, sortByCreator, sortByTime), and unfinished search method (searchByKeyword).
