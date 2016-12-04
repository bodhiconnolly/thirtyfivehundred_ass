package cs3500.music.controller;

import java.awt.event.KeyEvent;

import cs3500.music.model.Adapter;
import cs3500.music.model.IChart;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.provider.GuiView;
import cs3500.music.provider.MidiViewModel;

/**
 * Controller class that gives interactive functionality to views.
 */
public class MusicEditorController implements IMusicEditorController {
  private MidiViewModel midiViewModel;
  private GuiView view;

  public MusicEditorController(IMusicEditorModel iMusicEditorModel, GuiView view) {
    this.view = view;
    IChart chartTrack = new Adapter(iMusicEditorModel);
    this.midiViewModel = new MidiViewModel(chartTrack);

    KeyboardHandler key = new KeyboardHandler();
    key.addRunnable(KeyEvent.VK_SPACE, () -> this.view.pausePlay());
    key.addRunnable(KeyEvent.VK_HOME, () -> this.view.goToStart());
    key.addRunnable(KeyEvent.VK_END, () -> this.view.goToEnd());
    key.addRunnable(KeyEvent.VK_LEFT, () -> this.view.scrollLeft());
    key.addRunnable(KeyEvent.VK_RIGHT, () -> this.view.scrollRight());
    this.view.addKeyListener(key);
  }

  @Override
  public void begin() {
    this.view.run(midiViewModel);
  }
}
