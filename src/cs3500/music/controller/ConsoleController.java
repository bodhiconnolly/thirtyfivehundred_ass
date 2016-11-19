package cs3500.music.controller;

import cs3500.music.model.IMusicEditorModel;
import cs3500.music.view.IMusicEditorView;


public class ConsoleController implements IMusicEditorController {
  private IMusicEditorModel model;
  private IMusicEditorView view;

  public ConsoleController(IMusicEditorModel model, IMusicEditorView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void go() {
    view.renderNote(0, 0, 0, 0, 0);
  }

}