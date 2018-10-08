# About Notes App
  This app is made for writting and saving notes at one place. To add a note simply touch the 3 dots in the right hand side of the action bar and the click "Add Note", then the app will direct the user to the editor. Just type and that's it, when you press the back button or exit the app, it will autosave the note and all the notes would be displayed when next time the app is opened.

# What each file is doing?
1. MainActivity.java contains the code for the activity that is displayed when the app is opened.
2. AddActivityNote.java contains teh code for the editor that gets moving when user wants to add a new note.
3. ObjectSerializer.Java contains the code for the class that is required for internal applications.
4. activity_main and activity_add_note.xml contains the xml code to define th UI of mainActivity.java and AddActivity.Java respectively.
5. menu_main.xml contains the xml code for defining the interface of the dialog box that appears when the 3 dots in action bar is clicked.

# How does it saves data?
I have used shared preferences for saving and retreiving the notes.

# Additional Features
The notes can be deleted after a long press on the target note and then pressing yes on the dialog box that appears.
