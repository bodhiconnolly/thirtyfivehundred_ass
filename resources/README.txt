README

An MVC music player.

Contains three views:
ConsoleView, MidiViewImpl and GuiViewImpl which each implement IMusicEditorView.

These views are selected by the main function in MEMain, and run by controllers which implement IMusicEditorController.

As previously, Track implements IMusicEditorModel which is the model.